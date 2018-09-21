//package com.jade.service.impl;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.jade.dao.CommodityMapper;
//import com.jade.dao.EvaluateMapper;
//import com.jade.dao.UorderMapper;
//import com.jade.mod.Commodity;
//import com.jade.mod.CommodityExample;
//import com.jade.mod.Evaluate;
//import com.jade.mod.Uorder;
//import com.jade.mod.UorderExample;
//import com.jade.mod.UorderExample.Criteria;
//import com.jade.service.IMyTestService;
//import com.jade.uitil.UuidUtil;
//
//@Component 
//public class IMyTestServiceImpl implements IMyTestService{
//
//	@Autowired
//	private UorderMapper orderMapper;
//	@Autowired
//	private EvaluateMapper evaluateMapper;
//	@Autowired
//	private CommodityMapper commodityMapper;
//	
//	/**
//	 * 7天自动更新收货，自动评价
//	 */
//    @Scheduled(cron="0/300 * *  * * ? ")   //每5秒执行一次 
//	@Override
//	public void myTest() throws Exception{
//		// TODO Auto-generated method stub
//    	System.out.println("7天自动更改为已收货");
//    		orderMapper.updateByTimeToClose();//60分钟自动关闭订单
//			orderMapper.updateByTime();//自动更新收货
//    		orderMapper.insertByTime();//自动插入购物历史
//    
//    	List<Map<String,Object>> list = orderMapper.selectByTime();
//    	System.out.println(list);
//    	if(0<list.size()){
//    		for(int i=0;i<list.size();i++){
//        		Uorder uorder = new Uorder();
//        		uorder.setType("0");
//        		
//        		UorderExample example = new UorderExample();
//        		Criteria criteria = example.createCriteria();
//        		criteria.andOrderIdEqualTo(list.get(i).get("oId").toString());
//        		orderMapper.updateByExampleSelective(uorder, example);
//        		Evaluate evaluate = new Evaluate();
//        		evaluate.setId(UuidUtil.get32UUID());
//        		evaluate.setuName(list.get(i).get("uName").toString());
//        		evaluate.setuImg(list.get(i).get("uImg").toString());
//        		evaluate.setuEvaluate("东西很好，好评");
//        		evaluate.setCid(list.get(i).get("cId").toString());
//        		evaluate.setcName(list.get(i).get("cName").toString());
//        		evaluate.setcNumber("1");
//        		evaluate.setcImg(list.get(i).get("cImg").toString());
//        		evaluate.setAccount(list.get(i).get("account").toString());
//        		evaluate.setEvaluateTime(new Date());
//        		evaluateMapper.insert(evaluate);
//        	}
//    	}
//    	
//    	
//	}
///**
// * 统计商品总数和交易总数
// */
//    @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次 
//	@Override
//	public void myTest1() throws Exception{
//		System.out.println("任务2.......");
//    	CommodityExample commodityExample = new CommodityExample();
//    	com.jade.mod.CommodityExample.Criteria criteria1 = commodityExample.createCriteria();
//    	criteria1.andSidIsNotNull();
//    	List<Commodity> comList = commodityMapper.selectByExample(commodityExample);
//    	for(int i=0;i<comList.size();i++){
//    		UorderExample example1 = new UorderExample();
//    		Criteria criteria2 = example1.createCriteria();
//    		criteria2.andCidEqualTo(comList.get(i).getCid());
//    		criteria2.andTypeNotEqualTo("1");
//    		int count = orderMapper.countByExample(example1);
//    		CommodityExample commodityExample1 = new CommodityExample();
//        	com.jade.mod.CommodityExample.Criteria criteria11 = commodityExample1.createCriteria();
//        	criteria11.andCidEqualTo(comList.get(i).getCid());
//        	Commodity commodity = new Commodity();
//        	commodity.setIsdel(count+"");
//    		commodityMapper.updateByExampleSelective(commodity, commodityExample1);
//    	}
//    	
//	}
//    	@Scheduled(cron="0/86400 * *  * * ? ")   //每5秒执行一次 
//		@Override
//		public void myTest2() throws Exception {
//			//商品有效时间过期，下架
//    		commodityMapper.updateByTimeToClose();
//		}
//		    
//    
//}
