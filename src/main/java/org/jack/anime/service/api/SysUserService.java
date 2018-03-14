/**
 * 
 */
package org.jack.anime.service.api;

import java.util.Map;

import org.jack.anime.entity.PageResult;
import org.jack.anime.service.vo.animeUser.AnimeUserDto;
import org.jack.anime.service.vo.animeUser.AnimeUserVo;

/**
 * @author jack
 *
 */
public interface SysUserService {

	/**
	 * 获取用户总数
	 * @return
	 */
	public Integer countAnime();
	/**
	 * 保存用户
	 * @param dto
	 * @return
	 */
	public Integer save(AnimeUserDto dto);
	/**
	 * 修改用户信息
	 * @param dto
	 * @return
	 */
	public Boolean modify(AnimeUserDto dto);
	
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	public AnimeUserVo getById(Integer id);
	
	
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
	public PageResult<AnimeUserVo> getListpager(Map<String, Object> params,Integer startRow, Integer pageSize);
}
