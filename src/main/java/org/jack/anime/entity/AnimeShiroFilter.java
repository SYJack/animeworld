package org.jack.anime.entity;

import java.io.Serializable;

public class AnimeShiroFilter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4021654722875160121L;

	public interface Save {
	}

	public interface Modify {
	}
	
    private Integer id;

    private String name;

    private String perms;

    private Integer sortOrder;

    private Long createTimestamp;

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
        this.name = name == null ? null : name.trim();
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}