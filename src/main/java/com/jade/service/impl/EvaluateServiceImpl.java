package com.jade.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CommodityMapper;
import com.jade.dao.EvaluateMapper;
import com.jade.dao.UorderMapper;
import com.jade.dao.UserMapper;
import com.jade.mod.Commodity;
import com.jade.mod.Evaluate;
import com.jade.mod.EvaluateExample;
import com.jade.mod.EvaluateExample.Criteria;
import com.jade.mod.Uorder;
import com.jade.mod.User;
import com.jade.mod.UserExample;
import com.jade.po.Result;
import com.jade.service.EvaluateService;
import com.jade.uitil.Const;
import com.jade.uitil.ImageUtil;
import com.jade.uitil.PageBean;
import com.jade.uitil.UuidUtil;
@Service
public class EvaluateServiceImpl implements EvaluateService{

	@Autowired
	private EvaluateMapper evaluateMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CommodityMapper commodityMapper;
	@Autowired
	private UorderMapper uorderMapper;
	
	@Override
	public Result selectEvaluate(String cid,int page) {
		Result result = new Result();
		try {
			EvaluateExample example = new EvaluateExample();
			Criteria criteria = example.createCriteria();
			criteria.andCidEqualTo(cid);
			example.setLimit(Const.COMMODITY_PAGE);
			example.setOffset(Const.COMMODITY_PAGE*(page -1));
			example.setOrderByClause("evaluate_Time DESC");
			List<Map<String,Object>> list = evaluateMapper.selectByPage(example);
			
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					list.get(i).get("u_img");
					list.get(i).put("u_img", ImageUtil.getUrl(list.get(i).get("u_img").toString(), 600*1000));
					list.get(i).put("c_img", ImageUtil.getUrls(list.get(i).get("c_img").toString(), 600*1000).get(0));
				}
			}
			PageBean<String> records = new PageBean<>();
			records.setPageNum(page);
			records.setPageSize(Const.COMMODITY_PAGE);
			records.setBeanList(list);
			records.setTr(evaluateMapper.countByPage(example));
			if(0<list.size()){
				result.setSuccess(true);
				result.getResult().put("data", records);
			}else{
				result.setSuccess(true);
				result.getResult().put("data", records);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result writeEvaluate(String account, String cid,String uEvaluate,String orderId) {
		Result result = new Result();
		try {
			UserExample userExample = new UserExample();
			com.jade.mod.UserExample.Criteria criteria = userExample.createCriteria();
			criteria.andAccountEqualTo(account);
			List<User> user = userMapper.selectByExample(userExample);
			Commodity commodity = commodityMapper.selectByPrimaryKey(cid);
			Evaluate evaluate = new Evaluate();
			evaluate.setAccount(account);
			evaluate.setCid(cid);
			evaluate.setcImg(commodity.getCommodityimg());
			evaluate.setcName(commodity.getName());
			evaluate.setcNumber("1");
			evaluate.setEvaluateTime(new Date());
			evaluate.setId(UuidUtil.get32UUID());
			evaluate.setuEvaluate(uEvaluate);
			evaluate.setuImg(user.get(0).getHeadimg().toString());
			evaluate.setuName(user.get(0).getName());
			evaluateMapper.insert(evaluate);
			Uorder uorder = new Uorder();
			uorder.setOrderId(orderId);
			uorder.setType("0");
			uorderMapper.updateByPrimaryKeySelective(uorder);
			result.setSuccess(true);
			result.getResult().put("Evaluate", "评论成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}



}
