package spicinemas.api.model;

import spicinemas.api.type.MovieListingType;

public class MovieDetailInfo {
    private String synopsis;
    private String genre;
    private String actors;
    private MovieListingType type;
    private String experience;

    public MovieDetailInfo(String synopsis, String genre, String actors, MovieListingType type, String experience) {
        this.synopsis = synopsis;
        this.genre = genre;
        this.actors = actors;
        this.type = type;
        this.experience = experience;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public MovieListingType getType() {
        return type;
    }

    public void setType(MovieListingType type) {
        this.type = type;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
