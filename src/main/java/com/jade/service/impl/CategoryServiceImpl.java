package com.jade.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CategoryMapper;
import com.jade.mod.Category;
import com.jade.mod.CategoryExample;
import com.jade.mod.CategoryExample.Criteria;
import com.jade.po.Result;
import com.jade.service.CategoryService;
import com.jade.uitil.ImageUtil;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryMapper cateoryMapper;
	
	@Override
	public Result selectCategory(String agentId) {
		Result result= new Result();
		try{
			CategoryExample example = new CategoryExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIsNotNull();
			criteria.andNameNotEqualTo("");
			criteria.andReserveEqualTo(agentId);
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			List<Category> listCategory = cateoryMapper.selectByExample(example);
			if(listCategory.size()>0){
				for(int i=0;i<listCategory.size();i++){
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("name", listCategory.get(i).getName());
					map.put("categoryId", listCategory.get(i).getFirstId());
					map.put("img", ImageUtil.getUrl(listCategory.get(i).getShowimg(), 60*1000));
					list.add(map);
				}
				result.setSuccess(true);
				result.getResult().put("data", list);
			}else{
				result.setSuccess(true);
				result.getResult().put("data", list);
			}
		}catch(Exception e){
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
			return result;
		}

}
