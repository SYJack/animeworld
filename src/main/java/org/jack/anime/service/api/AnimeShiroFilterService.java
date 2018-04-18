package org.jack.anime.service.api;

import java.util.Map;

import org.jack.anime.entity.PageResult;
import org.jack.anime.service.vo.animeShiroFilter.AnimeShiroFilterDto;
import org.jack.anime.service.vo.animeShiroFilter.AnimeShiroFilterVo;

public interface AnimeShiroFilterService {
	/**
	 * 获取用户总数
	 * @return
	 */
	public Integer countFilter();
	/**
	 * 保存权限配置
	 * @param dto
	 * @return
	 */
	public Integer save(AnimeShiroFilterDto dto);
	/**
	 * 修改权限配置
	 * @param dto
	 * @return
	 */
	public Boolean modify(AnimeShiroFilterDto dto);
	
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	public AnimeShiroFilterVo getById(Integer id);
	
	
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
	public PageResult<AnimeShiroFilterVo> getListpager(Map<String, Object> params,Integer startRow, Integer pageSize);
}
