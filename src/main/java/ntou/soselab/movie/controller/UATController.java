package ntou.soselab.movie.controller;

import ntou.soselab.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UATController {
    private final MovieRepository movieRepository;

    @Autowired
    public UATController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @DeleteMapping("/reset")
    public void resetDB() {
        movieRepository.deleteAll();
    }
}
