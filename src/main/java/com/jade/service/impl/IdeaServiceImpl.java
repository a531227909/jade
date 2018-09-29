package com.jade.service.impl;

import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jade.dao.IdeaMapper;
import com.jade.dao.UserMapper;
import com.jade.mod.Idea;
import com.jade.mod.IdeaExample;
import com.jade.mod.IdeaExample.Criteria;
import com.jade.mod.User;
import com.jade.po.Result;
import com.jade.service.IdeaService;
import com.jade.uitil.ImageUtil;
@Service
public class IdeaServiceImpl implements IdeaService{

	@Autowired
	private IdeaMapper ideaMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Result insertIdea(String account, String content) {
		Result result = new Result();
		try {
			if(content!=null&&!"null".equals(content)){
				System.out.println("*******0+"+content);
				User user = userMapper.selectByPrimaryKey(account);
				Idea idea = new Idea();
				idea.setAccount(account);
				idea.setAccountName(user.getName());
				idea.setImg(user.getHeadimg());
				idea.setContent(content);
				idea.setCreateTime(new Date());
				idea.setIdeaId(UUID.randomUUID().toString());
				ideaMapper.insertSelective(idea);
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				String nei = user.getName()+"##@@##@@"+content+"##@@##@@"+format.format(new Date());
				//第三方接口goEasy
				GoEasy goEasy = new GoEasy("BC-a5e9eca11fe54c0994f9a1eb9635eaeb");//appkey
//				GoEasy goEasy = new GoEasy("BC-a5e9eca11fe54c0994f9a1eb9635eaeb", nei);//appkey
				//goEasy.publish("channel",content);
				goEasy.publish(user.getSid(),nei, new PublishListener(){
					@Override
					public void onSuccess() {
					System.out.print("消息发布成功。"+nei);
					}
					@Override
					public void onFailed(GoEasyError error) {
					System.out.print("消息发布失败, 错误编码：" + error.getCode() + " 错误信息： " + error.getContent());
					}
					});

				result.setSuccess(true);
			}else{
				result.setSuccess(false);
				result.getResult().put("error", "内容不能为空");
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
	 * 获取所有意见
	 */
	@Override
	public Result selectIdea() {
		Result result = new Result();
		try {
			IdeaExample ideaExample = new IdeaExample();
			Criteria criteria = ideaExample.createCriteria();
			criteria.andAccountNameIsNotNull();
			List<Idea> list = ideaMapper.selectByExample(ideaExample);
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

	
}
