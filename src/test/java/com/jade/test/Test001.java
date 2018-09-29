package com.jade.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.jade.douya.SslContextUtils;

import net.sf.json.JSONObject;

public class Test001 {
	
	@Test
	public void test001(){
		System.out.println(sendHttpsPost("{type:1}", "http://localhost:8088/jade/uorerManage/getMyAllUOrder.action"));
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
				httpConn.setRequestProperty("Content-type", "application/json");
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
	
	@Test
	public void test002(){
		String url="http://3s.dkys.org:17404/jade/uorerManage/getMyAllUOrder.action";
		String entityJson="{\"type\":\"2\"}";
//		UorerManage a=new UorerManage();
//		a.setType("1");
//		String entityJson=JSONObject.fromObject(a).toString();
		HttpPost httpost = new HttpPost(url); // 设置响应头信息
		httpost.addHeader("Content-Type", "application/json; charset=UTF-8");
		httpost.addHeader("Cookie","goeasyNode=4; JSESSIONID=EA972C8D694C5AF8299C8ACE284357F4; Admin-Token=yckj311049000");
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(3000)
                                     .setConnectTimeout(3000).build();
		httpost.setConfig(requestConfig);
		httpost.setEntity(new StringEntity(entityJson, "UTF-8"));
		String returnStr = null;
		try {
			HttpResponse response = HttpClientBuilder.create().build().execute(httpost);
			returnStr = EntityUtils.toString(response.getEntity(), "utf-8");
			System.out.println(returnStr);
		} catch (Exception e) {
		} finally {
			httpost.releaseConnection();
		}
	}
	
	@Test
	public void test003(){
		String user_id = "piluchun03,piluchun";
		String userIds = "";
		String[] users = user_id.split(",");
		for(String user : users){
			userIds += "\""+user+"\",";
		}
		userIds = userIds.substring(0,userIds.length()-1);
		System.err.println(userIds);
	}
	
	@Test
	public void test004(){
		String resultStr = "{'body':{},'heard':{'code':'1007','mag':'暂无可用付款码'}}";
		JSONObject json = JSONObject.fromObject(resultStr);
		System.out.println(JSONObject.fromObject(json.get("body")));
	}

}
