package com.jade.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jade.po.Result;
import com.jade.service.CallBackService;
import com.jade.uitil.payUtils.XML2JSON;

@Controller
@RequestMapping(value="callback")
public class CallBackAction {

	@Autowired
	private CallBackService callBackService;
	
	/**
	 * 微信支付回调
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/notify/weixin.action")
	public String weixinpay(HttpServletRequest request, @RequestBody String data) {
		Result result = new Result();
		JSONObject json = new JSONObject();
		System.out.println(data);
		try {
			json = XML2JSON.documentToJSONObject(data);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
		Set<String> sets = json.keySet();
		Iterator<String> it = sets.iterator();
		Map<String, String> params = new HashMap<String, String>();
		while (it.hasNext()) {
			String key = it.next();
			params.put(key, json.get(key).toString());
		}
		return callBackService.callBack(params);
	}

}
