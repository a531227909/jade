package com.jade.uitil;

public class PhoneCodeUtil {
	
	public static int getCode (){
		int code = (int)(Math.random()*(9999-1000+1))+1000;//产生1000-9999的随机数
		return code;
	}

}
