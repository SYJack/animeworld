/**
 * 
 */
package org.jack.anime.controller.manage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jack.anime.service.api.AnimeTimetableService;
import org.jack.anime.service.vo.animeTimetable.AnimeTimetableVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
 * @author jack
 *
 */
@Controller
public class AnimeController extends BaseController{
	
	@Resource(name="animeTimetableServiceImpl")
	private AnimeTimetableService animeTimetableServiceimpl;
	
	@RequestMapping(value = "/anime/schedule/list", method = { RequestMethod.GET })
	@ResponseBody
	public ModelAndView animeScheduleList(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			PageInfo<AnimeTimetableVo> page = animeTimetableServiceimpl.getListpager(null, 1, 10);
			modelAndView.addObject("success", true);
			modelAndView.addObject("pageNum", page.getPageNum());
			modelAndView.addObject("totalpages", page.getPages());
			modelAndView.addObject("scheduleList", page.getList());
			modelAndView.setViewName("admin/animeSchedule");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
}
