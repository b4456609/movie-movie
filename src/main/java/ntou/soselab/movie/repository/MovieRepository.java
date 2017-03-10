package ntou.soselab.movie.repository;


import ntou.soselab.movie.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {
    public List<Movie> findAllByTitleContainingIgnoreCase(String name);
}
