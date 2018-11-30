package com.jade.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.jade.po.Result;
import com.jade.service.DownLoadService;

@Service
public class DownLoadServiceImpl implements DownLoadService{

	@Override
	public Result downLoad(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		String fileName = request.getParameter("filename");  //23239283-92489-阿凡达.avi
//      try {
//			fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
      //上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
      String fileSaveRootPath=request.getSession().getServletContext().getRealPath("");
      if(fileSaveRootPath.endsWith("/")){
    	  fileSaveRootPath = fileSaveRootPath.substring(0,fileSaveRootPath.length() - 1);
      }
      fileSaveRootPath = fileSaveRootPath.substring(0,fileSaveRootPath.lastIndexOf("/"));
      fileSaveRootPath = fileSaveRootPath.substring(0,fileSaveRootPath.lastIndexOf("/"))+"/upload";
      //通过文件名找出文件的所在目录
      String path = fileSaveRootPath;
//      String path = findFileSavePathByFileName(fileName,fileSaveRootPath);
      //得到要下载的文件
      File file = new File(path + "/" + fileName);
      //如果文件不存在
      if(!file.exists()){
		result.setSuccess(false);
		result.getResult().put("error", "您要下载的资源不存在或已被删除！！");
      	return result;
      }
      //处理文件名
      String realname = fileName.substring(fileName.indexOf("_")+1);
      //设置响应头，控制浏览器下载该文件
      try {
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
      //读取要下载的文件，保存到文件输入流
      FileInputStream in = null;
		try {
			in = new FileInputStream(path + "/" + fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
      //创建输出流
      OutputStream out = null;
		try {
			out = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
      //创建缓冲区
      byte buffer[] = new byte[1024];
      int len = 0;
      //循环将输入流中的内容读取到缓冲区当中
      try {
			while((len=in.read(buffer))>0){
			    //输出缓冲区的内容到浏览器，实现文件下载
			    out.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
      //关闭文件输入流
      try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
      //关闭输出流
      try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	result.setSuccess(true);
	result.getResult().put("msg", "下载成功！");
  	return result;
	}
	
  /**
    * @Method: findFileSavePathByFileName
    * @Description: 通过文件名和存储上传文件根目录找出要下载的文件的所在路径
    * @param filename 要下载的文件名
    * @param saveRootPath 上传文件保存的根目录，也就是/WEB-INF/upload目录
    * @return 要下载的文件的存储目录
    */ 
    public String findFileSavePathByFileName(String filename,String saveRootPath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        String dir = saveRootPath + "/" + dir1 + "/" + dir2;  //upload\2\3  upload\3\5
        File file = new File(dir);
        if(!file.exists()){
            //创建目录
            file.mkdirs();
        }
        return dir;
    }
	
}
