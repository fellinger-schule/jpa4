package at.htl.workloads.ticket;

import java.util.List;

public interface TicketService {
    Ticket getTicketById(long id);
    boolean addTicket(Ticket ticket);
    boolean removeTicket(Ticket ticket);
    List<Ticket> getAllTickets();
}
