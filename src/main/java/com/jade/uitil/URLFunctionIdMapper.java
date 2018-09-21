package com.jade.uitil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class URLFunctionIdMapper {
	//url和功能编号的映射表
	private static Map<String,List<String>> map = null;
	//应用根目录
	private static String rootPath = "/jade";
	
	public static List<String> getFunctionByURL(String url){
		if(map == null){
			mapInit();
		}
		return map.get(url);
	}

	//初始化URL和功能编号的映射表
	private static void mapInit() {
		map = new HashMap<String,List<String>>();
		//初始化报修模块
		repairInit(map);
		//初始化保养模块
		maintenanceInit(map);
		//初始化备品备件模块
		materialInit(map);
		//初始化巡检模块
		inspectionInit(map);
		//初始化能源采集模块
		resourceInit(map);
		//初始化部门模块
		departmentInit(map);
		//初始化用户模块
		userInit(map);
		//初始化聊天模块
		charInit(map);
		//初始化商城模块
		marketInit(map);
		//初始化公共模块
		commonInit(map);
	}

	//初始报修模块
	private static void repairInit(Map<String,List<String>> map){
		String modulePath = "/repair";
		// 获取当天上班打卡工程部用户
		List<String> list1 = new ArrayList<>();			
		list1.add("0201020000");
		list1.add("0201030000");
		map.put(rootPath + modulePath +  "/getTodayRepairer.action", list1);
		// 新增报修单
		List<String> list2 = new ArrayList<>();
		list2.add("0201010000");
		map.put(rootPath + modulePath + "/addRepairOrder.action", list2);
		List<String> list2Android = new ArrayList<>();
		list2Android.add("0201010000");
		map.put(rootPath + modulePath + "/addRepairOrderForAndroid.action", list2Android);
		// 获取报修单详情
		List<String> list3 = new ArrayList<>();
		list3.add("0201010000");
		list3.add("0201020000");
		list3.add("0201030000");
		map.put(rootPath + modulePath + "/getRepairOrder.action", list3);
		// 获取原始报修单
		List<String> list4 = new ArrayList<>();
		list4.add("0201010000");
		list4.add("0201020000");
		list4.add("0201030000");
		map.put(rootPath + modulePath + "/getOriginRepairOrder.action", list4);
		// 审核不通过
		List<String> list5 = new ArrayList<>();
		list5.add("0201020000");
		map.put(rootPath + modulePath + "/checkNotPass.action", list5);
		// 审核通过报修单（维修类型：“维修”；酒店内部指定人员）
		List<String> list6 = new ArrayList<>();
		list6.add("0201020000");
		map.put(rootPath + modulePath + "/checkPassOfRepair.action", list6);
		// 修改报修单
		List<String> list7 = new ArrayList<>();
		list7.add("0201020000");
		map.put(rootPath + modulePath + "/editRepairOrder.action", list7);
		// 报修单开始
		List<String> list8 = new ArrayList<>();
		list8.add("0201030000");
		map.put(rootPath + modulePath + "/beginRepair.action", list8);
		// 报修单退回
		List<String> list9 = new ArrayList<>();
		list9.add("0201030000");
		map.put(rootPath + modulePath + "/returnRepair.action", list9);
		// 报修单完成
		List<String> list10 = new ArrayList<>();
		list10.add("0201030000");
		map.put(rootPath + modulePath + "/finishRepair.action", list10);
		// 报修单确认完成
		List<String> list11 = new ArrayList<>();
		list11.add("0201010000");
		map.put(rootPath + modulePath + "/affirmFinish.action", list11);
		// 报修单完成驳回
		List<String> list12 = new ArrayList<>();
		list12.add("0201010000");
		map.put(rootPath + modulePath + "/finishReturn.action", list12);
		// 报修单查看评价
		List<String> list13 = new ArrayList<>();
		list13.add("0201010000");
		list13.add("0201020000");
		list13.add("0201030000");
		map.put(rootPath + modulePath + "/queryTheEvaluate.action", list13);
		// 删除审核不通过的报修单
		List<String> list14 = new ArrayList<>();
		list14.add("0201010000");
		map.put(rootPath + modulePath + "/deleteCheckNotPassOrder.action", list14);
		// 获取更多报修单
		List<String> list15 = new ArrayList<>();
		list15.add("0201010000");
		list15.add("0201020000");
		list15.add("0201030000");
		map.put(rootPath + modulePath + "/getRepairOrderMore.action", list15);
		// 根据赛选条件获取报修单
		List<String> list16 = new ArrayList<>();
		list16.add("0201010000");
		list16.add("0201020000");
		list16.add("0201030000");
		map.put(rootPath + modulePath + "/getRepairOrderByExample.action", list16);
		// 根据搜索内容获取报修单
		List<String> list17 = new ArrayList<>();
		list17.add("0201010000");
		list17.add("0201020000");
		list17.add("0201030000");
		map.put(rootPath + modulePath + "/getRepairOrderByAnything.action", list17);
		// 审核通过报修单（“改造/新增”；客房部和工程部审核）
		List<String> list18 = new ArrayList<>();
		list18.add("0201020000");
		map.put(rootPath + modulePath + "/checkPassByHSKPAndENG.action", list18);
		// 审核通过报修单（“改造/新增”；财务部审核）
		List<String> list19 = new ArrayList<>();
		list19.add("0201020000");
		map.put(rootPath + modulePath + "/checPassByAC.action", list19);
		// 添加维修反馈记录
		List<String> list20 = new ArrayList<>();
		list20.add("0201030000");
		map.put(rootPath + modulePath + "/addRepairFeedback.action", list20);
		// 查看维修反馈记录
		List<String> list21 = new ArrayList<>();
		list21.add("0201010000");
		list21.add("0201020000");
		list21.add("0201030000");
		map.put(rootPath + modulePath + "/getRepairFeedbacks.action", list21);
		// 报修单移交
		List<String> list22 = new ArrayList<>();
		list22.add("0201030000");
		map.put(rootPath + modulePath + "/removeRepairOrder.action", list22);
		// 获取移交记录
		List<String> list23 = new ArrayList<>();
		list23.add("0201010000");
		list23.add("0201020000");
		list23.add("0201030000");
		map.put(rootPath + modulePath + "/getRemoveInfos.action", list23);
		//根据级别获取报修位置
		List<String> list24 = new ArrayList<>();
		list24.add("0201010000");
		list24.add("0201020000");
		list24.add("0206020000");
		map.put(rootPath + modulePath + "/getRepairLocations.action", list24);
		//添加报修位置
		List<String> list25 = new ArrayList<>();
		list25.add("0206020000");
		map.put(rootPath + modulePath + "/addRepairLocation.action", list25);
		//删除报修位置
		List<String> list26 = new ArrayList<>();
		list26.add("0206020000");
		map.put(rootPath + modulePath + "/deleteRepairLocation.action", list26);
		// 根据级别获取报修类别
		List<String> list27 = new ArrayList<>();
		list27.add("0201010000");
		list27.add("0201020000");
		list27.add("0206020000");
		map.put(rootPath + modulePath + "/getRepairCategorys.action", list27);
		// 添加报修类别
		List<String> list28 = new ArrayList<>();
		list28.add("0206020000");
		map.put(rootPath + modulePath + "/addRepairCategory.action", list28);
		// 删除报修位置
		List<String> list29 = new ArrayList<>();
		list29.add("0206020000");
		map.put(rootPath + modulePath + "/deleteRepairCategory.action", list29);
		// 维修投诉
		List<String> list30 = new ArrayList<>();
		list30.add("0201030000");
		map.put(rootPath + modulePath + "/repairComplain.action", list30);
		// 获取报修投诉信息
		List<String> list31 = new ArrayList<>();
		list31.add("0201040000");
		map.put(rootPath + modulePath + "/getRepairComplain.action", list31);
		// 获取报修单投诉信息
		List<String> list32 = new ArrayList<>();
		list32.add("0201030000");
		map.put(rootPath + modulePath + "/getRepairOrderComplain.action", list32);
		// 投诉反馈
		List<String> list33 = new ArrayList<>();
		list33.add("0201040000");
		map.put(rootPath + modulePath + "/complainFeedback.action", list33);
		// 反馈结果评价
		List<String> list34 = new ArrayList<>();
		list34.add("0201030000");
		map.put(rootPath + modulePath + "/evaluateFeedback.action", list34);
		// 添加签收单
		List<String> list35 = new ArrayList<>();
		list35.add("0201050000");
		map.put(rootPath + modulePath + "/addRepairSignOrder.action", list35);
		// 获取签收单
		List<String> list36 = new ArrayList<>();
		list36.add("0201050000");
		map.put(rootPath + modulePath + "/getRepairSignOrders.action", list36);
		// 编辑签收单
		List<String> list37 = new ArrayList<>();
		list37.add("0201050000");
		map.put(rootPath + modulePath + "/editRepairSignOrder.action", list37);
		// 删除签收单
		List<String> list38 = new ArrayList<>();
		list38.add("0201050000");
		map.put(rootPath + modulePath + "/deleteRepairSignOrder.action", list38);
		// 获取酒店报修单维修类型
		List<String> list39 = new ArrayList<>();
		list39.add("0201010000");
		list39.add("0201020000");
		list39.add("0206020000");
		map.put(rootPath + modulePath + "/getRepairTypes.action", list39);
		// 更新酒店报修单维修类型
		List<String> list40 = new ArrayList<>();
		list40.add("0206020000");
		map.put(rootPath + modulePath + "/updateRepairType.action", list40);
		// 获取酒店报修单紧急状态
		List<String> list41 = new ArrayList<>();
		list41.add("0201010000");
		list41.add("0201020000");
		list41.add("0206020000");
		map.put(rootPath + modulePath + "/getEmergencyLevels.action", list41);
		// 更新酒店报修单紧急状态
		List<String> list42 = new ArrayList<>();
		list42.add("0206020000");
		map.put(rootPath + modulePath + "/updateEmergencyLevel.action", list42);
		// 更新酒店报修位置
		List<String> list43 = new ArrayList<>();
		list43.add("0206020000");
		map.put(rootPath + modulePath + "/updateRepairLocation.action", list43);
		// 更新酒店报修类别
		List<String> list44 = new ArrayList<>();
		list44.add("0206020000");
		map.put(rootPath + modulePath + "/updateRepairCategory.action", list44);
	}
	
	//初始化保养模块
	private static void maintenanceInit(Map<String,List<String>> map){
		String modulePath = "/maintenance";
		// 新增保养计划
		List<String> list1 = new ArrayList<>();			
		list1.add("0203010000");
		map.put(rootPath + modulePath +  "/addMaintenanceProject.action", list1);
		// 获取保养计划详情
		List<String> list2 = new ArrayList<>();			
		list2.add("0203010000");
		list2.add("0203020000");
		list2.add("0203030000");
		map.put(rootPath + modulePath +  "/getMaintenanceProjectById.action", list2);
		// 获取保养计划设备
		List<String> list3 = new ArrayList<>();			
		list3.add("0203010000");
		list3.add("0203020000");
		list3.add("0203030000");
		map.put(rootPath + modulePath +  "/getMaintenanceEquipmentsById.action", list3);
		// 获取保养计划更多
		List<String> list4 = new ArrayList<>();			
		list4.add("0203010000");
		list4.add("0203020000");
		list4.add("0203030000");
		map.put(rootPath + modulePath +  "/getMaintenanceProjects.action", list4);
		// 修改保养计划基本信息
		List<String> list5 = new ArrayList<>();			
		list5.add("0203020000");
		map.put(rootPath + modulePath +  "/editMaintenanceProject.action", list5);
		// 保养计划审核不通过
		List<String> list6 = new ArrayList<>();			
		list6.add("0203020000");
		map.put(rootPath + modulePath +  "/checkNotPassBy.action", list6);
		// 保养计划审核通过
		List<String> list7 = new ArrayList<>();			
		list7.add("0203020000");
		map.put(rootPath + modulePath +  "/checkPassBy.action", list7);
		// 保养计划退回
		List<String> list8 = new ArrayList<>();			
		list8.add("0203030000");
		map.put(rootPath + modulePath +  "/returnMaintenanceProject.action", list8);
		// 保养计划开始
		List<String> list9 = new ArrayList<>();			
		list9.add("0203030000");
		map.put(rootPath + modulePath +  "/startMaintenance.action", list9);
		// 保养计划完成
		List<String> list10 = new ArrayList<>();			
		list10.add("0203030000");
		map.put(rootPath + modulePath +  "/finishedMaintenance.action", list10);
		// 保养计划确认完成
		List<String> list11 = new ArrayList<>();			
		list11.add("0203010000");
		map.put(rootPath + modulePath +  "/affirmFinishedMaintenance.action", list11);
		// 保养计划完成驳回
		List<String> list12 = new ArrayList<>();			
		list12.add("0203010000");
		map.put(rootPath + modulePath +  "/returnFinishedMaintenance.action", list12);
		// 删除保养计划
		List<String> list13 = new ArrayList<>();			
		list13.add("0203010000");
		map.put(rootPath + modulePath +  "/deleteMaintenanceProject.action", list13);
		// 重新提交保养计划
		List<String> list14 = new ArrayList<>();			
		list14.add("0203010000");
		map.put(rootPath + modulePath +  "/addMaintenanceProjectAgain.action", list14);
		// 添加保养设备
		List<String> list15 = new ArrayList<>();			
		list15.add("0203010000");
		list15.add("0203020000");
		map.put(rootPath + modulePath +  "/addMaintenanceEquipment.action", list15);
		// 删除保养设备
		List<String> list16 = new ArrayList<>();			
		list16.add("0203010000");
		list16.add("0203020000");
		map.put(rootPath + modulePath +  "/deleteMaintenanceEquipment.action", list16);
		// 添加反馈记录
		List<String> list17 = new ArrayList<>();			
		list17.add("0203030000");
		map.put(rootPath + modulePath +  "/addFeedBackRecord.action", list17);
		// 查看反馈记录
		List<String> list18 = new ArrayList<>();	
		list18.add("0203010000");
		list18.add("0203020000");
		list18.add("0203030000");
		map.put(rootPath + modulePath +  "/getFeedBackRecords.action", list18);
		// 保养人对“正在进行”的保养设备点击“完成”
		List<String> list19 = new ArrayList<>();	
		list19.add("0203030000");
		map.put(rootPath + modulePath +  "/finishedMaintenanceEquipment.action", list19);
		// 制定人对“等待确认”的保养设备点击“确认完成”
		List<String> list20 = new ArrayList<>();	
		list20.add("0203010000");
		map.put(rootPath + modulePath +  "/affirmFinishedMaintenanceEquipment.action", list20);
		// 制定人对“等待确认”的保养设备点击“驳回”
		List<String> list21 = new ArrayList<>();	
		list21.add("0203010000");
		map.put(rootPath + modulePath +  "/returnFinishedMaintenanceEquipment.action", list21);
		// 设备进入下一周期，制定人对“已经完成”的设备点击“进入一下周期”
		List<String> list22 = new ArrayList<>();	
		list22.add("0203010000");
		map.put(rootPath + modulePath +  "/intoNextMaintenancePeriod.action", list22);
		// 制定人对“正在进行”的保养设备点击“提醒”
		List<String> list23 = new ArrayList<>();	
		list23.add("0203010000");
		map.put(rootPath + modulePath +  "/remindToMaintenance.action", list23);
		// 获取当天在岗的保养人员
		List<String> list24 = new ArrayList<>();	
		list24.add("0203020000");
		map.put(rootPath + modulePath +  "/getTodayMaintenanceUsers.action", list24);
		// 筛选保养计划
		List<String> list25 = new ArrayList<>();	
		list25.add("0203010000");
		list25.add("0203020000");
		list25.add("0203030000");
		map.put(rootPath + modulePath +  "/getMaintenanceProjectByExample.action", list25);
		// 搜索保养计划
		List<String> list26 = new ArrayList<>();
		list26.add("0203010000");
		list26.add("0203020000");
		list26.add("0203030000");
		map.put(rootPath + modulePath + "/getMaintenanceProjectByAnything.action", list26);
		// 新增保养位置
		List<String> list27 = new ArrayList<>();
		list27.add("0206030000");
		map.put(rootPath + modulePath + "/addMaintenanceLocation.action", list27);
		// 获取保养位置
		List<String> list28 = new ArrayList<>();
		list28.add("0206030000");
		list28.add("0203010000");
		list28.add("0203020000");
		map.put(rootPath + modulePath + "/getMaintenanceLocations.action", list28);
		// 删除保养位置
		List<String> list29 = new ArrayList<>();
		list29.add("0206030000");
		map.put(rootPath + modulePath + "/deleteMaintenanceLocation.action", list29);
		// 删除保养位置
		List<String> list30 = new ArrayList<>();
		list30.add("0206030000");
		map.put(rootPath + modulePath + "/updateMaintenanceLocation.action", list30);
	}
	
	// 初始化备品备件模块
	private static void materialInit(Map<String, List<String>> map) {
		String modulePath = "/material";
		// 获取备品备件类型
		List<String> list1 = new ArrayList<>();
		list1.add("0202010000");
		list1.add("0202020000");
		list1.add("0202030000");
		list1.add("0202040000");
		list1.add("0206060000");
		map.put(rootPath + modulePath + "/getMaterialTypes.action", list1);
		// 根据类型获取备品备件的名称
		List<String> list2 = new ArrayList<>();
		list2.add("0202010000");
		list2.add("0202020000");
		list2.add("0202030000");
		list2.add("0202040000");
		list2.add("0206060000");
		map.put(rootPath + modulePath + "/getMaterialsNameByType.action", list2);
		// 根据备品备件的名称来获取备品备件
		List<String> list3 = new ArrayList<>();
		list3.add("0202010000");
		list3.add("0202020000");
		list3.add("0202030000");
		list3.add("0202040000");
		list3.add("0206060000");
		map.put(rootPath + modulePath + "/getMaterialsByName.action", list3);
		// 添加领用记录
		List<String> list4 = new ArrayList<>();
		list4.add("0202010000");
		map.put(rootPath + modulePath + "/addUseRecord.action", list4);
		// 获取热门备品备件
		List<String> list5 = new ArrayList<>();
		list5.add("0202010000");
		list5.add("0202020000");
		list5.add("0202030000");
		list5.add("0202040000");
		map.put(rootPath + modulePath + "/getHotMaterials.action", list5);
		// 查询备品备件的领用记录
		List<String> list6 = new ArrayList<>();
		list6.add("0202010000");
		list6.add("0202020000");
		map.put(rootPath + modulePath + "/getUseRecords.action", list6);
		// 领用记录领用物品归还
		List<String> list7 = new ArrayList<>();
		list7.add("0202020000");
		map.put(rootPath + modulePath + "/useRecordReturn.action", list7);
		// 添加报废记录
		List<String> list8 = new ArrayList<>();
		list8.add("0202020000");
		map.put(rootPath + modulePath + "/addScrapRecord.action", list8);
		// 查看报废记录
		List<String> list9 = new ArrayList<>();
		list9.add("0202020000");
		map.put(rootPath + modulePath + "/getScrapRecords.action", list9);
		// 搜索备品备件
		List<String> list10 = new ArrayList<>();
		list10.add("0202010000");
		list10.add("0202020000");
		list10.add("0202030000");
		list10.add("0202040000");
		list10.add("0206060000");
		map.put(rootPath + modulePath + "/searchMaterialsByName.action", list10);
		// 获取领用记录详情
		List<String> list11 = new ArrayList<>();
		list11.add("0202010000");
		list11.add("0202020000");
		map.put(rootPath + modulePath + "/getUseRecordDetails.action", list11);
		// 申购
		List<String> list12 = new ArrayList<>();
		list12.add("0202010000");
		map.put(rootPath + modulePath + "/addPurchaseRecord.action", list12);
		// 查看申购记录
		List<String> list13 = new ArrayList<>();
		list13.add("0202040000");
		map.put(rootPath + modulePath + "/getPurchaseRecords.action", list13);
		// 处理申购请求
		List<String> list14 = new ArrayList<>();
		list14.add("0202040000");
		map.put(rootPath + modulePath + "/handleThePurchase.action", list14);
		// 获取备品备件（PC）
		List<String> list15 = new ArrayList<>();
		list15.add("0202010000");
		list15.add("0202020000");
		list15.add("0202030000");
		list15.add("0202040000");
		list15.add("0206060000");
		map.put(rootPath + modulePath + "/getMaterials.action", list15);
		// 录入备品备件
		List<String> list16 = new ArrayList<>();
		list16.add("0202030000");
		map.put(rootPath + modulePath + "/addMaterial.action", list16);
		// 删除备品备件
		List<String> list17 = new ArrayList<>();
		list17.add("0202030000");
		map.put(rootPath + modulePath + "/deleteMaterial.action", list17);
		// 入库备品备件
		List<String> list18 = new ArrayList<>();
		list18.add("0202040000");
		map.put(rootPath + modulePath + "/entryMaterial.action", list18);
		// 添加备品备件类型（批量添加）
	    List<String> list19 = new ArrayList<>();
	    list19.add("0206060000");
	    map.put(rootPath + modulePath + "/addMaterialTypes.action", list19);
	    // 删除备品备件类型
	    List<String> list20 = new ArrayList<>();
	    list20.add("0206060000");
	    map.put(rootPath + modulePath + "/deleteMaterialType.action", list20);
	    // 编辑备品备件类型
	    List<String> list21 = new ArrayList<>();
	    list21.add("0206060000");
	    map.put(rootPath + modulePath + "/editMaterialType.action", list21);
	}
	
	// 初始化巡检模块
	private static void inspectionInit(Map<String, List<String>> map) {
		String modulePath = "/inspection";
		// 新增巡检表
		List<String> list1 = new ArrayList<>();
		list1.add("0205030200");
		map.put(rootPath + modulePath + "/addInspectionTable.action", list1);
		// 获取巡检表基本信息
		List<String> list2 = new ArrayList<>();
		list2.add("0205030100");
		list2.add("0205030200");
		map.put(rootPath + modulePath + "/getInspectionTableBasicInfo.action", list2);
		// 获取巡检表详情信息
		List<String> list3 = new ArrayList<>();
		list3.add("0205030100");
		list3.add("0205030200");
		map.put(rootPath + modulePath + "/getInspectionTableDetailInfo.action", list3);
		// 添加巡检反馈记录
		List<String> list4 = new ArrayList<>();
		list4.add("0205010000");
		map.put(rootPath + modulePath + "/addInspectionFeedBack.action", list4);
		// 获取巡检反馈记录基本信息
		List<String> list5 = new ArrayList<>();
		list5.add("0205020100");
		list5.add("0205020200");
		map.put(rootPath + modulePath + "/getInspectionFeedBackBasicInfo.action", list5);
		// 获取巡检反馈记录详细信息
		List<String> list6 = new ArrayList<>();
		list6.add("0205020100");
		list6.add("0205020200");
		map.put(rootPath + modulePath + "/getInspectionFeedBackDetailInfo.action", list6);
		// 查询巡检表基本信息(APP端巡检表搜索)
		List<String> list7 = new ArrayList<>();
		list7.add("0205010000");
		map.put(rootPath + modulePath + "/getInspectionTable.action", list7);
		// 修改巡检表的基本信息
		List<String> list8 = new ArrayList<>();
		list8.add("0205030200");
		map.put(rootPath + modulePath + "/editInspectionTableBasicInfo.action", list8);
		// 删除巡检表
		List<String> list9 = new ArrayList<>();
		list9.add("0205030200");
		map.put(rootPath + modulePath + "/deleteInspectionTable.action", list9);
		// 添加巡检表的项目
		List<String> list10 = new ArrayList<>();
		list10.add("0205030200");
		map.put(rootPath + modulePath + "/addInspectionItem.action", list10);
		// 删除巡检表的项目
		List<String> list11 = new ArrayList<>();
		list11.add("0205030200");
		map.put(rootPath + modulePath + "/deleteInspectionItem.action", list11);
	}
	
	// 初始化巡检模块
	private static void resourceInit(Map<String, List<String>> map) {
		String modulePath = "/resource";
		String modulePath1 = "/resourceTable";
		// 获取能源
		List<String> list1 = new ArrayList<>();
		list1.add("0204010000");
		list1.add("0204020000");
		list1.add("0204030000");
		list1.add("0206040000");
		map.put(rootPath + modulePath + "/getResource.action", list1);
		// 获取能源表
		List<String> list2 = new ArrayList<>();
		list2.add("0204010000");
		list2.add("0204020000");
		list2.add("0204030000");
		list2.add("0206040000");
		map.put(rootPath + modulePath1 + "/queryResourceTable.action", list2);
		// 添加采集记录
		List<String> list3 = new ArrayList<>();
		list3.add("0204010000");
		list3.add("0204020000");
		list3.add("0204030000");
		map.put(rootPath + modulePath + "/addCollectRecord.action", list3);
		// 获取采集记录
		List<String> list4 = new ArrayList<>();
		list4.add("0204040100");
		list4.add("0204040200");
		map.put(rootPath + modulePath + "/getCollectRecords.action", list4);
		// 获取采集记录详情
		List<String> list5 = new ArrayList<>();
		list5.add("0204040100");
		list5.add("0204040200");
		map.put(rootPath + modulePath + "/getCollectionRecordDetails.action", list5);
		// 添加能源
		List<String> list6 = new ArrayList<>();
		list6.add("0206040000");
		map.put(rootPath + modulePath + "/addResources.action", list6);
		// 更新能源
		List<String> list7 = new ArrayList<>();
		list7.add("0206040000");
		map.put(rootPath + modulePath + "/updateResource.action", list7);
		// 删除能源
		List<String> list8 = new ArrayList<>();
		list8.add("0206040000");
		map.put(rootPath + modulePath + "/deleteResource.action", list8);
		// 添加能源表
		List<String> list9 = new ArrayList<>();
		list9.add("0206040000");
		map.put(rootPath + modulePath1 + "/addResourceTable.action", list9);
		// 更新能源表
		List<String> list10 = new ArrayList<>();
		list10.add("0206040000");
		map.put(rootPath + modulePath1 + "/updateResourceTable.action", list10);
		// 删除能源表
		List<String> list11 = new ArrayList<>();
		list11.add("0206040000");
		map.put(rootPath + modulePath1 + "/deleteResourceTable.action", list11);
		// 获取能源表上期读数
		List<String> list12 = new ArrayList<>();
		list12.add("0204010000");
		list12.add("0204020000");
		list12.add("0204030000");
		map.put(rootPath + modulePath1 + "/getPervReading.action", list12);
	}
	// 初始部门检模块
	private static void departmentInit(Map<String, List<String>> map) {
		String modulePath = "/department";
		// 新增酒店部门
		List<String> list1 = new ArrayList<>();
		list1.add("0207030000");
		map.put(rootPath + modulePath + "/addDepartment.action", list1);
		// 编辑酒店部门
		List<String> list2 = new ArrayList<>();
		list2.add("0207030000");
		map.put(rootPath + modulePath + "/editDepartment.action", list2);
		// 删除酒店部门
		List<String> list3 = new ArrayList<>();
		list3.add("0207030000");
		map.put(rootPath + modulePath + "/deleteDepartment.action", list3);
		//获取酒店职位
		List<String> list4 = new ArrayList<>();
		list4.add("0207030000");
		map.put(rootPath + modulePath + "/getDepartmentPositions.action", list4);
		//添加酒店职位
		List<String> list5 = new ArrayList<>();
		list5.add("0207030000");
		map.put(rootPath + modulePath + "/addDepartmentPosition.action", list5);
		//编辑酒店职位
		List<String> list6 = new ArrayList<>();
		list6.add("0207030000");
		map.put(rootPath + modulePath + "/editDepartmentPosition.action", list6);
		//删除酒店职位
		List<String> list7 = new ArrayList<>();
		list7.add("0207030000");
		map.put(rootPath + modulePath + "/deleteDepartmentPosition.action", list7);
	}
	
	// 初始用户检模块
	private static void userInit(Map<String, List<String>> map) {
		String modulePath = "/user";
		// 获取酒店角色
		List<String> list1 = new ArrayList<>();
		list1.add("0207020100");
		list1.add("0207020200");
		map.put(rootPath + modulePath + "/getRoles.action", list1);
		// 获取酒店角色权限
		List<String> list2 = new ArrayList<>();
		list2.add("0207020100");
		list2.add("0207020200");
		map.put(rootPath + modulePath + "/getRoleAuthority.action", list2);
		// 新增酒店角色
		List<String> list3 = new ArrayList<>();
		list3.add("0207020200");
		map.put(rootPath + modulePath + "/addRole.action", list3);
		// 编辑酒店角色
		List<String> list4 = new ArrayList<>();
		list4.add("0207020200");
		map.put(rootPath + modulePath + "/editRole.action", list4);
		// 刪除酒店角色
		List<String> list5 = new ArrayList<>();
		list5.add("0207020200");
		map.put(rootPath + modulePath + "/deleteRole.action", list5);
		// 获取用户
		List<String> list6 = new ArrayList<>();
		list6.add("0207010100");
		list6.add("0207010200");
		map.put(rootPath + modulePath + "/getUsers.action", list6);
		// 添加用户
		List<String> list7 = new ArrayList<>();
		list7.add("0207010200");
		map.put(rootPath + modulePath + "/addUser.action", list7);
		// 编辑用户
		List<String> list8 = new ArrayList<>();
		list8.add("0207010200");
		map.put(rootPath + modulePath + "/editUser.action", list8);
		// 注销用户
		List<String> list9 = new ArrayList<>();
		list9.add("0207010200");
		map.put(rootPath + modulePath + "/disableUser.action", list9);
		// 激活用户
		List<String> list10 = new ArrayList<>();
		list10.add("0207010200");
		map.put(rootPath + modulePath + "/enableUser.action", list10);
		// 删除用户
		List<String> list11 = new ArrayList<>();
		list11.add("0207010200");
		map.put(rootPath + modulePath + "/deleteUser.action", list11);
		// 获取个人资料
		List<String> list12 = new ArrayList<>();
		list12.add("0209010000");
		map.put(rootPath + modulePath + "/getBasicInfo.action", list12);
		// 编辑个人资料
		List<String> list13 = new ArrayList<>();
		list13.add("0209010000");
		map.put(rootPath + modulePath + "/editBasicInfo.action", list13);
		// 获取用户的所有角色
		List<String> list14 = new ArrayList<>();
		list14.add("0207010100");
		list14.add("0207010200");
		map.put(rootPath + modulePath + "/getUserRoles.action", list14);
		// 添加用户角色
		List<String> list15 = new ArrayList<>();
		list15.add("0207010200");
		map.put(rootPath + modulePath + "/addRoleForUser.action", list15);
		// 删除用户的所有角色
		List<String> list16 = new ArrayList<>();
		list16.add("0207010200");
		map.put(rootPath + modulePath + "/deleteUserRole.action", list16);
		// 删除用户的所有角色
		List<String> list17 = new ArrayList<>();
		list17.add("0207010100");
		map.put(rootPath + modulePath + "/resetPassword.action", list17);
	}
	
	// 初始聊天模块
	private static void charInit(Map<String, List<String>> map) {
		String modulePath = "/emchat";
		// 查询群组信息
		List<String> list1 = new ArrayList<>();
		list1.add("0209020000");
		map.put(rootPath + modulePath + "/queryGroupTable.action", list1);
		// 添加群组信息
		List<String> list2 = new ArrayList<>();
		list2.add("0209020000");
		map.put(rootPath + modulePath + "/addGroupTable.action", list2);
		// 用户添加群
		List<String> list3 = new ArrayList<>();
		list3.add("0209020000");
		map.put(rootPath + modulePath + "/addHxuserGroup.action", list3);
		// 查询某个用户加入的所有群的信息
		List<String> list4 = new ArrayList<>();
		list4.add("0209020000");
		map.put(rootPath + modulePath + "/queryHxuserGroup.action", list4);
		// 获取好友列表
		List<String> list5 = new ArrayList<>();
		list5.add("0209020000");
		map.put(rootPath + modulePath + "/queryFriends.action", list5);
		// 获取用户详情
		List<String> list6 = new ArrayList<>();
		list6.add("0209020000");
		map.put(rootPath + modulePath + "/selectFriends.action", list6);
		// 显示验证信息,用户和群详情
		List<String> list7 = new ArrayList<>();
		list7.add("0209020000");
		map.put(rootPath + modulePath + "/queryFriendGroupInfo.action", list7);
		// 显示验证信息,用户和群详情
		List<String> list8 = new ArrayList<>();
		list8.add("0209020000");
		map.put(rootPath + modulePath + "/queryFriend.action", list8);
		// 通过用户账号获取用户
		List<String> list9 = new ArrayList<>();
		list9.add("0209020000");
		map.put(rootPath + modulePath + "/queryFriendAccout.action", list9);
		// 通过用户id获取用户
		List<String> list10 = new ArrayList<>();
		list10.add("0209020000");
		map.put(rootPath + modulePath + "/queryFriendUserId.action", list10);
		
		// 添加备注
		List<String> list11 = new ArrayList<>();
		list11.add("0209020000");
		map.put(rootPath + modulePath + "/addFriendRelation.action", list11);
		// 修改备注
		List<String> list12 = new ArrayList<>();
		list12.add("0209020000");
		map.put(rootPath + modulePath + "/updateFriendRelation.action", list12);
		// 删除备注
		List<String> list13 = new ArrayList<>();
		list13.add("0209020000");
		map.put(rootPath + modulePath + "/deleteFriendRelation.action", list13);
		// 获取备注
		List<String> list14 = new ArrayList<>();
		list14.add("0209020000");
		map.put(rootPath + modulePath + "/queryFriendRelation.action", list14);
	}
	
	// 初始化商城模块
	private static void marketInit(Map<String, List<String>> map) {
		String modulePath = "/market";
		// 根据类别id获取该类别下的子类别
		List<String> list1 = new ArrayList<>();
		list1.add("0209040000");
		map.put(rootPath + modulePath + "/queryCategory.action", list1);
		// 根据类别级别获取该级别下的类别
		List<String> list2 = new ArrayList<>();
		list2.add("0209040000");
		map.put(rootPath + modulePath + "/selectCategory.action", list2);
		// 添加类别
		List<String> list3 = new ArrayList<>();
		list3.add("0209040000");
		map.put(rootPath + modulePath + "/addCategory.action", list3);
		// 删除类别
		List<String> list4 = new ArrayList<>();
		list4.add("0209040000");
		map.put(rootPath + modulePath + "/delCategory.action", list4);
		// 修改类别
		List<String> list5 = new ArrayList<>();
		list5.add("0209040000");
		map.put(rootPath + modulePath + "/updateCategory.action", list5);

		// 添加商品
		List<String> commodityList1 = new ArrayList<>();
		commodityList1.add("0209040000");
		map.put(rootPath + modulePath + "/addCommodityTable.action", commodityList1);
		// 根据商品名称获取商品信息
		List<String> commodityList2 = new ArrayList<>();
		commodityList2.add("0209040000");
		map.put(rootPath + modulePath + "/queryCommodityName.action", commodityList2);
		// 多条件获取商品详情
		List<String> commodityList3 = new ArrayList<>();
		commodityList3.add("0209040000");
		map.put(rootPath + modulePath + "/queryCommodity.action", commodityList3);
		// 上架或下架
		List<String> commodityList4 = new ArrayList<>();
		commodityList4.add("0209040000");
		map.put(rootPath + modulePath + "/updateStatus.action", commodityList4);
		// 修改商品信息
		List<String> commodityList5 = new ArrayList<>();
		commodityList5.add("0209040000");
		map.put(rootPath + modulePath + "/updateCommodity.action", commodityList5);
		// 根据商品id获取单个商品的详情
		List<String> commodityList6 = new ArrayList<>();
		commodityList6.add("0209040000");
		map.put(rootPath + modulePath + "/selectCommodityCid.action", commodityList6);

		// 获取订单详情
		List<String> orderList1 = new ArrayList<>();
		orderList1.add("0209040000");
		map.put(rootPath + modulePath + "/queryOrderTable.action", orderList1);
		// 添加订单
		List<String> orderList2 = new ArrayList<>();
		orderList2.add("0209040000");
		map.put(rootPath + modulePath + "/addOrderTable.action", orderList2);
		// 添加快递信息
		List<String> orderList3 = new ArrayList<>();
		orderList3.add("0209040000");
		map.put(rootPath + modulePath + "/addLoglistics.action", orderList3);
		// 获取单个订单详情
		List<String> orderList4 = new ArrayList<>();
		orderList4.add("0209040000");
		map.put(rootPath + modulePath + "/queryOrderId.action", orderList4);
		// 修改状态
		List<String> orderList5 = new ArrayList<>();
		orderList5.add("0209040000");
		map.put(rootPath + modulePath + "/updateState.action", orderList5);
		// 退货
		List<String> orderList6 = new ArrayList<>();
		orderList6.add("0209040000");
		map.put(rootPath + modulePath + "/updateDetails.action", orderList6);
		// 评价
		List<String> orderList7 = new ArrayList<>();
		orderList7.add("0209040000");
		map.put(rootPath + modulePath + "/addDescribe.action", orderList7);

		// 查询某个商品的图片
		List<String> imageList1 = new ArrayList<>();
		imageList1.add("0209040000");
		map.put(rootPath + modulePath + "/queryImage.action", imageList1);
		// 添加单张图片
		List<String> imageList2 = new ArrayList<>();
		imageList2.add("0209040000");
		map.put(rootPath + modulePath + "/addCommodityImage.action", imageList2);
		// 修改图片信息
		List<String> imageList3 = new ArrayList<>();
		imageList3.add("0209040000");
		map.put(rootPath + modulePath + "/updateImage.action", imageList3);
		// 删除图片信息
		List<String> imageList4 = new ArrayList<>();
		imageList4.add("0209040000");
		map.put(rootPath + modulePath + "/delImage.action", imageList4);

		// 查看评价
		List<String> appraiseList1 = new ArrayList<>();
		appraiseList1.add("0209040000");
		map.put(rootPath + modulePath + "/queryAppraise.action", appraiseList1);
	}
	
	// 初始公共模块
	private static void commonInit(Map<String, List<String>> map) {
		String modulePath1 = "/image";
		// 上传模块轮播图
		List<String> list1 = new ArrayList<>();
		list1.add("0206010000");
		list1.add("0206020000");
		list1.add("0206030000");
		list1.add("0206040000");
		list1.add("0206050000");
		list1.add("0206060000");
		map.put(rootPath + modulePath1 + "/uploadModuleSlideshow.action", list1);
		// 添加模块轮播图key值
		List<String> list2 = new ArrayList<>();
		list2.add("0206010000");
		list2.add("0206020000");
		list2.add("0206030000");
		list2.add("0206040000");
		list2.add("0206050000");
		list2.add("0206060000");
		map.put(rootPath + modulePath1 + "/addModuleSlideshowKey.action", list2);
		// 删除模块轮播图
		List<String> list3 = new ArrayList<>();
		list3.add("0206010000");
		list3.add("0206020000");
		list3.add("0206030000");
		list3.add("0206040000");
		list3.add("0206050000");
		list3.add("0206060000");
		map.put(rootPath + modulePath1 + "/deleteModuleSlideshow.action", list3);
	}
}
