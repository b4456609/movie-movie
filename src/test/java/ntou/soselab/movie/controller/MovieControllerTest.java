package ntou.soselab.movie.controller;

import ntou.soselab.movie.model.Movie;
import ntou.soselab.movie.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MovieControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    MovieRepository movieRepository;

    @Captor
    ArgumentCaptor<Movie> movieCaptor;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getMovieTimetable() throws Exception {

    }

    @Test
    public void getMovieById() throws Exception {

    }

    @Test
    public void searchMovieByName() throws Exception {

    }

    @Test
    public void addMovie() throws Exception {
        this.getClass().getResource("/movie/lalaland.json").getPath();
        byte[] bytes = Files.readAllBytes(Paths.get(this.getClass().getResource("/movie/lalaland.json").getPath()));
        String content = new String(bytes);
        System.out.println(content);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(content,headers);

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("/", entity, String.class);
        System.out.println(stringResponseEntity);

        verify(movieRepository).save(movieCaptor.capture());
        Movie value = movieCaptor.getValue();

        assertThat(value)
                .hasFieldOrPropertyWithValue("title", "La La Land")
                .hasFieldOrPropertyWithValue("year", "2016")
                .hasFieldOrPropertyWithValue("rated", "PG-13")
                .hasFieldOrPropertyWithValue("runTime", "128 min")
                .hasFieldOrPropertyWithValue("genre", "Comedy, Drama, Musical")
                .hasFieldOrPropertyWithValue("director", "Damien Chazelle")
                .hasFieldOrPropertyWithValue("actors", "Ryan Gosling, Emma Stone, Amiée Conn, Terry Walters")
                .hasFieldOrPropertyWithValue("plot", "A jazz pianist falls for an aspiring actress in Los Angeles.");
    }

}