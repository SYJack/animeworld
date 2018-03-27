/**
 * 
 */
package animeworld;

import javax.annotation.Resource;

import org.jack.anime.service.api.SysUserService;
import org.jack.anime.service.vo.animeUser.AnimeUserDto;
import org.junit.Test;

/**
 * @author Administrator
 *
 */
public class ServiceTest extends BaseTest {

	@Resource(name="sysUserServiceImpl")
	private SysUserService sysUserServiceImpl;
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
		
		AnimeUserDto dto = new AnimeUserDto();
		dto.setEmail("1101939669");
		dto.setGender(Short.valueOf("1"));
		dto.setLoginname("jack");
		dto.setMobile("1830019759");
		dto.setStatus(Short.valueOf("1"));
		sysUserServiceImpl.save(dto);
		
	}
}
