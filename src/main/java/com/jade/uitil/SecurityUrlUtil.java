package com.jade.uitil;

import java.util.ArrayList;
import java.util.List;

public class SecurityUrlUtil {
	
	private static List<String> securityUrls;
	
	/**
	 * 定义时间：2017年06月14日
	 * 实现时间：2017年06月15日
	 * 编写者：shadow
	 * 用途：判断url是否为安全url，即用户登录之后，可以直接调用的url
	 * @param url
	 * @return
	 */
	public static boolean isSecurityUrl(String url){
		boolean flag = false;
		if(securityUrls == null){
			init();
		}
		for(String sUrl : securityUrls){
			if(url.equals(sUrl)){
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * 初始化安全url
	 */
	private static void init(){
		securityUrls = new ArrayList<>();
		securityUrls.add("/hotel/user/changePunchStatus.action");
		securityUrls.add("/hotel/main/getMainPageContent.action");
		securityUrls.add("/hotel/department/getAllDepartments.action");
		securityUrls.add("/hotel/department/getDepartmentAllStaff.action"); 
		securityUrls.add("/hotel/message/getMessageByUserId.action");
		securityUrls.add("/hotel/message/changeMessageStatus.action");
		securityUrls.add("/hotel/image/uploadImage.action");
		securityUrls.add("/hotel/image/deleteImage.action");
		securityUrls.add("/hotel/image/getModuleSlideshow.action");
	}
}
