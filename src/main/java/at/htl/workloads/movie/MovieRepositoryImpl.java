package at.htl.workloads.movie;


import javax.persistence.EntityManager;
import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {
    private final EntityManager entityManager;

    public MovieRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Movie getMovieById(long id) {
        var query = entityManager.createQuery("select p from Movie p where p.id = :id", Movie.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void addMovie(Movie movie) {
        entityManager.persist(movie);
    }

    @Override
    public void removeMovie(Movie movie) {

    }

    @Override
    public List<Movie> getAllMovies() {
        var query = entityManager.createQuery("select p from Movie p", Movie.class);
        return query.getResultList();
    }
}
