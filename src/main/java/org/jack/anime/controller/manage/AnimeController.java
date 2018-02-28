/**
 * 
 */
package org.jack.anime.controller.manage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.jack.anime.entity.PageResult;
import org.jack.anime.service.api.AnimeTimetableService;
import org.jack.anime.service.vo.animeTimetable.AnimeTimetableVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
			
			String page = request.getParameter("pagenum");
			Integer pagenum;
	        if (StringUtils.isEmpty(page)) {
	            pagenum = 1;
	        } else {
	            pagenum = Integer.parseInt(page);
	        }
			PageResult<AnimeTimetableVo> pageResult = animeTimetableServiceimpl.getListpager(null, pagenum, 10);
			
			Integer startpage, endpage;
	        if (pageResult.getPages() < 6) {
	            startpage = 1;
	            endpage = pageResult.getPages();
	        } else {
	            if (pagenum > 3) {
	                startpage = pageResult.getPageNo() - 3;
	                endpage = pageResult.getPageNo() + 3 > pageResult.getPages() ? pageResult.getPages() : pagenum + 3;
	            } else {
	                startpage = 1;
	                endpage = pageResult.getPageNo() + 4 > pageResult.getPages() ? pageResult.getPages() : pagenum + 4;
	            }
	        }
			modelAndView.addObject("success", true);
			modelAndView.addObject("startpage", startpage);
	        modelAndView.addObject("endpage", endpage);
			modelAndView.addObject("pageNum", pageResult.getPageNo());
			modelAndView.addObject("totalpages", pageResult.getPages());
			modelAndView.addObject("scheduleList", pageResult.getDataList());
			modelAndView.setViewName("admin/animeSchedule");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	public ModelAndView deleteAnimeSchedule(HttpServletRequest request){
		try {
			String id = request.getParameter("animeId");
		} catch (Exception e) {
		}
		return null;
	}
}
