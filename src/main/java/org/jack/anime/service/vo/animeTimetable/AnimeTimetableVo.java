package org.jack.anime.service.vo.animeTimetable;

import java.io.Serializable;

public class AnimeTimetableVo implements Serializable{

	/**
     * 
     */
    private Integer id;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		this.animeName = animeName;
	}

	public String getAnimeCover() {
		return animeCover;
	}

	public void setAnimeCover(String animeCover) {
		this.animeCover = animeCover;
	}

	public String getAnimeVerticalCover() {
		return animeVerticalCover;
	}

	public void setAnimeVerticalCover(String animeVerticalCover) {
		this.animeVerticalCover = animeVerticalCover;
	}

	public String getAnimePlayDate() {
		return animePlayDate;
	}

	public void setAnimePlayDate(String animePlayDate) {
		this.animePlayDate = animePlayDate;
	}

	public String getAnimePlayTime() {
		return animePlayTime;
	}

	public void setAnimePlayTime(String animePlayTime) {
		this.animePlayTime = animePlayTime;
	}

	public String getAnimeOriginTime() {
		return animeOriginTime;
	}

	public void setAnimeOriginTime(String animeOriginTime) {
		this.animeOriginTime = animeOriginTime;
	}

	public String getAnimePlaySite() {
		return animePlaySite;
	}

	public void setAnimePlaySite(String animePlaySite) {
		this.animePlaySite = animePlaySite;
	}

	public String getAnimeOriginStation() {
		return animeOriginStation;
	}

	public void setAnimeOriginStation(String animeOriginStation) {
		this.animeOriginStation = animeOriginStation;
	}

	public String getAnimePlayEpisode() {
		return animePlayEpisode;
	}

	public void setAnimePlayEpisode(String animePlayEpisode) {
		this.animePlayEpisode = animePlayEpisode;
	}

	public String getAnimePlayUrl() {
		return animePlayUrl;
	}

	public void setAnimePlayUrl(String animePlayUrl) {
		this.animePlayUrl = animePlayUrl;
	}

	@Override
	public String toString() {
		return "AnimeTimetableVo [id=" + id + ", animeId=" + animeId + ", animeName=" + animeName + ", animeCover="
				+ animeCover + ", animeVerticalCover=" + animeVerticalCover + ", animePlayDate=" + animePlayDate
				+ ", animePlayTime=" + animePlayTime + ", animeOriginTime=" + animeOriginTime + ", animePlaySite="
				+ animePlaySite + ", animeOriginStation=" + animeOriginStation + ", animePlayEpisode="
				+ animePlayEpisode + ", animePlayUrl=" + animePlayUrl + "]";
	}
    
	
}
