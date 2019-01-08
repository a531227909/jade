//package com.jade.test;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.net.ssl.HttpsURLConnection;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.util.EntityUtils;
//import org.junit.Test;
//
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.JsonObject;
//import com.jade.douya.SslContextUtils;
//import com.jade.uitil.IdUtil;
//import com.jade.uitil.PriceUtils;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//public class Test001 {
//	
//	@Test
//	public void test001(){
//		System.out.println(sendHttpsPost("{type:1}", "http://localhost:8088/jade/uorerManage/getMyAllUOrder.action"));
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
//				httpConn.setRequestProperty("Content-type", "application/json");
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
//	@Test
//	public void test002(){
//		String url="http://3s.dkys.org:18037/jade/uorder/insertOrderByCart.action";
//		String entityJson="{\"type\":\"2\"}";
////		UorerManage a=new UorerManage();
////		a.setType("1");
////		String entityJson=JSONObject.fromObject(a).toString();
//		HttpPost httpost = new HttpPost(url); // 设置响应头信息
//		httpost.addHeader("Content-Type", "application/json; charset=UTF-8");
//		httpost.addHeader("Cookie","JSESSIONID=3DB3DB0DDF63328B659208E8DE7F991F");
//		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(3000)
//                                     .setConnectTimeout(3000).build();
//		httpost.setConfig(requestConfig);
//		httpost.setEntity(new StringEntity(entityJson, "UTF-8"));
//		String returnStr = null;
//		try {
//			HttpResponse response = HttpClientBuilder.create().build().execute(httpost);
//			returnStr = EntityUtils.toString(response.getEntity(), "utf-8");
//			System.out.println(returnStr);
//		} catch (Exception e) {
//		} finally {
//			httpost.releaseConnection();
//		}
//	}
//	
//	@Test
//	public void test003(){
//		String user_id = "piluchun03,piluchun";
//		String userIds = "";
//		String[] users = user_id.split(",");
//		for(String user : users){
//			userIds += "\""+user+"\",";
//		}
//		userIds = userIds.substring(0,userIds.length()-1);
//		System.err.println(userIds);
//	}
//	
//	@Test
//	public void test004(){
//		String resultStr = "{'body':{},'heard':{'code':'1007','mag':'暂无可用付款码'}}";
//		JSONObject json = JSONObject.fromObject(resultStr);
//		System.out.println(JSONObject.fromObject(json.get("body")));
//	}
//	
//	@Test
//	public void test005(){
//		System.out.println(PriceUtils.getOnePrice("0,30,50,100-10,9,8,5"));
//		System.out.println(PriceUtils.getPayPrice("0,30,50,100-10,9,8,5", "101"));
//	}
//	
//	@Test
//	public void test006(){
//		Date today = new Date();
//		Date yesterday = new Date(today.getTime() - 86400000L);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		System.out.println(sdf.format(today));
//		System.out.println(sdf.format(yesterday));
//	}
//	
//	@Test
//	public void test007() throws JsonParseException, JsonMappingException, IOException{
//		String test = "{'data':[{'cid':'jade20181031133949','color':'{\"name\":\"尺码\",\"data\":\"37\"}','money':9,'number':'1','rid':'991ed679d3ce4a0f8eb0647b9a7e3793','sid':'yckj311049000','user_coupon_id':'1','user_coupon_money':'1'}],'total_pay':9,'account':'test007'}";
//		JSONObject data = JSONObject.fromObject(test);
////		String datas = "[{'cid':'jade20181031133949','color':'{\"name\":\"尺码\",\"data\":\"37\"}','money':9,'number':'1','rid':'991ed679d3ce4a0f8eb0647b9a7e3793','sid':'yckj311049000','user_coupon_id':'1','user_coupon_money':'1'}]";
////		IdUtil it = com.alibaba.fastjson.JSONObject.parseObject(datas, IdUtil.class);
////		System.out.println(it.getColor());
//		
////		List<IdUtil> list = com.alibaba.fastjson.JSONObject.parseArray(datas,IdUtil.class);
////		
////		for(int i=0;i<list.size();i++){
////			String color = list.get(i).getColor();
////			System.out.println(color);
////		}
//		
//		String datas = data.getString("data");
////		datas = datas.substring(1, datas.length()-1);
////		JSONObject json = JSONObject.fromObject(datas);
////		String color = json.getString("color");
////		System.out.println(color);
//		
//		JSONArray jsonArray = data.getJSONArray("data");
////		List<IdUtil> list = (List<IdUtil>) JSONArray.toCollection(jsonArray, IdUtil.class);
//		List<IdUtil> list = com.alibaba.fastjson.JSONObject.parseArray(datas,IdUtil.class);
//		for(int i=0;i<list.size();i++){
//			String user_coupon_id = list.get(i).getUser_coupon_id();
//			String color = list.get(i).getColor();
//			System.out.println(user_coupon_id+":"+color);
//		}
//		
////		ObjectMapper mapper = new ObjectMapper();
////		List<IdUtil> lendReco = mapper.readValue(data.getString("data"),new TypeReference<List<IdUtil>>() { });
////		System.out.println(lendReco.get(0).getColor());
//	}
//	
//	@Test
//	public void test008() {
//		String price = "12";
//		String number = "100";
//		String rule_money = "88";
//		String money = "1012.00";
//		System.out.println(price+":"+number+":"+rule_money+":"+money);
//		System.out.println(Double.parseDouble(price)*Double.parseDouble(number)-Double.parseDouble(rule_money));
//		System.out.println(Double.parseDouble(money));
//		System.out.println(Double.parseDouble(price)*Double.parseDouble(number)-Double.parseDouble(rule_money)==Double.parseDouble(money));
//		System.out.println(Double.doubleToLongBits(Double.parseDouble(price)*Double.parseDouble(number)-Double.parseDouble(rule_money))==Double.doubleToLongBits(Double.parseDouble(money)));
//		if(Double.doubleToLongBits(Double.parseDouble(price)*Double.parseDouble(number)-Double.parseDouble(rule_money))==Double.doubleToLongBits(Double.parseDouble(money))){
//			
//		}
//	}
//
//}
