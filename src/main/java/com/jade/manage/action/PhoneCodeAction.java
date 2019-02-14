package com.jade.manage.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.manage.service.PhoneCodeService;
import com.jade.po.Result;

@Controller
@RequestMapping(value="phoneCode")
public class PhoneCodeAction {

	@Autowired
	private PhoneCodeService phoneCodeService;
	
	/**
	 * 获取手机验证码(验证码唯一)
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getCode.action",method=RequestMethod.POST)
	public @ResponseBody Result getCouponList(String phoneNum){
		Result result = new Result();
		result = phoneCodeService.getCode(phoneNum);
		return result;
	}

}
