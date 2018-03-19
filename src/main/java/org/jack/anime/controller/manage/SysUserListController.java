package org.jack.anime.controller.manage;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jack.anime.entity.PageResult;
import org.jack.anime.service.api.SysUserService;
import org.jack.anime.service.vo.Result;
import org.jack.anime.service.vo.animeUser.AnimeUserVo;
import org.jack.anime.utils.tool.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class SysUserListController extends BaseController {
	
	@Resource(name="sysUserServiceImpl")
	private SysUserService sysUserServiceImpl;
	
	@RequestMapping(value="/sysUserList", method = { RequestMethod.GET })
    public String sysUser(HttpServletRequest request) throws Exception {
		return "admin/sysUserList";
	}
	
	@RequestMapping(value = "/sysuser/list", method = { RequestMethod.GET })
	@ResponseBody
	public PageUtil<AnimeUserVo> getUserList(@RequestParam(value = "pageName",defaultValue = "1")Integer page,
           									@RequestParam(value = "limitName",defaultValue = "10")Integer limit,
           									HttpServletRequest request) {
		PageUtil<AnimeUserVo> pageUtil = new PageUtil<AnimeUserVo>();
		try {
		/*	String page = request.getParameter("pageNumber");
			String limit = request.getParameter("limit");
			System.out.println(page);
			Integer pagenum;
	        if (StringUtils.isEmpty(page)) {
	            pagenum = 1;
	        } else {
	            pagenum = Integer.parseInt(page);
	        }*/
			
			PageResult<AnimeUserVo> pageResult = sysUserServiceImpl.getListpager(null, page, limit);
			pageUtil.setMsg("返回成功");
			pageUtil.setCode(0);
			pageUtil.setCount(pageResult.getTotal());
			pageUtil.setData(pageResult.getDataList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageUtil;
	}
	
	@RequestMapping(value = "/sysuser/del", method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
	@ResponseBody
	public Result<String> deleteAnimeSchedule(Integer id){
		try {
			if(id == null){
				return new Result<>(false, "id不能为空!");
			}
			sysUserServiceImpl.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<>(false, e.getMessage());
		}
		return new Result<>(true, "删除成功!");
	}
	
	@GetMapping("/sysuser/edit")
	public String sysUserEdit(Integer id,Model model){
		if(id==null){
			
		}
		AnimeUserVo	vo = sysUserServiceImpl.getById(id);
		model.addAttribute("currentUser",vo);
		return "admin/sysUserEdit";
	}
}
