package com.jade.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CommodityMapper;
import com.jade.dao.CouponMapper;
import com.jade.dao.UOderDataMapper;
import com.jade.mod.Commodity;
import com.jade.mod.UOderData;
import com.jade.mod.UserCoupon;
import com.jade.po.Result;
import com.jade.service.CallBackService;
import com.jade.service.UOrderService;
import com.jade.uitil.IdUtil;
import com.jade.uitil.PriceUtils;
import com.jade.uitil.payUtils.SignUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service
public class CallBackServiceImpl implements CallBackService{
	
	@Autowired
	private UOrderService uOrderService;
	
	@Autowired
	private UOderDataMapper uOderDataMapper;
	
	@Autowired
	private CommodityMapper comMapper;
	
	@Autowired
	private CouponMapper couponMapper;

	@Override
	public String callBack(Map<String, String> params) {
		Result result = new Result();
		Map<String, String> data = new HashMap<String, String>();
		String signKey = "9f450b70ea57630a3336e44ac7778cd0";	//密钥
		
		String return_code = params.get("return_code"); 	//返回状态码 SUCCESS/FAIL
		String return_msg = params.get("return_msg"); 		//返回信息
		String appid = params.get("appid"); 				//微信分配的公众账号ID
		String mch_id = params.get("mch_id"); 				//微信支付分配的商户号
		String device_info = params.get("device_info");		//微信支付分配的终端设备号
		String nonce_str = params.get("nonce_str"); 		//随机字符串，不长于32位
		String sign = params.get("sign");        			//数据签名
		String sign_type = params.get("sign_type");			//签名类型，目前支持HMAC-SHA256和MD5，默认为MD5
		String result_code = params.get("result_code"); 	//SUCCESS表示成功，FAIL表示失败
		String err_code = params.get("err_code");			//错误返回的状态码
		String err_code_des = params.get("err_code_des");	//错误返回的信息描述
		String openid = params.get("openid");				//用户在商户appid下的唯一标识
		String is_subscribe = params.get("is_subscribe");	//用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
		String trade_type = params.get("trade_type");		//JSAPI、NATIVE、APP
		String bank_type = params.get("bank_type");			//银行类型，采用字符串类型的银行标识，银行类型见微信银行列表
		String total_fee = params.get("total_fee");			//订单总金额，单位为分
		String settlement_total_fee = params.get("settlement_total_fee");//	应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
		String fee_type = params.get("fee_type");			//货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见微信货币类型
		String cash_fee = params.get("cash_fee");			//现金支付金额订单现金支付金额，详见微信支付金额
		String cash_fee_type = params.get("cash_fee_type");	//货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY，其他值列表详见微信货币类型
		String coupon_fee = params.get("coupon_fee");		//代金券金额<=订单金额，订单金额-代金券金额=现金支付金额，详见微信支付金额
		String coupon_count = params.get("coupon_count");	//代金券使用数量
		String coupon_type_$n = params.get("coupon_type_$n");//CASH--充值代金券 NO_CASH---非充值代金券 并且订单使用了免充值券后有返回（取值：CASH、NO_CASH）。$n为下标,从0开始编号，举例：coupon_type_0
		String coupon_id_$n = params.get("coupon_id_$n");	//代金券ID,$n为下标，从0开始编号
		String coupon_fee_$n = params.get("coupon_fee_$n");	//	单个代金券支付金额,$n为下标，从0开始编号
		String transaction_id = params.get("transaction_id");//微信支付订单号
		String out_trade_no = params.get("out_trade_no");	//商户系统内部订单号
		String attach = params.get("attach");				//商家数据包，原样返回
		String time_end = params.get("time_end");			//支付完成时间
		
		// 按照实际情况封装参数，字段含义和格式要求，请查看接入文档
		if(!StringUtils.isBlank(return_code)){
			data.put("return_code", return_code);
		}
		if(!StringUtils.isBlank(return_msg)){
			data.put("return_msg", return_msg);
		}
		if(!StringUtils.isBlank(appid)){
			data.put("appid", appid);
		}
		if(!StringUtils.isBlank(mch_id)){
			data.put("mch_id", mch_id);
		}
		if(!StringUtils.isBlank(nonce_str)){
			data.put("nonce_str", nonce_str);
		}
		if(!StringUtils.isBlank(sign_type)){
			data.put("sign_type", sign_type);
		}
		if(!StringUtils.isBlank(result_code)){
			data.put("result_code", result_code);
		}
		if(!StringUtils.isBlank(openid)){
			data.put("openid", openid);
		}
		if(!StringUtils.isBlank(trade_type)){
			data.put("trade_type", trade_type);
		}
		if(!StringUtils.isBlank(bank_type)){
			data.put("bank_type", bank_type);
		}
		if(!StringUtils.isBlank(total_fee)){
			data.put("total_fee", total_fee);
		}
		if(!StringUtils.isBlank(cash_fee)){
			data.put("cash_fee", cash_fee);
		}
		if(!StringUtils.isBlank(transaction_id)){
			data.put("transaction_id", transaction_id);
		}
		if(!StringUtils.isBlank(out_trade_no)){
			data.put("out_trade_no", out_trade_no);
		}
		if(!StringUtils.isBlank(time_end)){
			data.put("time_end", time_end);
		}
		if(!StringUtils.isBlank(device_info)){
			data.put("device_info", device_info);
		}
		if(!StringUtils.isBlank(err_code)){
			data.put("err_code", err_code);
		}
		if(!StringUtils.isBlank(err_code_des)){
			data.put("err_code_des", err_code_des);
		}
		if(!StringUtils.isBlank(is_subscribe)){
			data.put("is_subscribe", is_subscribe);
		}
		if(!StringUtils.isBlank(settlement_total_fee)){
			data.put("settlement_total_fee", settlement_total_fee);
		}
		if(!StringUtils.isBlank(fee_type)){
			data.put("fee_type", fee_type);
		}
		if(!StringUtils.isBlank(cash_fee_type)){
			data.put("cash_fee_type", cash_fee_type);
		}
		if(!StringUtils.isBlank(coupon_fee)){
			data.put("coupon_fee", coupon_fee);
		}
		if(!StringUtils.isBlank(coupon_count)){
			data.put("coupon_count", coupon_count);
		}
		if(!StringUtils.isBlank(coupon_type_$n)){
			data.put("coupon_type_$n", coupon_type_$n);
		}
		if(!StringUtils.isBlank(coupon_id_$n)){
			data.put("coupon_id_$n", coupon_id_$n);
		}
		if(!StringUtils.isBlank(coupon_fee_$n)){
			data.put("coupon_fee_$n", coupon_fee_$n);
		}
		if(!StringUtils.isBlank(attach)){
			data.put("attach", attach);
		}
		
		String mySign = SignUtils.buildSign(data, signKey);
		boolean isValidate = mySign.equals(sign);
		if(isValidate){
			if("SUCCESS".equals(return_code)){
				if("SUCCESS".equals(result_code)){
					UOderData uOderData = uOderDataMapper.selectUOderDataByID(out_trade_no);
					JSONObject dataOfUOder = JSONObject.fromObject(uOderData.getData());
					
					//修改优惠券状态为0(已使用)
					try {
						JSONArray jsonArray = dataOfUOder.getJSONArray("data");
						List<IdUtil> list = (List) JSONArray.toCollection(jsonArray, IdUtil.class); 
						String cid;
						String user_coupon_id;
						for(int i=0;i<list.size();i++){
							cid =  list.get(i).getCid();
							user_coupon_id = list.get(i).getUser_coupon_id();
							Commodity commodity = comMapper.selectByPrimaryKey(cid);
							if(commodity!=null){
								if(!commodity.getStatus().equals("0")){
									if(StringUtils.isNotBlank(user_coupon_id)){
										couponMapper.updateUserCouponStatus(user_coupon_id, dataOfUOder.getString("account"), "0");
									}
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if(uOderData.getIs_callback().equals("1")){
						result.setSuccess(true);
						result.getResult().put("data", dataOfUOder.toString());
						result.getResult().put("msg", "微信支付接收回调成功");
						String account = dataOfUOder.getString("account");
						uOrderService.insertOrderByCart(dataOfUOder, account);
						uOderDataMapper.updateIsCallBackByID("0", uOderData.getU_order_data_id());
						return "SUCCESS";
					}else{
						return "SUCCESS";
					}
				}else{
					return "FAIL";
				}
			}else{
				return "FAIL";
			}
		}else{
			return "FAIL";
		}
	}
	
}
