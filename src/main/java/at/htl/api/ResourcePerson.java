package at.htl.api;

import at.htl.model.kino.PersonDTO;
import at.htl.workloads.hall.HallService;
import at.htl.workloads.person.PersonService;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.*;


@Path("/api/Csv")
public class ResourcePerson {




    PersonService personService;

    public ResourcePerson(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @Path("PersonInit")
    @Produces(MediaType.APPLICATION_JSON)
    public String fillData(){
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lorda\\Desktop\\Jpa4\\src\\main\\java\\at\\htl\\api\\Csv\\Person_Data.csv"));
            br.readLine();
            while((line = br.readLine()) != null){
                String[] Values = line.split(",");
                PersonDTO newP = new PersonDTO(Long.parseLong(Values[0]),Values[1]);

                personService.addPerson(newP);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "ook";
    }


}
