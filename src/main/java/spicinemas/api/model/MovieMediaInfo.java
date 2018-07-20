package spicinemas.api.model;

public class MovieMediaInfo {
    private String poster;
    private String videoURL;

    public MovieMediaInfo(String poster, String videoURL) {
        this.poster = poster;
        this.videoURL = videoURL;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}
