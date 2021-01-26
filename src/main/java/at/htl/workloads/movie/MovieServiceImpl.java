package at.htl.workloads.movie;

import at.htl.model.kino.HallDTO;
import at.htl.model.kino.MovieDTO;
import at.htl.workloads.hall.Hall;

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
    public boolean addMovie(MovieDTO movie) {
        var exists = movieRepository.getMovieById((movie.getId()));
        if (exists != null) {
            return false;
        }
        var newcustomer = convertIntoNormal(movie);
        movieRepository.addMovie(newcustomer);
        return true;
    }

    @Override
    public boolean removeMovie(MovieDTO movie) {
        var exists = movieRepository.getMovieById((movie.getId()));
        if (exists != null) {
            return false;
        }
        var newcustomer = convertIntoNormal(movie);
        movieRepository.removeMovie(newcustomer);
        return true;
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
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
