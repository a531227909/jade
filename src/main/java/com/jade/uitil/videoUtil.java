package com.jade.uitil;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.web.multipart.MultipartFile;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoRequest;
import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoResponse;

public class videoUtil {

	private static String accessKeyId = "";
	private static String accessKeySecret = "";
	private static  String endpoint;
	// 应用启动时，自动加载与发送信息相关的配置文件aliyunoos.properties，并初始化相关参数
	static {
		Properties pro = new Properties();
		InputStream input = ImageUtil.class.getClassLoader().getResourceAsStream("conf/aliyunoos.properties");
		try {
			pro.load(new InputStreamReader(input, "UTF-8"));
			accessKeyId = pro.getProperty("accessKeyId");
			endpoint = pro.getProperty("endpoint");
			accessKeySecret = pro.getProperty("accessKeySecret");
		 	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	  
	//获取视频上传凭证和地址
	 public static String createUploadVideo() {
		 	//初始化
		 	DefaultAcsClient client;
		 	client = new DefaultAcsClient(
		    DefaultProfile.getProfile("cn-beijing",accessKeyId,accessKeySecret));
	        CreateUploadVideoRequest request = new CreateUploadVideoRequest();
	        CreateUploadVideoResponse response = null;
	        try {
	              /*必选，视频源文件名称（必须带后缀, 支持 ".3gp", ".asf", ".avi", ".dat", ".dv", ".flv", ".f4v", ".gif", ".m2t", ".m3u8", ".m4v", ".mj2", ".mjpeg", ".mkv", ".mov", ".mp4", ".mpe", ".mpg", ".mpeg", ".mts", ".ogg", ".qt", ".rm", ".rmvb", ".swf", ".ts", ".vob", ".wmv", ".webm"".aac", ".ac3", ".acm", ".amr", ".ape", ".caf", ".flac", ".m4a", ".mp3", ".ra", ".wav", ".wma"）*/
	              request.setFileName("video11.mp4");
	              //必选，视频标题
	              request.setTitle("movi");
//	              //可选，分类ID
//	              request.setCateId(0);
//	              //可选，视频标签，多个用逗号分隔
//	              request.setTags("标签1,标签2");
//	              //可选，视频描述
//	              request.setDescription("视频描述");
	              //可选，视频源文件字节数
	              //request.setFileSize((long) 1024);
	              response = client.getAcsResponse(request);
	        } catch (ServerException e) {
	              System.out.println("CreateUploadVideoRequest Server Exception:");
	              e.printStackTrace();
	        } catch (ClientException e) {
	              System.out.println("CreateUploadVideoRequest Client Exception:");
	              e.printStackTrace();
	        }
	        System.out.println("RequestId:"+response.getRequestId());
	        System.out.println("UploadAuth:"+response.getUploadAuth());
	        System.out.println("UploadAddress:"+response.getUploadAddress());
	        return response.getVideoId();
	  }
	 //刷新视频上传凭证
	 public static void refreshUploadVideo(String videoId) {
		 	//初始化
		 	DefaultAcsClient client;
		 	client = new DefaultAcsClient(
		    DefaultProfile.getProfile("cn-shanghai",accessKeyId,accessKeySecret));
	        RefreshUploadVideoRequest request = new RefreshUploadVideoRequest();
	        RefreshUploadVideoResponse response = null;
	        try {
	              request.setVideoId(videoId);
	              response = client.getAcsResponse(request);
	        } catch (ServerException e) {
	              System.out.println("RefreshUploadVideoRequest Server Exception:");
	              e.printStackTrace();
	        } catch (ClientException e) {
	              System.out.println("RefreshUploadVideoRequest Client Exception:");
	              e.printStackTrace();
	        }
	        System.out.println("RequestId:" + response.getRequestId());
	        System.out.println("UploadAuth:" + response.getUploadAuth());
	  }
	 
	 public static void upload(){
		  //需要替换为真实用户AK
	
		    //fileName为上传文件所在的绝对路径(必须包含扩展名)
		    String fileName = "D://movie.mp4";
		    String title = "视频标题";
		    //构造上传请求实例
		    UploadVideoRequest request = new UploadVideoRequest(accessKeyId, accessKeySecret, title, fileName);
		    //视频分类ID
		    //request.setCateId(0);
		    //视频标签,多个用逗号分隔
		    //request.setTags("标签1,标签2");
		    //视频自定义封面URL
		   // request.setCoverURL("http://cover.sample.com/sample.jpg");
		    //设置上传完成后的回调URL
		    //request.setCallback("http://callback.sample.com");
		    //可指定分片上传时每个分片的大小，默认为10M字节
		    request.setPartSize(10 * 1024 * 1024L);
		    //可指定分片上传时的并发线程数，默认为1 (注: 该配置会占用服务器CPU资源，需根据服务器情况指定）
		    request.setTaskNum(1);
		    request.setDescription("视频描述");
		    //设置是否使用水印
		   // request.setIsShowWaterMark(true);
		    try {
		      UploadVideoImpl uploader = new UploadVideoImpl();
		      UploadVideoResponse response = uploader.uploadVideo(request);
		      //上传成功后返回视频ID
		      System.out.print(response.getVideoId());
		    } catch (Exception e) {
		      System.out.println("UploadVideoRequest Server Exception:");
		      e.printStackTrace();
		    }
	 }
//	 String videoId = createUploadVideo(aliyunClient);
//	  System.out.println("VideoId:" + videoId);
//	  //当网络异常导致文件上传失败时,可刷新上传凭证后再次执行上传操作
//	  refreshUploadVideo(aliyunClient, videoId);

}
