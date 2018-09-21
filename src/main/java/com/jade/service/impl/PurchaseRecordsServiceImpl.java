package com.jade.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.jade.dao.CommodityMapper;
import com.jade.dao.PurchaseRecordsMapper;
import com.jade.dao.SupplierMapper;
import com.jade.mod.Commodity;
import com.jade.mod.PurchaseRecords;
import com.jade.mod.PurchaseRecordsExample;
import com.jade.mod.PurchaseRecordsExample.Criteria;
import com.jade.po.Result;
import com.jade.service.PurchaseRecordsService;
import com.jade.uitil.Const;
import com.jade.uitil.ImageUtil;
import com.jade.uitil.PageBean;
@Service
public class PurchaseRecordsServiceImpl implements PurchaseRecordsService{
	
	@Autowired
	private PurchaseRecordsMapper purchaseRecordsMapper;
	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private CommodityMapper comMapper;

	@Override
	public Result selectPurchaseRecords(String account,int page) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			PurchaseRecordsExample example = new PurchaseRecordsExample();
			example.setOffset(Const.COMMODITY_PAGE*(page -1));
			example.setLimit(Const.COMMODITY_PAGE);
			example.setOrderByClause("create_Time desc");
			Criteria criteria = example.createCriteria();
			criteria.andAccountEqualTo(account);
			List<PurchaseRecords> purchaseRecords = purchaseRecordsMapper.selectByExample(example);
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			if(0<purchaseRecords.size()){
				
				for(int i=0;i<purchaseRecords.size();i++){
					Commodity com = comMapper.selectByPrimaryKey(purchaseRecords.get(i).getCid());
					Map<String,Object> map = new HashMap<String, Object>();
					if(null!=com.getIsnopackagemaill()&&!"0".equals(com.getIsnopackagemaill())){
						List<String> url = ImageUtil.getUrls(com.getIsnopackagemaill(),60*1000);
						map.put("video", url.get(0));
						map.put("videoImg", url.get(1));
					}else{
						if(null!=com.getCommodityimg()&&!"0".equals(com.getCommodityimg())){
							List<String> url = ImageUtil.getUrls(com.getCommodityimg(),60*1000);
							map.put("img", url.get(0));
							
						}else{
							map.put("img", "");
						}
					}
					//map.put("img", ImageUtil.getUrl(purchaseRecords.get(i).getReserve(),60*1000));
					map.put("name", purchaseRecords.get(i).getName());
					map.put("supplier", supplierMapper.selectByPrimaryKey(purchaseRecords.get(i).getSid()).getName());
					map.put("price", purchaseRecords.get(i).getPrice());
					map.put("color", com.getColor());
					list.add(map);
				}
				
				PageBean<String> records = new PageBean<>();
				records.setPageNum(page);
				records.setPageSize(Const.COMMODITY_PAGE);
				records.setBeanList(list);
				records.setTr(purchaseRecordsMapper.countByExample(example));
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

	

}
