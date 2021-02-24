package at.htl.api;

import at.htl.model.kino.HallDTO;
import at.htl.workloads.hall.HallService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Path("/Hall")
public class RescourceHall {

    private final HallService hallservice;

    public RescourceHall(HallService hallservice) {
        this.hallservice = hallservice;
    }

    @GET
    @Path("HallInit")
    @Produces(MediaType.APPLICATION_JSON)
    public String fillData(){
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lorda\\Desktop\\Jpa4\\src\\main\\java\\at\\htl\\api\\Csv\\Hall_Data.csv"));
            br.readLine();
            while((line = br.readLine()) != null){
                String[] Values = line.split(",");
                HallDTO newH = new HallDTO(Long.parseLong(Values[0]),Values[1],Integer.parseInt(Values[2]));

                hallservice.addHall(newH);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "ok Hall filled";
    }
}
