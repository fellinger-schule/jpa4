package at.htl.workloads.movie;

import at.htl.model.kino.MovieDTO;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository mr) {
        movieRepository = mr;
    }

    @Override
    public Movie getMovieById(long id) {
        return movieRepository.getMovieById(id);
    }

    @Override
    public boolean addMovie(MovieDTO movie) {
        var newMovie = convertIntoNormal(movie);
        movieRepository.addMovie(newMovie);
        return true;
    }

    @Override
    public boolean removeMovie(long id) {
        var exists = movieRepository.getMovieById(id);
        if (exists != null) {
            movieRepository.removeMovie(exists);
            return true;
        }
        return false;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public Movie convertIntoNormal(MovieDTO movie){
        var newmovie = new Movie();
        newmovie.setDuration(movie.getDuration());
        newmovie.setId(movie.getId());
        newmovie.setName(movie.getName());
        newmovie.setRating(movie.getRating());
        return newmovie;
    }
}
