package spicinemas.api.db;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import spicinemas.api.model.Movie;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Movies {

    static private List<Movie> movies = new ArrayList<>();

    public static void init() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://thoughtworksreactreduxmovies.firebaseio.com/movies.json";
        ResponseEntity<Object[]> response = restTemplate.getForEntity(fooResourceUrl, Object[].class);
        for (Object movieObject : response.getBody()) {
            String title = ((LinkedHashMap) movieObject).get("Title").toString();
            String poster = ((LinkedHashMap) movieObject).get("Poster").toString();
            String language = ((LinkedHashMap) movieObject).get("Language").toString();
            Movie movie = new Movie(title, poster, language);
            movies.add(movie);
        }
    }

    public static List<Movie> getMovies() {
        return movies;
    }

}