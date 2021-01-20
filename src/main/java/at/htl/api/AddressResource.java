package at.htl.api;

import at.htl.model.person.AddressDTO;
import at.htl.workloads.person.PersonRepository;
import at.htl.workloads.person.PersonService;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/address")
public class AddressResource {

    private final PersonService personService;

    public AddressResource(PersonService personService) {
        this.personService = personService;
    }

    @Transactional
    @POST
    public Response add(AddressDTO newAddress){
        if (newAddress == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        var result = personService.addAddress(newAddress);
        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAddresses(){
        var personAddresses = personService.getAllAddresses();
        return Response.ok(personAddresses).build();
    }


}
