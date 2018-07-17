package spicinemas.api.db;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import spicinemas.api.model.Movie;
import spicinemas.api.type.MovieListingType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static spicinemas.api.db.LanguagesRepository.LANGUAGES;
import static spicinemas.api.db.LocationRepository.LOCATIONS;

public class Movies {

    private static List<Movie> movies = new ArrayList<>();

    private static final MovieListingType[] TYPES = {MovieListingType.NOW_SHOWING, MovieListingType.UPCOMING};

    public static void init() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://thoughtworksreactreduxmovies.firebaseio.com/movies.json";
        ResponseEntity<Object[]> response = restTemplate.getForEntity(fooResourceUrl, Object[].class);
        for (Object movieObject : response.getBody()) {
            String title = ((LinkedHashMap) movieObject).get("Title").toString();
            String poster = ((LinkedHashMap) movieObject).get("Poster").toString();
            String id = ((LinkedHashMap) movieObject).get("imdbID").toString();
            String synopsis = ((LinkedHashMap) movieObject).get("Plot").toString();
            String genre = ((LinkedHashMap) movieObject).get("Genre").toString();
            String actors = ((LinkedHashMap) movieObject).get("Actors").toString();
            int locIndex = (int)(Math.random() * 10) % (LOCATIONS.length);
            int langIndex = (int)(Math.random() * 10) % (LANGUAGES.length);
            int typeIndex = (int)(Math.random() * 10) % (TYPES.length);
            Movie movie = new Movie(id, title, poster, LANGUAGES[langIndex], synopsis, genre, actors, TYPES[typeIndex], LOCATIONS[locIndex]);
            movies.add(movie);
        }
    }

    public static List<Movie> getMovies() {
        return movies;
    }
}