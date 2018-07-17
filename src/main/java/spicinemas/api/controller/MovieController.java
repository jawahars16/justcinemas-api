package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
    public List<Movie> getNowShowingMovies(@RequestParam String language, @RequestParam String location) {
        return movieRepo.getNowShowingMovies(language, location);
    }

    @RequestMapping(value = "/movies/upcoming",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getUpcomingMovies(@RequestParam String language, @RequestParam String location) {
        return movieRepo.getUpcomingMovies(language, location);
    }

    @RequestMapping(value = "/movies/{id}",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovieDetail(@PathVariable("id") String id) {
        return movieRepo.getMovie(id);
    }

    @RequestMapping(value = "/locations",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getLocations() {
        return movieRepo.getLocations();
    }

    @RequestMapping(value = "/languages",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getLanguages() {
        return movieRepo.getLanguages();
    }
}