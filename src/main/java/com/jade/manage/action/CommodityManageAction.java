package com.jade.manage.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jade.manage.service.CommodityManageService;
import com.jade.po.Result;
import com.jade.uitil.ExcelUtil;

@Controller
@RequestMapping("/commodityManage")
public class CommodityManageAction {

	@Autowired
	private CommodityManageService commodityService;
	
	/**
	 * 获取商品上架列表
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/getCommodityList.action",method=RequestMethod.POST)
	public @ResponseBody Result getCommodityList(HttpSession session){
		String account = (String) session.getAttribute("account");
		return commodityService.getCommodityList(account);
		
	}
	
	/**
	 * 获取商品下架列表
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/getCommoditysoldOut.action",method=RequestMethod.POST)
	public @ResponseBody Result getCommoditysoldOut(HttpSession session){
		String account = (String) session.getAttribute("account");
		return commodityService.getCommoditysoldOut(account);
		
	}
	
	/**
	 * 上架和下架
	 * @return
	 */
	@RequestMapping(value="/soldOutAndPutAway.action",method=RequestMethod.POST)
	public @ResponseBody Result soldOutAndPutAway(@RequestBody JSONObject data){
		
			return commodityService.soldOutAndPutAway(data);

	}
	
	/**
	 *根据cid等获取商品详细信息
	 * @return
	 */
	@RequestMapping(value="/selectCommosityByCid.action",method=RequestMethod.POST)
	public @ResponseBody Result selectCommosityByCid(@RequestBody JSONObject data){
		
			return commodityService.selectCommosityByCid(data);

	}
	/**
	 *删除商品
	 * @return
	 */
	@RequestMapping(value="/delCommodity.action",method=RequestMethod.POST)
	public @ResponseBody Result delCommodity(@RequestBody JSONObject data){
		
			return commodityService.delCommodity(data);

	}
	/**
	 *更新商品
	 * @return
	 */
	@RequestMapping(value="/updataCommodity.action",method=RequestMethod.POST)
	public @ResponseBody Result updataCommodity(@RequestBody JSONObject data){
		
			return commodityService.updataCommodity(data);

	}
	/**
	 *添加商品
	 * @return
	 */
	@RequestMapping(value="/addCommodity.action",method=RequestMethod.POST)
	public @ResponseBody Result addCommodity(@RequestBody JSONObject data,HttpSession session){
			String account = (String)session.getAttribute("account");
			return commodityService.addCommodity(data,account);

	}
	/**
	 *获取一级类别列表
	 * @return
	 */
	@RequestMapping(value="/getFirstCategory.action",method=RequestMethod.POST)
	public @ResponseBody Result getFirstCategory(HttpSession session){
		String agentId= (String)session.getAttribute("agentId");
			return commodityService.getFirstCategory(agentId);

	}
	/**
	 *根据一级类别获取二级
	 * @return
	 */
	@RequestMapping(value="/getSecondByFirst.action",method=RequestMethod.POST)
	public @ResponseBody Result getSecondByFirst(@RequestBody JSONObject data){
		
			return commodityService.getSecondByFirst(data);

	}
	/**
	 *删除类别
	 * @return
	 */
	@RequestMapping(value="/delCategory.action",method=RequestMethod.POST)
	public @ResponseBody Result delCategory(@RequestBody JSONObject data){
		
			return commodityService.delCategory(data);

	}
	/**
	 *修改类别信息
	 * @return
	 */
	@RequestMapping(value="/updateCategory.action",method=RequestMethod.POST)
	public @ResponseBody Result updateCategory(@RequestBody JSONObject data){
		
			return commodityService.updateCategory(data);

	}
	/**
	 *新增类别
	 * @return
	 */
	@RequestMapping(value="/addCategory.action",method=RequestMethod.POST)
	public @ResponseBody Result addCategory(@RequestBody JSONObject data,HttpSession session){
		String agentId= (String)session.getAttribute("agentId");
			return commodityService.addCategory(data,agentId);

	}
	/**
	 *新增二级类别
	 * @return
	 */
	@RequestMapping(value="/addSecondCategory.action",method=RequestMethod.POST)
	public @ResponseBody Result addSecondCategory(@RequestBody JSONObject data,HttpSession session){
		String agentId= (String)session.getAttribute("agentId");
		
			return commodityService.addSecondCategory(data,agentId);

	}
	/**
	 *给一级类增加子类
	 * @return
	 */
	@RequestMapping(value="/addSecondByFirst.action",method=RequestMethod.POST)
	public @ResponseBody Result addSecondByFirst(@RequestBody JSONObject data){
		
			return commodityService.addSecondByFirst(data);

	}
	
	/**
	 *删除2级类
	 * @return
	 */
	@RequestMapping(value="/delSecondCategory.action",method=RequestMethod.POST)
	public @ResponseBody Result delSecondCategory(@RequestBody JSONObject data){
		
			return commodityService.delSecondCategory(data);

	}
	
	/**
	 *获取所有二级类别
	 * @return
	 */
	@RequestMapping(value="/getAllSecondCategory.action",method=RequestMethod.POST)
	public @ResponseBody Result getAllSecondCategory(@RequestBody JSONObject data,HttpSession session){
		String agentId= (String)session.getAttribute("agentId");
		
			return commodityService.getAllSecondCategory(data,agentId);

	}
	
