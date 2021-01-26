package at.htl.workloads.movie;

import java.util.List;

public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository mr) {
        movieRepository = mr;
    }

    @Override
    public Movie getMovieById(long id) {
        return null;
    }

    @Override
    public boolean addMovie(Movie movie) {
        return false;
    }

    @Override
    public boolean removeMovie(Movie movie) {
        return false;
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }
}
