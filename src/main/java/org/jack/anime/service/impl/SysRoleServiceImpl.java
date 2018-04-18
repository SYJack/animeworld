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
import org.jack.anime.dao.RolePermMapper;
import org.jack.anime.entity.AnimeRole;
import org.jack.anime.entity.PageResult;
import org.jack.anime.entity.RolePerm;
import org.jack.anime.service.api.SysRoleService;
import org.jack.anime.service.vo.animeRole.AnimeRoleDto;
import org.jack.anime.service.vo.animeRole.AnimeRoleVo;
import org.jack.anime.service.vo.rolePerm.RolePermDto;
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
	
	@Resource(name = "animePermissionMapper")
	private AnimePermissionMapper animePermissionMapper;
	
	@Resource(name = "rolePermMapper")
	private RolePermMapper rolePermMapper;
	
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
		Integer result = null;
		if(dto == null){
			logger.error("save:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		if(this.getRoleByRoleName(dto.getName())!=null){
			logger.error("save:该角色名已存在");
			throw new RuntimeException("该角色名已存在");
		}
		try {
			AnimeRole po = AnimeRole.class.newInstance();
			AutoMapper.mapping(dto,po);
			if(animeRoleMapper.insertSelective(po)!=1){
				logger.error("save:添加角色失败");
	            throw new RuntimeException("添加角色失败");
	        }
			if(dto.getList()!=null && dto.getList().size()>0){
				AnimeRoleVo vo = this.getRoleByRoleName(po.getName());
				for(int i=0;i<dto.getList().size();i++){
					Set<ConstraintViolation<RolePermDto>> rolePermSet = this.validator.validate(dto.getList().get(i), RolePermDto.Save.class);
					for (ConstraintViolation<RolePermDto> error : rolePermSet) {
						throw new RuntimeException(error.getMessage());
					}
					RolePerm rolePerm = RolePerm.class.newInstance();
					rolePerm.setRoleId(vo.getId());
					rolePerm.setPermissionId(dto.getList().get(i).getPermissionId());
					if(rolePermMapper.insertSelective(rolePerm)!=1){
	                    throw new RuntimeException("添加角色-权限失败");
	                }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return result;
	}

	@Override
	public Boolean modify(AnimeRoleDto dto) {
		Set<ConstraintViolation<AnimeRoleDto>> set = this.validator.validate(dto, AnimeRoleDto.Save.class);
		for (ConstraintViolation<AnimeRoleDto> error : set) {
			throw new RuntimeException(error.getMessage());
		}
		if(dto == null){
			logger.error("modify:参数对象为空");
			throw new RuntimeException("参数对象为空");
		}
		
		AnimeRoleVo vo = this.getById(dto.getId());
		if(vo == null){
			logger.error("modify:管理员信息未持久化");
			throw new RuntimeException("管理员信息未持久化");
		}
		if(this.getRoleByRoleName(dto.getName())!=null){
			logger.error("save:该角色名已存在");
			throw new RuntimeException("该角色名已存在");
		}
		
		try {
			AnimeRole po = AnimeRole.class.newInstance();
			AutoMapper.mapping(dto,po);
			if(animeRoleMapper.updateByPrimaryKeySelective(po)!=1){
				logger.error("modify:修改角色失败");
	            throw new RuntimeException("修改角色失败");
	        }
			if(dto.getList()!=null){
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("roleId", dto.getId());
				List<RolePerm> resultLs = this.rolePermMapper.getListpager(params);
				if(resultLs!=null){
					for (RolePerm rolePerm : resultLs) {
						if (this.rolePermMapper.deleteByPrimaryKey(rolePerm.getId()) != 1) {
	        	            throw new RuntimeException("删除角色权限失败");
	                    }
					}
				}
				for(int i=0;i<dto.getList().size();i++){
					RolePerm rolePerm = RolePerm.class.newInstance();
					rolePerm.setRoleId(dto.getId());
					rolePerm.setPermissionId(dto.getList().get(i).getPermissionId());
					if(rolePermMapper.insertSelective(rolePerm)!=1){
	                    throw new RuntimeException("添加角色-权限失败");
	                }
				}
			}else{
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("roleId", dto.getId());
				List<RolePerm> resultLs = this.rolePermMapper.getListpager(params);
				if(resultLs!=null){
					for (RolePerm rolePerm : resultLs) {
						if (this.rolePermMapper.deleteByPrimaryKey(rolePerm.getId()) != 1) {
	        	            throw new RuntimeException("删除角色权限失败");
	                    }
					}
				}
			}
			return Boolean.TRUE;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
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
		if(animeRoleMapper.deleteByPrimaryKey(id)!=1){
			throw new RuntimeException("delete:数据删除失败!");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleId", id);
		List<RolePerm> resultLs = this.rolePermMapper.getListpager(params);
		if(resultLs!=null){
			for (RolePerm rolePerm : resultLs) {
				if (this.rolePermMapper.deleteByPrimaryKey(rolePerm.getId()) != 1) {
    	            throw new RuntimeException("delete:删除角色权限失败");
                }
			}
		}
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

	@Override
	public AnimeRoleVo getRoleByRoleName(String roleName) {
		AnimeRoleVo vo = null;
		if(roleName == null){
			logger.error("角色名称为空");
			throw new RuntimeException("角色名称为空");
		}
		AnimeRole po = animeRoleMapper.getRoleByRoleName(roleName);
		if (po == null) {
			logger.error("数据未持久化");
			throw new RuntimeException("数据未持久化");
		}
		try {
			vo = AnimeRoleVo.class.newInstance();
			BeanUtils.copyProperties(vo, po);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
}
