package com.jade.manage.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.PhoneCodeMapper;
import com.jade.manage.service.PhoneCodeService;
import com.jade.mod.PhoneCode;
import com.jade.po.Result;
import com.jade.uitil.AccountValidatorUtil;
import com.jade.uitil.PhoneCodeUtil;

@Service
public class PhoneCodeServiceImpl implements PhoneCodeService{
	
	@Autowired
	private SendPhoneMessageServiceImpl sendPhoneMessageServiceImpl;
	@Autowired
	private PhoneCodeMapper phoneCodeMapper;

	@Override
	public Result getCode(String phoneNum) {
		Result result = new Result();
		boolean isMobile = AccountValidatorUtil.isMobile(phoneNum);
		if(isMobile){
			String code = String.valueOf(PhoneCodeUtil.getCode());
			code = DigestUtils.md2Hex(code);
			sendPhoneMessageServiceImpl.SendMessage(phoneNum, code);
			PhoneCode phoneCode = phoneCodeMapper.selectPhoneCodeByPhoneNum(phoneNum);
			if(phoneCode==null||phoneCode.equals("")){
				int i = phoneCodeMapper.insertPhoneCode(phoneNum, code);
				if(i==1){
					result.setSuccess(true);
					result.getResult().put("data", "发送成功");
				}else{
					result.setSuccess(false);
					result.getResult().put("error", "服务器故障发送失败");
				}
			}else{
				int i = phoneCodeMapper.updateCode(phoneNum, code);
				if(i==1){
					result.setSuccess(true);
					result.getResult().put("data", "发送成功");
				}else{
					result.setSuccess(false);
					result.getResult().put("error", "服务器故障发送失败");
				}
			}
		}else{
			result.setSuccess(false);
			result.getResult().put("error", "号码格式错误");
			return result;
		}
		return result;
	}
	
	
}
