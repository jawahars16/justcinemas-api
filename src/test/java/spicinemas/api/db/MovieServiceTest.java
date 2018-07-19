package spicinemas.api.db;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spicinemas.api.model.Movie;
import spicinemas.api.service.MovieService;
import spicinemas.api.type.MovieListingType;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class MovieServiceTest {

    private String location;
    private String language;
    private MovieListingType type;

    @Autowired
    private MovieService movieService = new MovieService();

    @Before
    public void init() {
        location = "Pune";
        language = "English";
        type = MovieListingType.UPCOMING;
        MovieRepository.init();
    }

    @Test
    public void testAllMoviesAreOfGivenLanguage() {
        List<Movie> movies = movieService.getMovies(language, location, type);
        boolean flag = true;
        for(Movie movie : movies) {
            if(!language.equals(movie.getLanguage())) {
                flag = false;
                break;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void testAllMoviesAreOfGivenLocation() {
        List<Movie> movies = movieService.getMovies(language, location, type);
        boolean flag = true;
        for(Movie movie : movies) {
            if(!movie.getLocation().equals(location)) {
                flag = false;
                break;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void testAllMoviesAreOfGivenType() {
        List<Movie> movies = movieService.getMovies(language, location, type);
        boolean flag = true;
        for(Movie movie : movies) {
            if(movie.getType() != type) {
                flag = false;
                break;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void testNullFilterShouldGiveEmptyMovieList() {
        List<Movie> movies = movieService.getMovies(null, null, null);
        assertNotNull(movies);
    }

    @Test
    public void testEmptyFilterShouldGiveEmptyMovieList() {
        List<Movie> movies = movieService.getMovies("", "", null);
        assertNotNull(movies);
    }

    @Test
    public void testRandomFilterShouldGiveEmptyMovieList() {
        List<Movie> movies = movieService.getMovies("Random value", "Random value", null);
        assertNotNull(movies);
    }
}