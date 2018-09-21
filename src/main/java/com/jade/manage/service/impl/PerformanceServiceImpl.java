package com.jade.manage.service.impl;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

import com.jade.dao.PerformanceMapper;
import com.jade.manage.service.PerformanceService;
import com.jade.mod.Performance;
import com.jade.mod.PerformanceExample;
import com.jade.mod.PerformanceExample.Criteria;
import com.jade.mod.PerformanceExample.Criterion;
import com.jade.po.Result;
@Service
public class PerformanceServiceImpl implements PerformanceService{

	@Autowired
	private PerformanceMapper performanceMapper;
	//查询代理商业绩
	@Override
	public Result agentPerformance(JSONObject data) {
		Result result = new Result();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sid = data.getString("sid");
			PerformanceExample example = new PerformanceExample();
			Criteria critera = example.createCriteria();
			critera.andSidEqualTo(sid);
			if(data.has("beginTime")&&data.has("endTime")){
				String beginTime = data.getString("beginTime");
				String endTime = data.getString("endTime");
				if(!"".equals(beginTime)&&!"".equals(endTime))
				critera.andEndTimeBetween(format.parse(beginTime), format.parse(endTime));
			}
			List<Performance> list = performanceMapper.selectByExample(example);
			if(list!=null&&0<list.size()){
				result.setSuccess(true);
				result.getResult().put("data", list);
				}else{
					result.setSuccess(true);
					result.getResult().put("data", list);
				}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}
	//清空代理商业绩
	@Override
	public Result delagentPerformance(JSONObject data) {
		Result result = new Result();
		try {
			String sid = data.getString("sid");
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			PerformanceExample example = new PerformanceExample();
			Criteria critera = example.createCriteria();
			critera.andSidEqualTo(sid);
			if(data.has("beginTime")&&data.has("endTime")){
				String beginTime = data.getString("beginTime");
				String endTime = data.getString("endTime");
				if(!"".equals(beginTime)&&!"".equals(endTime))
				critera.andEndTimeBetween(format.parse(beginTime), format.parse(endTime));
			}
			performanceMapper.deleteByExample(example);
			result.setSuccess(true);
			result.getResult().put("success", "已清空代理商业绩");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	

}
