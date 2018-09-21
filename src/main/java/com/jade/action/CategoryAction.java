package com.jade.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.dao.CategoryMapper;
import com.jade.po.Result;
import com.jade.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryAction {

	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 获取所有类别
	 * @return
	 */
	@RequestMapping(value="/getAllCategory.action",method=RequestMethod.POST)
	public @ResponseBody Result getAllCategory(HttpSession session){
//		String str = "2018-09-21 20:59:59";
		String agentId = (String)session.getAttribute("agentId");
		return categoryService.selectCategory(agentId);
		
	}

}