	/**
	 *修改二级类别
	 * @return
	 */
	@RequestMapping(value="/updateSecond.action",method=RequestMethod.POST)
	public @ResponseBody Result updateSecond(@RequestBody JSONObject data){
		
			return commodityService.updateSecond(data);

	}
	
	@RequestMapping(value="/saveDoc.action",method=RequestMethod.POST)
	@ResponseBody
    public Result uploadDoc(HttpServletRequest request,HttpServletResponse response,String sid) throws IOException, Exception{
		Result result = new Result();
		System.out.println("收到文档!");
        MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest)request;
        
        ExcelUtil<Map<String, Object>> ex = new ExcelUtil<Map<String, Object>>();
        Map<String, MultipartFile> files = Murequest.getFileMap();//得到文件map对象
        System.out.println(files.get("file"));
        List fileNameList = new ArrayList();
        Map map=new HashMap();
        String upaloadUrl = request.getSession().getServletContext().getRealPath("/")+"savefile\\";//得到当前工程路径拼接上文件名
        File dir = new File(upaloadUrl);
        System.out.println(upaloadUrl);
        int counter=0;      
        if(!dir.exists())//目录不存在则创建
            dir.mkdirs();
        for(MultipartFile file :files.values()){
            counter++;
            String fileName = file.getOriginalFilename();
            System.out.println(fileName);
            String suffix=fileName.substring(fileName.indexOf("."));
            fileName=this.rename(request)+suffix;
            fileNameList.add(fileName);
            File tagetFile = new File(upaloadUrl+fileName);//创建文件对象
            if(!tagetFile.exists()){//文件名不存在 则新建文件，并将文件复制到新建文件中
                try {
                    tagetFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    file.transferTo(tagetFile);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        String docName=StringUtils.join(fileNameList.toArray(), ",");
        map.put("docName", docName);
        System.out.println(map.get("docName"));
        System.out.println("---------------->"+map.get("docName"));
        String str = upaloadUrl+map.get("docName");
        System.out.println("================>"+str);
        //判断导入文件是什么文件，如果是excel则解析入库
        
        return commodityService.uploadExcel(map,str,sid);
}
	/**
	 * 重新命名上传的文件
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public String rename(HttpServletRequest request) throws IOException, Exception{
		HttpServletRequest httpReq=(HttpServletRequest)request;
		 SimpleDateFormat sdf =   new SimpleDateFormat( "yyyyMMddhhmmss" );
         String str = sdf.format(new Date());
         String hoteId = (String) httpReq.getSession().getAttribute("hotelId");
         String userId = (String) httpReq.getSession().getAttribute("userId");
         String fileName=str+hoteId+userId;
		return fileName;
		
	}
	
	/**
	 * 导出模板excel
	 * @param userPerson
	 * @param typeName
	 * @param type
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping(value="/downExcel.action",method=RequestMethod.GET)
	public @ResponseBody Result downTotalExcel(HttpServletRequest request,HttpServletResponse response,String usePerson, String typeName, String type,
			String beginTime, String endTime){		
			String upaloadUrl = request.getSession().getServletContext().getRealPath("/")+"savefile\\";
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	        String str = format.format(new Date());
	        try {
	    	ExcelUtil<Map<String, Object>> ex = new ExcelUtil<Map<String, Object>>();
	        String[] headers = { "一级类别", "二级类别", "商品名称", "商品单价", "上架天数" ,"商品圈口","商品颜色","商品描述"};
	        Collection<Map<String, Object>> dataset = new ArrayList<Map<String, Object>>();
	      
	            Map<String, Object> mapOut = new HashMap<String, Object>();
	            mapOut.put("一级类别", "玉石");
	            mapOut.put("二级类别", "翡翠");
	            mapOut.put("商品名称", "小白钻戒");
	            mapOut.put("商品单价", "23100");
	            mapOut.put("上架天数", "20");
	            mapOut.put("商品圈口", "8.1");
	            mapOut.put("商品颜色", "白色");
	            mapOut.put("商品描述", "东西很好");
	            dataset.add(mapOut);
	        
	        
	        // 到处excel
	        System.out.println("*-/*-/*-/-"+upaloadUrl);
	        File dir = new File(upaloadUrl);
	        if(!dir.exists())//目录不存在则创建
	            dir.mkdirs();
	        OutputStream output = new FileOutputStream(upaloadUrl+"jade"+str+".xls");

	        ex.exportExcel("abc", headers, headers, dataset, output, "yyyy-MM-dd HH:mm:ss");

	        output.close();
	        //JOptionPane.showMessageDialog(null, "导出成功!");
	        System.out.println("excel导出成功！");
	        
			 response.setContentType("application/x-msdownload");   
	          
		        String fileName = str+".xls";  
		        
					response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
					OutputStream out = response.getOutputStream();  
				
				 
			          
			        InputStream in = new FileInputStream(upaloadUrl+"jade"+str+".xls");  
			          
			        byte [] buffer = new byte[1024];  
			        int len = 0;  
			          
			        while((len = in.read(buffer)) != -1){  
			            out.write(buffer, 0, len);  
			        }  
			          
			        in.close(); 
			        out.close();
			       // JOptionPane.showMessageDialog(null, "导出成功!");
				} catch (Exception e) {
					e.printStackTrace();
				}  
		          
		        
			return null;
		
	}


}
