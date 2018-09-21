package com.jade.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CommodityMapper;
import com.jade.dao.ExpressMapper;
import com.jade.dao.UorderMapper;
import com.jade.manage.service.UOrderManageService;
import com.jade.mod.Commodity;
import com.jade.mod.Express;
import com.jade.mod.Uorder;
import com.jade.mod.UorderExample;
import com.jade.po.Result;
import com.jade.uitil.Const;
import com.jade.uitil.ImageUtil;
import com.jade.uitil.PageBean;
@Service
public class UOrderManageServiceImpl implements UOrderManageService{
	
	@Autowired
	private UorderMapper uOrderMapper;

	@Autowired
	private CommodityMapper comMapper;
	
	@Autowired
	private ExpressMapper expressService;
	
	/**
	 * 退单
	 * @param data
	 * @return
	 */
	@Override
	public Result returnedUOrder(JSONObject data) {
		Result result = new Result();
		try {
			String orderId = data.getString("orderId");
			Uorder uorder = uOrderMapper.selectByPrimaryKey(orderId);
			if(uorder==null){
				result.setSuccess(false);
				result.getResult().put("error", "不存在此订单");
			}else{
				
				Commodity commodity = comMapper.selectByPrimaryKey(uorder.getCid());
				
				int inven = commodity.getInventory();
				Commodity commodity1=new Commodity();
				commodity1.setCid(uorder.getCid());
				commodity1.setInventory(inven+1);
				comMapper.updateByPrimaryKeySelective(commodity1);
				uOrderMapper.deleteByPrimaryKey(orderId);
				result.setSuccess(true);
				result.getResult().put("error", "退单成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}
	
	
	
	/**
	 * 查看某代理商的所有订单
	 * @param data
	 * @return
	 */

	@Override
	public Result getMyAllUOrder(JSONObject data,String account) {
		Result result = new Result();
		try {
			//int page = data.getInt("page");
//			if(data.has("type")){
//				
//			}
			String type = data.getString("type");
	
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("type", type);
			map.put("account", account);
		//	map.put("limit", Const.COMMODITY_PAGE);
		//	map.put("offset", Const.COMMODITY_PAGE*(page-1));
			
			
			List<Map<String,Object>> list = uOrderMapper.getMyAllUOrder(map);
			if(type.equals("3")){
				for(int i=0;i<list.size();i++){
					Date date = (Date) list.get(i).get("endTime");
					Calendar   calendar   =   new   GregorianCalendar(); 
				    calendar.setTime(date); 
				    calendar.add(calendar.DATE,3);//把日期往后增加一天.整数往后推,负数往前移动 
				    date=calendar.getTime();   //这个时间就是日期往后推一天的结果 
				    list.get(i).put("evaluateTime", date);
				}
			}
		
			
			//PageBean<String> records = new PageBean<>();
			//records.setPageNum(page);
			//records.setPageSize(Const.COMMODITY_PAGE);
			//records.setBeanList(list);
			//records.setTr(uOrderMapper.countMyAllUOrder(map));
			result.setSuccess(true);
			result.getResult().put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	/**
	 * 查看订单（含收货地址，商品详情）
	 */
	@Override
	public Result checkComAndRec(JSONObject data) {
		Result result = new Result();
		try {
			String orderId = data.getString("orderId");
			Map<String,Object> map = uOrderMapper.getComAndRecInType1(orderId);
			if(null!=map.get("video")&&!map.get("video").equals("0")&&(map.get("video").toString()).indexOf(",00000000")!=-1){
				map.put("video", ImageUtil.getUrls(map.get("video").toString(), 60*1000).get(0));
			}else{
				map.put("img", ImageUtil.getUrls(map.get("img").toString(), 60*1000));
			}
			result.setSuccess(true);
			result.setResult(map);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	/**
	 * 改变订单状态（待发货）
	 */
	@Override
	public Result changeUOrderType(JSONObject data) {
		Result result = new Result();
		try {
			String orderId = data.getString("orderId");
			Uorder uorder = uOrderMapper.selectByPrimaryKey(orderId);
			if(uorder==null){
				result.setSuccess(false);
				result.getResult().put("error", "不存在此订单");
			}else{
				String expressId = data.getString("expressId");
				String expressCompany = data.getString("expressCompany");
			
				Express express = new Express();
				express.setExpressCompany(expressCompany);
				express.setExpressId(expressId);
				express.setOrderId(orderId);
				expressService.insertSelective(express);
				Commodity commodity =  comMapper.selectByPrimaryKey(uorder.getCid());
				int invent = commodity.getInventory();
				if(invent>0){
					
					Uorder uorderChange = new Uorder();
					String type = uorder.getType();
					if(type.equals("1")){
						uorderChange.setType("2");
						uorderChange.setOrderId(orderId);
						uorderChange.setRecevingTime(new Date());
						uOrderMapper.updateByPrimaryKeySelective(uorderChange);
						
						
						result.setSuccess(true);
						result.getResult().put("UOrder", "已发货");
					}else{
						result.setSuccess(true);
						result.getResult().put("error", "此订单未处于待发货状态");
					}
				}else{
					result.setSuccess(true);
					result.getResult().put("UOrder", "库存为0");
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}
	/**
	 * 恢复订单
	 * @param data
	 * @return
	 */
	@Override
	public Result restoreUOrder(JSONObject data) {
		Result result = new Result();
		try {
			String orderId = data.getString("orderId");
			Uorder uorder = uOrderMapper.selectByPrimaryKey(orderId);
			if(uorder==null){
				result.setSuccess(false);
				result.getResult().put("error", "不存在此订单");
			}else{
				Uorder uorderChange = new Uorder();
				String type = uorder.getType();
				if("4".equals(type)){
					uorderChange.setType("1");
					uorderChange.setOrderId(orderId);
					uorderChange.setOrderTime(new Date());
					Calendar calendar = Calendar.getInstance();
			        calendar.add(Calendar.MINUTE, 30);
			        String closeTime =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
			        uorderChange.setReserve(closeTime);
			        uOrderMapper.updateByPrimaryKeySelective(uorderChange);
					result.setSuccess(true);
					result.getResult().put("UOrder", "已恢复订单"+orderId);
				}else{
					result.setSuccess(false);
					result.getResult().put("error", "订单未处在关闭状态");
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
