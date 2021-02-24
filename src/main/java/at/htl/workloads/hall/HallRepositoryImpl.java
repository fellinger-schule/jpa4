package at.htl.workloads.hall;

import at.htl.workloads.employee.Employee;
import at.htl.workloads.person.Person;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class HallRepositoryImpl implements HallRepository {
    private final EntityManager entityManager;

    public HallRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Hall getHallById(long id) {
        var query = entityManager.createQuery("select p from Hall p where p.id = :id", Hall.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void addHall(Hall hall) {
        entityManager.merge(hall);
    }

    @Override
    public void removeHall(Hall hall) {
        entityManager.remove(hall);
    }

    @Override
    public List<Hall> getAllHalls() {
        var query = entityManager.createQuery("select p from Hall p", Hall.class);
        return query.getResultList();
    }
}
