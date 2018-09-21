package com.jade.uitil.interceptor;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jade.po.Result;
import com.jade.uitil.JSONUtil;
import com.jade.uitil.SecurityUrlUtil;
import com.jade.uitil.URLFunctionIdMapper;

public class AuthHandlerInterceptor implements HandlerInterceptor {
	private PrintWriter pw = null;
	private List<String> allowUris;
	public void setAllowUris(List<String> allowUris) {
		this.allowUris = allowUris;
	}
	private List<String> manageUris;
	public void setManageUris(List<String> manageUris) {
		this.manageUris = manageUris;
	}
	public static  Map<String, Object> USER_SESSION = new HashMap<String, Object>();  
	
	public static  Map<String, Object> USERMANAGE_SESSION = new HashMap<String, Object>();  

	private int i = 0;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpServletRequest httpReq=(HttpServletRequest)request;
		HttpServletResponse httpRes=(HttpServletResponse)response;
		System.out.println("sessionId：" + httpReq.getSession().getId() + "uri：" + httpReq.getRequestURI() );
		httpReq.getSession().setAttribute("oldUrl", httpReq.getSession().getAttribute("url"));
		String uri=httpReq.getRequestURI();
		httpReq.getSession().setAttribute("url", uri);
		
		  
		if(httpReq.getSession().getAttribute("account")!=null){//已经登录
			if(isManageUris(uri)){
				if(httpReq.getSession().getAttribute("accountType")==null){
					returnError("还没有登录",httpRes);
					return false;
				}else{
					return true;
				}
			}else{
				return true;
			}
		}
		else{//没有登录
			if(isAllowURI(uri)){//本身登录模块不需要 拦截
				return true;
			}else{
				returnError("还没有登录",httpRes);
				return false;
			}
			
		}
	}
	
	

	/**
	 * 判断是否不需要拦截的URI
	 * @param uri
	 * @return
	 */
	private boolean isAllowURI(String uri){
		if(allowUris!=null){
			for(String str : allowUris){
				if(uri.indexOf(str)>-1){
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean isManageUris(String uri){
		if(manageUris!=null){
			for(String str : manageUris){
				if(uri.indexOf(str)>-1&&uri.indexOf("getUserPerformance")==1){
					return true;
				}
			}
		}
		return false;
	}
	

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}
	
	//返回错误
	private void returnError(String error,HttpServletResponse httpRes){
		httpRes.setContentType("application/json");
		Result result = new Result();
		result.getResult().put("error",error);
		String content = JSONUtil.toObject(result).toString();
		try {
			pw = new PrintWriter(new OutputStreamWriter(
					httpRes.getOutputStream(),"UTF-8"));
			pw.write(content);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(pw != null){
				pw.close();
			}
		}
		
	}
    
    //判断用户是否具备调用接口的权限
    private boolean hasAuthority(HttpSession httpSession, String uri) {
        boolean result = false;
        @SuppressWarnings("unchecked")
        List<String> userFunctions = (List<String>) httpSession.getAttribute("functions");
        List<String> allowFunctions = URLFunctionIdMapper.getFunctionByURL(uri);
        if(allowFunctions != null && userFunctions != null &&  userFunctions.size()>0){
            for(String userfunction : userFunctions){
                boolean flag = false;
                for(String allowFunction : allowFunctions){
                    if(userfunction.equals(allowFunction)){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}
