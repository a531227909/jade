package com.jade.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CommodityMapper;
import com.jade.dao.ShoppingCartMapper;
import com.jade.dao.SupplierMapper;
import com.jade.mod.Commodity;
import com.jade.mod.ShoppingCart;
import com.jade.mod.ShoppingCartExample;
import com.jade.mod.Supplier;
import com.jade.mod.SupplierExample;
import com.jade.mod.ShoppingCartExample.Criteria;
import com.jade.po.Result;
import com.jade.service.ShoppingCartService;
import com.jade.uitil.ImageUtil;
import com.jade.uitil.UuidUtil;
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

	@Autowired
	private ShoppingCartMapper shoppingCartMapper;
	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private CommodityMapper comMapper;
	
	@Override
	public Result selectShoppingCart(String account) {
		// TODO Auto-generated method stub
		Result result = new Result();
		try {
			
			//List<Map<String,Object>> allMap = new ArrayList<Map<String,Object>>();
			int total = 0;
			
				
				ShoppingCartExample example = new ShoppingCartExample();
				Criteria criteria = example.createCriteria();
				criteria.andAccountEqualTo(account);
			
				List<Map<String,Object>> lmap = shoppingCartMapper.selectBySup(example);
				for(int i=0;i<lmap.size();i++){
					
					if(null!=lmap.get(i).get("video")&&!"0".equals(lmap.get(i).get("video"))&&(lmap.get(i).get("video").toString()).indexOf(",00000000")!=-1){
						List<String> url = ImageUtil.getUrls(lmap.get(i).get("video").toString(),60*1000);
						lmap.get(i).put("video", url.get(0));
						lmap.get(i).put("videoImg", url.get(1));
					}else{
						if(null!=lmap.get(i).get("img")&&!"0".equals(lmap.get(i).get("img"))){
							List<String> url = ImageUtil.getUrls(lmap.get(i).get("img").toString(),60*1000);
							lmap.get(i).put("img", url.get(0));
							
						}else{
							lmap.get(i).put("img", "");
						}
					}
	
					Supplier suppliers = supplierMapper.selectByPrimaryKey(lmap.get(i).get("sid").toString());
					lmap.get(i).put("supplier", suppliers.getName());
					total= total+Integer.parseInt(lmap.get(i).get("price").toString());
//						map.put("supplier", suppliers.get(i).getName());
//						map.put("sid", suppliers.get(i).getSid());
//						map.put("content", lmap);
						//allMap.add(map);
					
				}
				
			
			if(0<lmap.size()){
				
				
				result.setSuccess(true);
				result.getResult().put("data", lmap);
			}else{
				result.setSuccess(true);
				result.getResult().put("data", lmap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result insertShoppingCart(String cid, String number,
			String account) {
		Result result = new Result();
		try {
			Commodity shopping = comMapper.selectByPrimaryKey(cid);
			ShoppingCart sc = shoppingCartMapper.selectByCidAccount(cid, account);
			if(!(sc==null||sc.equals(""))){
				number = String.valueOf(Integer.parseInt(number)+Integer.parseInt(sc.getNumber()));
				sc.setNumber(number);
				shoppingCartMapper.updateByPrimaryKeySelective(sc);
			}else{
				ShoppingCart shoppingCart = new ShoppingCart();
				shoppingCart.setAccount(account);
				shoppingCart.setCid(cid);
				shoppingCart.setColor(shopping.getColor());
				shoppingCart.setId(UuidUtil.get32UUID());
				shoppingCart.setImg(shopping.getCommodityimg());
				shoppingCart.setName(shopping.getName());
				shoppingCart.setNumber(number);
				shoppingCart.setPrice(shopping.getPrice().toString());
				shoppingCart.setSid(shopping.getSid());
				shoppingCartMapper.insert(shoppingCart);
			}
			result.setSuccess(true);
			result.getResult().put("ShoppingCart", "购物车添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result delShoppingCart(String id) {
		Result result = new Result();
		try {
			shoppingCartMapper.deleteByPrimaryKey(id);
			result.setSuccess(true);
			result.getResult().put("ShoppingCart", "购物车删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result updateShoppingCart(String cid, String number, String account) {
		Result result = new Result();
		try {
			ShoppingCart sc = shoppingCartMapper.selectByCidAccount(cid, account);
			if(!(sc==null||sc.equals(""))){
				sc.setNumber(number);
				shoppingCartMapper.updateByPrimaryKeySelective(sc);
			}else{
				result.setSuccess(false);
				result.getResult().put("error", "购物车中不存在此物品");
			}
			result.setSuccess(true);
			result.getResult().put("ShoppingCart", "购物车物品数量更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	

}
