package at.htl.api;

import at.htl.model.kino.CustomerDTO;
import at.htl.model.kino.PersonDTO;
import at.htl.workloads.customer.Customer;
import at.htl.workloads.customer.CustomerService;
import at.htl.workloads.person.Person;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Path("/Customer")
public class RescourceCustomer {
    private final CustomerService customerService;

    public RescourceCustomer(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Transactional
    @GET
    @Path("CustomerInit")
    @Produces(MediaType.TEXT_PLAIN)
    public String fillData(){
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("../src/main/java/at/htl/api/Csv/Customer_Data2.csv"));
            br.readLine();
            while((line = br.readLine()) != null){
                String[] Values = line.split(",");
                CustomerDTO newC = new CustomerDTO(Integer.parseInt(Values[0]),Values[1], Boolean.parseBoolean(Values[2]),Integer.parseInt(Values[3]));

                customerService.addCustomer(newC);
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
    @Path("CustomerAdd")
    public String AddData(CustomerDTO newCustomer){
        customerService.addCustomer(newCustomer);
        return "ok";
    }

    @Transactional
    @DELETE
    @Path("CustomerDelete/{id}")
    public Response.Status DeletData(@PathParam("id")long id){
        var ToDelete = customerService.getCustomerById(id);
        if(ToDelete != null){
            customerService.removeCustomer(id);
            return Response.Status.OK;
        }
        return Response.Status.BAD_REQUEST;
    }

    @Path("GetCustomer")
    @GET
    public List<Customer> CustomerList(){
        return customerService.getAllCustomers();
    }

    @Path("GetCustomerByID/{id}")
    @GET
    public Customer FindCustomer(@PathParam("id")long id){
        return customerService.getCustomerById(id);
    }

}
