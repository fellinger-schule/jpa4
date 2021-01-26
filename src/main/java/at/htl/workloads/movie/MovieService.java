package at.htl.workloads.movie;

import at.htl.model.kino.MovieDTO;

import java.util.List;

public interface MovieService {
    Movie getMovieById(long id);
    boolean addMovie(MovieDTO movie);
    boolean removeMovie(MovieDTO movie);
    List<Movie> getAllMovies();
}
