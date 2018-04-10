/**
 * 
 */
package org.jack.anime.service.api;

import java.util.Map;

import org.jack.anime.entity.PageResult;
import org.jack.anime.service.vo.animeManager.AnimeManagerDto;
import org.jack.anime.service.vo.animeManager.AnimeManagerVo;

/**
 * @author jack
 *
 */
public interface SysManagerService {

	/**
	 * 获取管理员总数
	 * @return
	 */
	public Integer countManager();
	/**
	 * 保存管理员
	 * @param dto
	 * @return
	 */
	public Integer save(AnimeManagerDto dto);
	/**
	 * 修改管理员信息
	 * @param dto
	 * @return
	 */
	public Boolean modify(AnimeManagerDto dto);
	
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	public AnimeManagerVo getById(Integer id);
	
	
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
	public PageResult<AnimeManagerVo> getListpager(Map<String, Object> params,Integer startRow, Integer pageSize);
}
