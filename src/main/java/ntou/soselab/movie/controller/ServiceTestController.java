package ntou.soselab.movie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ntou.soselab.movie.model.Movie;
import ntou.soselab.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class ServiceTestController {

    private final MovieRepository movieRepository;

    @Autowired
    public ServiceTestController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostMapping("/serviceTest")
    public void test(@RequestBody ServiceTestDTO serviceTestDTO) throws IOException {
        if (serviceTestDTO.getState() == "The La la land exists in db And id is '5ef2bf0d-6dbf-4de8-a095-93690854da5b'") {
            this.saveLaLaLand();
        }
    }

    private void saveLaLaLand() throws IOException {
        String path = this.getClass().getResource("/movie/lalaland.json").getPath();
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        String lalalandJson = new String(bytes);
        ObjectMapper objectMapper = new ObjectMapper();
        Movie movie = objectMapper.readValue(bytes, Movie.class);
        movie.setId("5ef2bf0d-6dbf-4de8-a095-93690854da5b");
        movieRepository.save(movie);
    }
}
