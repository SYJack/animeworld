package org.jack.anime.entity;


public class AnimeTimetable extends BaseEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * anitama动漫ID
     */
    private Integer animeBid;

    /**
     * 动漫ID
     */
    private Long animeId;

    /**
     * 动漫名称
     */
    private String animeName;

    /**
     * 动漫封面图片链接
     */
    private String animeCover;

    /**
     * 动漫图片链接
     */
    private String animeVerticalCover;

    /**
     * 动漫播放日期
     */
    private String animePlayDate;

    /**
     * 国内动漫播放时间
     */
    private String animePlayTime;

    /**
     * 制作国家动漫播放时间
     */
    private String animeOriginTime;

    /**
     * 国内动漫播放网站
     */
    private String animePlaySite;

    /**
     * 制作国家动漫播放电视台
     */
    private String animeOriginStation;

    /**
     * 动漫播放集数
     */
    private String animePlayEpisode;

    /**
     * 国内动漫播放网站地址
     */
    private String animePlayUrl;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnimeBid() {
        return animeBid;
    }

    public void setAnimeBid(Integer animeBid) {
        this.animeBid = animeBid;
    }

    public Long getAnimeId() {
        return animeId;
    }

    public void setAnimeId(Long animeId) {
        this.animeId = animeId;
    }

    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName == null ? null : animeName.trim();
    }

    public String getAnimeCover() {
        return animeCover;
    }

    public void setAnimeCover(String animeCover) {
        this.animeCover = animeCover == null ? null : animeCover.trim();
    }

    public String getAnimeVerticalCover() {
        return animeVerticalCover;
    }

    public void setAnimeVerticalCover(String animeVerticalCover) {
        this.animeVerticalCover = animeVerticalCover == null ? null : animeVerticalCover.trim();
    }

    public String getAnimePlayDate() {
        return animePlayDate;
    }

    public void setAnimePlayDate(String animePlayDate) {
        this.animePlayDate = animePlayDate == null ? null : animePlayDate.trim();
    }

    public String getAnimePlayTime() {
        return animePlayTime;
    }

    public void setAnimePlayTime(String animePlayTime) {
        this.animePlayTime = animePlayTime == null ? null : animePlayTime.trim();
    }

    public String getAnimeOriginTime() {
        return animeOriginTime;
    }

    public void setAnimeOriginTime(String animeOriginTime) {
        this.animeOriginTime = animeOriginTime == null ? null : animeOriginTime.trim();
    }

    public String getAnimePlaySite() {
        return animePlaySite;
    }

    public void setAnimePlaySite(String animePlaySite) {
        this.animePlaySite = animePlaySite == null ? null : animePlaySite.trim();
    }

    public String getAnimeOriginStation() {
        return animeOriginStation;
    }

    public void setAnimeOriginStation(String animeOriginStation) {
        this.animeOriginStation = animeOriginStation == null ? null : animeOriginStation.trim();
    }

    public String getAnimePlayEpisode() {
        return animePlayEpisode;
    }

    public void setAnimePlayEpisode(String animePlayEpisode) {
        this.animePlayEpisode = animePlayEpisode == null ? null : animePlayEpisode.trim();
    }

    public String getAnimePlayUrl() {
        return animePlayUrl;
    }

    public void setAnimePlayUrl(String animePlayUrl) {
        this.animePlayUrl = animePlayUrl == null ? null : animePlayUrl.trim();
    }
    
}