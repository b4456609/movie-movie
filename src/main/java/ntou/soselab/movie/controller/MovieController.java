package ntou.soselab.movie.controller;

import lombok.extern.slf4j.Slf4j;
import ntou.soselab.movie.model.Movie;
import ntou.soselab.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.List;

@Slf4j
@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public List<Movie> getMovieTimetable() {
        return movieRepository.findAll();
    }

    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable("id") String id) {
        log.info("movie id: {}", id);
        return movieRepository.findOne(id);
    }

    @GetMapping("/movie")
    public List<Movie> searchMovieByName(@QueryParam("q") String name) {
        log.info("query movie name: {}", name);
        return movieRepository.findAllByTitleContainingIgnoreCase(name);
    }
}
