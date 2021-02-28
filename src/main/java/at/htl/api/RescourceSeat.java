package at.htl.api;

import at.htl.model.kino.HallDTO;
import at.htl.model.kino.SeatDTO;
import at.htl.workloads.hall.Hall;
import at.htl.workloads.seat.Seat;
import at.htl.workloads.seat.SeatService;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Path("/Seat")
public class RescourceSeat {
    private final SeatService seatService;

    public RescourceSeat(SeatService seatService) {
        this.seatService = seatService;
    }

    @Transactional
    @GET
    @Path("SeatInit")
    @Produces(MediaType.TEXT_PLAIN)
    public String fillData(){
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("../src/main/java/at/htl/api/Csv/Seat_Data.csv"));
            br.readLine();
            while((line = br.readLine()) != null){
                String[] Values = line.split(",");
                SeatDTO newS = new SeatDTO(Long.parseLong(Values[0]),Values[1],Integer.parseInt(Values[2]));

                seatService.AddSeat(newS);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @Path("GetSeat")
    @GET
    public List<Seat> HallList(){
        return seatService.getAllSeats();
    }

    @Path("GetSeatByID/{id}")
    @GET
    public Seat FindSeat(@PathParam("id")long id){
        return seatService.getSeatById(id);
    }

}
