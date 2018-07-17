package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Movie;
import spicinemas.api.type.MovieListingType;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MovieRepository {

    public List<Movie> getNowShowingMovies(String language, String location) {
        List<Movie> nowShowingMovies = new ArrayList<>();
        for (Movie movie : Movies.getMovies()) {
            if(movie.getType() == MovieListingType.NOW_SHOWING) {
                if ((language != null && !language.isEmpty() && movie.getLanguage().equalsIgnoreCase(language)) && (location != null && !location.isEmpty() && movie.getLocation().equalsIgnoreCase(location))) {
                    nowShowingMovies.add(movie);
                }
            }
        }
        return nowShowingMovies;
    }

    public List<Movie> getUpcomingMovies(String language, String location) {
        List<Movie> upcomingMovies = new ArrayList<>();
        for (Movie movie : Movies.getMovies()) {
            if(movie.getType() == MovieListingType.UPCOMING) {
                if ((language != null && !language.isEmpty() && movie.getLanguage().equalsIgnoreCase(language)) && (location != null && !location.isEmpty() && movie.getLocation().equalsIgnoreCase(location))) {
                    upcomingMovies.add(movie);
                }
            }
        }
        return upcomingMovies;
    }

    public Movie getMovie(String id){
        return  Movies.getMovies().stream().filter(movie -> movie.getId().equals(id)).findFirst().get();
    }
}