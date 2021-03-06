package at.htl.workloads.seatCategory;


import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
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
        entityManager.merge(seatCatigory);
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
