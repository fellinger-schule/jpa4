package at.htl.api;

import at.htl.model.kino.PersonDTO;
import at.htl.model.kino.TicketDTO;
import at.htl.workloads.person.Person;
import at.htl.workloads.ticket.Ticket;
import at.htl.workloads.ticket.TicketService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Path("/Ticket")
public class RescourceTicket {
    private final TicketService ticketService;

    public RescourceTicket(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Transactional
    @GET
    @Path("TicketInit")
    @Produces(MediaType.APPLICATION_JSON)
    public String fillData(){
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lorda\\Desktop\\Jpa4\\src\\main\\java\\at\\htl\\api\\Csv\\Person_Data.csv"));
            br.readLine();
            while((line = br.readLine()) != null){
                String[] Values = line.split(",");
                TicketDTO newT = new TicketDTO(Long.parseLong(Values[0]),Long.parseLong(Values[1]),Long.parseLong(Values[2]),Float.parseFloat(Values[3]));

                ticketService.addTicket(newT);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "ook";
    }

    @Transactional
    @POST
    @Path("TicketAdd")
    public String AddData(TicketDTO newTicket){
        ticketService.addTicket(newTicket);
        return "ok";
    }

    @Transactional
    @POST
    @Path("TicketDelete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String DeletData(@PathParam("id")long id){
        var ToDelete = ticketService.getTicketById(id);
        if(ToDelete != null){
            ticketService.removeTicket(id);
            return "ok";
        }
        return "not ok";
    }

    @Path("GetTicket")
    @GET
    public List<Ticket> TicketList(){
        return ticketService.getAllTickets();
    }

    @Path("GetTicketByID/{id}")
    @GET
    public Ticket FindTicket(@PathParam("id")long id){
        return ticketService.getTicketById(id);
    }

}
