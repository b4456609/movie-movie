package ntou.soselab.movie.controller;

import lombok.extern.slf4j.Slf4j;
import ntou.soselab.movie.model.Movie;
import ntou.soselab.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/timetable")
    public List<Movie> getMovieTimetable() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") String id) {
        log.info("movie id: {}", id);
        return movieRepository.findOne(id);
    }

    @GetMapping("/")
    public List<Movie> searchMovieByName(@QueryParam("q") String name) {
        log.info("query movie name: {}", name);
        return movieRepository.findAllByTitleContainingIgnoreCase(name);
    }

    @PostMapping("/")
    public Movie addMovie(@RequestBody MovieDTO movieDTO){
        log.info("add movie name: {}", movieDTO.getTitle());
        Movie movie = Movie.builder()
                .year(movieDTO.getYear())
                .actors(movieDTO.getActors())
                .director(movieDTO.getDirector())
                .genre(movieDTO.getGenre())
                .id(UUID.randomUUID().toString())
                .plot(movieDTO.getPlot())
                .rated(movieDTO.getRated())
                .runTime(movieDTO.getRunTime())
                .title(movieDTO.getTitle())
                .build();
        movieRepository.save(movie);
        return movie;
    }
}
