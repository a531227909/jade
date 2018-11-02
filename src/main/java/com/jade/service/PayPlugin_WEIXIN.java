//package com.funtsui.plugins.pay;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.net.HttpURLConnection;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.text.DecimalFormat;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.net.ssl.HostnameVerifier;
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSession;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//
//import com.funtsui.plugins.ThirdPartyPaymentException;
//
//import org.apache.commons.lang.StringUtils;
//import org.dom4j.DocumentException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.funtsui.common.douya.SignUtils;
//import com.funtsui.common.douya.SslContextUtils;
//import com.funtsui.common.douya.XmlUtils;
//import com.funtsui.common.xinyunbao.PayUtil;
//import com.funtsui.entity.PayParams;
//import com.funtsui.plugins.Plugin;
//import com.funtsui.utils.Constants;
//import com.funtsui.utils.Date2;
//import com.funtsui.utils.GeneratePageUtil;
//import com.funtsui.utils.Result;
//import com.funtsui.utils.XML2JSON;
//
//import net.sf.json.JSONObject;
//
//@Plugin(callBackType="",payType=Constants.WEIXIN)
//public class PayPlugin_WEIXIN implements PayPlugin{
//
//	private Logger logger = LoggerFactory.getLogger(PayPlugin_WEIXIN.class);
//
//	//支付系统的
//	private String payType;
//	private String h5url;
//	private String platform;//1PC端,2移动端
//	private String payUrl;
//	private String userId;
//	private String clientIp;
//
//	//插件的
//	private String version = "3.0";//版本号;
//	private String method = "ZT.online.interface";//接口名称;
//	private String key;
//	private String postUrl;
//
//    //单笔支付的
//	private String partner;
//	private String banktype;
//	private String paymoney;
//	private String ordernumber;
//	private String callbackurl;
//	private String sign;
//	private String hrefbackurl;
//
//
//	/**
//	 * 初始化参数，并进行必要的检查
//	 * @param params
//	 */
//	private void init(PayParams params)
//	{
//		payType = params.getPayType();
//		h5url = params.getH5Url();
//		platform = params.getPlatform();
//		payUrl = params.getPayUrl();
//		userId = params.getUserId();
//		clientIp = params.getClientIp();
//
//
//		key = params.getKey();
//		postUrl = params.getPostUrl();
//
//
//		partner = params.getMerNo();
//		paymoney = params.getTransamt();
//		ordernumber = params.getOrderNo();
//		callbackurl = params.getNotifyUrl();
//		hrefbackurl = params.getNotifyUrl();
//
//	}
//
//	public Result hanld(PayParams params) {
//
//		try{
//			init(params);
////			//微信扫码
//			 if("WEIXIN_WECHATQR".equals(params.getPayType()))
//			{
//				return excuteWECHATQR();
//			}
////			//微信H5
//			else if("WEIXIN_WECHATWAP".equals(params.getPayType()))
//			{
////				if (!"2".equals(params.getPlatform())) {
////					Result result_error = Result.err();
////					result_error.setMessage("请在移动端发起支付");
////					return result_error;
////				}else{
//					return excuteWECHATWAP();
////				}
//				
//			}
//
//		}
//		catch (ThirdPartyPaymentException e)
//		{
//
//			Result result_error = Result.err();
//			result_error.setMessage("第三方支付出现故障，无法完成支付！");
//			return result_error;
//
//		}
//		catch (Exception e)
//		{
//			Result result_error = Result.err();
//			result_error.setMessage("支付系统故障，请稍后重试或联系客服！");
//			return result_error;
//		}
//		Result result_error = Result.err();
//		result_error.setMessage("支付方式不存在，请联系客服！");
//		return result_error;
//	}
//
//	/**
//	 * 1.微信扫码
//	 * @return
//	 */
//	private Result excuteWECHATQR() throws FileNotFoundException, URISyntaxException {
//		logger.info("开始微信支付-支付类型：WECHATQR");
//		String appid = partner.split("@")[1];
//		String mchId = partner.split("@")[0];
//        //随机串
//        String nonceStr = PayUtil.generateUUID();
//        clientIp = "127.0.0.1";
//		
//		//依据实际情况填写具体请求类型
//		Map<String, String> data = new HashMap<String, String>();
//		// 按照实际情况封装参数，字段含义和格式要求，请查看接入文档
//		data.put("appid", appid);
//		data.put("mch_id", mchId);
//		data.put("nonce_str", nonceStr);
//		data.put("sign_type", "MD5");
//		data.put("body", "充值中心-微信充值");
//		data.put("out_trade_no", ordernumber);
//		data.put("total_fee", String.valueOf(Integer.parseInt(new DecimalFormat("0").format(Math.floor(Double.valueOf(paymoney)*100)))));
//		data.put("spbill_create_ip", clientIp);
//		data.put("notify_url", callbackurl);
//		data.put("trade_type", "APP");
//		
//		String sign = SignUtils.buildSign(data, key);
//		data.put("sign", sign);
//		String xml = XmlUtils.toXml(data);
//		String resultStr = this.sendHttpsPost(xml, postUrl);
//		logger.info("微信支付-返回结果："+resultStr);
//		JSONObject json = new JSONObject();
//		
//		try {
//			json = XML2JSON.documentToJSONObject(resultStr);
//		} catch (DocumentException e) {
//			Result rs = Result.err();
//			rs.setMessage("支付系统故障，请稍后重试或联系客服！");
//			logger.info("微信支付系统故障:"+resultStr);
//			e.printStackTrace();
//			return rs;
//		}
//
//		String timestamp = String.valueOf(System.currentTimeMillis()/1000);
//
//		Map<String, String> payDatas = new HashMap<String, String>();
//		// 按照实际情况封装参数，字段含义和格式要求，请查看接入文档
//		payDatas.put("appid", appid);
//		payDatas.put("partnerid", mchId);
//		payDatas.put("prepayid", json.getString("prepay_id"));
//		payDatas.put("package", "Sign=WXPay");
//		payDatas.put("noncestr", nonceStr);
//		payDatas.put("timestamp", timestamp);
//
//		JSONObject WXPay = new JSONObject();
//		// 按照实际情况封装参数，字段含义和格式要求，请查看接入文档
//		WXPay.put("appid", appid);
//		WXPay.put("partnerid", mchId);
//		WXPay.put("prepayid", json.getString("prepay_id"));
//		WXPay.put("package", "Sign=WXPay");
//		WXPay.put("noncestr", nonceStr);
//		WXPay.put("timestamp", timestamp);
//		WXPay.put("sign", SignUtils.buildSign(payDatas, key));
//		System.out.println(WXPay.toString());
//
//		if(json.get("return_code").equals("SUCCESS")){
//			if(json.get("result_code").equals("SUCCESS")){
//				String code_img_url = h5url+"?money="+paymoney+"&qrcode="+json.getString("code_url")+"&bankType="+payType.split("_")[1];
//				Result result = Result.ok();
//				result.put("code_img_url", code_img_url);
//				//result.put("jump_type","sysBrowser");//webview 内部  sysBrowser外部
//				logger.info("正常结束豆芽支付-支付类型：WECHATQR");
//				return result;
//			}else{
//				Result result = Result.err();
//				result.setMessage(json.getString("err_code_des"));
//				logger.info("微信支付系统故障:"+json.toString());
//				return result;
//			}
//		}else{
//			Result result = Result.err();
//			result.setMessage(json.getString("return_msg"));
//			logger.info("微信支付系统故障:"+json.toString());
//			return result;
//		}
//	}
//
//	/**
//	 * 2.微信H5
//	 * @return
//	 */
//	private Result excuteWECHATWAP() throws ThirdPartyPaymentException, UnsupportedEncodingException {
//		logger.info("开始微信支付-支付类型：WECHATWAP");
//		String appid = partner.split("@")[1];
//		String mchId = partner.split("@")[0];
//        //随机串
//        String nonceStr = PayUtil.generateUUID();
//        clientIp = "127.0.0.1";
//		
//		//依据实际情况填写具体请求类型
//		Map<String, String> data = new HashMap<String, String>();
//		// 按照实际情况封装参数，字段含义和格式要求，请查看接入文档
//		data.put("appid", appid);
//		data.put("mch_id", mchId);
//		data.put("nonce_str", nonceStr);
//		data.put("sign_type", "MD5");
//		data.put("body", "充值中心-微信充值");
//		data.put("out_trade_no", ordernumber);
//		data.put("total_fee", String.valueOf(Integer.parseInt(new DecimalFormat("0").format(Math.floor(Double.valueOf(paymoney)*100)))));
//		data.put("spbill_create_ip", clientIp);
//		data.put("notify_url", callbackurl);
//		data.put("trade_type", "MWEB");
//		data.put("scene_info", "{'h5_info': {'type':'Wap','wap_url': '','wap_name': ''}}");
//		
//		String sign = SignUtils.buildSign(data, key);
//		data.put("sign", sign);
//		String xml = XmlUtils.toXml(data);
//		String resultStr = this.sendHttpsPost(xml, postUrl);
//		logger.info("微信支付-返回结果："+resultStr);
//		JSONObject json = new JSONObject();
//		
//		try {
//			json = XML2JSON.documentToJSONObject(resultStr);
//		} catch (DocumentException e) {
//			Result rs = Result.err();
//			rs.setMessage("支付系统故障，请稍后重试或联系客服！");
//			logger.info("微信支付系统故障:"+resultStr);
//			e.printStackTrace();
//			return rs;
//		}
//		
//		if(json.get("return_code").equals("SUCCESS")){
//			if(json.get("result_code").equals("SUCCESS")){
//				Result result = Result.ok();
//				result.put("code_img_url", json.getString("mweb_url"));
//				result.put("jump_type","sysBrowser");//webview 内部  sysBrowser外部
//				logger.info("正常结束豆芽支付-支付类型：WECHATWAP");
//				return result;
//			}else{
//				Result result = Result.err();
//				result.setMessage(json.getString("err_code_des"));
//				logger.info("微信支付系统故障:"+json.toString());
//				return result;
//			}
//		}else{
//			Result result = Result.err();
//			result.setMessage(json.getString("return_msg"));
//			logger.info("微信支付系统故障:"+json.toString());
//			return result;
//		}
//	}
//
//	private String sendHttpsPost(String data, String urlStr) {
//		StringBuilder sb = new StringBuilder();
//		try {
//			SslContextUtils sslContextUtils = new SslContextUtils();
//
//			try {
//				// 请求地址
//				URL url = new URL(urlStr);
//				HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
//				if (httpConn instanceof HttpsURLConnection) {
//					sslContextUtils.initHttpsConnect((HttpsURLConnection) httpConn);
//				}
//				httpConn.setRequestMethod("POST");
//				httpConn.setDoOutput(true);
//				httpConn.setDoInput(true);
//				httpConn.setRequestProperty("Content-type", "text/xml");
//				httpConn.setConnectTimeout(600000);
//				httpConn.setReadTimeout(600000);
//				// 发送请求
//				httpConn.getOutputStream().write(data.getBytes("utf-8"));
//				httpConn.getOutputStream().flush();
//				httpConn.getOutputStream().close();
//				// 获取输入流
//				BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "utf-8"));
//				char[] buf = new char[1024];
//				int length = 0;
//				while ((length = reader.read(buf)) > 0) {
//					sb.append(buf, 0, length);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return sb.toString();
//	}
//	
//}
