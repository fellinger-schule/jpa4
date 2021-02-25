package at.htl.model.kino;

import java.time.LocalDateTime;

public class ShowDTO {
    private long id;
    private long hallId ;
    private long movieId;
    private String showTime ;

    public ShowDTO() {
    }

    public ShowDTO(long id, long hallId, long movieId, String showTime) {
        this.id = id;
        this.hallId = hallId;
        this.movieId = movieId;
        this.showTime = showTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHallId() {
        return hallId;
    }

    public void setHallId(long hallId) {
        this.hallId = hallId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
