/**
 * 
 */
package org.jack.anime.service.api;

import java.util.Map;

import org.jack.anime.entity.PageResult;
import org.jack.anime.service.vo.animeTimetable.AnimeTimetableDto;
import org.jack.anime.service.vo.animeTimetable.AnimeTimetableVo;

import com.github.pagehelper.PageInfo;

/**
 * @author jack
 *
 */
public interface AnimeTimetableService {

	/**
	 * 获取番剧总数
	 * @return
	 */
	public Integer countAnime();
	/**
	 * 保存番剧时间表
	 * @param dto
	 * @return
	 */
	public Integer save(AnimeTimetableDto dto);
	/**
	 * 修改番剧时间表
	 * @param dto
	 * @return
	 */
	public Boolean modify(AnimeTimetableDto dto);
	
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	public AnimeTimetableVo getById(Integer id);
	
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public Boolean delete(Integer id);
	
	
	/**
	 * @param startRow 页数
	 * @param pageSize 每页的条数
	 * @return
	 */
	public PageResult<AnimeTimetableVo> getListpager(Map<String, Object> params,Integer startRow, Integer pageSize);

}
