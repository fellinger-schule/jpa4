package at.htl.workloads.ticket;

import at.htl.model.kino.TicketDTO;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository tr) {
        ticketRepository = tr;
    }

    @Override
    public Ticket getTicketById(long id) {
        return ticketRepository.getTicketById(id);
    }

    @Override
    public boolean addTicket(TicketDTO ticket) {
        var exists = ticketRepository.getTicketById((ticket.getId()));
        if (exists != null) {
            return false;
        }
        var newshow = convertIntoNormal(ticket);
        ticketRepository.addTicket(newshow);
        return true;
    }

    @Override
    public boolean removeTicket(long id) {
        var exists = ticketRepository.getTicketById(id);
        if (exists != null) {
            return false;
        }
        ticketRepository.removeTicket(exists);
        return true;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.getAllTickets();
    }

    public Ticket convertIntoNormal(TicketDTO ticket){
        var newticket = new Ticket();
        newticket.setCustomerId(ticket.getCustomerId());
        newticket.setId(ticket.getId());
        newticket.setMovieId(ticket.getMovieId());
        newticket.setPrice(ticket.getPrice());
        newticket.setPurchase_date(ticket.getPurchase_date());
        return newticket;
    }
}
