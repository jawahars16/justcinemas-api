package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import spicinemas.api.type.MovieListingType;

import java.io.Serializable;

@EqualsAndHashCode(exclude = {"id"})
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public MovieListingType getType() {
        return type;
    }

    public void setType(MovieListingType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}