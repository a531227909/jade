package com.jade.action;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.manage.service.NoticeService;
import com.jade.po.Result;
import com.jade.service.ConditionService;
import com.jade.service.commodityService;

@Controller
@RequestMapping(value="/commodity")
public class CommodityAction {

	@Autowired
	private commodityService commodityService;
	@Autowired
	private ConditionService conditionService;
	@Autowired
	private NoticeService noticeService;
	
	
	/**
	 * 根据类型获取公告
	 * @param cid
	 * @return
	 */
	
	@RequestMapping(value="/getNoticByType.action",method=RequestMethod.POST)
	public @ResponseBody Result getNoticByType(HttpSession session){
		String agentId = (String)session.getAttribute("agentId");
		return noticeService.getNoticByType(agentId);
		
	}
	/**
	 * 获取颜色，种水，价格
	 * @param cid
	 * @return
	 */
	
	@RequestMapping(value="/getCondition.action",method=RequestMethod.POST)
	public @ResponseBody Result getCondition(){
		
		return conditionService.getCondition();
		
	}
	/**
	 * 根据商品ID获取该详细信息
	 * @param cid
	 * @return
	 */
	
	@RequestMapping(value="/commodityByCId.action",method=RequestMethod.POST)
	public @ResponseBody Result commodityByCId(String cid,HttpSession session){
		String account = (String) session.getAttribute("account");
		return commodityService.getCommodityByCId(cid,account);
		
	}
	/**
	 * 
	 * 获取前三热销类别中的某四件商品*
	 * @param categoryId 类别ID
	 * @return
	 */
	@RequestMapping(value="/getFourOrByCategoryId.action",method=RequestMethod.POST)
	public @ResponseBody Result getFourOrByCategoryId(HttpSession session){
		String account = (String) session.getAttribute("account");
		return commodityService.getFourOrByCategoryId(account);
		
	}
	
	/**
	 * 根据价格区间，尺寸，类别 查找商品
	 * @param beginPrice 低价格
	 * @param endPrice		高价格
	 * @param size		尺寸
	 * @param categoryId  类别ID
	 * @return
	 */
	@RequestMapping(value="/getCommodityByCondition.action",method=RequestMethod.POST)
	public @ResponseBody Result getCommodityByPrice(HttpSession session,int page,String beginPrice, String endPrice,String beginSize, String endSize,String water,String color,String categoryId,String second_category){
			String account = (String) session.getAttribute("account");
			return commodityService.getCommodityByPrice(beginPrice, endPrice,beginSize,endSize, water,color,categoryId,second_category,page,account);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
	
	/**
	 * 统计商品总数，交易总数
	 * @return
	 */
	@RequestMapping(value="/totalCommodity.action",method=RequestMethod.POST)
	public @ResponseBody Result totalCommodity(){
	
			return commodityService.totalCommodity();
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
	/**
	 * 获取最新的四个宝贝信息
	 * @return
	 */
	@RequestMapping(value="/getCommodityByNew.action",method=RequestMethod.POST)
	public @ResponseBody Result getCommodityByNew(HttpSession session){
		String account = (String) session.getAttribute("account");
		String agentId = (String) session.getAttribute("agentId");
			return commodityService.getCommodityByNew(account,agentId);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
	/**
	 * 获取最热的四个宝贝信息
	 * @return
	 */
	@RequestMapping(value="/getCommodityByHot.action",method=RequestMethod.POST)
	public @ResponseBody Result getCommodityByHot(HttpSession session){
		String account = (String) session.getAttribute("account");
		String agentId = (String) session.getAttribute("agentId");
			return commodityService.getCommodityByHot(account,agentId);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
	
	/**
	 * 获取立即下单时物品信息
	 * @return
	 */
	@RequestMapping(value="/selectComAndSup.action",method=RequestMethod.POST)
	public @ResponseBody Result selectComAndSup(@RequestBody JSONObject data){
	
			return commodityService.selectComAndSup(data);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
	
	/**
	 * 根据categoryId获取分页信息
	 * @return
	 */
	@RequestMapping(value="/selectByPage.action",method=RequestMethod.POST)
	public @ResponseBody Result selectByPage(String categoryId,int page,String second_category){
		if(page<1){
			page=1;
		}
			return commodityService.selectByPage(categoryId, page,second_category);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
	/**
	 * 根据categoryId获取排序最热门宝物分页信息
	 * @return
	 */
	@RequestMapping(value="/selectByPageHot.action",method=RequestMethod.POST)
	public @ResponseBody Result selectByPageHot(String name,String categoryId,int page,String second_category,HttpSession session){
		if(page<1){
			page=1;
		}
			String account = (String) session.getAttribute("account");
			return commodityService.selectByPageHot(name,categoryId, page,second_category,account);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
	/**
	 * 根据categoryId获取排序最新宝物分页信息
	 * @return
	 */
	@RequestMapping(value="/selectByPageNew.action",method=RequestMethod.POST)
	public @ResponseBody Result selectByPageNew(String name,String categoryId,int page,String second_category,HttpSession session){
		if(page<1){
			page=1;
		}
		String account = (String) session.getAttribute("account");
			return commodityService.selectByPageNew(name,categoryId, page,second_category,account);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
	
	/**
	 * 根据categoryId获取排序价格分页信息
	 * @return
	 */
	@RequestMapping(value="/selectByPagePrice.action",method=RequestMethod.POST)
	public @ResponseBody Result selectByPagePrice(String name,String categoryId,int page,String second_category,HttpSession session,String type){
		if(page<1){
			page=1;
		}
			
			return commodityService.selectByPagePrice(name,categoryId, page,second_category,session,type);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
	
	/**
	 * 模糊查询分页
	 * @return
	 */
	@RequestMapping(value="/selectByPageLike.action",method=RequestMethod.POST)
	public @ResponseBody Result selectByPageLike(String name,int page,HttpSession session){
		if(page<1){
			page=1;
		}
		String account = (String) session.getAttribute("account");
			return commodityService.selectByPageLike(name, page,account);
		
		//return commodityService.getCommodityByPrice(beginPrice, endPrice);
	}
}
