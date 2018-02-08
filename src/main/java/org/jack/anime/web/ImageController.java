/**
 * 
 */
package org.jack.anime.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jack
 *
 */
@Controller
public class ImageController {

	// 登录跳转
	@RequestMapping(value = "/anime/image", method = { RequestMethod.GET })
	public String login() {
		System.out.println("BBB");
		return "admin/image";
	}

}
