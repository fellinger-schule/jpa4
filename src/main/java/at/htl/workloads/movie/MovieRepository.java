package at.htl.workloads.movie;

import java.util.List;

public interface MovieRepository {
    Movie getMovieById(long id);
    void addMovie(Movie movie);
    void removeMovie(Movie movie);
    List<Movie> getAllMovies();
}
