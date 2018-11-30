package com.jade.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.po.Result;
import com.jade.service.DownLoadService;


@Controller
@RequestMapping("/download")
public class DownLoadController {
	
	@Resource
	DownLoadService downLoadService;
	
	@RequestMapping("/downloadapp.action")
	@ResponseBody
	public Result download(HttpServletRequest request, HttpServletResponse response){ 
		Result result = downLoadService.downLoad(request, response);
		return result;
	}
	
}