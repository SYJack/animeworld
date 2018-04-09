package org.jack.anime.service.vo.animeRole;

import org.jack.anime.entity.BaseEntity;

public class AnimeRoleVo extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4851853619594360269L;

	private Integer id;

    private String name;

    private String description;

    private String permissionId;

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

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
    
    
}
