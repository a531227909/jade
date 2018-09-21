package com.jade.manage.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.stream.ImageInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jade.manage.service.ImageService;
import com.jade.po.Result;
import com.jade.uitil.ImageUtil;
import com.jade.uitil.videoUtil;



@Service
public class ImageServiceImp implements ImageService {
	

	/**
	 * 上传图片
	 */
	@Override
	public Result uploadImage(String module,InputStream inputStream) throws Exception{
		String key = createImageKey(module);
		ImageUtil.uploadFile(inputStream, "image/jpeg", key);
	
		Result result = new Result();
		result.setSuccess(true);
		result.getResult().put("key", key);
		return result;
	}

	/**
	 * 删除图片
	 */
	@Override
	public Result deleteImage(String key) throws Exception{
		//删除阿里云上的图片
		ImageUtil.deleteFile(key);
		
		Result result = new Result();
		result.setSuccess(true);
		return result;
	}
	
	
	
	private String createImageKey(String module){
		//HotelVO hotel = hotelMapper.selectByPrimaryKey(hotelId);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = format.format(new Date());
		
		//String str = StringUtil.createTimeString("yyyy/MM/dd/HHmmss");
		//String randomString = StringUtil.getRandomString(8);
		return  module + "/" + str +((Math.random()*9+1)*10+"").substring(0, 2);
	}

//	/**
//	 * 上传模块轮播图
//	 */
//	@Override
//	public Result uploadModuleSlideshow(String hotelId,InputStream inputStream, short module)throws Exception{
//		HotelVO hotel = hotelMapper.selectByPrimaryKey(hotelId);
//		String hotelName = hotel.getName();
//		String moduleName = getModuleName(module);
//		String timeString = StringUtil.createTimeString("yyyy/MM/dd/HHmmss");
//		String randomString = StringUtil.getRandomString(4);
//		String imageKey = hotelName + "/轮播图" +  "/" + moduleName + "/" + timeString +  "/" + randomString;
//		ImageUtil.uploadFile(inputStream, "image/jpeg", imageKey);
//		Result result = new Result();
//		result.setSuccess(true);
//		result.getResult().put("key", imageKey);
//		return result;
//	}
//
//	/**
//	 * 保存模块轮播图key值
//	 */
//	@Override
//	public Result addModuleSlideshowKey(String hotelId, String [] images, short module) {
//		Result result = new Result();
//		try{
//			//添加图片
//			for(String key : images){
//				ModuleSlideshow image = new ModuleSlideshow();
//				image.setId(UUID.randomUUID().toString());
//				image.setImageKey(key);
//				image.setHotelId(hotelId);
//				image.setModule(module);
//				slideshowImageMapper.insertSelective(image);
//			}
//			
//			//返回数据
//			result.setSuccess(true);
//		}catch(Exception e){
//			result.setSuccess(false);
//			result.getResult().put("error", "error");
//		}
//		return result;
//	}
//
	/**
	 * 获取模块图片
	 */
	@Override
	public String getModuleSlideshow(String key) {
		
		String url = "";
			//生成图片url
			url = ImageUtil.getUrl(key, 60*1000);
		return url;
	}
//
//	/**
//	 * 删除模块轮播图
//	 */
//	@Override
//	public Result deleteModuleSlideshow(String hotelId, String userId, String key) {
//	
//		// 删除数据库图片
//		ModuleSlideshowExample example = new ModuleSlideshowExample();
//		ModuleSlideshowExample.Criteria c = example.createCriteria();
//		c.andHotelIdEqualTo(hotelId);
//		c.andImageKeyEqualTo(key);
//		slideshowImageMapper.deleteByExample(example);
//		
//		// 删除阿里云上的图片
//		ImageUtil.deleteFile(key);
//		
//		Result result = new Result();
//		result.setSuccess(true);
//		return result;
//	}
	
	//上传视频
	@Override
	public Result yoloadVideo(InputStream inputStream) throws Exception {
		String key = createImageKey("视频");
		ImageUtil.uploadFile(inputStream, "video/mpeg4", key+".mp4");
		//videoUtil.createUploadVideo();
		//ImageUtil.getUrl(key+".mp4", 60*1000);
		Result result = new Result();
	
		result.setSuccess(true);
		result.getResult().put("key", key);
		
		return result;
	}
}
