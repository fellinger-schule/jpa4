package at.htl.workloads.movie;

public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository mr) {
        movieRepository = mr;
    }
}
