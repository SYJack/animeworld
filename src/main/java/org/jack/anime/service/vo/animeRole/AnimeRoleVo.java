package org.jack.anime.service.vo.animeRole;

import java.util.List;

import org.jack.anime.entity.BaseEntity;
import org.jack.anime.service.vo.rolePerm.RolePermVo;

public class AnimeRoleVo extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4851853619594360269L;

	private Integer id;

    private String name;

    private String description;
    
    private List<RolePermVo> list;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<RolePermVo> getList() {
		return list;
	}

	public void setList(List<RolePermVo> list) {
		this.list = list;
	}

	
	

}
