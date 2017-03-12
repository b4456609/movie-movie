package ntou.soselab.movie.controller;

import lombok.Data;

@Data
public class MovieDTO {
    private String title;
    private String year;
    private String rated;
    private String runTime;
    private String genre;
    private String director;
    private String actors;
    private String plot;
}
