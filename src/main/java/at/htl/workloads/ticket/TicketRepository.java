package at.htl.workloads.ticket;

import java.util.List;

public interface TicketRepository {
    Ticket getTicketById(long id);
    void addTicket(Ticket ticket);
    void removeTicket(Ticket ticket);
    List<Ticket> getAllTickets();

}
