package at.htl.api;

import at.htl.model.kino.PersonDTO;
import at.htl.workloads.person.Person;
import at.htl.workloads.person.PersonService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.List;


@Path("/Person")
public class ResourcePerson {

    private final PersonService personService;

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
                PersonDTO newP = new PersonDTO(Values[1]);

                personService.addPerson(newP);
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
    @Path("PersonAdd")
    public String AddData(PersonDTO newPerson){
        personService.addPerson(newPerson);
        return "ok";
    }

    @Transactional
    @POST
    @Path("PersonDelete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String DeletData(@PathParam("id")long id){
        var ToDelete = personService.getPersonById(id);
        if(ToDelete != null){
            personService.deletePerson(id);
            return "ok";
        }
        return "not ok";
    }

    @Path("GetPersons")
    @GET
    public List<Person> PersonList(){
        return personService.getAllPeople();
    }

    @Path("GetPersonByID/{id}")
    @GET
    public Person FindPerson(@PathParam("id")long id){
        return personService.getPersonById(id);
    }

}
