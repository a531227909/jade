package com.jade.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.po.Result;
import com.jade.service.SecondLevelService;

@Controller
@RequestMapping(value="/secondLevel")
public class SecondLevelAction {

	@Autowired
	private SecondLevelService levelService;
	
	/**
	 * 根据一级类别获取二级列表
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value="/getSecondIdByCategory.action",method=RequestMethod.POST)
	public @ResponseBody Result getSecondIdByCategory(String categoryId){
		
		return levelService.getSecondIdByCategory(categoryId);
		
	}
}
