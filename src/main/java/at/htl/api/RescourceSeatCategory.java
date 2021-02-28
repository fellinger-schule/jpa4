package at.htl.api;

import at.htl.model.kino.SeatCategoryDTO;
import at.htl.model.kino.SeatDTO;
import at.htl.workloads.seat.Seat;
import at.htl.workloads.seatCategory.SeatCategory;
import at.htl.workloads.seatCategory.SeatCatigory;

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

@Path("/SeatCategory")
public class RescourceSeatCategory {
    private final SeatCategory seatCategory;

    public RescourceSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }


    @Transactional
    @GET
    @Path("SeatCategoryInit")
    @Produces(MediaType.APPLICATION_JSON)
    public String fillData(){
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("../src/main/java/at/htl/api/Csv/SeatCatagory_Data.csv"));
            br.readLine();
            while((line = br.readLine()) != null){
                String[] Values = line.split(",");
                SeatCategoryDTO newS = new SeatCategoryDTO(Long.parseLong(Values[0]),Values[1],Values[2]);

                seatCategory.addSeatCat(newS);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @Path("GetSeatCategory")
    @GET
    public List<SeatCatigory> SeatCatigoryList(){
        return seatCategory.getAllSeatCat();
    }

    @Path("GetSeatCatigoryByID/{id}")
    @GET
    public SeatCatigory FindSeatCatigory(@PathParam("id")long id){
        return seatCategory.getSeatCatById(id);
    }

}
