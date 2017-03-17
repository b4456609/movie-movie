package ntou.soselab.movie.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ntou.soselab.movie.model.Movie;
import ntou.soselab.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class ServiceTestController {

    private final MovieRepository movieRepository;

    @Autowired
    public ServiceTestController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostMapping("/serviceTest")
    public void test(@RequestBody ServiceTestDTO serviceTestDTO) throws IOException {
        log.info("{}", serviceTestDTO);
        if (serviceTestDTO.getState().equals("The La la land exists in db And id is '5ef2bf0d-6dbf-4de8-a095-93690854da5b'")) {
            this.saveLaLaLand();
        }
    }

    private void saveLaLaLand() throws IOException {
        String lalalandJson = "{\n" +
                "  \"title\": \"La La Land\",\n" +
                "  \"year\": \"2016\",\n" +
                "  \"rated\": \"PG-13\",\n" +
                "  \"runTime\": \"128 min\",\n" +
                "  \"genre\": \"Comedy, Drama, Musical\",\n" +
                "  \"director\": \"Damien Chazelle\",\n" +
                "  \"actors\": \"Ryan Gosling, Emma Stone, Amiée Conn, Terry Walters\",\n" +
                "  \"plot\": \"A jazz pianist falls for an aspiring actress in Los Angeles.\"\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        Movie movie = objectMapper.readValue(lalalandJson, Movie.class);
        movie.setId("5ef2bf0d-6dbf-4de8-a095-93690854da5b");
        movieRepository.save(movie);
    }
}
