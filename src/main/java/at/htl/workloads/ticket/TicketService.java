package at.htl.workloads.ticket;

import at.htl.model.kino.TicketDTO;

import java.util.List;

public interface TicketService {
    Ticket getTicketById(long id);
    boolean addTicket(TicketDTO ticket);
    boolean removeTicket(long id);
    List<Ticket> getAllTickets();
}
