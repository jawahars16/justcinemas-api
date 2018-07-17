package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Movie;

import java.util.List;

@Repository
@Transactional
public class MovieRepository {

    public List<Movie> getNowShowingMovies() {
        return Movies.getMovies();
    }

    public Movie getMovie(String id){
        return  Movies.getMovies().stream().filter(movie -> movie.getId().equals(id)).findFirst().get();
    }


}