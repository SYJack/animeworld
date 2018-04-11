/**
 * 
 */
package animeworld;

import javax.annotation.Resource;

import org.jack.anime.service.api.SysManagerService;
import org.jack.anime.service.api.SysPermissionService;
import org.jack.anime.service.api.SysRoleService;
import org.jack.anime.service.api.SysUserService;
import org.jack.anime.service.vo.animeManager.AnimeManagerDto;
import org.jack.anime.service.vo.animePermission.AnimePermissionDto;
import org.jack.anime.service.vo.animeRole.AnimeRoleDto;
import org.junit.Test;

/**
 * @author Administrator
 *
 */
public class ServiceTest extends BaseTest {

	@Resource(name="sysUserServiceImpl")
	private SysUserService sysUserServiceImpl;
	
	@Resource(name="sysManagerServiceImpl")
	private SysManagerService sysManagerServiceImpl;
	
	@Resource(name="sysRoleServiceImpl")
	private SysRoleService sysRoleServiceImpl;
	
	@Resource(name="sysPermissionServiceImpl")
	private SysPermissionService sysPermissionServiceImpl;
	@Test
	public void test(){
		/*Integer count = animeTimetableServiceImpl.countAnime();
		System.out.println(count);*/
		
		/*Map<String, Object> map = new HashMap<String, Object>();  
        map.put("status", 1);  
		PageResult<AnimeUserVo> page = sysUserServiceImpl.getListpager(map, 1, 10);
		List<AnimeUserVo> vl= page.getDataList();
		for (AnimeUserVo vo : vl) {
			System.out.println(vo.toString());
		}*/
//		AnimeTimetableVo vo = animeTimetableServiceImpl.getById(1);
//		System.out.println(vo);
		
		/*AnimeUserDto dto = new AnimeUserDto();
		dto.setEmail("1101939661@qq.com");
		dto.setGender(Short.valueOf("1"));
		dto.setLoginname("神田空太");
		dto.setMobile("18300197593");
		dto.setStatus(Short.valueOf("0"));
		dto.setPasswd("123456");
		sysUserServiceImpl.save(dto);*/
		
		/*AnimePermissionDto dto = new AnimePermissionDto();
		dto.setName("番剧管理-日志查看");
		dto.setStatus(Short.valueOf("1"));
		dto.setCode("COMICJOURANL:LIST");
		dto.setUrl("/admin/animeSchedule");
		sysPermissionServiceImpl.save(dto);*/
		
	/*	AnimeRoleDto dto =new AnimeRoleDto();
		dto.setName("manager");
		dto.setDescription("系统管理员");
		dto.setPermissionId("|1||2|");
		sysRoleServiceImpl.save(dto);
		*/
		
		/*AnimeRoleDto dto =new AnimeRoleDto();
		dto.setName("tourist");
		dto.setDescription("游客");
		dto.setPermissionId("|2|");
		sysRoleServiceImpl.save(dto);*/
		
		AnimeManagerDto dto =new AnimeManagerDto();
		dto.setRoleId(Integer.valueOf("2"));
		dto.setCustomerId(Integer.valueOf("5"));
		dto.setStatus(Short.valueOf("1"));
		sysManagerServiceImpl.save(dto);
	}
}
