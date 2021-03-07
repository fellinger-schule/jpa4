package at.htl.workloads.ticket;

import at.htl.model.kino.TicketDTO;
import at.htl.workloads.customer.Customer;
import at.htl.workloads.show.Show;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDateTime;
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
        var newshow = convertIntoNormal(ticket);
        ticketRepository.addTicket(newshow);
        return true;
    }

    @Override
    public boolean removeTicket(long id) {
        var exists = ticketRepository.getTicketById(id);
        if (exists == null) {
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
        var newTicket = new Ticket();

        var cust = new Customer();
        cust.setId(ticket.getCustomerId());
        var show = new Show();
        show.setId(ticket.getShowId());

        newTicket.setCustomer(cust);
        newTicket.setShow(show);

        newTicket.setPrice("10");
        newTicket.setPurchase_date(LocalDateTime.now());

        return newTicket;
    }
}
