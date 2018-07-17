package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.db.MovieRepository;
import spicinemas.api.model.Movie;

import java.io.Console;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieRepository movieRepo;

    @RequestMapping(value = "/movies/now-showing",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getNowShowingMovies() {
        return movieRepo.getNowShowingMovies();
    }

    @RequestMapping(value = "/movies/{id}",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovieDetail(@PathVariable("id") String id) {
        return movieRepo.getMovie(id);
    }
    
    @RequestMapping(value = "/movies/upcoming",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getUpcomingMovies() {
        return movieRepo.getUpcomingMovies();
    }

}