package at.htl.workloads.seatCategory;

import at.htl.workloads.employee.Employee;
import at.htl.workloads.person.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class SeatCategoryRepositoryImpl implements SeatCategoryRepository{
    private final EntityManager entityManager;

    public SeatCategoryRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public SeatCatigory  getSeatCatById(long id) {
        var query = entityManager.createQuery("select p from SeatCatigory p where p.id = :id", SeatCatigory.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);    }

    @Override
    public void addSeatCat(SeatCatigory seatCatigory) {
        entityManager.persist(seatCatigory);
    }

    @Override
    public void RemoveSeatCat(SeatCatigory seatCatigory) {
        entityManager.remove(seatCatigory);

    }

    @Override
    public List<SeatCatigory> getAllSeatCat() {
        var query = entityManager.createQuery("select p from SeatCatigory p", SeatCatigory.class);
        return query.getResultList();
    }
}
