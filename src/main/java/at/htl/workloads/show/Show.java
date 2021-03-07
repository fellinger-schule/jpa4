package at.htl.workloads.show;

import at.htl.workloads.hall.Hall;
import at.htl.workloads.movie.Movie;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

public class Show {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private String showTime ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Hall getHall() {
        return this.hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public void setMovie(Movie movie) { this.movie = movie; }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
