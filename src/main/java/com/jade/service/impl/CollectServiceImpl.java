package com.jade.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CollectMapper;
import com.jade.dao.CommodityMapper;
import com.jade.dao.SupplierMapper;
import com.jade.mod.Collect;
import com.jade.mod.CollectExample;
import com.jade.mod.CollectExample.Criteria;
import com.jade.mod.Commodity;
import com.jade.mod.CommodityExample;
import com.jade.mod.Supplier;
import com.jade.po.Result;
import com.jade.service.CollectService;
import com.jade.uitil.Const;
import com.jade.uitil.ImageUtil;
import com.jade.uitil.PageBean;
@Service
public class CollectServiceImpl implements CollectService{
	
	@Autowired
	private CollectMapper collectMapper;
	@Autowired
	private CommodityMapper commodityMapper;
	
	@Autowired
	private SupplierMapper supplierMapper;
	
	@Override
	public Result getCollectByUser(String account,int page) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			CollectExample collectExample = new CollectExample();
			collectExample.setOffset(Const.COMMODITY_PAGE*(page -1));
			collectExample.setLimit(Const.COMMODITY_PAGE);
			collectExample.setOrderByClause("createTime desc");
			Criteria criteria = collectExample.createCriteria();
			criteria.andAccountEqualTo(account);
			List<Collect> collect = collectMapper.selectByExample(collectExample);
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			List<String> notList = new ArrayList<String>();
			if(0<collect.size()){
				for(int i=0;i<collect.size();i++){
					
					Commodity com = commodityMapper.selectByPrimaryKey(collect.get(i).getCid());
					if(!com.getStatus().equals("0")){
						Map<String,Object> map = new HashMap<String, Object>();
						if(!com.getIsnopackagemaill().equals("0")&&null!=com.getIsnopackagemaill() ){
							map.put("video", ImageUtil.getUrls(com.getIsnopackagemaill(),600*10000).get(0));
							map.put("videoImg", ImageUtil.getUrls(com.getIsnopackagemaill(),60*1000).get(1));
						}else{
							map.put("img", ImageUtil.getUrls(collect.get(i).getCommodityimg(),60*1000).get(0));
						}
						map.put("name", collect.get(i).getName());
						map.put("price", collect.get(i).getPrice());
						Supplier supplier = supplierMapper.selectByPrimaryKey(collect.get(i).getSid());
						map.put("sid", supplier.getSid());
						map.put("supplier", supplier.getName());
						map.put("cid", collect.get(i).getCid());
						list.add(map);
					}else{
						notList.add(collect.get(i).getCid());
					}
				
				}
				if(list.size()>0){
					PageBean<String> records = new PageBean<>();
					records.setPageNum(page);
					records.setPageSize(Const.COMMODITY_PAGE);
					records.setBeanList(list);
					if(notList.size()>0){
						criteria.andCidNotIn(notList);
					}
					
					records.setTr(collectMapper.countByExample(collectExample));
					result.setSuccess(true);
					result.getResult().put("data", list);
				}else{
					PageBean<String> records = new PageBean<>();
					records.setPageNum(page);
					records.setPageSize(Const.COMMODITY_PAGE);
					records.setBeanList(list);
					criteria.andCidNotIn(notList);
					records.setTr(0);
					result.setSuccess(true);
					result.getResult().put("data", list);
				}
				
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

	@Override
	public Result changeCollect(String cId,String account) {
		Result result = new Result();
		try {
			CollectExample collectExample = new CollectExample();
			com.jade.mod.CollectExample.Criteria criteria = collectExample.createCriteria();
			criteria.andCidEqualTo(cId);
			criteria.andAccountEqualTo(account);
			List<Collect> collectL = collectMapper.selectByExample(collectExample);
			if(0<collectL.size()){
				collectMapper.deleteByExample(collectExample);
				result.setSuccess(true);
				result.getResult().put("collect", "已取消收藏");
			}else{
				CommodityExample commodityExample = new CommodityExample();
				com.jade.mod.CommodityExample.Criteria criteria2 = commodityExample.createCriteria();
				criteria2.andCidEqualTo(cId);
				List<Commodity> commodity = commodityMapper.selectByExample(commodityExample);
				if(0<commodity.size()){
					Collect collect = new Collect();
					collect.setCid(commodity.get(0).getCid());
					collect.setId(UUID.randomUUID().toString());
					collect.setAccount(account);
					collect.setSid(commodity.get(0).getSid());
					collect.setName(commodity.get(0).getName());
					collect.setCategoryId(commodity.get(0).getCategoryId());
					collect.setPrice(commodity.get(0).getPrice());
					collect.setCreatetime(new Date());
					collect.setCommodityimg(commodity.get(0).getCommodityimg());
					collectMapper.insertSelective(collect);
					result.setSuccess(true);
					result.getResult().put("collect", "已添加收藏");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		
		return result;
	}

	
}
