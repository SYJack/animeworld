/**
 * 
 */
package org.jack.anime.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jack
 *
 */
@Controller
public class AnimeController {
	
	// 登录跳转
	@RequestMapping(value = "/anime/schedule/list", method = { RequestMethod.GET })
	public String animeScheduleList() {
		System.out.println("BBB");
		return "admin/image";
	}
}
