package at.htl.model.kino;

import at.htl.workloads.hall.Hall;
import at.htl.workloads.movie.Movie;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embedded;
import java.time.LocalDateTime;

public class ShowDTO {
    private long id;
    private long hallId;
    private String hallName;
    private long movieId;
    private String movieTitle;
    private String showTime ;

    public ShowDTO() {
    }

    public ShowDTO(long id, long hallId, String hallName, long movieId, String movieTitle, String showTime) {
        this.id = id;
        this.hallId = hallId;
        this.hallName = hallName;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.showTime = showTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public long getHallId() {
        return hallId;
    }

    public void setHallId(long hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
}
