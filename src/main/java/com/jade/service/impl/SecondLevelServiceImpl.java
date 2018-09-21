package com.jade.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.SecondLevelMapper;
import com.jade.mod.SecondLevel;
import com.jade.mod.SecondLevelExample;
import com.jade.mod.SecondLevelExample.Criteria;
import com.jade.po.Result;
import com.jade.service.SecondLevelService;
import com.jade.uitil.ImageUtil;
@Service
public class SecondLevelServiceImpl implements SecondLevelService{

	@Autowired
	private SecondLevelMapper secondLevelMapper;
	
	@Override
	public Result getSecondIdByCategory(String categoryId) {
		Result result = new Result();
		try {
			SecondLevelExample example = new SecondLevelExample();
			Criteria criteria = example.createCriteria();
			criteria.andBelongtoLike("%"+categoryId+"%");
			criteria.andNameNotEqualTo("");
			List<Map<String,Object>> list = secondLevelMapper.getByExample(example);
			if(0<list.size()){
				for(int i=0;i<list.size();i++){
					list.get(i).put("categoryId", categoryId);
					list.get(i).put("img",ImageUtil.getUrl(list.get(i).get("reserve").toString(),60*1000));
				}
			}
			result.setSuccess(true);
			result.getResult().put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	
}
