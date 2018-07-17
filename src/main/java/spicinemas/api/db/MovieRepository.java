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
    @Autowired
    private DSLContext dsl;

    public List<Movie> getNowShowingMovies() {
        List<Movie> nowShowingMovies = new ArrayList<>();
        for (Movie movie : Movies.getMovies()) {
            if(movie.getType() == MovieListingType.NOW_SHOWING) {
                nowShowingMovies.add(movie);
            }
        }
        return nowShowingMovies;
    }

    public List<Movie> getUpcomingMovies() {
        List<Movie> upcomingMovies = new ArrayList<>();
        for (Movie movie : Movies.getMovies()) {
            if(movie.getType() == MovieListingType.UPCOMING) {
                upcomingMovies.add(movie);
            }
        }
        return upcomingMovies;
    }

    public void addMovie(Movie movie) {
        dsl.insertInto(DSL.table("MOVIE"), DSL.field("TITLE"), DSL.field("POSTER"), DSL.field("MOVIE_LANGUAGE"))
                .values(movie.getName(), movie.getPoster(), movie.getLanguage())
                .execute();
    }

    public Movie getMovie(String name) {
        return dsl.select(DSL.field("TITLE"), DSL.field("POSTER"), DSL.field("MOVIE_LANGUAGE"))
                .from(DSL.table("MOVIE"))
                .where(DSL.field("MOVIE.TITLE").eq(name))
                .fetchOne()
                .into(Movie.class);
    }

}