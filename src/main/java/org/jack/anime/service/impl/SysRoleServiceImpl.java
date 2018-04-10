package org.jack.anime.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.beanutils.BeanUtils;
import org.jack.anime.common.dataMapping.AutoMapper;
import org.jack.anime.dao.AnimePermissionMapper;
import org.jack.anime.dao.AnimeRoleMapper;
import org.jack.anime.entity.AnimeRole;
import org.jack.anime.entity.AnimeUser;
import org.jack.anime.entity.PageResult;
import org.jack.anime.service.api.SysRoleService;
import org.jack.anime.service.vo.animeRole.AnimeRoleDto;
import org.jack.anime.service.vo.animeRole.AnimeRoleVo;
import org.jack.anime.service.vo.animeUser.AnimeUserDto;
import org.jack.anime.service.vo.animeUser.AnimeUserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("sysRoleServiceImpl")
public class SysRoleServiceImpl implements SysRoleService {

	private static final Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);

	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Resource(name = "animeRoleMapper")
	private AnimeRoleMapper animeRoleMapper;
	
	@Override
	public Integer countRole() {
		Integer result = (Integer) animeRoleMapper.totalItem();
		return result;
	}

	@Override
	public Integer save(AnimeRoleDto dto) {
		Set<ConstraintViolation<AnimeRoleDto>> set = this.validator.validate(dto, AnimeRoleDto.Save.class);
		for (ConstraintViolation<AnimeRoleDto> error : set) {
			throw new RuntimeException(error.getMessage());
		}
		Map<String, Object> map =new HashMap<String, Object>();
		Integer result = null;
		if(dto == null){
			logger.error("save:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		return null;
	}

	@Override
	public Boolean modify(AnimeRoleDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnimeRoleVo getById(Integer id) {
		AnimeRoleVo vo = null;
		if (id == null) {
			return null;
		}
		AnimeRole po = animeRoleMapper.selectByPrimaryKey(id);
		if (po == null) {
			return null;
		}
		try {
			vo = AnimeRoleVo.class.newInstance();
			BeanUtils.copyProperties(vo, po);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public Boolean delete(Integer id) {
		if(id == null)
			return Boolean.FALSE;
		AnimeRole po = animeRoleMapper.selectByPrimaryKey(id);
		if (po == null) {
			logger.error("delete:数据未持久化");
			throw new RuntimeException("数据未持久化");
		}
		animeRoleMapper.deleteByPrimaryKey(id);
		return Boolean.TRUE;
	}

	@Override
	public PageResult<AnimeRoleVo> getListpager(Map<String, Object> params, Integer startRow, Integer pageSize) {
		startRow = startRow == null ? 1 : startRow;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(startRow, pageSize);

		List<AnimeRole> list = animeRoleMapper.getListpager(params);

		PageInfo<AnimeRole> pageInfo = new PageInfo<>(list);
		
		List<AnimeRoleVo> result = new ArrayList<AnimeRoleVo>();
		if (list != null && list.size() > 0) {
			for (AnimeRole po : list) {
				try {
					AnimeRoleVo vo = AnimeRoleVo.class.newInstance();
					AutoMapper.mapping(po, vo);
					result.add(vo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		PageResult<AnimeRoleVo> pageResult = new PageResult<AnimeRoleVo>(); 
		pageResult.setPageNo(pageInfo.getPageNum());  
		pageResult.setPageSize(pageInfo.getPageSize());  
		pageResult.setDataList(result);  
		pageResult.setTotal(pageInfo.getTotal());  
		pageResult.setPages(pageInfo.getPages());  
		return pageResult;
	}

}
