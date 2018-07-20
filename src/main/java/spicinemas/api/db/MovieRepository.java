package spicinemas.api.db;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import spicinemas.api.Utils.Constants;
import spicinemas.api.model.Movie;
import spicinemas.api.model.MovieBasicInfo;
import spicinemas.api.model.MovieDetailInfo;
import spicinemas.api.model.MovieMediaInfo;
import spicinemas.api.type.MovieListingType;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static spicinemas.api.db.LanguagesRepository.LANGUAGES;
import static spicinemas.api.db.LocationRepository.LOCATIONS;

public class MovieRepository {

    private static ArrayList<Movie> movies = new ArrayList<>();

    private static final MovieListingType[] TYPES = {MovieListingType.NOW_SHOWING, MovieListingType.UPCOMING};

    private static String[] EXPERIENCES = {"Dolby Atmos", "Atmos", "DTS", "Basic", "Auro 3D"};

    public static void init() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = Constants.RESOURCE_URL;
        ResponseEntity<Object[]> response = restTemplate.getForEntity(fooResourceUrl, Object[].class);
        for (Object movieObject : response.getBody()) {
            String title = ((LinkedHashMap) movieObject).get("Title").toString();
            String poster = ((LinkedHashMap) movieObject).get("Poster").toString();
            String id = ((LinkedHashMap) movieObject).get("imdbID").toString();
            String synopsis = ((LinkedHashMap) movieObject).get("Plot").toString();
            String genre = ((LinkedHashMap) movieObject).get("Genre").toString();
            String actors = ((LinkedHashMap) movieObject).get("Actors").toString();
            String videoURL = Constants.VIDEO_URL;

            int locIndex = (int)(Math.random() * 10) % (LOCATIONS.length);
            int langIndex = (int)(Math.random() * 10) % (LANGUAGES.length);
            int typeIndex = (int)(Math.random() * 10) % (TYPES.length);
            int experienceIndex = (int)(Math.random() * 10) % (EXPERIENCES.length);

            MovieBasicInfo basic = new MovieBasicInfo(title, LANGUAGES[langIndex], id, LOCATIONS[locIndex]);
            MovieDetailInfo detail = new MovieDetailInfo(synopsis, genre, actors, TYPES[typeIndex], EXPERIENCES[experienceIndex]);
            MovieMediaInfo media = new MovieMediaInfo(poster, videoURL);
            Movie movie = new Movie(basic, detail, media);

            movies.add(movie);
        }
    }

    public static ArrayList<Movie> getMovies() {
        return (ArrayList<Movie>) movies.clone();
    }
}