package spicinemas.api.model;

import lombok.EqualsAndHashCode;

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

    public Movie(String id, String title, String poster, String language, String synopsis, String genre, String actors) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.language = language;
        this.synopsis = synopsis;
        this.genre = genre;
        this.actors = actors;
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
}