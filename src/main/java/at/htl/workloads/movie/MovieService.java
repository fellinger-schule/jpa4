package at.htl.workloads.movie;

import java.util.List;

public interface MovieService {
    Movie getMovieById(long id);
    boolean addMovie(Movie movie);
    boolean removeMovie(Movie movie);
    List<Movie> getAllMovies();
}
