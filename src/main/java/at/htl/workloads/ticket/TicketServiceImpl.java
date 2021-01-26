package at.htl.workloads.ticket;

public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository tr) {
        ticketRepository = tr;
    }
}
