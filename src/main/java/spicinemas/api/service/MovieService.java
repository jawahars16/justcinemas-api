package spicinemas.api.service;

import org.springframework.stereotype.Service;
import spicinemas.api.db.Movies;
import spicinemas.api.model.Movie;
import spicinemas.api.type.MovieListingType;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private static final String ALL_LANGUAGES = "All Language";
    private static final String ALL_LOCATIONS = "All Location";

    public List<Movie> getMovies(String language, String location, MovieListingType type) {
        return Movies.getMovies().stream().filter(movie -> movie.getType() == type)
                .filter(movie -> ALL_LOCATIONS.equals(location) || Objects.equals(movie.getLocation(), location))
                .filter(movie -> ALL_LANGUAGES.equals(language) || Objects.equals(movie.getLanguage(), language))
                .sorted(Comparator.comparing(Movie::getName)).collect(Collectors.toList());
    }

    public Movie getMovie(String id){
        return  Movies.getMovies().stream().filter(movie -> movie.getId().equals(id)).findFirst().get();
    }
}