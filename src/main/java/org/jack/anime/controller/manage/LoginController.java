/**
 * 
 */
package org.jack.anime.controller.manage;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jack.anime.utils.tool.VerifyCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jack
 *
 */
@Controller
public class LoginController extends BaseController {

	@GetMapping("login")
	public String login(HttpServletRequest request) {
		super.logger.info("跳到这边的路径为:"+request.getRequestURI());
		return "admin/login";
	}
	
	/**
	 * 获取验证码图片和文本(验证码文本会保存在HttpSession中)
	 */
	@GetMapping("/admin/getCaptcha")
	public void genCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置页面不缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_ALL_MIXED, 4, null);
		//将验证码放到HttpSession里面
		request.getSession().setAttribute("validateCode", verifyCode);
		super.logger.info("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");
		//设置输出的内容的类型为JPEG图像
		response.setContentType("image/jpeg");
		BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 116, 36, 5, true, new Color(249,205,173), null, null);
		//写给浏览器
		ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
	}
}
