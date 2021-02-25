package at.htl.workloads.seat;


import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class SeatRepositoryImpl implements SeatRepository{
    private final EntityManager entityManager;

    public SeatRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Seat getSeatById(long id) {
        var query = entityManager.createQuery("select p from Seat p where p.id = :id", Seat.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void AddSeat(Seat seat) {
        entityManager.merge(seat);
    }

    @Override
    public void RemoveSeat(Seat seat) {
        entityManager.remove(seat);

    }

    @Override
    public List<Seat> getAllSeats() {
        var query = entityManager.createQuery("select p from Seat p", Seat.class);
        return query.getResultList();
    }
}
