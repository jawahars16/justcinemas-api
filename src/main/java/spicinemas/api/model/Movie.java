package spicinemas.api.model;

import spicinemas.api.type.MovieListingType;

import java.io.Serializable;

public class Movie implements Serializable {
    private String title;
    private String poster;
    private String language;
    private String id;
    private String synopsis;
    private String genre;
    private String actors;
    private String location;
    private MovieListingType type;
    private String experience;
    private String videoURL;

    public Movie(MovieBasicInfo basic, MovieDetailInfo detail, MovieMediaInfo media){
        this.id = basic.getId();
        this.title = basic.getTitle();
        this.poster = media.getPoster();
        this.language = basic.getLanguage();
        this.synopsis = detail.getSynopsis();
        this.genre = detail.getGenre();
        this.actors = detail.getActors();
        this.type = detail.getType();
        this.location = basic.getLocation();
        this.experience = detail.getExperience();
        this.videoURL = media.getVideoURL();
    }

    public String getName() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getLanguage() {
        return language;
    }

    public String getId() {
        return id;
    }

    public MovieListingType getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public String getActors() {
        return actors;
    }

    public String getExperience() {
        return experience;
    }

    public String getVideoURL() {
        return videoURL;
    }
}