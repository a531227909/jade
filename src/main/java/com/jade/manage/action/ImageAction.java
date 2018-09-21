package com.jade.manage.action;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jade.manage.service.ImageService;
import com.jade.po.Result;

@Controller
@RequestMapping("/image")
public class ImageAction {
	
	@Autowired
	private ImageService imageService;
	
	/**
	 * 定义时间：2017年06月11日
	 * 实现时间：2017年06月11日
	 * 编写者：shadow
	 * 用途：上传图片
	 * @param image
	 * @param type
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadImage.action",method=RequestMethod.POST)
	public @ResponseBody Result uploadImage(MultipartFile image) throws Exception{
		String ContentType = image.getContentType();
		Long size = image.getSize();
		if(size > 50*1024*1024){
			Result result = new Result();
			result.setSuccess(false);
			result.getResult().put("error", "上传的文件只能在50MB之内");
			return result;
		}
		if(!ContentType.equals("image/jpeg")&&!ContentType.equals("image/png")){
			Result result = new Result();
			result.setSuccess(false);
			result.getResult().put("error", "只能上传jpeg或者png格式的图片");
			return result;
		}
		String module = "上传";
		Result result = new Result();
		if(size>1*1024*1024){
			result = imageService.uploadImage(module,zipImageFile(image,2000,2000,1f));
		}else{
			result = imageService.uploadImage(module,image.getInputStream());
		}
		return result;
	}
	
	
	
	/**
	 * 上传视频
	 * @param image
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value="/uploadVideo.action",method=RequestMethod.POST)
	public @ResponseBody Result upload(MultipartFile image) throws Exception{
		String ContentType = image.getContentType();
		Long size = image.getSize();
		if(size > 50*1024*1024){
			Result result = new Result();
			result.setSuccess(false);
			result.getResult().put("error", "上传的文件只能在50MB之内");
			return result;
		}
//		if(!ContentType.equals("video/mpeg4")&&!ContentType.equals("video/avi")){
//			Result result = new Result();
//			result.setSuccess(false);
//			result.getResult().put("error", "只能上传mp4或者avi格式的视频");
//			return result;
//		}

		Result result = imageService.yoloadVideo(image.getInputStream());
		return result;
	}
//	
//	/**
//	 * 定义时间：2017年06月11日
//	 * 实现时间：2017年06月11日
//	 * 编写者：shadow
//	 * 用途：删除图片
//	 * @param key
//	 * @param session
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value="/deleteImage.action",method=RequestMethod.POST)
//	public @ResponseBody Result deleteImage(String key,HttpSession session) throws Exception{
//		String userId = (String)session.getAttribute("userId");
//		String hotelId = (String)session.getAttribute("hotelId");
//		Result result = imageService.deleteImage(hotelId,userId,key);
//		return result;
//	}
//	
//	/**
//	 * 定义时间：2017年07月13日
//	 * 实现时间：2017年07月13日
//	 * 编写者：shadow
//	 * 用途：上传模块轮播图
//	 * @param image
//	 * @param module
//	 * @param session
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value="/uploadModuleSlideshow.action",method=RequestMethod.POST)
//	public @ResponseBody Result uploadModuleSlideshow(MultipartFile image,
//			@RequestParam(required=true) short module,HttpSession session) throws Exception{
//		if(module != SignalMapperUtil.MAIN_PAGE_IMAGE){
//			module = SignalMapperUtil.MAIN_PAGE_IMAGE;
//		}
//		String ContentType = image.getContentType();
//		Long size = image.getSize();
//		if(size > 5*1024*1024){//判断图片的大小是否大于5MB
//			Result result = new Result();
//			result.setSuccess(false);
//			result.getResult().put("error", "上传的文件只能在5MB之内");
//			return result;
//		}
//		if(!ContentType.equals("image/jpeg")&&!ContentType.equals("image/png")){//判断图片的类型是否为jpeg或者png
//			Result result = new Result();
//			result.setSuccess(false);
//			result.getResult().put("error", "只能上传jpeg或者png格式的图片");
//			return result;
//		}
//		String hotelId = (String)session.getAttribute("hotelId");
//		Result result = imageService.uploadModuleSlideshow(hotelId, image.getInputStream(), module);
//		return result;
//	}
//	
//	/**
//	 * 定义时间：2017年07月13日
//	 * 实现时间：2017年07月13日
//	 * 编写者：shadow
//	 * 用途：添加模块轮播图key值
//	 * @param images
//	 * @param module
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping(value="/addModuleSlideshowKey.action",method=RequestMethod.POST)
//	public @ResponseBody Result addModuleSlideshowKey(@RequestParam(required=true,value="images[]") String []images,
//			short module,HttpSession session){
//		if(module != SignalMapperUtil.MAIN_PAGE_IMAGE){
//			module = SignalMapperUtil.MAIN_PAGE_IMAGE;
//		}
//		String hotelId = (String)session.getAttribute("hotelId");
//		return imageService.addModuleSlideshowKey(hotelId, images, module);
//	}
//	
	/**
	 * 定义时间：2017年07月13日
	 * 实现时间：2017年07月13日
	 * 编写者：shadow
	 * 用途：获取模块轮播图
	 * @param session
	 * @param module
	 * @return
	 */
//	@RequestMapping(value="/getModuleSlideshow.action",method=RequestMethod.GET)
//	public @ResponseBody Result getModuleSlideshow(HttpSession session,@RequestParam(required=true) short module){
//		if(module != SignalMapperUtil.MAIN_PAGE_IMAGE){
//			module = SignalMapperUtil.MAIN_PAGE_IMAGE;
//		}
//		String hotelId = (String)session.getAttribute("hotelId");
//		return imageService.getModuleSlideshow(hotelId, module);
//	}
////	
//	/**
//	 * 定义时间：2017年07月13日
//	 * 实现时间：2017年07月13日
//	 * 编写者：shadow
//	 * 用途：删除模块轮播图
//	 * @param session
//	 * @param key
//	 * @return
//	 */
//	@RequestMapping(value="/deleteModuleSlideshow.action",method=RequestMethod.POST)
//	public @ResponseBody Result deleteModuleSlideshow(HttpSession session,
//			@RequestParam(required=true) String key,
//			@RequestParam(required=true) short module){
//		String userId = (String)session.getAttribute("userId");
//		String hotelId = (String)session.getAttribute("hotelId");
//		return imageService.deleteModuleSlideshow(hotelId, userId, key);
//	}
	
