package org.jack.anime.service.vo.animePermission;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.jack.anime.entity.BaseEntity;

public class AnimePermissionDto extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4240637807305782311L;
	
	public interface Save {
	}

	public interface Modify {
	}
	
	@NotNull(message ="id不能为空",groups = {Modify.class})
	@Null(message= "id必须为空",groups = {Save.class})
	private Integer id;

	@NotNull(message ="权限名称不能为空",groups = {Modify.class,Save.class})
    private String name;

	@NotNull(message ="权限url不能为空",groups = {Modify.class,Save.class})
    private String url;

	@NotNull(message ="权限代码不能为空",groups = {Modify.class,Save.class})
    private String code;

	
    private String description;

    @NotNull(message ="权限状态不能为空",groups = {Modify.class,Save.class})
    private Short status;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}
    
    

}
