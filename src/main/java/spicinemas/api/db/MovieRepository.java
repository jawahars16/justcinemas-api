package spicinemas.api.db;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.model.Movie;
import spicinemas.api.type.MovieListingType;

import java.util.*;

@Repository
@Transactional
public class MovieRepository {

    public List<Movie> getNowShowingMovies(String language, String location) {
        List<Movie> nowShowingMovies = new ArrayList<>();
        for (Movie movie : Movies.getMovies()) {
            if(movie.getType() == MovieListingType.NOW_SHOWING) {
                if((language == null || language.isEmpty()) && (location == null || location.isEmpty())) {
                    nowShowingMovies.add(movie);
                }

                if(language != null && !language.isEmpty() && (location == null || location.isEmpty())) {
                    if(language.equalsIgnoreCase("All Language") || movie.getLanguage().equalsIgnoreCase(language)) {
                        nowShowingMovies.add(movie);
                    }
                }

                if(location != null && !location.isEmpty() && (language == null || language.isEmpty())) {
                    if(location.equalsIgnoreCase("All Location") || movie.getLocation().equalsIgnoreCase(location)) {
                        nowShowingMovies.add(movie);
                    }
                }

                if((language != null && !language.isEmpty() && (language.equalsIgnoreCase("All Language") || movie.getLanguage().equalsIgnoreCase(language))) && (location != null && !location.isEmpty() && (location.equalsIgnoreCase("All Location") || movie.getLocation().equalsIgnoreCase(location)))) {
                    nowShowingMovies.add(movie);
                }
            }
        }
        nowShowingMovies.sort(Comparator.comparing(Movie::getName));
        return nowShowingMovies;
    }

    public List<Movie> getUpcomingMovies(String language, String location) {
        List<Movie> upcomingMovies = new ArrayList<>();
        for (Movie movie : Movies.getMovies()) {
            if(movie.getType() == MovieListingType.UPCOMING) {
                if((language == null || language.isEmpty()) && (location == null || location.isEmpty())) {
                    upcomingMovies.add(movie);
                }

                if(language != null && !language.isEmpty() && (location == null || location.isEmpty())) {
                    if(movie.getLanguage().equalsIgnoreCase(language)) {
                        upcomingMovies.add(movie);
                    }
                }

                if(location != null && !location.isEmpty() && (language == null || language.isEmpty())) {
                    if(movie.getLocation().equalsIgnoreCase(location)) {
                        upcomingMovies.add(movie);
                    }
                }

                if((language != null && !language.isEmpty() && (language.equalsIgnoreCase("All Language") || movie.getLanguage().equalsIgnoreCase(language))) && (location != null && !location.isEmpty() && (location.equalsIgnoreCase("All Location") || movie.getLocation().equalsIgnoreCase(location)))) {
                    upcomingMovies.add(movie);
                }
            }
        }
        upcomingMovies.sort(Comparator.comparing(Movie::getName));
        return upcomingMovies;
    }

    public Movie getMovie(String id){
        return  Movies.getMovies().stream().filter(movie -> movie.getId().equals(id)).findFirst().get();
    }

    public List<String> getLocations() {
        return Arrays.asList(LocationRepository.LOCATIONS);
    }

    public List<String> getLanguages() {
        return Arrays.asList(LanguagesRepository.LANGUAGES);
    }
}