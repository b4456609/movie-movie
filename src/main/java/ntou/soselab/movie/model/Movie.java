package ntou.soselab.movie.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Movie {
    @Id
    private String id;
    private String title;
    private int year;
    private String rated;
    private int runTime;
    private String genre;
    private String director;
    private String actors;
    private String plot;
}
