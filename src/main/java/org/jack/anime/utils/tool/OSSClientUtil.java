/**
 * 
 */
package org.jack.anime.utils.tool;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;





import org.apache.commons.lang.StringUtils;
import org.jack.anime.utils.constant.FileDirectory;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;


/**
 * @author jack
 *
 */
public class OSSClientUtil {
	
	private static String accessKeyId = PropertyReader.getProperty("aliyun.oss.accessKeyId");
	private static String accessKeySecret = PropertyReader.getProperty("aliyun.oss.accessKeySecret");
	private static String endpoint = PropertyReader.getProperty("aliyun.oss.endpoint");
	private static String bucketName = PropertyReader.getProperty("aliyun.oss.bucketName");
	private static String ossDomain = PropertyReader.getProperty("aliyun.oss.ossDomain");
	
	public static String putObject(FileDirectory directory,InputStream content, String fileName){
		String key = fileName;
		String ret = "";
		try {
			OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
			ObjectMetadata meta = new ObjectMetadata();// 创建上传Object的Metadata
			meta.setContentLength((long)content.available());// 必须设置ContentLength
			if(StringUtils.isEmpty(fileName)){
				throw new RuntimeException("输入流文件名不能为空");
			}
			key = DateUtil.format(new Date(), "yyyy/MM/dd") + "/" + System.currentTimeMillis() + (fileName.lastIndexOf(".")>=0?fileName.substring(fileName.lastIndexOf(".")):"");
			PutObjectResult result = client.putObject(bucketName, directory+"/"+key, content, meta);// 上传Object
			ret = getImgUrl(result.getETag(),directory+"/"+key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if (null != content) {
					content.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(StringUtils.isEmpty(key)){
			return null;
		}
	    return ret;
	}
	 public static String getImgUrl(String fileUrl,String key) {
	    if (!StringUtils.isEmpty(fileUrl)) {
	      return getUrl(key);
	    }
	    return null;
	  }
	 
	 /**
	   * 获得url链接
	   *
	   * @param key
	   * @return
	   */
	  public static String getUrl(String key) {
	    // 设置URL过期时间为10年  3600l* 1000*24*365*10
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	    Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
	    // 生成URL
	    URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
	    if (url != null) {
	      return url.toString();
	    }
	    return null;
	  }
}
