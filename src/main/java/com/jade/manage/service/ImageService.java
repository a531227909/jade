package com.jade.manage.service;

import java.io.InputStream;

import javax.imageio.stream.ImageInputStream;

import org.springframework.web.multipart.MultipartFile;

import com.jade.po.Result;

public interface ImageService {

	/**
	 * 定义时间：2017年06月12日
	 * 编写者：shadow
	 * 用途：上传图片
	 * @param hotelId
	 * @param userId
	 * @param inputStream
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public Result uploadImage(String module,InputStream inputStream) throws Exception;
	
	/**
	 * 定义时间：2017年06月12日
	 * 编写者：shadow
	 * 用途：删除图片
	 * @param hotelId
	 * @param userId
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Result deleteImage(String key) throws Exception;
	
	/**
	 * 定义时间：2017年07月13日
	 * 实现时间：2017年07月13日
	 * 编写者：shadow
	 * 用途：上传轮播图
	 * @param hotelId
	 * @param inputStream
	 * @param module
	 * @return
	 * @throws Exception
	 * 
	 * public Result deleteImage(String key) throws Exception;
	 */
	public Result yoloadVideo(InputStream inputStream) throws Exception;
//	public Result uploadModuleSlideshow(String hotelId,InputStream inputStream,short module)throws Exception;
//	
//	/**
//	 * 定义时间：2017年07月13日
//	 * 编写者：shadow
//	 * 用途：添加模块轮播图
//	 * @param hotelId
//	 * @param images
//	 * @param module
//	 * @return
//	 */
//	public Result addModuleSlideshowKey(String hotelId, String [] images,short module);
//	
	/**
	 * 定义时间：2017年07月13日
	 * 编写者：shadow
	 * 用途：获取模块轮播图
	 * @param hotelId
	 * @param module
	 * @return
	 */
	public String getModuleSlideshow(String key);
//	
//	/**
//	 * 定义时间：2017年07月13日
//	 * 编写者：shadow
//	 * 用途：删除模块轮播图
//	 * @param hotelId
//	 * @param userId
//	 * @param key
//	 * @return
//	 */
//	public Result deleteModuleSlideshow(String hotelId,String userId,String key);
}
