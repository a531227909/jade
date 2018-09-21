package com.jade.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jade.dao.ConditionMapper;
import com.jade.mod.Condition;
import com.jade.mod.ConditionExample;
import com.jade.mod.ConditionExample.Criteria;
import com.jade.po.Result;
import com.jade.service.ConditionService;
@Service
public class ConditionServiceImpl implements ConditionService{

	@Autowired
	private ConditionMapper conditionMapper;
	/**
	 * 获取颜色，种水，价格
	 */
	@Override
	public Result getCondition() {
		Result result = new Result();
		try {
			ConditionExample conditionExample = new ConditionExample();
			Criteria criteria = conditionExample.createCriteria();
			criteria.andIdIsNotNull();
			List<Condition> list = conditionMapper.selectByExample(conditionExample);
			List<String> color = new ArrayList<String>();
			List<String> water = new ArrayList<String>();
			List<String> price = new ArrayList<String>();
			Map<String,Object> map = new HashMap<String,Object>();
			if(list!=null){
				for(int i=0;i<list.size();i++){
					if(list.get(i).getColor()!=null&&!"null".equals(list.get(i).getColor())){
						color.add(list.get(i).getColor());
					}
					if(list.get(i).getWater()!=null&&!"null".equals(list.get(i).getWater())){
						water.add(list.get(i).getWater());
					}
					if(list.get(i).getPrice()!=null&&!"null".equals(list.get(i).getPrice())){
						price.add(list.get(i).getPrice());
					}
				}
			}
			map.put("color", color);
			map.put("price", price);
			map.put("water", water);
			result.setSuccess(true);
			result.setResult(map);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}

}