	/**  
     * 根据设置的宽高等比例压缩图片文件<br> 先保存原文件，再压缩、上传  
     * @param oldFile  要进行压缩的文件  
     * @param newFile  新文件  
     * @param width  宽度 //设置宽度时（高度传入0，等比例缩放）  
     * @param height 高度 //设置高度时（宽度传入0，等比例缩放）  
     * @param quality 质量  
     * @return 返回压缩后的文件的全路径  
     */    
    public static InputStream zipImageFile(MultipartFile image, int width, int height,float quality) {    
    	InputStream is = null;
        try {    
            /** 对服务器上的临时文件进行处理 */    
            Image srcFile = ImageIO.read(image.getInputStream());    
            int w = srcFile.getWidth(null);    
            int h = srcFile.getHeight(null);    
            double bili;    
            if(width>0){    
                bili=width/(double)w;    
                height = (int) (h*bili);    
            }else{    
                if(height>0){    
                    bili=height/(double)h;    
                    width = (int) (w*bili);    
                }    
            }    
            String subfix = "jpg";  
            BufferedImage buffImg = null;   
            if(subfix.equals("png")){  
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);  
            }else{  
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            }  
  
            Graphics2D graphics = buffImg.createGraphics();  
            graphics.setBackground(new Color(255,255,255));  
            graphics.setColor(new Color(255,255,255));  
            graphics.fillRect(0, 0, width, height);  
            graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);    
            ByteArrayOutputStream bs =new ByteArrayOutputStream(); 
            ImageOutputStream imOut =ImageIO.createImageOutputStream(bs); 
            System.out.println(imOut);
            ImageIO.write(buffImg, subfix, imOut);    
           is = new ByteArrayInputStream(bs.toByteArray());
            
        } catch (FileNotFoundException e) {    
            e.printStackTrace();    
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
        return is;    
    }    
	
}
