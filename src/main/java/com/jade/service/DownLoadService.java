package com.jade.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jade.po.Result;

public interface DownLoadService {
	
	public Result downLoad(HttpServletRequest request, HttpServletResponse response);

}
