package at.htl.workloads.show;


import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class ShowRepositoryImpl implements ShowRepository {
    private final EntityManager entityManager;

    public ShowRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Show getShowById(long id) {
        var query = entityManager.createQuery("select p from Show p where p.id = :id", Show.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void addShow(Show show) {
        entityManager.persist(show);
    }

    @Override
    public void removeShow(Show show) {
        entityManager.remove(show);

    }

    @Override
    public List<Show> getAllShows() {
        var query = entityManager.createQuery("select p from Show p", Show.class);
        return query.getResultList();
    }
}
