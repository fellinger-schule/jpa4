package at.htl.api;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


@Path("/api/Csv")
public class CsvResource {

    @Inject
    private EntityManager em ;

    @POST
    @Path("init")
    @Produces(MediaType.APPLICATION_JSON)
    public String fillData(){

    }
}
