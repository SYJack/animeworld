/**
 * 
 */
package org.jack.anime.controller.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;










import org.apache.commons.lang.StringUtils;
import org.jack.anime.service.vo.animeTimetable.Result;
import org.jack.anime.utils.constant.FileDirectory;
import org.jack.anime.utils.tool.DateUtil;
import org.jack.anime.utils.tool.OSSClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author jack
 *
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {
	
	@RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> uploadPic(@RequestParam(value="photo",required=false) MultipartFile file,HttpServletRequest request){
		
		String directory = request.getParameter("directory");
		String fileName = null;
		String ret = null;
		Map<String, String> map = new HashMap<String, String>(); 
		try {
			if(file == null){
				return new Result<>(false, "上传图片为空!");
			}
			// 定义允许上传的文件扩展名
			if (file.getContentType().indexOf("image")<0) {
				return new Result<>(false, "文件上传不合法!");
			}
			
			FileDirectory fd = null;
			String fdString = "";
			if(!StringUtils.isEmpty(directory)){
				if("COVER".equals(directory)){
					fd = FileDirectory.COVER;
					fdString = fd.toString();
				}else if("PORTRAIT".equals(directory)){
					fd = FileDirectory.PORTRAIT;
					fdString = fd.toString();
				}else{
					fd = FileDirectory.PORTRAIT;
					fdString = fd.toString();
				}
			}else{
				fd = FileDirectory.PORTRAIT;
			}
			
			fileName = DateUtil.format(new Date(), "yyyy/MM/dd") + "/" + System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			
			ret = OSSClientUtil.putObject(fd,file.getInputStream(), new Random().nextInt(99999999)+"");
			map.put("url", ret);
			map.put("msg", "上传成功");
			System.out.println(ret);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<>(false, e.getMessage());
		}
		return new Result<>(true,ret);
	}

}
