package com.jade.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CommodityMapper;
import com.jade.dao.CouponMapper;
import com.jade.dao.UOderDataMapper;
import com.jade.mod.Commodity;
import com.jade.mod.ShoppingCartExample;
import com.jade.mod.UOderData;
import com.jade.mod.UserCoupon;
import com.jade.po.Result;
import com.jade.service.UserPayService;
import com.jade.uitil.GetCouponOrderNumberUtils;
import com.jade.uitil.IdUtil;
import com.jade.uitil.PriceUtils;
import com.jade.uitil.payUtils.PayUtil;
import com.jade.uitil.payUtils.SignUtils;
import com.jade.uitil.payUtils.SslContextUtils;
import com.jade.uitil.payUtils.XML2JSON;
import com.jade.uitil.payUtils.XmlUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class UserPayServiceImpl implements UserPayService{
	
	@Autowired
	private CommodityMapper comMapper;
	
	@Autowired
	private CouponMapper couponMapper;
	
	@Autowired
	private UOderDataMapper uOderDataMapper;

	@Override
	public Result pay(JSONObject data, String account) {
		
//		{"total_pay":"总支付金额","data":[{"rid":"991ed679d3ce4a0f8eb0647b9a7e3793","sid":"yckj311049000",
//			"cid":"jade20181031133949","number":"数量",
//			"money":"此商品实际支付金额","user_coupon_id":"用户优惠券ID","user_coupon_money":"用户优惠金额"}]}
		Result result = new Result();
		Double total_pay = Double.parseDouble(data.getString("total_pay"));
		try {
			JSONArray jsonArray = data.getJSONArray("data");
			Double real_pay = 0.0;
			List<Object> retu = new ArrayList<Object>();
			List<IdUtil> list = (List) JSONArray.toCollection(jsonArray, IdUtil.class); 
			String cid;
			String rid;
			String sid;
			String number;
			String money;
			String user_coupon_id;
			String user_coupon_money;
			String price;
			for(int i=0;i<list.size();i++){
				cid =  list.get(i).getCid();
				rid =  list.get(i).getRid();
				sid =  list.get(i).getSid();
				number = list.get(i).getNumber();
				money = list.get(i).getMoney();
				user_coupon_id = list.get(i).getUser_coupon_id();
				user_coupon_money = list.get(i).getUser_coupon_money();
				Commodity commodity = comMapper.selectByPrimaryKey(cid);
				if(commodity!=null){
					price = PriceUtils.getPayPrice(commodity.getPrice(), number);
					System.out.println("one_real_pay"+Double.parseDouble(price)*Double.parseDouble(number));
					System.out.println("one_total_pay"+Double.parseDouble(money));
					System.out.println(Double.doubleToLongBits(Double.parseDouble(price)*Double.parseDouble(number))==Double.doubleToLongBits(Double.parseDouble(money)));
					if(Double.doubleToLongBits(Double.parseDouble(price)*Double.parseDouble(number))==Double.doubleToLongBits(Double.parseDouble(money))){
						if(!commodity.getStatus().equals("0")){
							if(StringUtils.isBlank(user_coupon_id)){
								real_pay += Double.parseDouble(price)*Double.parseDouble(number);
								retu.add("商品"+cid+",下单成功");
							}else{
								UserCoupon userCoupon = couponMapper.selectUserCouponByID(user_coupon_id);
								String[] coupon_rule = userCoupon.getCoupon_rule().split("-");
								if(Double.doubleToLongBits(Double.parseDouble(price)*Double.parseDouble(number))>=Double.doubleToLongBits(Double.parseDouble(coupon_rule[0]))){
									real_pay += Double.parseDouble(price)*Double.parseDouble(number)-Double.parseDouble(coupon_rule[1]);
									retu.add("商品"+cid+",下单成功");
								}else{
									real_pay += Double.parseDouble(price)*Double.parseDouble(number);
									retu.add("商品"+cid+",下单成功");
								}
							}
						}else{
							retu.add("商品"+cid+",已下架");
						}
					}else{
						result.setSuccess(false);
						result.getResult().put("error", "支付系统金额错误，请稍后重试或联系客服！");
					}
				}else{
					retu.add("无此商品"+cid);
				}
			}
			result.getResult().put("data",retu);
			System.out.println("total_pay"+total_pay);
			System.out.println("real_pay"+real_pay);
			System.out.println(Double.doubleToLongBits(total_pay)!=Double.doubleToLongBits(real_pay));
			if(Double.doubleToLongBits(total_pay)!=Double.doubleToLongBits(real_pay)){
				result.setSuccess(false);
				result.getResult().put("error","支付系统金额错误，请稍后重试或联系客服！");
				return result;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String appid = "wx4f027d7c3152b599";
		String mchId = "1516385391";
		String key = "9f450b70ea57630a3336e44ac7778cd0";
		String callbackurl = "http://3s.dkys.org:18037/jade/callback/notify/weixin.action";
		String postUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String paymoney = "1";
        //随机串
        String nonceStr = PayUtil.generateUUID();
        String clientIp = "127.0.0.1";
        
        UOderData uOderData = new UOderData();
        String u_oder_data_id = GetCouponOrderNumberUtils.GetCouponOrderNumber();
        uOderData.setU_order_data_id(u_oder_data_id);
        uOderData.setData(data.toString());
        uOderDataMapper.insertUOderData(uOderData);
        
		//依据实际情况填写具体请求类型
		Map<String, String> datas = new HashMap<>();
		// 按照实际情况封装参数，字段含义和格式要求，请查看接入文档
		datas.put("appid", appid);
		datas.put("mch_id", mchId);
		datas.put("nonce_str", nonceStr);
		datas.put("sign_type", "MD5");
		datas.put("body", "充值中心-微信充值");
		datas.put("out_trade_no", u_oder_data_id);
		datas.put("total_fee", String.valueOf(Integer.parseInt(new DecimalFormat("0").format(Math.floor(Double.valueOf(paymoney)*100)))));
		datas.put("spbill_create_ip", clientIp);
		datas.put("notify_url", callbackurl);
		datas.put("trade_type", "APP");
		
		String sign = SignUtils.buildSign(datas, key);
		datas.put("sign", sign);
		String xml = XmlUtils.toXml(datas);
		String resultStr = this.sendHttpsPost(xml, postUrl);
		JSONObject json = new JSONObject();
		
		try {
			json = XML2JSON.documentToJSONObject(resultStr);
			System.out.println(json.toString());
		} catch (DocumentException e) {
			result.setSuccess(false);
			result.getResult().put("error", "支付系统故障，请稍后重试或联系客服！");
			e.printStackTrace();
			return result;
		}

		String timestamp = String.valueOf(System.currentTimeMillis()/1000);

		Map<String, String> payDatas = new HashMap<String, String>();
		// 按照实际情况封装参数，字段含义和格式要求，请查看接入文档
		payDatas.put("appid", appid);
		payDatas.put("partnerid", mchId);
		payDatas.put("prepayid", json.getString("prepay_id"));
		payDatas.put("package", "Sign=WXPay");
		payDatas.put("noncestr", nonceStr);
		payDatas.put("timestamp", timestamp);

		JSONObject WXPay = new JSONObject();
		// 按照实际情况封装参数，字段含义和格式要求，请查看接入文档
		WXPay.put("appid", appid);
		WXPay.put("partnerid", mchId);
		WXPay.put("prepayid", json.getString("prepay_id"));
		WXPay.put("package", "Sign=WXPay");
		WXPay.put("noncestr", nonceStr);
		WXPay.put("timestamp", timestamp);
		WXPay.put("sign", SignUtils.buildSign(payDatas, key));
		System.out.println(WXPay.toString());

		if(json.get("return_code").equals("SUCCESS")){
			if(json.get("result_code").equals("SUCCESS")){
				result.setSuccess(true);
				result.getResult().put("payData",WXPay.toString());
				return result;
			}else{
				result.setSuccess(false);
				result.getResult().put("error", json.getString("err_code_des"));
				return result;
			}
		}else{
			result.setSuccess(false);
			result.getResult().put("error", json.getString("return_msg"));
			return result;
		}
	}
	
	private String sendHttpsPost(String data, String urlStr) {
	StringBuilder sb = new StringBuilder();
	try {
		SslContextUtils sslContextUtils = new SslContextUtils();

		try {
			// 请求地址
			URL url = new URL(urlStr);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			if (httpConn instanceof HttpsURLConnection) {
				sslContextUtils.initHttpsConnect((HttpsURLConnection) httpConn);
			}
			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			httpConn.setRequestProperty("Content-type", "text/xml");
			httpConn.setConnectTimeout(600000);
			httpConn.setReadTimeout(600000);
			// 发送请求
			httpConn.getOutputStream().write(data.getBytes("utf-8"));
			httpConn.getOutputStream().flush();
			httpConn.getOutputStream().close();
			// 获取输入流
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
			char[] buf = new char[1024];
			int length = 0;
			while ((length = reader.read(buf)) > 0) {
				sb.append(buf, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	return sb.toString();
}
	
}
