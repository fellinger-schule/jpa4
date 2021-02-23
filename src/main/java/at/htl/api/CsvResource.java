package at.htl.api;

import at.htl.model.kino.PersonDTO;
import at.htl.workloads.person.PersonService;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.*;


@Path("/api/Csv")
public class CsvResource {




    private final PersonService personService;

    public CsvResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @Path("init")
    @Produces(MediaType.APPLICATION_JSON)
    public String fillData(){
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("Customer_Data.csv"));

            while((line = br.readLine()) != null){
                System.out.println(line);
                String[] Values = line.split(",");
                PersonDTO newp = new PersonDTO(Long.parseLong(Values[0]),Values[1]);
                personService.addPerson(newp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
