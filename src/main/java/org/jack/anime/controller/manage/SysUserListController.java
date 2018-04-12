package org.jack.anime.controller.manage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jack.anime.entity.PageResult;
import org.jack.anime.service.api.SysUserService;
import org.jack.anime.service.vo.Result;
import org.jack.anime.service.vo.animeUser.AnimeUserDto;
import org.jack.anime.service.vo.animeUser.AnimeUserVo;
import org.jack.anime.utils.tool.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Result<String> deleteAnimeUser(Integer id){
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
	
	@GetMapping("/sysuser/modify")
	public String sysUserEdit(Integer id,Model model){
		AnimeUserVo	vo = sysUserServiceImpl.getById(id);
		model.addAttribute("currentUser",vo);
		return "admin/sysUserEdit";
	}
	
	@RequestMapping(value = "/sysuser/modify", method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
	@ResponseBody
	public Result<String> sysUserEdit(@RequestBody AnimeUserDto dto){
		try {
			Boolean ret = null;
			if (dto == null) {
				return new Result<>(false, "参数为空!");
			}
			if(dto.getId() == null){
				return new Result<>(false, "id不能为空!");
			}
			ret = sysUserServiceImpl.modify(dto);
			if(!ret){
				return new Result<>(false, "修改失败!");
			}
			return new Result<>(true, "保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<>(false, e.getMessage());
		}
	}
	
	@GetMapping("/sysuser/add")
	public String sysUserAdd(Integer id,Model model){
		AnimeUserVo	vo = sysUserServiceImpl.getById(id);
		model.addAttribute("currentUser",vo);
		return "admin/sysUserAdd";
	}
	
	@RequestMapping(value = "/sysuser/add", method = RequestMethod.POST, produces = {"application/json; charset=utf-8" })
	@ResponseBody
	public Result<String> sysUserAdd(@RequestBody AnimeUserDto dto){
		try {
			Integer ret = null;
			if (dto == null) {
				return new Result<>(false, "参数为空!");
			}
			ret = sysUserServiceImpl.save(dto);
			if(ret == null){
				return new Result<>(false, "添加失败!");
			}
			return new Result<>(true, "保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result<>(false, e.getMessage());
		}
	}
}
