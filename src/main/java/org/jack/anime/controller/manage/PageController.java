/**
 * 
 */
package org.jack.anime.controller.manage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jack
 *
 */
@Controller
public class PageController {
	@RequestMapping("{path}")
	public String pathJump(@PathVariable("path") String path) {
		return path;
	}
	
	@RequestMapping("/admin/{page}")
   public String adminPath(@PathVariable("page")String page,HttpServletRequest request) throws Exception {
		return "admin/"+page;
   }
}
