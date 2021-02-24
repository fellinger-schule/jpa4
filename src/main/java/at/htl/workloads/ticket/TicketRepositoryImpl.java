package at.htl.workloads.ticket;


import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class TicketRepositoryImpl implements TicketRepository {
    private final EntityManager entityManager;

    public TicketRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Ticket getTicketById(long id) {
        var query = entityManager.createQuery("select p from Ticket p where p.id = :id", Ticket.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void addTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Override
    public void removeTicket(Ticket ticket) {
        entityManager.remove(ticket);

    }

    @Override
    public List<Ticket> getAllTickets() {
        var query = entityManager.createQuery("select p from Ticket p", Ticket.class);
        return query.getResultList();    }
}
