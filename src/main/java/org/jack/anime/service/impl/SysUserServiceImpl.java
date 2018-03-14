package org.jack.anime.service.impl;

import java.util.Map;

import org.jack.anime.entity.PageResult;
import org.jack.anime.service.api.SysUserService;
import org.jack.anime.service.vo.animeUser.AnimeUserDto;
import org.jack.anime.service.vo.animeUser.AnimeUserVo;
import org.springframework.stereotype.Service;


@Service("sysUserServiceImpl")
public class SysUserServiceImpl implements SysUserService {

	@Override
	public Integer countAnime() {
		return null;
	}

	@Override
	public Integer save(AnimeUserDto dto) {
		return null;
	}

	@Override
	public Boolean modify(AnimeUserDto dto) {
		return null;
	}

	@Override
	public AnimeUserVo getById(Integer id) {
		return null;
	}

	@Override
	public Boolean delete(Integer id) {
		return null;
	}

	@Override
	public PageResult<AnimeUserVo> getListpager(Map<String, Object> params, Integer startRow, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
