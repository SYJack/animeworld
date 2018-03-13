package org.jack.anime.entity;


public class AnimeRole extends BaseEntity {
    private Integer id;

    private String name;

    private String popedomJson;

    private static final long serialVersionUID = 1L;

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

    public String getPopedomJson() {
        return popedomJson;
    }

    public void setPopedomJson(String popedomJson) {
        this.popedomJson = popedomJson == null ? null : popedomJson.trim();
    }
}