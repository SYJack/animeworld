/**
 * 
 */
package org.jack.anime.controller.manage;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.jack.anime.service.vo.Result;
import org.jack.anime.utils.constant.Constants;
import org.jack.anime.utils.tool.VerifyCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jack
 *
 */
@Controller
@RequestMapping("/admin")
public class LoginController extends BaseController {

	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		super.logger.info("跳到这边的路径为:"+request.getRequestURI());
		return "/admin/login";
	}
	
	/**
	 * 获取验证码图片和文本(验证码文本会保存在HttpSession中)
	 */
	@GetMapping("/getCaptcha")
	public void genCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置页面不缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_ALL_MIXED, 4, null);
		//将验证码放到HttpSession里面
		request.getSession().setAttribute(Constants.VALIDATE_CODE, verifyCode);
		super.logger.info("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");
		//设置输出的内容的类型为JPEG图像
		response.setContentType("image/jpeg");
		BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 116, 36, 5, true, new Color(249,205,173), null, null);
		//写给浏览器
		ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
	}
	
	@PostMapping("/loginmain")
	@ResponseBody
	public Result<Map<String, Object>> loginMain(HttpServletRequest request) {
		
		Map<String,Object> map = new HashMap<>();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
		
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
			map.put("msg", "用户名或者密码不能为空");
			return new Result<Map<String,Object>>(false, map);
		}
		if(StringUtils.isEmpty(code)){
			map.put("msg", "验证码不能为空");
			return new Result<Map<String,Object>>(false, map);
		}
		HttpSession session = request.getSession();
		if(session == null){
			map.put("msg", "session超时");
			return new Result<Map<String,Object>>(false, map);
		}
		String trueCode =  (String)session.getAttribute(Constants.VALIDATE_CODE);
		if(StringUtils.isEmpty(trueCode)){
			map.put("msg", "验证码超时");
			return new Result<Map<String,Object>>(false, map);
		}
		if(StringUtils.isEmpty(code) || !trueCode.toLowerCase().equals(code.toLowerCase())){
			map.put("msg", "验证码错误");
			return new Result<Map<String,Object>>(false, map);
		}else{
			 //获取当前的Subject  
	        Subject currentUser = SecurityUtils.getSubject();
	      //测试当前用户是否已经被认证(即是否已经登录)  
	        if (!currentUser.isAuthenticated()) {  
	            //将用户名与密码封装为UsernamePasswordToken对象  
	            UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
	            token.setRememberMe(true);//记录用户  
	            try {  
	                currentUser.login(token);//调用Subject的login方法执行登录  
	            } catch (IncorrectCredentialsException e) {
	            	map.put("msg", "登录密码错误");
	            	return new Result<Map<String,Object>>(false, map);
	            }catch (ExcessiveAttemptsException e) {
	            	map.put("msg", "登录失败次数过多");
	            	return new Result<Map<String,Object>>(false, map);
	            }catch (LockedAccountException e) {
	            	map.put("msg", "帐号已被锁定");
	            	return new Result<Map<String,Object>>(false, map);
	            }catch (UnauthorizedException e) {
	            	map.put("msg", "您没有得到相应的授权！");
	            	return new Result<Map<String,Object>>(false, map);
	            } 
	        }  
		}
		map.put("msg", "登录成功");
		return new Result<Map<String,Object>>(true, map);
	}
	
	@GetMapping("/systemLogout")
	public String logout(){
		SecurityUtils.getSubject().logout();
		return "redirect:/admin/login";
	}
	
	@GetMapping("/index")
	public String showView(HttpServletRequest request){
		return "/admin/index";
	}
}
