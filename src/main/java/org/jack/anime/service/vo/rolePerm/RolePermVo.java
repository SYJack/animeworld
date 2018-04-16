package org.jack.anime.service.vo.rolePerm;

import org.jack.anime.entity.BaseEntity;

public class RolePermVo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 21446649445974655L;
	
	private Integer id;

    private Integer roleId;

    private Integer permissionId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
    
    

}
