package spicinemas.api.db;

import org.jooq.DSLContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.controller.MovieController;
import spicinemas.api.model.Movie;
import spicinemas.api.type.MovieListingType;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
@ContextConfiguration
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepo;

    @Test
    public void upcomingMoviesShouldShowUpcomingMovies() {
        Movies.init();
        List<Movie> movies = movieRepo.getUpcomingMovies();
        boolean flag = true;
        for(Movie movie : movies) {
            if(movie.getType() != MovieListingType.UPCOMING) {
                flag = false;
                break;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void nowShowingMoviesShouldShowNowShowingMovies() {
        Movies.init();
        List<Movie> movies = movieRepo.getNowShowingMovies();
        boolean flag = true;
        for(Movie movie : movies) {
            if(movie.getType() != MovieListingType.NOW_SHOWING) {
                flag = false;
                break;
            }
        }
        assertTrue(flag);
    }
}