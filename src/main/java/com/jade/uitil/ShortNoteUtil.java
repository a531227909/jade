package com.jade.uitil;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class ShortNoteUtil {
	//短信发送URL
	private static String url = null;
	//appkey
	private static String appkey = null;
	//secret
	private static String secret = null;
	//短信类型
	private static String smsType = null;
	//短信签名
	private static String smsFreeSignName = null;
	//短信模板
	private static String smsTemplateCode = null;
	//产品
	private static String product = null;
	
	//应用启动时，自动加载与发送信息相关的配置文件ShortNoteConfig.properties，并初始化相关参数
	static{
		Properties pro = new Properties();
		InputStream input = ShortNoteUtil.class.
			getClassLoader().
			getResourceAsStream("conf/ShortNoteConfig.properties");
		try {
			pro.load(new InputStreamReader(input, "UTF-8"));
			url = pro.getProperty("url");
			appkey = pro.getProperty("appkey");
			secret = pro.getProperty("secret");
			smsType = pro.getProperty("smsType");
			smsFreeSignName = pro.getProperty("smsFreeSignName");
			smsTemplateCode = pro.getProperty("smsTemplateCode");
			product = pro.getProperty("product");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(input!=null){
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 将验证码code发送给手机号为telephone的用户
	 * @param telephone
	 * @param code
	 * @throws ApiException 
	 */
	public static void sendShortNoteMsg(String telephone,String code) throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType(smsType);
		req.setSmsFreeSignName(smsFreeSignName);
		if(product == null){
			req.setSmsParamString("{\"code\":\"" + code + "\"}");
		}else{
			req.setSmsParamString("{\"code\":\"" + code +"\"," + "\"product\":\"" + product + "\"}");
		}
		req.setRecNum(telephone);
		req.setSmsTemplateCode(smsTemplateCode);
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}
}
