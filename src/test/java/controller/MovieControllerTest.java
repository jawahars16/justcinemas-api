package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.controller.MovieController;
import spicinemas.api.service.MovieService;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
@ContextConfiguration(classes = SpiCinemasApplication.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    public void contextLoads() {
        assertNotNull(movieService);
    }

    @Test
    public void testHomePageShouldLoad() throws Exception{
        this.mockMvc.perform(get("/movies?type=NOW_SHOWING&language=All Languages&location=All Locations")).andExpect(status().isOk());
    }

    @Test
    public void testMovieDetailShouldLoad() throws Exception {
        this.mockMvc.perform(get("/movie/21")).andExpect(status().isOk());
    }
}