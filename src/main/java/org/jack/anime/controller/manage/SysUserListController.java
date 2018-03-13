package org.jack.anime.controller.manage;

import javax.annotation.Resource;

import org.jack.anime.service.api.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class SysUserListController extends BaseController {
	
	@Resource(name="sysUserServiceImpl")
	private SysUserService sysUserServiceImpl;
}
