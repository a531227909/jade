package com.jade.manage.service;

import java.util.Map;

import net.sf.json.JSONObject;

import com.jade.po.Result;

public interface CommodityManageService {
	/**
	 * 获取商品上架列表
	 * @param data
	 * @return
	 */
	public Result getCommodityList(String account);
	/**
	 * 获取商品下架列表
	 * @param data
	 * @return
	 */
	public Result getCommoditysoldOut(String account);
	/**
	 * 上架和下架
	 * @param data
	 * @return
	 */
	public Result soldOutAndPutAway(JSONObject data);
	
	/**
	 * 根据cid等获取商品详细信息
	 * @param data
	 * @return
	 */
	public Result selectCommosityByCid(JSONObject data);
	/**
	 * 删除商品
	 * @param data
	 * @return
	 */
	public Result delCommodity(JSONObject data);
	/**
	 * 更新商品
	 * @param data
	 * @return
	 */
	public Result updataCommodity(JSONObject data);

	/**
	 * 添加商品
	 * @param data
	 * @return
	 */
	public Result addCommodity(JSONObject data,String account);
	/**
	 * 获取一级类别列表
	 */
	public Result getFirstCategory(String agentId);
	/**
	 * 根据一级类别获取二级
	 */
	public Result getSecondByFirst(JSONObject data);
	/**
	 * 删除类别
	 * @param data
	 * @return
	 */
	public Result delCategory(JSONObject data);
	/**
	 * 修改类别信息
	 * @param data
	 * @return
	 */
	public Result updateCategory(JSONObject data);
	/**
	 * 新增类别
	 * @param data
	 * @return
	 */
	public Result addCategory(JSONObject data,String agentId);
	/**
	 * 新增二级类别
	 */
	public Result addSecondCategory(JSONObject data,String agentId);
	/**
	 * 给一级类增加子类
	 * @param data
	 * @return
	 */
	public Result addSecondByFirst(JSONObject data);
	//删除二级类别
	public Result delSecondCategory(JSONObject data);
	/**
	 * 获取所有二级类
	 * @param data
	 * @return
	 */
	public Result getAllSecondCategory(JSONObject data,String agentId);
	/**
	 * 修改二级类
	 * @param data
	 * @return
	 */
	public Result updateSecond(JSONObject data);
	/**
	 * 批量导入
	 * @param map
	 * @return
	 */
	public Result uploadExcel(Map map,String str,String sid);
}
