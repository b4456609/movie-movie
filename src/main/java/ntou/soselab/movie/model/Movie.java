package ntou.soselab.movie.model;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Movie {
    @Id
    private String id;
    private String title;
    private String year;
    private String rated;
    private String runTime;
    private String genre;
    private String director;
    private String actors;
    private String plot;

    @Tolerate
    Movie() {
    }
}
