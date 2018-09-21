package com.jade.uitil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import com.aliyun.oss.model.ObjectMetadata;
import com.jade.po.Result;

/**
 * 阿里云图片工具类
 * @author weidoukeji
 *
 */
public class ImageUtil {
	
	private static  String bucketName;
	
	private static  String endpoint;
	
	private static  String accessKeyId;
	
	private static  String accessKeySecret;
	
	// 应用启动时，自动加载与发送信息相关的配置文件aliyunoos.properties，并初始化相关参数
	static {
		Properties pro = new Properties();
		InputStream input = ImageUtil.class.getClassLoader().getResourceAsStream("conf/aliyunoos.properties");
		try {
			pro.load(new InputStreamReader(input, "UTF-8"));
			bucketName = pro.getProperty("bucketName");
			endpoint = pro.getProperty("endpoint");
			accessKeyId = pro.getProperty("accessKeyId");
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
	
	/**
	 * 定义时间：2017年06月12日
	 * 实现时间：2017年06月12日
	 * 编写者：shadow
	 * 根据图片的key值和有效时间（单位为毫秒），生成获取图片的url，单张图片
	 * @param key
	 * @param expires
	 * @return
	 */
	public static String getUrl(String key,long expires){
		if(expires <= 0){
			expires = 60 * 1000;
		}
		// 设置URL过期时间为1分钟
		Date expiration = new Date(new Date().getTime() + expires);

		OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		
		// 生成URL
		URL url = client.generatePresignedUrl(bucketName, key, expiration);
		
		client.shutdown();
		
		return url.toString();
		
	}
	
	public static List<String> getUrls(String key,long expires){
		if(expires <= 0){
			expires = 60 * 1000;
		}
		// 设置URL过期时间为1分钟
		Date expiration = new Date(new Date().getTime() + 600*10000);

		OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		String[] keys =  key.split(",");
		// 生成URL
		List<String> list = new ArrayList<String>();
		for(int i=0;i<keys.length;i++){
			if(!keys[i].equals("00000000")){
			URL url = client.generatePresignedUrl(bucketName, keys[i], expiration);
			list.add(url.toString());
			}
		}
		client.shutdown();
		return list;
	}
	
	/**
	 * 定义时间：2017年06月12日
	 * 实现时间：2017年06月12日
	 * 编写者：shadow
	 * 根据图片的keys值，和url有效时间（单位为毫秒），生成获取图片的url，多张图片
	 * @param keys
	 * @param expires
	 * @return
	 */
	public static List<Map<String,Object>> getUrlAndKey(String keys,long expires){
		if(expires <= 0){
			expires = 60 * 1000;
		}
		// 设置URL过期时间
		Date expiration = new Date(new Date().getTime() + expires);

		OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		String[] key =  keys.split(",");
		//循环生成图片url
		List<Map<String,Object>> imagesUrlMap = new ArrayList<Map<String,Object>>();
		for(String keyss : key){
			if(!keyss.equals("00000000")){
				URL url = client.generatePresignedUrl(bucketName, keyss, expiration);
				Map<String,Object> map = new HashMap<>();
				map.put("key", keyss);
				map.put("url", url.toString());
				imagesUrlMap.add(map);
			}
			
		}

		client.shutdown();

		return imagesUrlMap;
	}
	
	
	/**
	 * 上传本地文件到阿里云
	 * @param filePath
	 * @param key
	 * @return
	 */
	public static void loadFile(String filePath,String contentType,String key){
		ObjectMetadata meta = new ObjectMetadata();
		meta.setContentType(contentType);
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 上传文件
		ossClient.putObject(bucketName, key, new File(filePath),meta);
		
		ossClient.shutdown();
		
	}
	
	/**
	 * 上传文件到阿里云
	 * @param file
	 * @param contentType
	 * @param key
	 */
	public static void uploadFile(InputStream file,String contentType,String key){
		ObjectMetadata meta = new ObjectMetadata();
		
		meta.setContentType(contentType);
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 上传文件
		ossClient.putObject(bucketName, key, file,meta);
		
		ossClient.shutdown();
		
	}
	
	/**
	 * 删除阿里云上的文件
	 * @param key
	 */
	public static void deleteFile(String key){
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 删除Object
		ossClient.deleteObject(bucketName, key);
		// 关闭client
		ossClient.shutdown();
	}
	
	
	
	/**
	 * 批量删除
	 * @param images
	 */
	public static void deleteFilesByKeys(List<String> keys){
		if(keys == null){
			return ;
		}
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(
				new DeleteObjectsRequest(bucketName).withKeys(keys));
		deleteObjectsResult.getDeletedObjects();
		// 关闭client
		ossClient.shutdown();
	}
	
	public String uploadImage(String module,InputStream inputStream) throws Exception{
		String key = createImageKey(module);
		ImageUtil.uploadFile(inputStream, "image/jpeg", key);
		return key;//返回Key值
	}
	
	private String createImageKey(String module){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = format.format(new Date());
		return  module + "/" + str ;
	}
	
	public Result deleteImage(String key) throws Exception{
		//删除阿里云上的图片
		ImageUtil.deleteFile(key);
		Result result = new Result();
		result.setSuccess(true);
		return result;
	}
	
}
