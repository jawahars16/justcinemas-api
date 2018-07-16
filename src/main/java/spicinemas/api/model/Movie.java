package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import spicinemas.api.type.MovieListingType;

import java.io.Serializable;

@EqualsAndHashCode(exclude = {"id"})
public class Movie implements Serializable {
    private String Title;
    private String Poster;
    private String Language;

    public Movie(String title, String Poster, String Language) {
        this.Title = title;
        this.Poster = Poster;
        this.Language = Language;
    }

    public Movie() {

    }

    public String getName() {
        return Title;
    }

    public String getPoster() {
        return Poster;
    }

    public String getLanguage() {
        return Language;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public void setPoster(String poster) {
        this.Poster = poster;
    }

    public void setLanguage(String language) {
        this.Language = language;
    }
}