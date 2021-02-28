package at.htl.api;

import at.htl.model.kino.PersonDTO;
import at.htl.model.kino.ShowDTO;
import at.htl.workloads.person.Person;
import at.htl.workloads.show.Show;
import at.htl.workloads.show.ShowService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Path("/Show")
public class RescourceShow {
    private final ShowService showService;

    public RescourceShow(ShowService showService) {
        this.showService = showService;
    }

    @Transactional
    @GET
    @Path("ShowInit")
    @Produces(MediaType.TEXT_PLAIN)
    public String fillData(){
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("../src/main/java/at/htl/api/Csv/Show_Data.csv"));
            br.readLine();
            while((line = br.readLine()) != null){
                String[] Values = line.split(",");
                ShowDTO newS = new ShowDTO(Long.parseLong(Values[0]),Long.parseLong(Values[1]),Long.parseLong(Values[2]), Values[3]);

                showService.addShow(newS);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @Transactional
    @POST
    @Path("ShowAdd")
    public String AddData(ShowDTO newShow){
        showService.addShow(newShow);
        return "ok";
    }

    @Transactional
    @POST
    @Path("ShowDelete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String DeletData(@PathParam("id")long id){
        var ToDelete = showService.getShowById(id);
        if(ToDelete != null){
            showService.removeShow(id);
            return "ok";
        }
        return "not ok";
    }

    @Path("GetShow")
    @GET
    public List<Show> ShowList(){
        return showService.getAllShows();
    }

    @Path("GetShowByID/{id}")
    @GET
    public Show FindShow(@PathParam("id")long id){
        return showService.getShowById(id);
    }

}
