package org.jack.anime.entity;

import java.io.Serializable;

public class AnimeTimetable implements Serializable {
    private Integer id;

    private Integer animeBid;

    private Long animeId;

    private String animeName;

    private String animeCover;

    private String animeVerticalCover;

    private String animePlayDate;

    private String animePlayTime;

    private String animeOriginTime;

    private String animePlaySite;

    private String animeOriginStation;

    private String animePlayEpisode;

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