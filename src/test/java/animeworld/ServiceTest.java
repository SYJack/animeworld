/**
 * 
 */
package animeworld;

import java.util.List;

import javax.annotation.Resource;

import org.jack.anime.entity.PageResult;
import org.jack.anime.service.api.AnimeTimetableService;
import org.jack.anime.service.api.SysUserService;
import org.jack.anime.service.vo.animeTimetable.AnimeTimetableVo;
import org.jack.anime.service.vo.animeUser.AnimeUserVo;
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
		
		PageResult<AnimeUserVo> page = sysUserServiceImpl.getListpager(null, 1, 10);
		List<AnimeUserVo> vl= page.getDataList();
		for (AnimeUserVo vo : vl) {
			System.out.println(vo.toString());
		}
//		AnimeTimetableVo vo = animeTimetableServiceImpl.getById(1);
//		System.out.println(vo);
	}
}
