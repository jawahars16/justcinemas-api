package spicinemas.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spicinemas.api.model.Movie;
import spicinemas.api.service.MovieService;
import spicinemas.api.type.MovieListingType;
import java.util.List;

@RestController
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/movies",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMovies(@RequestParam String type, @RequestParam String language, @RequestParam String location) {
        return movieService.getMovies(language, location, MovieListingType.valueOf(type));
    }

    @RequestMapping(value = "/movie/{id}",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovieDetail(@PathVariable("id") String id) {
        return movieService.getMovie(id);
    }
}