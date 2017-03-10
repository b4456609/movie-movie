package ntou.soselab.movie;

import ntou.soselab.movie.controller.MovieController;
import ntou.soselab.movie.model.Movie;
import ntou.soselab.movie.repository.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MovieRepositoryTests {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieController movieController;
    private Movie lalalandMovie;

    @Before
    public void before() {
        this.movieRepository.deleteAll();
        lalalandMovie = Movie.builder()
                .id("1234")
                .title("La La Land")
                .build();
        this.movieRepository.save(lalalandMovie);
    }

    @Test
    public void testFindFeature() {
        List<Movie> la = movieRepository.findAllByTitleContainingIgnoreCase("La");
        assertThat(la).contains(lalalandMovie);
    }

    @Test
    public void testFindTitleIgnoreCase() {
        List<Movie> la = movieRepository.findAllByTitleContainingIgnoreCase("la");
        assertThat(la).contains(lalalandMovie);
    }

}
