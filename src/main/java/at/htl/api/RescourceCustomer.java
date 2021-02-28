package at.htl.api;

import at.htl.model.kino.CustomerDTO;
import at.htl.model.kino.PersonDTO;
import at.htl.workloads.customer.Customer;
import at.htl.workloads.customer.CustomerService;
import at.htl.workloads.person.Person;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
            BufferedReader br = new BufferedReader(new FileReader("../src/main/java/at/htl/api/Csv/Customer_Data.csv"));
            br.readLine();
            while((line = br.readLine()) != null){
                String[] Values = line.split(",");
                CustomerDTO newC = new CustomerDTO(Integer.parseInt(Values[0]),Boolean.parseBoolean(Values[1]),Integer.parseInt(Values[2]));

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
    @POST
    @Path("CustomerDelete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String DeletData(@PathParam("id")long id){
        var ToDelete = customerService.getCustomerById(id);
        if(ToDelete != null){
            customerService.removeCustomer(id);
            return "ok";
        }
        return "not ok";
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
