package spicinemas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spicinemas.api.db.Movies;

@SpringBootApplication
public class SpiCinemasApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpiCinemasApplication.class, args);
		Movies.init();
	}
}