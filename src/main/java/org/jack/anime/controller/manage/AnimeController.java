/**
 * 
 */
package org.jack.anime.controller.manage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.jack.anime.entity.PageResult;
import org.jack.anime.service.api.AnimeTimetableService;
import org.jack.anime.service.vo.animeTimetable.AnimeTimetableDto;
import org.jack.anime.service.vo.animeTimetable.AnimeTimetableVo;
import org.jack.anime.service.vo.animeTimetable.Result;
import org.jack.anime.utils.tool.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jack
 *
 */
@Controller
@RequestMapping("/admin")
public class AnimeController extends BaseController{
	
	@Resource(name="animeTimetableServiceImpl")
	private AnimeTimetableService animeTimetableServiceimpl;
	
/*	@RequestMapping(value = "/anime/schedule/list", method = { RequestMethod.GET })
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
	}*/
	
	@RequestMapping(value="/animeSchedule", method = { RequestMethod.GET })
    public String adminPath(HttpServletRequest request) throws Exception {
		return "admin/animeSchedule";
	}
	
	
	@RequestMapping(value = "/anime/schedule/list", method = { RequestMethod.GET })
	@ResponseBody
	public PageUtil<AnimeTimetableVo> animeScheduleList(HttpServletRequest request) {
		PageUtil<AnimeTimetableVo> pageUtil = new PageUtil<AnimeTimetableVo>();
		try {
			String page = request.getParameter("pageNumber");
			String limit = request.getParameter("limit");
			System.out.println(page);
			Integer pagenum;
	        if (StringUtils.isEmpty(page)) {
	            pagenum = 1;
	        } else {
	            pagenum = Integer.parseInt(page);
	        }
			PageResult<AnimeTimetableVo> pageResult = animeTimetableServiceimpl.getListpager(null, pagenum, Integer.parseInt(limit));
			pageUtil.setMsg("返回成功");
			pageUtil.setCode(0);
			pageUtil.setCount(pageResult.getTotal());
			pageUtil.setData(pageResult.getDataList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageUtil;
	}
	
	@RequestMapping(value = "/anime/schedule/del", method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
	@ResponseBody
	public Result<String> deleteAnimeSchedule(Integer id){
		try {
			if(id == null){
				return new Result<>(false, "id不能为空!");
			}
			animeTimetableServiceimpl.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<>(false, e.getMessage());
		}
		return new Result<>(true, "删除成功!");
	}
	
	@RequestMapping(value = "/anime/schedule/add", method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
	@ResponseBody
	public Result<String> addAnimeSchedule(AnimeTimetableDto dto){
		try {
			Integer ret = null;
			if (dto == null) {
				return new Result<>(false, "参数为空!");
			}
			ret = animeTimetableServiceimpl.save(dto);
			if(ret == null){
				return new Result<>(false, "添加失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<>(false, e.getMessage());
		}
		return new Result<>(true, "保存成功!");
	}
	
	@RequestMapping(value = "/anime/schedule/modify", method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
	@ResponseBody
	public Result<String> modifyAnimeSchedule(AnimeTimetableDto dto){
		try {
			Boolean ret = null;
			if (dto == null) {
				return new Result<>(false, "参数为空!");
			}
			if(dto.getId() == null){
				return new Result<>(false, "id不能为空!");
			}
			ret = animeTimetableServiceimpl.modify(dto);
			if(!ret){
				return new Result<>(false, "修改失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<>(false, e.getMessage());
		}
		return new Result<>(true, "保存成功!");
	}
}
