package com.jade.manage.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import net.sf.json.JSONObject;

import com.jade.dao.CategoryMapper;
import com.jade.dao.CollectMapper;
import com.jade.dao.CommodityMapper;
import com.jade.dao.PurchaseRecordsMapper;
import com.jade.dao.SecondLevelMapper;
import com.jade.dao.UserMapper;
import com.jade.manage.service.CommodityManageService;
import com.jade.mod.Category;
import com.jade.mod.CategoryExample;
import com.jade.mod.CategoryExample.Criteria;
import com.jade.mod.Collect;
import com.jade.mod.CollectExample;
import com.jade.mod.Commodity;
import com.jade.mod.CommodityExample;
import com.jade.mod.PurchaseRecords;
import com.jade.mod.PurchaseRecordsExample;
import com.jade.mod.SecondLevel;
import com.jade.mod.SecondLevelExample;
import com.jade.mod.User;
import com.jade.po.Result;
import com.jade.uitil.Const;
import com.jade.uitil.ExcelUtil;
import com.jade.uitil.ImageUtil;
import com.jade.uitil.UuidUtil;
@Service
public class CommodityManageServiceImpl implements CommodityManageService{

	@Autowired
	private CommodityMapper comMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private SecondLevelMapper slMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CollectMapper collectMapper;
	@Autowired
	private PurchaseRecordsMapper purchaseRecordsMapper;
	
