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

    private static String[] experiences = new String[]
    {
        "Dolby Atmos", "Atmos", "DTS", "Basic", "Auro 3D"
    };

    ;

    public static void init() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://thoughtworksreactreduxmovies.firebaseio.com/movies.json";
        ResponseEntity<Object[]> response = restTemplate.getForEntity(fooResourceUrl, Object[].class);
        for (Object movieObject : response.getBody()) {
            String title = ((LinkedHashMap) movieObject).get("Title").toString();
            String poster = ((LinkedHashMap) movieObject).get("Poster").toString();
            String language = ((LinkedHashMap) movieObject).get("Language").toString();
            String id = ((LinkedHashMap) movieObject).get("imdbID").toString();
            String synopsis = ((LinkedHashMap) movieObject).get("Plot").toString();
            String genre = ((LinkedHashMap) movieObject).get("Genre").toString();
            String actors = ((LinkedHashMap) movieObject).get("Actors").toString();
            MovieListingType type = types[(int) (Math.random() * 10) % 2];
            String experience = experiences[(int) (Math.random() * 10) % 5];
            Movie movie = new Movie(id, title, poster, language, synopsis, genre, actors, type, experience);
            movies.add(movie);
        }
    }

    public static List<Movie> getMovies() {
        return movies;
    }

}