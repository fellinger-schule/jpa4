package at.htl.workloads.ticket;

import java.util.List;

public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository tr) {
        ticketRepository = tr;
    }

    @Override
    public Ticket getTicketById(long id) {
        return null;
    }

    @Override
    public boolean addTicket(Ticket ticket) {
        return false;
    }

    @Override
    public boolean removeTicket(Ticket ticket) {
        return false;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return null;
    }
}
