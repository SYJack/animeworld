package org.jack.anime.service.vo.animePermission;

import org.jack.anime.entity.BaseEntity;

public class AnimePermissionVo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3562931537913575940L;

	private Integer id;

	private String name;

	private String url;

	private String code;

	private String description;

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
