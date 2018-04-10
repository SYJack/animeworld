/**
 * 
 */
package org.jack.anime.service.api;

import java.util.Map;

import org.jack.anime.entity.PageResult;
import org.jack.anime.service.vo.animeRole.AnimeRoleDto;
import org.jack.anime.service.vo.animeRole.AnimeRoleVo;

/**
 * @author jack
 *
 */
public interface SysRoleService {

	/**
	 * 获取角色总数
	 * @return
	 */
	public Integer countRole();
	/**
	 * 保存角色
	 * @param dto
	 * @return
	 */
	public Integer save(AnimeRoleDto dto);
	/**
	 * 修改角色信息
	 * @param dto
	 * @return
	 */
	public Boolean modify(AnimeRoleDto dto);
	
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	public AnimeRoleVo getById(Integer id);
	
	
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
	public PageResult<AnimeRoleVo> getListpager(Map<String, Object> params,Integer startRow, Integer pageSize);
}
