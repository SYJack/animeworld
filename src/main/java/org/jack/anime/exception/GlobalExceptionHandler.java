/**
 * 
 */
package org.jack.anime.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.jack.anime.utils.tool.RestResponse;
import org.jack.anime.utils.tool.ToolUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jack
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UnauthorizedException.class)
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response,
			UnauthorizedException unauthorizedException) {
		if (ToolUtil.isAjax(request)) {
			try {
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter writer = response.getWriter();
				RestResponse failResponse = RestResponse.failure("您无此权限,请联系管理员!");
				writer.write(JSONObject.toJSONString(failResponse));
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			RestResponse restResponse = RestResponse.failure(unauthorizedException.getMessage());
			return new ModelAndView("admin/error/500", restResponse);
		}

		return null;
	}
}
