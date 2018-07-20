package spicinemas.api.model;

public class MovieBasicInfo {
    private String title;
    private String language;
    private String id;
    private String location;

    public MovieBasicInfo(String title, String language, String id, String location) {
        this.title = title;
        this.language = language;
        this.id = id;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
