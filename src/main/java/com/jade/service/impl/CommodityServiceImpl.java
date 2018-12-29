package com.jade.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.CollectMapper;
import com.jade.dao.CommodityMapper;
import com.jade.dao.NoticeMapper;
import com.jade.dao.UserMapper;
import com.jade.mod.Collect;
import com.jade.mod.CollectExample;
import com.jade.mod.Commodity;
import com.jade.mod.CommodityExample;
import com.jade.mod.CommodityExample.Criteria;
import com.jade.mod.Notice;
import com.jade.mod.NoticeExample;
import com.jade.mod.User;
import com.jade.po.Result;
import com.jade.service.commodityService;
import com.jade.uitil.Const;
import com.jade.uitil.IdUtil;
import com.jade.uitil.ImageUtil;
import com.jade.uitil.PageBean;
@Service
public class CommodityServiceImpl implements commodityService{
	
	@Autowired
	private CommodityMapper commodityMapper;
	@Autowired
	private CollectMapper collectMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private NoticeMapper noticeMapper;
	
	private boolean flagHot = false;
	
	private boolean flagNew = false;
	
	private boolean flagPrice = false;
	
	@Override
	public Result getCommodityByCId(String cid,String account) {
		Result result = new Result();
		try {
			Commodity com = commodityMapper.selectByPrimaryKey(cid);
			if("null".equals(cid)||null==cid||com==null||com.getStatus().equals("0")){
				result.setSuccess(false);
				result.getResult().put("error", "商品已下架");
			}else{
				CollectExample collectExample = new CollectExample();
				com.jade.mod.CollectExample.Criteria criteria = collectExample.createCriteria();
				criteria.andAccountEqualTo(account);
				criteria.andCidEqualTo(cid);
				List<Collect> collect = collectMapper.selectByExample(collectExample);
//				System.out.println(cid);
				List<Map<String,Object>> commodity = commodityMapper.selectCommodityByCId(cid);
				for(int i=0;i<commodity.size();i++){
					if(null!=commodity.get(i).get("video")&&!"0".equals(commodity.get(i).get("video"))&&(commodity.get(i).get("video").toString()).indexOf(",00000000")!=-1){
						List<String> url1 = ImageUtil.getUrls(commodity.get(i).get("video").toString(),60*1000);
						commodity.get(i).put("video", url1.get(0));
						commodity.get(i).put("videoImg", url1.get(1));
					}else{
						if(null!=commodity.get(i).get("img")&&!"0".equals(commodity.get(i).get("img"))){
							List<String> url1 = ImageUtil.getUrls(commodity.get(i).get("img").toString(),60*1000);
							commodity.get(i).put("imgList", url1);
						}else{
							commodity.get(i).put("img", new ArrayList<String>());
							commodity.get(i).put("imgList", new ArrayList<String>());
						}
						
					}
					if(null!=commodity.get(i).get("imgText")&&!"0".equals(commodity.get(i).get("imgText"))){
						List<String> urlText = ImageUtil.getUrls(commodity.get(i).get("imgText").toString(),60*1000);
						commodity.get(i).put("imgText", urlText);
					}
				}
				if(0<collect.size()&&commodity.size()>0){
					commodity.get(0).put("collect", "已收藏");
				}else{
					commodity.get(0).put("collect", "未收藏");
				}
//				System.out.println(commodity);
				if(0<commodity.size()){
					result.setSuccess(true);
					result.setResult(commodity.get(0));
				}else{
					result.setSuccess(true);
					result.getResult().put("error", commodity);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public Result getFourOrByCategoryId(String account) {
		Result result = new Result();
		try {
			
				ImageUtil imageUtil = new ImageUtil();
				List<Map<String,Object>> commodity = commodityMapper.selectCommodityByExample(account);
				List<Map<String,Object>> tt = new ArrayList<Map<String,Object>>();
				List<Map<String,Object>> listNO1 = new ArrayList<Map<String,Object>>();
				List<Map<String,Object>> listNO2 = new ArrayList<Map<String,Object>>();
				List<Map<String,Object>> listNO3 = new ArrayList<Map<String,Object>>();
				List<Object> data = new ArrayList<Object>();
				Map<String,Object> mapNO1 = new HashMap<String, Object>();
				Map<String,Object> mapNO2 = new HashMap<String, Object>();
				Map<String,Object> mapNO3 = new HashMap<String, Object>();
				if(0<commodity.size()){
					
					String no1 = (String) commodity.get(0).get("category_id");
					for(int i=0;i<commodity.size();i++){
					
						if(null!=commodity.get(i).get("video")&&!"0".equals(commodity.get(i).get("video"))&&(commodity.get(i).get("video").toString()).indexOf(",00000000")!=-1){
							List<String> url = ImageUtil.getUrls(commodity.get(i).get("video").toString(),60*1000);
							commodity.get(i).put("video", url.get(0));
							commodity.get(i).put("videoImg", url.get(1));
						}else{
							if(null!=commodity.get(i).get("img")&&!"0".equals(commodity.get(i).get("img"))){
							List<String> url = ImageUtil.getUrls(commodity.get(i).get("img").toString(),60*1000);
							commodity.get(i).put("img", url.get(0));
							}else{
								commodity.get(i).put("img", "");
							}
						}
						 
						if(no1.equals(commodity.get(i).get("category_id"))){
							listNO1.add(commodity.get(i));
						}else{
							tt.add(commodity.get(i));
						}
						
					}
					if(tt!=null&&tt.size()>0){
						String no2 = (String) tt.get(0).get("category_id");
						for(int j=0;j<tt.size();j++){
							if(no2.equals(tt.get(j).get("category_id"))){
								listNO2.add(tt.get(j));
							}else{
								listNO3.add(tt.get(j));
							}
						}
						mapNO2.put("cName",listNO2.get(0).get("cName"));
						mapNO2.put("data", listNO2);
					}
					
					mapNO1.put("cName",listNO1.get(0).get("cName"));
			
					mapNO1.put("data", listNO1);
					
				
					
					if(0<listNO3.size()){
						mapNO3.put("cName",listNO3.get(0).get("cName"));
						
						mapNO3.put("data", listNO3);
						data.add(mapNO3);
					}
					
					data.add(mapNO1);
					data.add(mapNO2);
					
					result.setSuccess(true);
					result.getResult().put("data", data);
				}else{
					result.setSuccess(true);
					result.getResult().put("data", data);
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result getCommodityByPrice(String beginPrice, String endPrice,String beginSize, String endSize,String water,String color,String categoryId,String second_category,int page,String account) {
		Result result = new Result();
		ImageUtil imageUtil = new ImageUtil();
		
		try {
			
				User user = userMapper.selectByPrimaryKey(account);
				CommodityExample commodityExample = new CommodityExample();
				commodityExample.setLimit(Const.COMMODITY_PAGE);
				commodityExample.setOffset(Const.COMMODITY_PAGE*(page -1));
				commodityExample.setOrderByClause("categoryId DESC");
				Criteria criteria = commodityExample.createCriteria();
				criteria.andSidEqualTo(user.getSid());
				if(!"".equals(beginPrice)&&!"".equals(endPrice)&&null!=endPrice&&null!=beginPrice){
				criteria.andPriceBetween(Integer.parseInt(beginPrice), Integer.parseInt(endPrice));}
				if(null!=water||null!=color){
					criteria.andColorLike("%"+color+"%");
				}
				if(null!=categoryId){
					criteria.andCategoryIdEqualTo(categoryId);
				}
				
				if(second_category!=null){
					criteria.andSecondCategoryEqualTo(second_category);
				}
				if(!"".equals(beginSize)&&!"".equals(endSize)&&null!=endSize&&null!=beginSize){
					criteria.andSizeBetween(beginSize, endSize);
				}
				criteria.andStatusNotEqualTo("0");
				List<Map<String,Object>> commodity = commodityMapper.selectByPriceE(commodityExample);
				if(0<commodity.size()){
					for(int i=0;i<commodity.size();i++){
						
						if(null!=commodity.get(i).get("video")&&!"0".equals(commodity.get(i).get("video"))&&(commodity.get(i).get("video").toString()).indexOf(",00000000")!=-1){
							List<String> url = ImageUtil.getUrls(commodity.get(i).get("video").toString(),60*1000);
							commodity.get(i).put("video", url.get(0));
							commodity.get(i).put("videoImg", url.get(1));
						}else{
							if(null!=commodity.get(i).get("img")&&!"0".equals(commodity.get(i).get("img"))){
							List<String> url = ImageUtil.getUrls(commodity.get(i).get("img").toString(),60*1000);
							commodity.get(i).put("img", url.get(0));
							}else{
								commodity.get(i).put("img", "");
							}
						}
					}
					PageBean<Map<String,Object>> pageBean = new PageBean<Map<String,Object>>();
					pageBean.setPageNum(page);
					pageBean.setPageSize(Const.COMMODITY_PAGE);
					pageBean.setBeanList(commodity);
					pageBean.setTr(commodityMapper.countByPage(commodityExample));
					result.setSuccess(true);
					result.getResult().put("data", pageBean);
					
				}else{
					PageBean<Map<String,Object>> pageBean = new PageBean<Map<String,Object>>();
					pageBean.setPageNum(page);
					pageBean.setPageSize(Const.COMMODITY_PAGE);
					pageBean.setBeanList(commodity);
					pageBean.setTr(commodityMapper.countByPage(commodityExample));
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
	public Result totalCommodity() {
		Result result = new Result();
		
		try {
			CommodityExample commodityExample = new CommodityExample();
			Criteria criteria = commodityExample.createCriteria();
			criteria.andCidIsNotNull();
			
			int totalNumber = commodityMapper.countByExample(commodityExample);//商品总数
			int totalDeal = commodityMapper.countByDeal();//交易总数
	
			result.setSuccess(true);
			result.getResult().put("totalDeal", totalDeal);
			result.getResult().put("totalNumber", totalNumber);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result getCommodityByNew(String account,String agentId) {
		Result result = new Result();
		ImageUtil imageUtil = new ImageUtil();
		try {
			
			NoticeExample example = new NoticeExample();
			com.jade.mod.NoticeExample.Criteria criterion = example.createCriteria();
			criterion.andReserveEqualTo(agentId);
			criterion.andOnlineEqualTo("1");
			criterion.andNoticeCategoryIdEqualTo("2");
			List<Notice> listNo  = noticeMapper.selectByExample(example);
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
			Map<String,Object> mapNo = new HashMap<String, Object>();
			if(listNo.size()>0){
				if(listNo.get(0).getImg()!=null&&!"0".equals(listNo.get(0).getImg())){
					
					mapNo.put("img", imageUtil.getUrl(listNo.get(0).getImg(),600*10000));
					}else{
						mapNo.put("img", "");
					}
					mapNo.put("cid", listNo.get(0).getCid());
					
					Commodity comList = commodityMapper.selectByPrimaryKey(listNo.get(0).getCid().toString());
					if(comList!=null){
						mapNo.put("name", commodityMapper.selectByPrimaryKey(listNo.get(0).getCid()).getName());
						
					}else{
						mapNo.put("name","");
					}
					
					list1.add(mapNo);
					result.getResult().put("new", list1);
			}else{
				
					mapNo.put("img", "");
					mapNo.put("cid", "");
					mapNo.put("name","");
					list1.add(mapNo);
					result.getResult().put("new", list1);
			}
			
			User user = userMapper.selectByPrimaryKey(account);
			CommodityExample commodityExample = new CommodityExample();
			commodityExample.setOrderByClause("Createtime DESC");
			Criteria criteria = commodityExample.createCriteria();
			criteria.andStatusNotEqualTo("0");
			criteria.andSidEqualTo(user.getSid());
			List<Commodity> commodity = commodityMapper.selectByExample(commodityExample);
			if(commodity.size()>=4){
				for(int i=0;i<4;i++){
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("name", commodity.get(i).getName());//名字
					map.put("cid", commodity.get(i).getCid());//货号
					map.put("size", commodity.get(i).getSize());//尺寸
					map.put("color", commodity.get(i).getColor());//颜色
					map.put("price", commodity.get(i).getPrice());//价格
					
					
					if(null!=commodity.get(i).getIsnopackagemaill()&&!"0".equals(commodity.get(i).getIsnopackagemaill())&&(commodity.get(i).getIsnopackagemaill().toString()).indexOf(",00000000")!=-1){
						map.put("video", imageUtil.getUrls(commodity.get(i).getIsnopackagemaill(),600*10000).get(0));
						map.put("videoImg", imageUtil.getUrls(commodity.get(i).getIsnopackagemaill(),600*10000).get(1));
					}else{
						if(null!=commodity.get(i).getCommodityimg()&&!"0".equals(commodity.get(i).getCommodityimg())){
						map.put("img", imageUtil.getUrls(commodity.get(i).getCommodityimg(),600*10000).get(0));//图片
						}else{
							map.put("img", "");//图片
						}
					}
					map.put("sid", commodity.get(i).getSid());//sid
					list.add(map);
					if(i==3){
						result.setSuccess(true);
						result.getResult().put("data", list);
					}
				}
			}else if(commodity.size()<4&&commodity.size()>0){
				for(int i=0;i<commodity.size();i++){
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("name", commodity.get(i).getName());//名字
					map.put("cid", commodity.get(i).getCid());//货号
					map.put("size", commodity.get(i).getSize());//尺寸
					map.put("color", commodity.get(i).getColor());//颜色
					map.put("price", commodity.get(i).getPrice());//价格

					if(null!=commodity.get(i).getIsnopackagemaill()&&!"0".equals(commodity.get(i).getIsnopackagemaill())&&(commodity.get(i).getIsnopackagemaill().toString()).indexOf(",00000000")!=-1){
						map.put("video", imageUtil.getUrls(commodity.get(i).getIsnopackagemaill(),600*10000).get(0));
						map.put("videoImg", imageUtil.getUrls(commodity.get(i).getIsnopackagemaill(),600*10000).get(1));
					}else{
						if(null!=commodity.get(i).getCommodityimg()&&!"0".equals(commodity.get(i).getCommodityimg())){
						
							map.put("img", imageUtil.getUrls(commodity.get(i).getCommodityimg(),600*10000).get(0));//图片
					
						}else{
							map.put("img", "");//图片
						}
					}
					map.put("sid", commodity.get(i).getSid());//sid
					list.add(map);
					if(i==commodity.size()-1){
						result.setSuccess(true);
						result.getResult().put("data", list);
					}
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
	public Result getCommodityByHot(String account,String agentId) {
		Result result = new Result();
		ImageUtil imageUtil = new ImageUtil();
		try {
			
			
			NoticeExample example = new NoticeExample();
			com.jade.mod.NoticeExample.Criteria criterion = example.createCriteria();
			criterion.andReserveEqualTo(agentId);
			criterion.andOnlineEqualTo("1");
			criterion.andNoticeCategoryIdEqualTo("3");
			List<Notice> listNo  = noticeMapper.selectByExample(example);
			
			Map<String,Object> mapNo = new HashMap<String, Object>();
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
			if(listNo.size()>0){
				if(!"0".equals(listNo.get(0).getImg())&&null!=listNo.get(0).getImg()){
					mapNo.put("img", imageUtil.getUrl(listNo.get(0).getImg(),60*1000));
				}else{
					mapNo.put("img", "");
				}
					mapNo.put("cid", listNo.get(0).getCid());
					Commodity comList = commodityMapper.selectByPrimaryKey(listNo.get(0).getCid().toString());
					if(comList!=null){
						mapNo.put("name", commodityMapper.selectByPrimaryKey(listNo.get(0).getCid()).getName());
					}else{
						mapNo.put("name","");
					}
					
					list1.add(mapNo);
					result.getResult().put("hot", list1);
			}else{
				
					mapNo.put("img", "");
					mapNo.put("cid", "");
					mapNo.put("name","");
					
					list1.add(mapNo);
					result.getResult().put("hot", list1);
			}
			User user = userMapper.selectByPrimaryKey(account);
			CommodityExample commodityExample = new CommodityExample();
			commodityExample.setOrderByClause("isdel DESC");
			Criteria criteria = commodityExample.createCriteria();
			criteria.andSidEqualTo(user.getSid());
			criteria.andStatusNotEqualTo("0");
			List<Commodity> commodity = commodityMapper.selectByExample(commodityExample);
			if(commodity.size()>=4){
				for(int i=0;i<4;i++){
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("name", commodity.get(i).getName());//名字
					map.put("cid", commodity.get(i).getCid());//货号
					map.put("size", commodity.get(i).getSize());//尺寸
					map.put("color", commodity.get(i).getColor());//颜色
					map.put("price", commodity.get(i).getPrice());//价格

					if(null!=commodity.get(i).getIsnopackagemaill()&&!"0".equals(commodity.get(i).getIsnopackagemaill())&&(commodity.get(i).getIsnopackagemaill().toString()).indexOf(",00000000")!=-1){
						map.put("video", imageUtil.getUrls(commodity.get(i).getIsnopackagemaill(),600*10000).get(0));
						map.put("videoImg", imageUtil.getUrls(commodity.get(i).getIsnopackagemaill(),600*10000).get(1));
					}else{
						if(null!=commodity.get(i).getCommodityimg()&&!"0".equals(commodity.get(i).getCommodityimg())){
							map.put("img", imageUtil.getUrls(commodity.get(i).getCommodityimg(),600*10000).get(0));//图片
						}else{
							map.put("img", "");//图片
						}
					}
					map.put("sid", commodity.get(i).getSid());//sid
					list.add(map);
					if(i==4-1){
						result.setSuccess(true);
						result.getResult().put("data", list);
					}
				}
			}else if(commodity.size()<4&&commodity.size()>0){
				for(int i=0;i<commodity.size();i++){
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("name", commodity.get(i).getName());//名字
					map.put("cid", commodity.get(i).getCid());//货号
					map.put("size", commodity.get(i).getSize());//尺寸
					map.put("color", commodity.get(i).getColor());//颜色
					map.put("price", commodity.get(i).getPrice());//价格

					if(null!=commodity.get(i).getIsnopackagemaill()&&!"0".equals(commodity.get(i).getIsnopackagemaill())&&(commodity.get(i).getIsnopackagemaill().toString()).indexOf(",00000000")!=-1){
						map.put("video", imageUtil.getUrls(commodity.get(i).getIsnopackagemaill(),600*10000).get(0));
						map.put("videoImg", imageUtil.getUrls(commodity.get(i).getIsnopackagemaill(),600*10000).get(1));
					}else{
						if(null!=commodity.get(i).getCommodityimg()&&!"0".equals(commodity.get(i).getCommodityimg())){
							map.put("img", imageUtil.getUrls(commodity.get(i).getCommodityimg(),600*10000).get(0));//图片
						}else{
							map.put("img", "");//图片
						}
					}
					map.put("sid", commodity.get(i).getSid());//sid
					list.add(map);
					if(i==commodity.size()-1){
						result.setSuccess(true);
						result.getResult().put("data", list);
					}
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
	public Result selectComAndSup(JSONObject data) {
		Result result = new Result();
		ImageUtil imageUtil = new ImageUtil();
		try {
			JSONArray jsonArray = data.getJSONArray("data");
			Map<String,Object> map = new HashMap<String, Object>();
			List<IdUtil> list = (List) JSONArray.toCollection(jsonArray, IdUtil.class);
			List<Map<String,Object>> retu  = new ArrayList<Map<String,Object>>();
			int total = 0;
			if(0<list.size()){
				for(int i=0;i<list.size();i++){
					Map<String,Object> list1 = commodityMapper.selectComAndSup(list.get(i).getCid());
					if(null!=list1.get("video")&&!"0".equals(list1.get("video"))&&(list1.get("video").toString()).indexOf(",00000000")!=-1){
						list1.put("video",imageUtil.getUrls(list1.get("video").toString(),60*1000).get(0));
						list1.put("videoImg",imageUtil.getUrls(list1.get("video").toString(),60*1000).get(1));
					}else{
						if(null!=list1.get("img")&&!"0".equals(list1.get("img"))){
							list1.put("img",imageUtil.getUrls(list1.get("img").toString(),60*1000));
						}else{
							list1.put("img","");
						}
					}
					
					total = total+Integer.parseInt(list1.get("cPrice").toString());
					//map.put("data", list1);
					retu.add(list1);
					
				}
				map.put("total", total);
				retu.add(map);
				result.setSuccess(true);
				result.getResult().put("data",retu);
			}else{
				result.setSuccess(true);
				result.getResult().put("data", retu);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result selectByPage(String categoryId,int page,String second_category) {
		Result result = new Result();
		ImageUtil imageUtil = new ImageUtil();
		try {
			CommodityExample commodityExample = new CommodityExample();
			commodityExample.setLimit(Const.COMMODITY_PAGE);
			commodityExample.setOffset(Const.COMMODITY_PAGE*(page -1));
			commodityExample.setOrderByClause("categoryId DESC");
			Criteria criteria = commodityExample.createCriteria();
			criteria.andStatusNotEqualTo("0");
			criteria.andCategoryIdEqualTo(categoryId);
			if(!"null".equals(second_category)&&null!=second_category){
				criteria.andSecondCategoryEqualTo(second_category);
			}
			List<Map<String,Object>> list = commodityMapper.selectByPage(commodityExample);
			if(0<list.size()){
				for(int i=0;i<list.size();i++){
					if(null!=list.get(i).get("video")&&!"0".equals(list.get(i).get("video"))&&(list.get(i).get("video").toString()).indexOf(",00000000")!=-1){
						List<String> url = ImageUtil.getUrls(list.get(i).get("video").toString(),60*1000);
						list.get(i).put("video", url.get(0));
						list.get(i).put("videoImg", url.get(1));
					}else{
						if(null!=list.get(i).get("img")&&!"0".equals(list.get(i).get("img"))){
							List<String> url = ImageUtil.getUrls(list.get(i).get("img").toString(),60*1000);
							list.get(i).put("img", url.get(0));
						}else{
							list.get(i).put("img", "");
						}
					}
					
				}
				PageBean<String> records = new PageBean<>();
				records.setPageNum(page);
				records.setPageSize(Const.COMMODITY_PAGE);
				records.setBeanList(list);
				records.setTr(commodityMapper.countByPage(commodityExample));
				result.setSuccess(true);
				result.getResult().put("data", records);
			}else{
				PageBean<String> records = new PageBean<>();
				records.setPageNum(page);
				records.setPageSize(Const.COMMODITY_PAGE);
				records.setBeanList(list);
				records.setTr(commodityMapper.countByPage(commodityExample));
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
	public Result selectByPageHot(String name,String categoryId, int page,String second_category,String account) {
		Result result = new Result();
		ImageUtil imageUtil = new ImageUtil();
		try {
			User user = userMapper.selectByPrimaryKey(account);
			CommodityExample commodityExample = new CommodityExample();
			commodityExample.setLimit(Const.COMMODITY_PAGE);
			commodityExample.setOffset(Const.COMMODITY_PAGE*(page -1));
			
				commodityExample.setOrderByClause("isdel DESC");
			
			
			Criteria criteria = commodityExample.createCriteria();
			criteria.andStatusNotEqualTo("0");
			criteria.andSidEqualTo(user.getSid());
			if(!"null".equals(name)&&null!=name){
				criteria.andNameLike("%"+name+"%");
			}
			if(!"null".equals(categoryId)&&null!=categoryId){
				criteria.andCategoryIdEqualTo(categoryId);
				if(!"null".equals(second_category)&&null!=second_category){
					criteria.andSecondCategoryEqualTo(second_category);
				}
			}else{
				criteria.andCategoryIdIsNotNull();
				if(!"null".equals(second_category)&&null!=second_category){
					criteria.andSecondCategoryIsNotNull();
				}
			}
			List<Map<String,Object>> list = commodityMapper.selectByPageHot(commodityExample);
			if(0<list.size()){
				for(int i=0;i<list.size();i++){
					if(null!=list.get(i).get("video")&&!"0".equals(list.get(i).get("video"))&&(list.get(i).get("video").toString()).indexOf(",00000000")!=-1){
						List<String> url = ImageUtil.getUrls(list.get(i).get("video").toString(),60*1000);
						list.get(i).put("video", url.get(0));
						list.get(i).put("videoImg", url.get(1));
					}else{
						if(null!=list.get(i).get("img")&&!"0".equals(list.get(i).get("img"))){
							List<String> url = ImageUtil.getUrls(list.get(i).get("img").toString(),60*1000);
							list.get(i).put("img", url.get(0));
						}else{
							list.get(i).put("img", "");
						}
					}
				}
				PageBean<String> records = new PageBean<>();
				records.setPageNum(page);
				records.setPageSize(Const.COMMODITY_PAGE);
				records.setBeanList(list);
				records.setTr(commodityMapper.countByPage(commodityExample));
				result.setSuccess(true);
				result.getResult().put("data", records);
			}else{
				PageBean<String> records = new PageBean<>();
				records.setPageNum(page);
				records.setPageSize(Const.COMMODITY_PAGE);
				records.setBeanList(list);
				records.setTr(commodityMapper.countByPage(commodityExample));
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
	public Result selectByPageNew(String name,String categoryId, int page,String second_category,String account) {
		Result result = new Result();
		ImageUtil imageUtil = new ImageUtil();
		try {
			User user = userMapper.selectByPrimaryKey(account);
			CommodityExample commodityExample = new CommodityExample();
			commodityExample.setLimit(Const.COMMODITY_PAGE);
			commodityExample.setOffset(Const.COMMODITY_PAGE*(page -1));
			
				commodityExample.setOrderByClause("createTime DESC");
			
			
			
			Criteria criteria = commodityExample.createCriteria();
			criteria.andSidEqualTo(user.getSid());
			criteria.andStatusNotEqualTo("0");
			if(!"null".equals(name)&&null!=name){
				criteria.andNameLike("%"+name+"%");
			}
			if(!"null".equals(categoryId)&&null!=categoryId){
				criteria.andCategoryIdEqualTo(categoryId);
				if(!"null".equals(second_category)&&null!=second_category){
					criteria.andSecondCategoryEqualTo(second_category);
				}
			}else{
				criteria.andCategoryIdIsNotNull();
				if(!"null".equals(second_category)&&null!=second_category){
					criteria.andSecondCategoryIsNotNull();
				}
				
			}
			
			List<Map<String,Object>> list = commodityMapper.selectByPageNew(commodityExample);
			if(0<list.size()){
				for(int i=0;i<list.size();i++){
					if(null!=list.get(i).get("video")&&!"0".equals(list.get(i).get("video"))&&(list.get(i).get("video").toString()).indexOf(",00000000")!=-1){
						List<String> url = ImageUtil.getUrls(list.get(i).get("video").toString(),60*1000);
						list.get(i).put("video", url.get(0));
						list.get(i).put("videoImg", url.get(1));
					}else{
						if(null!=list.get(i).get("img")&&!"0".equals(list.get(i).get("img"))){
							List<String> url = ImageUtil.getUrls(list.get(i).get("img").toString(),60*1000);
							list.get(i).put("img", url.get(0));
						}else{
							list.get(i).put("img", "");
						}
					}
				}
				PageBean<String> records = new PageBean<>();
				records.setPageNum(page);
				records.setPageSize(Const.COMMODITY_PAGE);
				records.setBeanList(list);
				records.setTr(commodityMapper.countByPage(commodityExample));
				result.setSuccess(true);
				result.getResult().put("data", records);
			}else{
				PageBean<String> records = new PageBean<>();
				records.setPageNum(page);
				records.setPageSize(Const.COMMODITY_PAGE);
				records.setBeanList(list);
				records.setTr(commodityMapper.countByPage(commodityExample));
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
	public Result selectByPagePrice(String name,String categoryId, int page,String second_category,HttpSession session,String type) {
		Result result = new Result();
		ImageUtil imageUtil = new ImageUtil();
		try {
			CommodityExample commodityExample = new CommodityExample();
			commodityExample.setLimit(Const.COMMODITY_PAGE);
			commodityExample.setOffset(Const.COMMODITY_PAGE*(page -1));
			String oldUrl = (String) session.getAttribute("oldUrl");
			String url = (String) session.getAttribute("url");
			String account = (String) session.getAttribute("account");
			User user = userMapper.selectByPrimaryKey(account);
			if(type.equals("1")){
				commodityExample.setOrderByClause("price ASC");
				
			}else if(type.equals("0")){
				commodityExample.setOrderByClause("price DESC");
				
			}
			
			Criteria criteria = commodityExample.createCriteria();
			criteria.andStatusNotEqualTo("0");
			criteria.andSidEqualTo(user.getSid());
			if(!"null".equals(name)&&null!=name){
				criteria.andNameLike("%"+name+"%");
			}
			if(!"null".equals(categoryId)&&null!=categoryId){
				criteria.andCategoryIdEqualTo(categoryId);
			}
			if(!"null".equals(second_category)&&null!=second_category){
				criteria.andSecondCategoryEqualTo(second_category);
			}
			
			List<Map<String,Object>> list = commodityMapper.selectByPagePrice(commodityExample);
			if(0<list.size()){
				for(int i=0;i<list.size();i++){
					if(null!=list.get(i).get("video")&&!"0".equals(list.get(i).get("video"))&&(list.get(i).get("video").toString()).indexOf(",00000000")!=-1){
						List<String> url1 = ImageUtil.getUrls(list.get(i).get("video").toString(),60*1000);
						list.get(i).put("video", url1.get(0));
						list.get(i).put("videoImg", url1.get(1));
					}else{
						if(null!=list.get(i).get("img")&&!"0".equals(list.get(i).get("img"))){
							List<String> url1 = ImageUtil.getUrls(list.get(i).get("img").toString(),60*1000);
							list.get(i).put("img", url1.get(0));
						}else{
							list.get(i).put("img", "");
						}
					}
				}
				PageBean<String> records = new PageBean<>();
				records.setPageNum(page);
				records.setPageSize(Const.COMMODITY_PAGE);
				records.setBeanList(list);
				records.setTr(commodityMapper.countByPage(commodityExample));
				result.setSuccess(true);
				result.getResult().put("data", records);
			}else{
				PageBean<String> records = new PageBean<>();
				records.setPageNum(page);
				records.setPageSize(Const.COMMODITY_PAGE);
				records.setBeanList(list);
				records.setTr(commodityMapper.countByPage(commodityExample));
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
	public Result selectByPageLike(String name, int page,String account) {
		Result result = new Result();
		ImageUtil imageUtil = new ImageUtil();
		try {
			User user = userMapper.selectByPrimaryKey(account);
			CommodityExample commodityExample = new CommodityExample();
			commodityExample.setLimit(Const.COMMODITY_PAGE);
			commodityExample.setOffset(Const.COMMODITY_PAGE*(page -1));
			commodityExample.setOrderByClause("price DESC");
			Criteria criteria = commodityExample.createCriteria();
			criteria.andNameLike("%"+name+"%");
			criteria.andStatusNotEqualTo("0");
			criteria.andSidEqualTo(user.getSid());
			List<Map<String,Object>> list = commodityMapper.selectByPageLike(commodityExample);
			if(0<list.size()){
				for(int i=0;i<list.size();i++){
					if(null!=list.get(i).get("video")&&!"0".equals(list.get(i).get("video"))&&(list.get(i).get("video").toString()).indexOf(",00000000")!=-1){
						List<String> url1 = ImageUtil.getUrls(list.get(i).get("video").toString(),60*1000);
						list.get(i).put("video", url1.get(0));
						list.get(i).put("videoImg", url1.get(1));
					}else{
						if(null!=list.get(i).get("img")&&!"0".equals(list.get(i).get("img"))){
							List<String> url1 = ImageUtil.getUrls(list.get(i).get("img").toString(),60*1000);
							list.get(i).put("img", url1.get(0));
						}else{
							list.get(i).put("img", "");
						}
					}
				}
				PageBean<String> records = new PageBean<>();
				records.setPageNum(page);
				records.setPageSize(Const.COMMODITY_PAGE);
				records.setBeanList(list);
				records.setTr(commodityMapper.countByPage(commodityExample));
				result.setSuccess(true);
				result.getResult().put("data", records);
			}else{
				PageBean<String> records = new PageBean<>();
				records.setPageNum(page);
				records.setPageSize(Const.COMMODITY_PAGE);
				records.setBeanList(list);
				records.setTr(commodityMapper.countByPage(commodityExample));
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

	
}
