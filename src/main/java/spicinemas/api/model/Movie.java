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

    public Movie(String id, String title, String poster, String language, String synopsis, String genre, String actors, MovieListingType type, String location, String experience) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.language = language;
        this.synopsis = synopsis;
        this.genre = genre;
        this.actors = actors;
        this.type = type;
        this.location = location;
        this.experience = experience;
    }

    public Movie() {

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
}