package at.htl.api;

import at.htl.model.kino.EmployeeDTO;
import at.htl.model.kino.PersonDTO;
import at.htl.workloads.employee.Employee;
import at.htl.workloads.employee.EmployeeService;
import at.htl.workloads.person.Person;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Path("/Employee")
public class RescourceEmployee {
    private final EmployeeService employeeService;

    public RescourceEmployee(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Transactional
    @GET
    @Path("EmployeeInit")
    @Produces(MediaType.TEXT_PLAIN)
    public String fillData(){
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("../src/main/java/at/htl/api/Csv/Employee_Data.csv"));
            br.readLine();
            while((line = br.readLine()) != null){
                String[] Values = line.split(",");
                EmployeeDTO newE = new EmployeeDTO(Long.parseLong(Values[0]),Long.parseLong(Values[1]),Float.parseFloat(Values[2]));

                employeeService.addEmp(newE);
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
    @Path("EmployeeAdd")
    public String AddData(EmployeeDTO newEmployee){
        employeeService.addEmp(newEmployee);
        return "ok";
    }

    @Transactional
    @POST
    @Path("EmployeeDelete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String DeletData(@PathParam("id")long id){
        var ToDelete = employeeService.getEmpById(id);
        if(ToDelete != null){
            employeeService.removeEmp(id);
            return "ok";
        }
        return "not ok";
    }

    @Path("GetEmployee")
    @GET
    public List<Employee> EmployeeList(){
        return employeeService.getAllEmployees();
    }

    @Path("GetPersonByID/{id}")
    @GET
    public Employee FindEmployee(@PathParam("id")long id){
        return employeeService.getEmpById(id);
    }

}