	//日志记录
		private Log log = LogFactory.getLog(this.getClass());
	/**
	 * 获取商品列表
	 * @param data
	 * @return
	 */
	@Override
	public Result getCommodityList(String account) {
		Result result = new Result();
		try {
			User user = userMapper.selectByPrimaryKey(account);
			List<Map<String,Object>> list = comMapper.getCommodityList(user.getSid());
			
			if(list!=null){
				for(int i=0;i<list.size();i++){
					
					if(!list.get(i).get("isNoPackagemaill").equals("0")&&null!=list.get(i).get("isNoPackagemaill")&&
							(list.get(i).get("isNoPackagemaill")==null?"0":list.get(i).get("isNoPackagemaill").toString()).indexOf(",00000000")!=-1){
						list.get(i).put("isNoPackagemaill", ImageUtil.getUrlAndKey(list.get(i).get("isNoPackagemaill").toString(), 600*1000));
						list.get(i).put("commodityImg", ImageUtil.getUrlAndKey(list.get(i).get("commodityImg").toString(), 600*1000));
						list.get(i).put("videoOrPhotos","1");
					}else{
						list.get(i).put("commodityImg", ImageUtil.getUrlAndKey(list.get(i).get("commodityImg").toString(), 600*1000));
						if(!list.get(i).get("isNoPackagemaill").equals("0")&&null!=list.get(i).get("isNoPackagemaill")){
							list.get(i).put("isNoPackagemaill", ImageUtil.getUrlAndKey(list.get(i).get("isNoPackagemaill").toString(), 600*1000));
						}
						list.get(i).put("videoOrPhotos","0");
					}
					list.get(i).put("figuredescribe", ImageUtil.getUrlAndKey(list.get(i).get("figuredescribe").toString(), 600*1000));
					
				}
				
			}
			
			result.setSuccess(true);
			result.getResult().put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 上架和下架
	 * @param data
	 * @return
	 */
	@Override
	public Result soldOutAndPutAway(JSONObject data) {
		Result result = new Result();
		try {
			String cid = data.getString("cid");
			Commodity commodity = new Commodity();
			Commodity com = comMapper.selectByPrimaryKey(cid);
			if(com!=null){
				if(com.getStatus().equals("1")){
					String time = data.getString("time");
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(com.getCreatetime());
			        calendar.add(Calendar.DATE, Integer.parseInt(time));
			        commodity.setEffectivetime(calendar.getTime());
					commodity.setStatus("0");
					commodity.setCid(cid);
				}else{
					commodity.setStatus("1");
					commodity.setCid(cid);
					commodity.setShelvestime(new Date());
				}
				
			}else{
				result.setSuccess(false);
				result.getResult().put("error", "不存在此商品");
			}
			comMapper.updateByPrimaryKeySelective(commodity);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 根据cid等获取商品详细信息
	 * @param data
	 * @return
	 */
	@Override
	public Result selectCommosityByCid(JSONObject data) {
		Result result = new Result();
		try {
			String cid = data.getString("cid");
			ImageUtil imageUtil = new ImageUtil();
			Commodity commodity = comMapper.selectByPrimaryKey(cid);
			Map<String,Object> map = new HashMap<String, Object>();
			if(commodity!=null){
				map.put("name", commodity.getName());//名字
				map.put("cid", commodity.getCid());//货号
				map.put("size", commodity.getSize());//尺寸
				map.put("color", commodity.getColor());//颜色
				map.put("price", commodity.getPrice());//价格
				if(commodity.getIsnopackagemaill()!=null&&!"0".equals(commodity.getIsnopackagemaill())&&(commodity.getIsnopackagemaill()==null?"0":commodity.getIsnopackagemaill()).indexOf(",00000000")!=-1){
					map.put("video", imageUtil.getUrlAndKey(commodity.getIsnopackagemaill(),60*1000).get(0));//视频
				}else{
					map.put("img", imageUtil.getUrlAndKey(commodity.getCommodityimg(),60*1000));//图片
				}
				
				map.put("sid", commodity.getSid());//sid
			}
			result.setSuccess(true);
			result.setResult(map);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 删除商品
	 * @param data
	 * @return
	 */
	@Override
	public Result delCommodity(JSONObject data) {
		Result result = new Result();
		try {
			CollectExample collectExample = new CollectExample();
			com.jade.mod.CollectExample.Criteria criteria = collectExample.createCriteria();
			String cid = data.getString("cid");
			criteria.andCidEqualTo(cid);
			List<Collect> list = new ArrayList<Collect>();
			if(list.size()>0){
				for(int i=0;i<list.size();i++){
					collectMapper.deleteByPrimaryKey(list.get(i).getId());
				}
			}
			PurchaseRecordsExample example1 = new PurchaseRecordsExample();
			
			com.jade.mod.PurchaseRecordsExample.Criteria criteria1 = example1.createCriteria();
			criteria1.andCidEqualTo(cid);
			List<PurchaseRecords> list1 = purchaseRecordsMapper.selectByExample(example1);
			if(list1.size()>0){
				for(int i=0;i<list1.size();i++){
					purchaseRecordsMapper.deleteByPrimaryKey(list1.get(i).getId());
				}
			}
			comMapper.deleteByPrimaryKey(cid);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 更新商品
	 * @param data
	 * @return
	 */
	@Override
	public Result updataCommodity(JSONObject data) {
		Result result = new Result();
		try {
			Commodity commodity = new Commodity();
			String videoOrPhotos = data.getString("videoOrPhotos");
			commodity.setCid(data.getString("cid"));
			if(data.has("name")){
				commodity.setName(data.getString("name"));
			}
			if(data.has("size")){
				commodity.setSize(data.getString("size"));
			}
			if(data.has("price")){
				commodity.setPrice(data.getString("price"));
			}
			if(data.has("color")){
				commodity.setColor(data.getString("color"));
			}
			if(data.has("firstId")){
				commodity.setCategoryId(data.getString("firstId"));
			}
			if(data.has("secondId")){
				commodity.setSecondCategory(data.getString("secondId"));
			}
			if(data.has("standarddcscribe")){
				commodity.setStandarddcscribe(data.getString("standarddcscribe"));
			}
			if(data.has("commodityImg")){
				System.out.println("----"+data.getString("commodityImg"));
				commodity.setCommodityimg(data.getString("commodityImg"));
				if(videoOrPhotos.equals("0")){
					commodity.setCommodityimg(data.getString("commodityImg")+",00000000");
				}
			}
			if(data.has("figuredescribe")){
				commodity.setFiguredescribe(data.getString("figuredescribe"));
			}
			if(data.has("status")){
				commodity.setStatus(data.getString("status"));
			}
			
			if(data.has("isNoPackagemaill")){
				if(!data.getString("isNoPackagemaill").equals("0")&&data.getString("isNoPackagemaill")!=null){
					System.out.println("----"+data.getString("isNoPackagemaill"));
					System.out.println(data.getString("isNoPackagemaill"));
					String str1 = data.getString("isNoPackagemaill");
					String[] arr = str1.split(",");
					commodity.setIsnopackagemaill(arr[0]+".mp4,"+arr[1]);
					if(videoOrPhotos.equals("1")){
						commodity.setIsnopackagemaill(arr[0]+".mp4,"+arr[1]+",00000000");
					}
				}
				
			}
			
			comMapper.updateByPrimaryKeySelective(commodity);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 添加商品
	 * @param data
	 * @return
	 */
	@Override
	public Result addCommodity(JSONObject data,String account) {
		Result result = new Result();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = format.format(new Date());
		try {
			String videoOrPhotos = data.getString("videoOrPhotos");
			Commodity commodity = new Commodity();
			User user = userMapper.selectByPrimaryKey(account);
			commodity.setCreatetime(new Date());
			commodity.setCid("jade"+str);
			commodity.setSid(user.getSid());
			commodity.setInventory(1);
			String firstId = data.getString("firstId");//一级类别
			commodity.setCategoryId(firstId);
			String secondId =data.getString("secondId");//二级类别
			commodity.setSecondCategory(secondId);
			String name =data.getString("name");//商品名
			commodity.setName(name);
			String price =data.getString("price");//价格
			commodity.setPrice(price);
			String time =data.getString("time");//上架有效时间
			if(Integer.parseInt(time)<=0){
				result.setSuccess(false);
				result.getResult().put("error", "最小有效时间为1天");
			}else{
				Calendar calendar = Calendar.getInstance();
		        calendar.add(Calendar.DATE, Integer.parseInt(time));
		        commodity.setEffectivetime(calendar.getTime());
			}
			
			String size =data.getString("size");//尺寸
			commodity.setSize(size);
			String color =data.getString("color");//颜色
			commodity.setColor(color);
			String describe =data.getString("describe");//描述
			commodity.setStandarddcscribe(describe);
			String imageText =data.getString("imageText");//图文描述
			commodity.setFiguredescribe(imageText);
			if(data.has("img")&&data.has("video")){
				if(videoOrPhotos.equals("1")){
					String str1 = data.getString("video");
					String[] arr = str1.split(",");
					commodity.setIsnopackagemaill(arr[0]+".mp4,"+arr[1]+",00000000");
					commodity.setCommodityimg(data.getString("img"));
				}else{
					if(!data.getString("video").equals("0")){
						String str1 = data.getString("video");
						String[] arr = str1.split(",");
						commodity.setIsnopackagemaill(arr[0]+".mp4,"+arr[1]);
					}
					
					commodity.setCommodityimg(data.getString("img")+",00000000");
				}
				
				
			}else if(data.has("img")&&!data.has("video")){
				
				commodity.setCommodityimg(data.getString("img")+",00000000");
			}else if(!data.has("img")&&data.has("video")){
				String str1 = data.getString("video");
				String[] arr = str1.split(",");
				commodity.setIsnopackagemaill(arr[0]+".mp4,"+arr[1]+",00000000");
			}else{
				result.setSuccess(false);
				result.getResult().put("error", "视频和图片至少传一种");
			}
			String status =data.getString("status");//
			if(status.equals("1")){
				commodity.setStatus("1");//直接上架
				commodity.setShelvestime(new Date());
			}else{
				commodity.setStatus("0");//加入仓库
			}
			comMapper.insertSelective(commodity);
			if(result.isSuccess()){
				result.setSuccess(false);
			}else{
				result.setSuccess(true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 获取一级类别列表
	 */
	@Override
	public Result getFirstCategory(String agentId) {
		Result result = new Result();
		ImageUtil imageUtil = new ImageUtil();
		try {
			CategoryExample example = new CategoryExample();
			Criteria criteria = example.createCriteria();
			criteria.andFirstIdIsNotNull();
			criteria.andReserveEqualTo(agentId);
			
			criteria.andNameNotEqualTo("");
			List<Category> list = categoryMapper.selectByExample(example);
			List<Map<String,Object>> limap = new ArrayList<Map<String,Object>>();
			if(list!=null){
				for(int i=0;i<list.size();i++){
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("id", list.get(i).getId());
					map.put("name", list.get(i).getName());
					map.put("showImg", imageUtil.getUrl(list.get(i).getShowimg(),60*1000));
					map.put("stylrImg", imageUtil.getUrl(list.get(i).getStylrimg(),60*1000));
					map.put("firstId", list.get(i).getFirstId());
					map.put("showKey", list.get(i).getShowimg());
					map.put("stylrKey", list.get(i).getStylrimg());
					limap.add(map);
				}
				
				result.setSuccess(true);
				result.getResult().put("data", limap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 根据一级类别获取二级
	 */
	@Override
	public Result getSecondByFirst(JSONObject data) {
		Result result = new Result();
		try {
			String firstId =  data.getString("firstId");
			SecondLevelExample example = new SecondLevelExample();
			com.jade.mod.SecondLevelExample.Criteria criteria = example.createCriteria();
			criteria.andBelongtoLike("%"+firstId+"%");
			criteria.andNameNotEqualTo("");
			List<SecondLevel> list = slMapper.selectByExample(example);
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					String img = list.get(i).getReserve();
					list.get(i).setReserve1(img);
					list.get(i).setReserve(ImageUtil.getUrl(img, 60*1000));
				}
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
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 删除类别
	 * @param data
	 * @return
	 */
	@Override
	public Result delCategory(JSONObject data) {
		Result result = new Result();
		try {
			String firstId =  data.getString("firstId");
			SecondLevelExample example1 = new SecondLevelExample();
			com.jade.mod.SecondLevelExample.Criteria criteria1 = example1.createCriteria();
			criteria1.andBelongtoLike(firstId);
			List<SecondLevel> list = slMapper.selectByExample(example1);
			if(list!=null){
				for(int i=0;i<list.size();i++){
					SecondLevel level = new SecondLevel();
					String arr = list.get(i).getBelongto();
					if(arr.indexOf(","+firstId+",")!=-1){
						String[] str = arr.split(firstId+",");
						String blong = str[0]+str[1];
						level.setId(list.get(i).getId());
						level.setBelongto(blong.trim());
					}else if(arr.indexOf(","+firstId)!=-1&&arr.indexOf(firstId+",")==-1){
						String[] str = arr.split(","+firstId);
						String blong = str[0]+str[1];
						level.setId(list.get(i).getId());
						level.setBelongto(blong.trim());
					}else if(arr.indexOf(firstId+",")!=-1&&arr.indexOf(","+firstId)==-1){
						String[] str = arr.split(firstId+",");
						String blong = str[0]+str[1];
						level.setId(list.get(i).getId());
						level.setBelongto(blong.trim());
					}else if(arr.indexOf(firstId+",")==-1&&arr.indexOf(","+firstId)==-1&&arr.indexOf(firstId)!=-1){
						level.setId(list.get(i).getId());
						level.setBelongto("");
					}
					
					slMapper.updateByPrimaryKeySelective(level);
				}
			}
			CategoryExample example = new CategoryExample();
			Criteria criteria = example.createCriteria();
			criteria.andFirstIdEqualTo(firstId);
			categoryMapper.deleteByExample(example);
			
			CommodityExample commodityExample = new CommodityExample();
			com.jade.mod.CommodityExample.Criteria criteria2 = commodityExample.createCriteria();
			criteria2.andCategoryIdEqualTo(firstId);
			List<Commodity> comList = comMapper.selectByExample(commodityExample);
			if(comList!=null){
				for(int i=0;i<comList.size();i++){
					Commodity commodity = new Commodity();
					commodity.setCategoryId("");
					commodity.setCid(comList.get(i).getCid());
					comMapper.updateByPrimaryKeySelective(commodity);
				}
				
			}
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 修改类别信息
	 * @param data
	 * @return
	 */
	@Override
	public Result updateCategory(JSONObject data) {
		Result result = new Result();
		try {
			Category category = new Category();
			
			String id = data.getString("id");
			if(id.equals("b250cbadfb62422ca11d000415eb1965")){
				result.setSuccess(false);
				result.getResult().put("error", "此类别不可修改");
			}else{
				category.setId(id);
				if(data.has("name")){
					category.setName(data.getString("name"));
				}
				if(data.has("showImg")){
					category.setShowimg(data.getString("showImg"));
				}
				if(data.has("stylrImg")){
					category.setStylrimg(data.getString("stylrImg"));
				}
				categoryMapper.updateByPrimaryKeySelective(category);
				result.setSuccess(true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 获取仓库列表
	 */
	@Override
	public Result getCommoditysoldOut(String account) {
		Result result = new Result();
		try {
			User user = userMapper.selectByPrimaryKey(account);
			List<Map<String,Object>> list = comMapper.getCommoditysoldOut(user.getSid());
			
			if(list!=null){
				for(int i=0;i<list.size();i++){
					if(!list.get(i).get("isNoPackagemaill").equals("0")&&null!=list.get(i).get("isNoPackagemaill")&&
							(list.get(i).get("isNoPackagemaill")==null?"0":list.get(i).get("isNoPackagemaill").toString()).indexOf(",00000000")!=-1){
						list.get(i).put("isNoPackagemaill", ImageUtil.getUrlAndKey(list.get(i).get("isNoPackagemaill").toString(), 600*1000));
						list.get(i).put("commodityImg", ImageUtil.getUrlAndKey(list.get(i).get("commodityImg").toString(), 600*1000));
						list.get(i).put("videoOrPhotos","1");
					}else{
						list.get(i).put("commodityImg", ImageUtil.getUrlAndKey(list.get(i).get("commodityImg").toString(), 600*1000));
						if(!list.get(i).get("isNoPackagemaill").equals("0")&&null!=list.get(i).get("isNoPackagemaill")){
							list.get(i).put("isNoPackagemaill", ImageUtil.getUrlAndKey(list.get(i).get("isNoPackagemaill").toString(), 600*1000));
						}
						list.get(i).put("videoOrPhotos","0");
					}
					
					list.get(i).put("figuredescribe", ImageUtil.getUrlAndKey(list.get(i).get("figuredescribe").toString(), 600*1000));
				}
				
			}
			
			result.setSuccess(true);
			result.getResult().put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 新增类别
	 * @param data
	 * @return
	 */
	@Override
	public Result addCategory(JSONObject data,String agentId) {
		Result result = new Result();
		try {
			Category category = new Category();
			
			category.setId(UuidUtil.get32UUID());
			if(data.has("name")){
				CategoryExample example = new CategoryExample();
				Criteria criteria = example.createCriteria();
				criteria.andNameEqualTo(data.getString("name"));
				criteria.andReserveEqualTo(agentId);
				String firstId = UuidUtil.get32UUID();
				List<Category> list =  categoryMapper.selectByExample(example);
				if(list.size()==0){
					category.setName(data.getString("name"));
					
					if(data.has("showImg")){
						category.setShowimg(data.getString("showImg"));
					}
					if(data.has("stylrImg")){
						category.setStylrimg(data.getString("stylrImg"));
					}
					category.setReserve(agentId);
					category.setFirstId(firstId);
					categoryMapper.insertSelective(category);
					SecondLevelExample example1 = new SecondLevelExample();
					com.jade.mod.SecondLevelExample.Criteria criteria1 = example1.createCriteria();
					criteria1.andNameEqualTo("其他");
					List<SecondLevel> list1 = slMapper.selectByExample(example1);
					SecondLevel level = new SecondLevel();
					level.setId(list1.get(0).getId());
					if(!list1.get(0).getBelongto().equals("")&&list1.get(0).getBelongto()!=null){
						level.setBelongto(list1.get(0).getBelongto()+","+firstId);
					}else{
						level.setBelongto(firstId);
					}
					slMapper.updateByPrimaryKeySelective(level);
					result.setSuccess(true);
				}else{
					result.setSuccess(false);
					result.getResult().put("error", "此类别已存在");
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 新增二级类别
	 */
	@Override
	public Result addSecondCategory(JSONObject data,String agentId) {
		Result result = new Result();
		try {

			SecondLevel level = new SecondLevel();
			level.setId(UuidUtil.get32UUID());
			SecondLevelExample example = new SecondLevelExample();
			com.jade.mod.SecondLevelExample.Criteria criteria = example.createCriteria();
			criteria.andNameEqualTo(data.getString("name"));
			criteria.andReserve1EqualTo(agentId);
			List<SecondLevel> list = slMapper.selectByExample(example);
			if(list.size()==0){
				level.setName(data.getString("name"));
				level.setSecondId(UuidUtil.get32UUID());
				String one = data.getString("data");//所属哪个一级类
				
				level.setReserve(data.getString("stylrImg"));
				
				level.setBelongto(one);
				slMapper.insertSelective(level);
				result.setSuccess(true);
			}else{
				result.setSuccess(false);
				result.getResult().put("error", "此类别已存在");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 给一级类增加子类
	 * @param data
	 * @return
	 */
	@Override
	public Result addSecondByFirst(JSONObject data) {
		Result result = new Result();
		try {
			String firstId = data.getString("firstId");
			String one = data.getString("data");//二级类second_id
			String[] str = one.split(",");
			if(str.length!=0){
				for(int i=0;i<str.length;i++){
					SecondLevelExample example = new SecondLevelExample();
					com.jade.mod.SecondLevelExample.Criteria criteria = example.createCriteria();
					criteria.andSecondIdEqualTo(str[i]);
					List<SecondLevel> list = slMapper.selectByExample(example);
					if(list.size()!=0){
						if(list.get(0).getBelongto().indexOf(firstId)==-1){
							SecondLevel level = new SecondLevel();
							level.setBelongto(list.get(0).getBelongto()+","+firstId);
							level.setId(list.get(0).getId());
							slMapper.updateByPrimaryKeySelective(level);
						}
					}
				}
			}
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	/**
	 * 删除二级类别
	 */
	@Override
	public Result delSecondCategory(JSONObject data) {
		Result result = new Result();
		try {
			String id = data.getString("id");
			SecondLevel level = slMapper.selectByPrimaryKey(id);
			if(!level.getName().equals("其他")){
				slMapper.deleteByPrimaryKey(id);
				CommodityExample commodityExample = new CommodityExample();
				com.jade.mod.CommodityExample.Criteria criteria2 = commodityExample.createCriteria();
				criteria2.andSecondCategoryEqualTo(id);
				List<Commodity> list = comMapper.selectByExample(commodityExample);
				if(list.size()>0){
					
					for(int i=0;i<list.size();i++){
						
						Commodity com = new Commodity();
						com.setCid(list.get(i).getCid());
						com.setSecondCategory("0");
						comMapper.updateByPrimaryKeySelective(com);
					}
				}
				slMapper.deleteByPrimaryKey(id);
				result.setSuccess(true);
			}else{
				result.setSuccess(false);
				result.getResult().put("error", "不可删除此类别");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	@Override
	public Result getAllSecondCategory(JSONObject data,String agentId) {
		Result result = new Result();
		try {
			String firstId = data.getString("firstId");
			SecondLevelExample example = new SecondLevelExample();
			com.jade.mod.SecondLevelExample.Criteria criteria = example.createCriteria();
			criteria.andIdIsNotNull();
			criteria.andBelongtoNotLike("%"+firstId+"%");
			criteria.andReserve1EqualTo(agentId);
			List<SecondLevel> list =  slMapper.selectByExample(example);
			if(list!=null&&list.size()>0){
				for(int i=0;i<list.size();i++){
					String url = ImageUtil .getUrl(list.get(i).getReserve(),60*1000);
					
					list.get(i).setReserve(url);
					
				}
			}
			result.setSuccess(true);
			result.getResult().put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	@Override
	public Result updateSecond(JSONObject data) {
		Result result = new Result();
		try {
			String id = data.getString("id");
			SecondLevel level = new SecondLevel();
			level.setId(id);
			level.setReserve1(slMapper.selectByPrimaryKey(id).getReserve1());
			if(data.has("name")){
				level.setName(data.getString("name"));
			}
			if(data.has("reserve")){
				level.setReserve(data.getString("reserve"));
			}
			slMapper.updateByPrimaryKeySelective(level);
			result.setSuccess(true);
			result.getResult().put("data", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	@Override
	public Result uploadExcel(Map map,String str,String sid) {
		Result result = new Result();
		ExcelUtil<Map<String, Object>> ex = new ExcelUtil<Map<String, Object>>();
		try {
			
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	        String cha = format.format(new Date());
			   if(map.get("docName").toString().indexOf(".xlsx")!=-1){ //XLSX
		        	XSSFSheet sheet = ex.read2007(str);
		            int physicalRowNum = sheet.getPhysicalNumberOfRows();
		            for(int i=1;i<physicalRowNum;i++){
		            	   XSSFRow row = sheet.getRow(i); 
		            	   if(row!=null){
		            		   if(row.getCell(3)!=null){
				            	   row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
				            	   }
				            	   if(row.getCell(4)!=null){
				            	   row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				            	   }
				            	   if(row.getCell(5)!=null){
					            	   row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
					            	   }
				                   XSSFCell firstCategory = row.getCell(0);  
				                   XSSFCell secondCategory = row.getCell(1);  
				                   XSSFCell name = row.getCell(2);  
				                   XSSFCell price = row.getCell(3);  
				                   XSSFCell time = row.getCell(4);  
				                   XSSFCell size = row.getCell(5);  
				                   XSSFCell color = row.getCell(6); 
				                   XSSFCell content = row.getCell(7); 
				                   if(firstCategory==null||secondCategory==null||name==null||price==null||time==null||size==null||color==null||content==null){
				                	   continue;
					                   }else{
						                   //新增类别
						                   CategoryExample example = new CategoryExample();
						   					Criteria criteria = example.createCriteria();
						   					criteria.andNameEqualTo(firstCategory.getRichStringCellValue().getString());
						   					criteria.andReserveEqualTo(sid);
						   					List<Category> list =  categoryMapper.selectByExample(example);
						   					String firstId = UuidUtil.get32UUID();
						   					String secondId = UuidUtil.get32UUID();
						   					if(list.size()==0){
						   						Category category = new Category();
						   						category.setId(UuidUtil.get32UUID());
						   						category.setFirstId(firstId);
						   						category.setName(firstCategory.getRichStringCellValue().getString());
						   						category.setShowimg("上传/20170817080742");
						   						category.setStylrimg("上传/20170817080742");
						   						category.setReserve(sid);
						   						categoryMapper.insert(category);
						   						SecondLevelExample example1 = new SecondLevelExample();
						   						com.jade.mod.SecondLevelExample.Criteria criteria1 = example1.createCriteria();
						   						criteria1.andNameEqualTo("其他");
						   						List<SecondLevel> list1 = slMapper.selectByExample(example1);
						   						SecondLevel level = new SecondLevel();
						   						level.setId(list1.get(0).getId());
						   						if(!list1.get(0).getBelongto().equals("")&&list1.get(0).getBelongto()!=null){
						   							level.setBelongto(list1.get(0).getBelongto()+","+firstId);
						   						}else{
						   							level.setBelongto(firstId);
						   						}
						   						slMapper.updateByPrimaryKeySelective(level);
						   					}else{
						   						firstId = list.get(0).getFirstId();
						   					}
						   					//新增二级类别
						   					SecondLevelExample slexample = new SecondLevelExample();
											com.jade.mod.SecondLevelExample.Criteria slcriteria = slexample.createCriteria();
											String second = secondCategory.getRichStringCellValue().getString();
											if(secondCategory.getRichStringCellValue().getString().equals("")||secondCategory.getRichStringCellValue().getString()==null){
												second = "其他";
											}
											slcriteria.andNameEqualTo(second);
											List<SecondLevel> listsl= slMapper.selectByExample(slexample);
											if(listsl.size()==0){
												SecondLevel level = new SecondLevel();
												level.setId(UuidUtil.get32UUID());
												level.setBelongto(firstId);
												level.setName(second);
												level.setSecondId(secondId);
												level.setReserve("上传/20170817080742");
												level.setReserve1(sid);
												slMapper.insert(level);
											}else{
												slcriteria.andBelongtoLike("%"+firstId+"%");
												List<SecondLevel> list1 = slMapper.selectByExample(slexample);
												if(list1.size()==0){
													if(listsl.get(0).getBelongto().indexOf(firstId)==-1){
														SecondLevel level = new SecondLevel();
														level.setBelongto(listsl.get(0).getBelongto()+","+firstId);
														level.setId(listsl.get(0).getId());
														slMapper.updateByPrimaryKeySelective(level);
													}
													
												}
												secondId = listsl.get(0).getSecondId();
											}
						                   //新增商品
											Commodity record = new Commodity();
											record.setCid(("jade"+cha+((Math.random()*9+1)*100000+"")).substring(0, 18));
											record.setCategoryId(firstId);
											record.setColor(color.getRichStringCellValue().getString());
											record.setCreatetime(new Date());
											record.setInventory(1);
											record.setName(name.getRichStringCellValue().getString());
											double dou = Double.parseDouble(price.getRichStringCellValue().getString());
											record.setPrice(String.valueOf(dou));
											record.setStatus("0");
											record.setCommodityimg("上传/20170817080742");
											record.setSid(sid);
											record.setSecondCategory(secondId);
											record.setIsdel("0");
											record.setShelvestime(new Date());
											record.setIsnopackagemaill("0");
											record.setFiguredescribe("0");
											 Calendar lastDate = Calendar.getInstance();
											 double dou1 = Double.parseDouble(time.getRichStringCellValue().getString());
										     lastDate.add(Calendar.DATE, (int)dou1);
										     System.out.println();
										     record.setEffectivetime(lastDate.getTime());
											record.setSize(size.getRichStringCellValue().getString());
											record.setStandarddcscribe(content.getRichStringCellValue().getString());
											comMapper.insert(record); 
					                   }
				                  
							
				            
		            	   }
		            	   //row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
		            	}
		            System.out.println("走到这里了！！2222！");
		            result.setSuccess(true);
   		            result.getResult().put("data", "上传成功");
		        }
			   String suffix = (map.get("docName").toString()).substring((map.get("docName").toString()).indexOf("."));
			   System.out.println(suffix);
			   if(".xls".equals(suffix)){ //XLSX
		        	HSSFSheet sheet = ex.read(str);
		            int physicalRowNum = sheet.getPhysicalNumberOfRows();
		            for(int i=1;i<physicalRowNum;i++){
		            	   HSSFRow row = sheet.getRow(i);  
		            	   //row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
		            	   if(row!=null){
		            		   if(row.getCell(3)!=null){
				            	   row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
				            	   }
				            	   if(row.getCell(4)!=null){
				            	   row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				            	   }
				            	   
				            	   if(row.getCell(5)!=null){
					            	   row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
					            	   }
				                   HSSFCell firstCategory = row.getCell(0);  
				                   HSSFCell secondCategory = row.getCell(1);  
				                   HSSFCell name = row.getCell(2);  
				                   HSSFCell price = row.getCell(3);  
				                   HSSFCell time = row.getCell(4);  
				                   HSSFCell size = row.getCell(5);  
				                   HSSFCell color = row.getCell(6); 
				                   HSSFCell content = row.getCell(7); 
				                   //新增类别
				                   if(firstCategory==null||secondCategory==null||name==null||price==null||time==null||size==null||color==null||content==null){
				                	   continue;
					                   }else{
						                   CategoryExample example = new CategoryExample();
						   					Criteria criteria = example.createCriteria();
						   					criteria.andNameEqualTo(firstCategory.getRichStringCellValue().getString());
						   					criteria.andReserveEqualTo(sid);
						   					List<Category> list =  categoryMapper.selectByExample(example);
						   					String firstId = UuidUtil.get32UUID();
						   					String secondId = UuidUtil.get32UUID();
						   					if(list.size()==0){
						   						Category category = new Category();
						   						category.setId(UuidUtil.get32UUID());
						   						category.setFirstId(firstId);
						   						category.setName(firstCategory.getRichStringCellValue().getString());
						   						category.setShowimg("上传/20170817080742");
						   						category.setStylrimg("上传/20170817080742");
						   						category.setReserve(sid);
						   						categoryMapper.insert(category);
						   						SecondLevelExample example1 = new SecondLevelExample();
						   						com.jade.mod.SecondLevelExample.Criteria criteria1 = example1.createCriteria();
						   						criteria1.andNameEqualTo("其他");
						   						List<SecondLevel> list1 = slMapper.selectByExample(example1);
						   						SecondLevel level = new SecondLevel();
						   						level.setId(list1.get(0).getId());
						   						if(!list1.get(0).getBelongto().equals("")&&list1.get(0).getBelongto()!=null){
						   							level.setBelongto(list1.get(0).getBelongto()+","+firstId);
						   						}else{
						   							level.setBelongto(firstId);
						   						}
						   						slMapper.updateByPrimaryKeySelective(level);
						   					}else{
						   						firstId = list.get(0).getFirstId();
						   					}
						   					//新增二级类别
						   					SecondLevelExample slexample = new SecondLevelExample();
											com.jade.mod.SecondLevelExample.Criteria slcriteria = slexample.createCriteria();
											String second = secondCategory.getRichStringCellValue().getString();
											if(secondCategory.getRichStringCellValue().getString().equals("")||secondCategory.getRichStringCellValue().getString()==null){
												second = "其他";
											}
											slcriteria.andNameEqualTo(second);
											List<SecondLevel> listsl= slMapper.selectByExample(slexample);
											if(listsl.size()==0){
												SecondLevel level = new SecondLevel();
												level.setId(UuidUtil.get32UUID());
												level.setBelongto(firstId);
												level.setName(second);
												level.setSecondId(secondId);
												level.setReserve("上传/20170817080742");
												level.setReserve1(sid);
												slMapper.insert(level);
											}else{
												slcriteria.andBelongtoLike(firstId);
												List<SecondLevel> list1 = slMapper.selectByExample(slexample);
												if(list1.size()==0){
													if(listsl.get(0).getBelongto().indexOf(firstId)==-1){
														SecondLevel level = new SecondLevel();
														level.setBelongto(listsl.get(0).getBelongto()+","+firstId);
														level.setId(listsl.get(0).getId());
														slMapper.updateByPrimaryKeySelective(level);
													}
													
												}
												secondId = listsl.get(0).getSecondId();
											}
						                   //新增商品
											Commodity record = new Commodity();
											record.setCid(("jade"+cha+((Math.random()*9+1)*100000+"")).substring(0, 18));
											record.setCategoryId(firstId);
											record.setColor(color.getRichStringCellValue().getString());
											record.setCreatetime(new Date());
											record.setInventory(1);
											record.setName(name.getRichStringCellValue().getString());
											double dou = Double.parseDouble(price.getRichStringCellValue().getString());
											record.setPrice(String.valueOf(dou));
											record.setStatus("0");
											record.setCommodityimg("上传/20170817080742");
											record.setSid(sid);
											record.setSecondCategory(secondId);
											record.setIsdel("0");
											record.setShelvestime(new Date());
											record.setIsnopackagemaill("0");
											record.setFiguredescribe("0");
											 Calendar lastDate = Calendar.getInstance();
											 double dou1 = Double.parseDouble(time.getRichStringCellValue().getString());
										     lastDate.add(Calendar.DATE, (int)dou1);
										     System.out.println();
										     record.setEffectivetime(lastDate.getTime());
											record.setSize(size.getRichStringCellValue().getString());
											record.setStandarddcscribe(content.getRichStringCellValue().getString());
											comMapper.insert(record);
											
					                   }
				                   
				            
		            	   }
		            	}
		            result.setSuccess(true);
   		            result.getResult().put("data", "上传成功");
		        }
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			log.error(e);
		}
		return result;
	}

	

}
