package com.jade.manage.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import net.sf.json.JSONObject;

import com.jade.dao.CommodityMapper;
import com.jade.dao.NoticeMapper;
import com.jade.manage.service.NoticeService;
import com.jade.mod.Commodity;
import com.jade.mod.Notice;
import com.jade.mod.NoticeExample;
import com.jade.mod.NoticeExample.Criteria;
import com.jade.mod.NoticeExample.Criterion;
import com.jade.po.Result;
import com.jade.uitil.ImageUtil;
import com.jade.uitil.UuidUtil;
@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private CommodityMapper comMapper;
	/**
	 * 获取公共列表
	 * @return
	 */
	@Override
	public Result getNoticeList(String agentId) {
		Result result = new Result();
		try {
			NoticeExample example = new NoticeExample();
			Criteria criterion = example.createCriteria();
			criterion.andNoticeIdIsNotNull();
			criterion.andReserveEqualTo(agentId);
			List<Notice> list  =noticeMapper.selectByExample(example);
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
	 * 浏览公告	
	 * @return
	 */
	@Override
	public Result browse(JSONObject data) {
		Result result = new Result();
		try {
			String noticeId = data.getString("noticeId");
	
			Notice notice =  noticeMapper.selectByPrimaryKey(noticeId);
			
			Map<String,Object> map = new HashMap<String,Object>();
			if(notice!=null){
				String img = notice.getImg();
				System.out.println(img+"-------------");
				String type = notice.getNoticeCategoryId();
				if(type.equals("1")){
					map.put("img", ImageUtil.getUrl(img, 60 * 1000));
					map.put("cid", notice.getCid());
				}else if(type.equals("2")||type.equals("3")){
					map.put("img", ImageUtil.getUrl(img, 60 * 1000));
					map.put("cid", notice.getCid());
				}else if(type.equals("4")){
					map.put("firstNotice", notice.getFirstNotice());
					map.put("secondNotice", notice.getSecondNoice());
				}else{
					map.put("error", "Excuse me？");
				}
				System.out.println(map+"-------------");
				result.setSuccess(true);
				result.setResult(map);
			}else{
				map.put("error", "Excuse me？");
				result.setSuccess(false);
				result.setResult(map);
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
	 * 上线/下线	
	 * @return
	 */
	@Override
	public Result isONLine(JSONObject data,String agentId) {
		Result result = new Result();
		try {
			System.out.println("*/*--*/-"+data.getString("noticeId"));
			String noticeId = data.getString("noticeId");
			Notice notice =  noticeMapper.selectByPrimaryKey(noticeId);
			
			NoticeExample example = new NoticeExample();
			Criteria criterion = example.createCriteria();
			criterion.andOnlineEqualTo("1");
			if(notice!=null){
				String type = notice.getOnline();
				if(type.equals("1")){
					result.setSuccess(true);
					notice.setOnline("0");
					noticeMapper.updateByPrimaryKeySelective(notice);
				}else{
					if(notice.getNoticeCategoryId().equals("1")){
						criterion.andNoticeCategoryIdEqualTo("1");
						criterion.andReserveEqualTo(agentId);
						List<Notice> list  =noticeMapper.selectByExample(example);
						if(list.size()==3){
							result.setSuccess(false);
							result.getResult().put("error", "轮播图一次只能上线三条");
						}else{
							result.setSuccess(true);
							notice.setOnline("1");
						}
					}else if(notice.getNoticeCategoryId().equals("2")){
						criterion.andNoticeCategoryIdEqualTo("2");
						criterion.andReserveEqualTo(agentId);
						List<Notice> list  =noticeMapper.selectByExample(example);
						if(list.size()>=1){
							result.setSuccess(false);
							result.getResult().put("error", "最新banner图一次只能上线一条");
						}else{
							result.setSuccess(true);
							notice.setOnline("1");
						}
					}else if(notice.getNoticeCategoryId().equals("3")){
						criterion.andNoticeCategoryIdEqualTo("3");
						criterion.andReserveEqualTo(agentId);
						List<Notice> list  =noticeMapper.selectByExample(example);
						if(list.size()>=1){
							result.setSuccess(false);
							result.getResult().put("error", "最热banner图一次只能上线一条");
						}else{
							result.setSuccess(true);
							notice.setOnline("1");
						}
					}else if(notice.getNoticeCategoryId().equals("4")){
						criterion.andNoticeCategoryIdEqualTo("4");
						criterion.andReserveEqualTo(agentId);
						List<Notice> list  =noticeMapper.selectByExample(example);
						if(list.size()>=1){
							result.setSuccess(false);
							result.getResult().put("error", "库管公告一次只能上线一条");
						}else{
							result.setSuccess(true);
							notice.setOnline("1");
						}
					}
					noticeMapper.updateByPrimaryKeySelective(notice);
				}
				
				
			}else{
				result.setSuccess(false);
				result.getResult().put("data", "exm");
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
	 * 删除
	 * @return
	 */
	@Override
	public Result delNotice(JSONObject data) {
		Result result = new Result();
		try {
			String noticeId = data.getString("noticeId");
			Notice notice =  noticeMapper.selectByPrimaryKey(noticeId);
		
			
			if(notice!=null){
				String type = notice.getOnline();
				if(type.equals("0")){
					noticeMapper.deleteByPrimaryKey(noticeId);
					result.setSuccess(true);
					result.getResult().put("notice", "删除成功");
				}else{
					result.setSuccess(false);
					result.getResult().put("error", "Excuse me？");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}

	/**
	 * 新增公告
	 * @return
	 */
	@Override
	public Result addNotice(JSONObject data,String agentId) {
		Result result = new Result();
		try {
			Notice notice = new Notice();
			ImageUtil imageUtil = new ImageUtil();
			notice.setName(data.getString("name"));
			notice.setNoticeId(UuidUtil.get32UUID());
			String type = data.getString("noticeCategoryId");
			if(type.equals("1")){
				notice.setNoticeCategory("首页轮播图");
				notice.setNoticeCategoryId("1");
				notice.setImg(data.getString("img"));
				Commodity com = comMapper.selectByPrimaryKey(data.getString("cid"));
				if(com!=null){
					notice.setCid(data.getString("cid"));
					notice.setOnline("0");
					notice.setReserve(agentId);
					noticeMapper.insertSelective(notice);
					result.setSuccess(true);
				}else{
					result.setSuccess(false);
					result.getResult().put("error", "货号为："+data.getString("cid")+"的商品不存在");
				}
				
			}else if(type.equals("2")){
				notice.setNoticeCategory("最新宝贝banner图");
				notice.setNoticeCategoryId("2");
				notice.setImg(data.getString("img"));
				Commodity com = comMapper.selectByPrimaryKey(data.getString("cid"));
				if(com!=null){
					notice.setCid(data.getString("cid"));
					notice.setOnline("0");
					notice.setReserve(agentId);
					noticeMapper.insertSelective(notice);
					result.setSuccess(true);
				}else{
					result.setSuccess(false);
					result.getResult().put("error", "货号为："+data.getString("cid")+"的商品不存在");
				}
				
			}else if(type.equals("3")){
				notice.setNoticeCategory("最热宝贝banner图");
				notice.setNoticeCategoryId("3");
				notice.setImg(data.getString("img"));
				Commodity com = comMapper.selectByPrimaryKey(data.getString("cid"));
				if(com!=null){
					notice.setCid(data.getString("cid"));
					notice.setOnline("0");
					notice.setReserve(agentId);
					noticeMapper.insertSelective(notice);
					result.setSuccess(true);
				}else{
					result.setSuccess(false);
					result.getResult().put("error", "货号为："+data.getString("cid")+"的商品不存在");
				}
			}else if(type.equals("4")){
				notice.setNoticeCategory("库管头条");
				notice.setNoticeCategoryId("4");
				notice.setFirstNotice(data.getString("firstNotice"));
				notice.setSecondNoice(data.getString("secondNoice"));
				notice.setOnline("0");
				notice.setReserve(agentId);
				noticeMapper.insertSelective(notice);
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
	 * 根据类型获取公告
	 */
	@Override
	public Result getNoticByType(String agentId) {
		Result result = new Result();
		try {
			NoticeExample example = new NoticeExample();
			Criteria criterion = example.createCriteria();
			List<String> list1 = new ArrayList<String>();
			criterion.andReserveEqualTo(agentId);
			criterion.andOnlineEqualTo("1");
			list1.add("1");
			list1.add("4");
			criterion.andNoticeCategoryIdIn(list1);
			List<Notice> list  = noticeMapper.selectByExample(example);
			if(list!=null){
				for(int i=0;i<list.size();i++){
					if(null!=list.get(i).getImg()&&!"null".equals(list.get(i).getImg())){
					list.get(i).setImg(ImageUtil.getUrl(list.get(i).getImg(),600*10000 ));}
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

	
	

}
