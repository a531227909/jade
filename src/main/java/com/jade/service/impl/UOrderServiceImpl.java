package com.jade.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.AgentMapper;
import com.jade.dao.CategoryMapper;
import com.jade.dao.CommodityMapper;
import com.jade.dao.PerformanceMapper;
import com.jade.dao.PurchaseRecordsMapper;
import com.jade.dao.ShoppingCartMapper;
import com.jade.dao.UorderMapper;
import com.jade.mod.Category;
import com.jade.mod.CategoryExample;
import com.jade.mod.Commodity;
import com.jade.mod.Performance;
import com.jade.mod.PerformanceExample;
import com.jade.mod.PurchaseRecords;
import com.jade.mod.ShoppingCartExample;
import com.jade.mod.Uorder;
import com.jade.mod.UorderExample;
import com.jade.mod.UorderExample.Criteria;
import com.jade.po.Result;
import com.jade.service.UOrderService;
import com.jade.uitil.Const;
import com.jade.uitil.IdUtil;
import com.jade.uitil.ImageUtil;
import com.jade.uitil.PageBean;
import com.jade.uitil.PriceUtils;
import com.jade.uitil.UuidUtil;
@Service
public class UOrderServiceImpl implements UOrderService{
	
	@Autowired
	private UorderMapper uOrderMapper;
	@Autowired
	private CommodityMapper comMapper;
	@Autowired
	private ShoppingCartMapper shoppingMapper;
	@Autowired
	private PurchaseRecordsMapper reMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private PerformanceMapper performanceMapper;
	
	
	@Override
	public Result insertOrder(JSONObject data, String account) {
		Result result = new Result();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		try {
			//List<Map<String,Object>> list = (List<Map<String, Object>>) data.get("data");
			//JSONArray jsonArray = data.getJSONArray("data");
			JSONArray jsonArray = data.getJSONArray("data");
			List<Object> retu = new ArrayList<Object>();
			List<IdUtil> list = (List<IdUtil>) JSONArray.toCollection(jsonArray, IdUtil.class); 
			//System.out.println("******"+list.get(0));
			for(int i=0;i<list.size();i++){
				//JSONObject jsonObject2 = jsonArray.getJSONObject(i);
				String cid =  list.get(i).getCid();
				String rid =  list.get(i).getRid();
				String sid =  list.get(i).getSid();
				Commodity commodity = comMapper.selectByPrimaryKey(cid);
				int inven = commodity.getInventory();
				
				if(inven>0){
					String str=sdf.format(new Date());
					java.util.Random random=new java.util.Random();
					String str1 = random.nextInt(10)*random.nextInt(10)+"";
					String str2 = random.nextInt(10)*random.nextInt(10)+"";
					
					Uorder uorder = new Uorder();
					uorder.setOrderId(str2+str+str1);
					uorder.setAccount(account);
					uorder.setCid(cid);
					uorder.setOrderTime(new Date());
					uorder.setRid(rid);
					uorder.setSid(sid);
					uorder.setType("1");
					Calendar calendar = Calendar.getInstance();
			        calendar.add(Calendar.MINUTE, 30);
			        String closeTime =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
			        uorder.setReserve(closeTime);
					uOrderMapper.insert(uorder);
					
					commodity.setInventory(1);
					commodity.setStatus("0");
					commodity.setCid(uorder.getCid());
					comMapper.updateByPrimaryKeySelective(commodity);
					
					retu.add("商品"+cid+",下单成功");
					
					
				}else{
					retu.add("商品"+cid+",库存为0");
					
				}
			
			}
			
			result.setSuccess(true);
			result.getResult().put("date",retu);
		
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result selectOrderByType(String type, String account,int page) {
		Result result = new Result();
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			if(!"null".equals(type)&&null!=type){
				map.put("type", type);
			}
			
			map.put("account", account);
			map.put("limit", Const.COMMODITY_PAGE);
			map.put("offset", Const.COMMODITY_PAGE*(page-1));
			map.put("orderByClause", "u.order_time desc");
			
			List<Map<String,Object>> list = uOrderMapper.getMyAllUOrder(map);
			if(0<list.size()){
				for(int i=0;i<list.size();i++){
					if(null!=list.get(i).get("video")&&!"0".equals(list.get(i).get("video"))&&(list.get(i).get("video").toString()).indexOf(",00000000")!=-1){
						List<String> url = ImageUtil.getUrls(list.get(i).get("video").toString(),60*1000);
						list.get(i).put("video", url.get(0));
						list.get(i).put("videoImg", url.get(1));
					}else{
						List<String> url = ImageUtil.getUrls(list.get(i).get("img").toString(),60*1000);
						list.get(i).put("img", url.get(0));
					}
					
				}
				PageBean pageBean = new PageBean<Map<String,Object>>();
				pageBean.setBeanList(list);
				pageBean.setPageNum(page);
				pageBean.setPageSize(Const.COMMODITY_PAGE);
				pageBean.setTr(list.size());
				result.setSuccess(true);
				result.getResult().put("data", pageBean);
			}else{
				PageBean pageBean = new PageBean<Map<String,Object>>();
				pageBean.setBeanList(list);
				pageBean.setPageNum(page);
				pageBean.setPageSize(Const.COMMODITY_PAGE);
				pageBean.setTr(list.size());
				result.setSuccess(true);
				result.getResult().put("data", pageBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result delOrder(String orderId, String account) {
		Result result = new Result();
		try {
			UorderExample example = new UorderExample();
			Criteria criteria = example.createCriteria();
			criteria.andAccountEqualTo(account);
			criteria.andOrderIdEqualTo(orderId);
			uOrderMapper.deleteByExample(example);
			result.setSuccess(true);
			result.getResult().put("UOrder", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result selectByOrderId(String orderId) {
		Result result = new Result();
		try {
			Uorder uorder = uOrderMapper.selectByPrimaryKey(orderId);
			if(uorder.getType().equals("1")){
				List<Map<String,Object>> list = uOrderMapper.selectByOrderIdtoOne(orderId);
				if(null!=list.get(0).get("video")&&!"0".equals(list.get(0).get("video"))&&(list.get(0).get("video").toString()).indexOf(",00000000")!=-1){
					List<String> url = ImageUtil.getUrls(list.get(0).get("video").toString(),60*1000);
					list.get(0).put("video", url.get(0));
					list.get(0).put("videoImg", url.get(1));
				}else{
					List<String> url = ImageUtil.getUrls(list.get(0).get("img").toString(),60*1000);
					list.get(0).put("img", url.get(0));
				}
				result.setSuccess(true);
				result.getResult().put("data", list);
			}else{
				List<Map<String,Object>> list = uOrderMapper.selectByOrderId(orderId);
				for(Map<String,Object> map : list){
					for(String key : map.keySet()){
						System.out.println("Key = " + key+"value = " + map.get(key));
					}
				}
				System.out.println(list);
				
					if("3".equals(list.get(0).get("oType"))){
						int type3 = uOrderMapper.selectByType3(list.get(0).get("oId").toString());
						if(type3>0){
//							int d = type3/86400;
//							int h = type3%86400/3600;
//							int m = type3%86400%3600/60;
//							String str3 = d+"天"+h+"时"+m+"分";
//							list.get(0).put("evaluateTime", str3);
							Date date = (Date) list.get(0).get("eTime");
							Calendar   calendar   =   new   GregorianCalendar(); 
						    calendar.setTime(date); 
						    calendar.add(calendar.DATE,3);//把日期往后增加一天.整数往后推,负数往前移动 
						    date=calendar.getTime();   //这个时间就是日期往后推一天的结果 
						    list.get(0).put("evaluateTime", date);
						    
						}
					}else if("2".equals(list.get(0).get("oType"))){
						int type2 = uOrderMapper.selectByType2(list.get(0).get("oId").toString());
						if(type2>0){
//							int d = type2/86400;
//							int h = type2%86400/3600;
//							int m = type2%86400%3600/60;
//							String str2 = d+"天"+h+"时"+m+"分";
//							list.get(0).put("receivingTime", str2);
							
							Date date = (Date) list.get(0).get("rTime");
							Calendar   calendar   =   new   GregorianCalendar(); 
						    calendar.setTime(date); 
						    calendar.add(calendar.DATE,7);//把日期往后增加一天.整数往后推,负数往前移动 
						    date=calendar.getTime();   //这个时间就是日期往后推一天的结果 
						    list.get(0).put("receivingTime", date);
						    list.get(0).put("eTime", "");
						}
					}
					if(null!=list.get(0).get("video")&&!"0".equals(list.get(0).get("video"))&&(list.get(0).get("video").toString()).indexOf(",00000000")!=-1){
						
						List<String> url = ImageUtil.getUrls(list.get(0).get("video").toString(),60*1000);
						list.get(0).put("video", url.get(0));
						list.get(0).put("videoImg", url.get(1));
					}else{
						List<String> url = ImageUtil.getUrls(list.get(0).get("img").toString(),60*1000);
						list.get(0).put("img", url.get(0));
					}
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
	public Result insertOrderByCart(JSONObject data, String account) {
		Result result = new Result();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		try {
			//List<Map<String,Object>> list = (List<Map<String, Object>>) data.get("data");
			//JSONArray jsonArray = data.getJSONArray("data");
			JSONArray jsonArray = data.getJSONArray("data");
			List<Object> retu = new ArrayList<Object>();
			List<IdUtil> list = (List) JSONArray.toCollection(jsonArray, IdUtil.class); 
			//Map<String,Object> map = new HashMap<String, Object>();
			//System.out.println("******"+list.get(0));
			int total = 0 ;
			for(int i=0;i<list.size();i++){
				//JSONObject jsonObject2 = jsonArray.getJSONObject(i);
				String cid =  list.get(i).getCid();
				String rid =  list.get(i).getRid();
				String sid =  list.get(i).getSid();
				String number = list.get(i).getNumber();
				String money = list.get(i).getMoney();
				String user_coupon_id = list.get(i).getUser_coupon_id();
				String user_coupon_money = list.get(i).getUser_coupon_money();
				Commodity commodity = comMapper.selectByPrimaryKey(cid);
				if(commodity!=null){
					
					if(!commodity.getStatus().equals("0")){
						String str=sdf.format(new Date());
						java.util.Random random=new java.util.Random();
						String str1 = random.nextInt(10)*random.nextInt(10)+"";
						String str2 = random.nextInt(10)*random.nextInt(10)+"";
						ShoppingCartExample cartExample = new ShoppingCartExample();
						com.jade.mod.ShoppingCartExample.Criteria criteria =  cartExample.createCriteria();
						criteria.andSidEqualTo(sid);
						criteria.andCidEqualTo(cid);
						//List<ShoppingCart> shoplist = shoppingMapper.selectByExample(cartExample);
						shoppingMapper.deleteByExample(cartExample);
						Uorder uorder = new Uorder();
						uorder.setOrderId(str2+str+str1);
						uorder.setAccount(account);
						uorder.setCid(cid);
						uorder.setOrderTime(new Date());
						uorder.setRid(rid);
						uorder.setSid(sid);
						uorder.setType("1");
						uorder.setNumber(number);
						uorder.setMoney(money);
						uorder.setUser_coupon_id(user_coupon_id);
						uorder.setUser_coupon_money(user_coupon_money);
						Calendar calendar = Calendar.getInstance();
				        calendar.add(Calendar.MINUTE, 30);
				        String closeTime =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
				        uorder.setReserve(closeTime);
						uOrderMapper.insert(uorder);
						retu.add("商品"+cid+",下单成功");
						
						
					}else{
						retu.add("商品"+cid+",已下架");
						System.out.println("已下架");
					}
				}else{
					result.setSuccess(true);
					result.getResult().put("error", "没有此商品");
				}
			}
			result.setSuccess(true);
			result.getResult().put("date",retu);
		
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}
	/**
	 * 修改待收货为收货状态
	 */
	@Override
	public Result updateOrder(String orderId, String type,String account) {
		Result result = new Result();
		try {
			Uorder uorder = new Uorder();
			uorder.setOrderId(orderId);
			if(type.equals("2")){
				uorder.setType("3");
				uorder.setEndTime(new Date());
				//历史结缘
				uOrderMapper.updateByPrimaryKeySelective(uorder);
				
				Uorder uo = uOrderMapper.selectByPrimaryKey(orderId);
				
				PurchaseRecords purchaseRecords = new PurchaseRecords();
				purchaseRecords.setCid(uo.getCid());
				purchaseRecords.setCreateTime(new Date());
				purchaseRecords.setId(UuidUtil.get32UUID());
				Commodity com = comMapper.selectByPrimaryKey(uo.getCid());
				purchaseRecords.setName(com.getName());
				purchaseRecords.setPrice(com.getPrice().toString());
				purchaseRecords.setSid(com.getSid());
				purchaseRecords.setAccount(account);
				reMapper.insertSelective(purchaseRecords);
				//统计业绩
				PerformanceExample example = new PerformanceExample();
				com.jade.mod.PerformanceExample.Criteria criteria = example.createCriteria();
				criteria.andCidEqualTo(uo.getCid());
				List<Performance> per = performanceMapper.selectByExample(example);
				if(per.size()==0){
					Commodity commo = comMapper.selectByPrimaryKey(uo.getCid());
					CategoryExample example2 = new CategoryExample();
					com.jade.mod.CategoryExample.Criteria criteria2 = example2.createCriteria();
					criteria2.andFirstIdEqualTo(commo.getCategoryId());
					Category category = categoryMapper.selectByExample(example2).get(0);
					Performance performance = new Performance();
					performance.setCid(uo.getCid());
					performance.setSid(com.getSid());
					performance.setCnumber((long)1);
					performance.setEndTime(new Date());
					performance.setId(UUID.randomUUID().toString());
					performance.setCprice(Long.parseLong(PriceUtils.getOnePrice(com.getPrice())));
					performance.setTotal(Long.parseLong(PriceUtils.getOnePrice(com.getPrice())));
					performance.setCname(com.getName());
					performance.setCcolor(commo.getColor());
					performance.setFname(category.getName());
					performanceMapper.insertSelective(performance);
				}else{
					Performance performance = new Performance();
					long num =  performance.getCnumber()+1;
					performance.setCnumber(num);
					performance.setTotal(num*performance.getCprice());
				}
				int num = Integer.parseInt(com.getIsdel())+1;
				com.setIsdel(num+"");
				comMapper.updateByPrimaryKeySelective(com);
				result.setSuccess(true);
			}else{
				result.setSuccess(true);
				result.getResult().put("error", "该订单未处于待收货状态");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	
}
