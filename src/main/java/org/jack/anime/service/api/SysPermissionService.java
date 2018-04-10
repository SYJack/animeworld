package org.jack.anime.service.api;

import java.util.Map;

import org.jack.anime.entity.PageResult;
import org.jack.anime.service.vo.animePermission.AnimePermissionDto;
import org.jack.anime.service.vo.animePermission.AnimePermissionVo;

public interface SysPermissionService {

	/**
	 * 获取权限总数
	 * @return
	 */
	public Integer countPermission();
	/**
	 * 保存权限
	 * @param dto
	 * @return
	 */
	public Integer save(AnimePermissionDto dto);
	/**
	 * 修改权限信息
	 * @param dto
	 * @return
	 */
	public Boolean modify(AnimePermissionDto dto);
	
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	public AnimePermissionVo getById(Integer id);
	
	
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
	public PageResult<AnimePermissionVo> getListpager(Map<String, Object> params,Integer startRow, Integer pageSize);
}
