package spicinemas.api.db;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import spicinemas.api.model.Movie;
import spicinemas.api.type.MovieListingType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Movies {

    private static List<Movie> movies = new ArrayList<>();

    private static MovieListingType[] types = {MovieListingType.NOW_SHOWING, MovieListingType.UPCOMING};

    public static void init() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://thoughtworksreactreduxmovies.firebaseio.com/movies.json";
        ResponseEntity<Object[]> response = restTemplate.getForEntity(fooResourceUrl, Object[].class);
        for (Object movieObject : response.getBody()) {
            String title = ((LinkedHashMap) movieObject).get("Title").toString();
            String poster = ((LinkedHashMap) movieObject).get("Poster").toString();
            String language = ((LinkedHashMap) movieObject).get("Language").toString();
            MovieListingType type = types[(int)(Math.random() * 10) % 2];
            Movie movie = new Movie(title, poster, language, type);
            movies.add(movie);
        }
    }

    public static List<Movie> getMovies() {
        return movies;
    }

}