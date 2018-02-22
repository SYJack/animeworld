/**
 * 
 */
package animeworld;

import java.util.List;

import javax.annotation.Resource;

import org.jack.anime.service.api.AnimeTimetableService;
import org.jack.anime.service.vo.animeTimetable.AnimeTimetableVo;
import org.junit.Test;

import com.github.pagehelper.PageInfo;

/**
 * @author Administrator
 *
 */
public class ServiceTest extends BaseTest {

	@Resource(name="animeTimetableService")
	private AnimeTimetableService animeTimetableServiceImpl;
	@Test
	public void test(){
		/*Integer count = animeTimetableServiceImpl.countAnime();
		System.out.println(count);*/
		
		PageInfo<AnimeTimetableVo> page = animeTimetableServiceImpl.getListpager(null, 1, 10);
		List<AnimeTimetableVo> vl= page.getList();
		for (AnimeTimetableVo vo : vl) {
			System.out.println(vo.toString());
		}
//		AnimeTimetableVo vo = animeTimetableServiceImpl.getById(1);
//		System.out.println(vo);
	}
}
