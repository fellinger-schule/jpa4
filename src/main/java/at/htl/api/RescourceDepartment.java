package at.htl.api;

import at.htl.model.kino.DepartmentDTO;
import at.htl.model.kino.HallDTO;
import at.htl.workloads.department.Department;
import at.htl.workloads.department.DepartmentService;
import at.htl.workloads.hall.Hall;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Path("/Department")
public class RescourceDepartment {
    private final DepartmentService departmentService;

    public RescourceDepartment(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @Transactional
    @GET
    @Path("DepartmentInit")
    @Produces(MediaType.APPLICATION_JSON)
    public String fillData(){
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lorda\\Desktop\\Jpa4\\src\\main\\java\\at\\htl\\api\\Csv\\Department_Data.csv"));
            br.readLine();
            while((line = br.readLine()) != null){
                String[] Values = line.split(",");
                DepartmentDTO newD = new DepartmentDTO(Long.parseLong(Values[0]),Values[1]);

                departmentService.addDepartment(newD);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "ok Hall filled";
    }

    @Path("GetDepartment")
    @GET
    public List<Department> DepartmentList(){
        return departmentService.getAllDepartments();
    }

    @Path("GetDepartmentByID/{id}")
    @GET
    public Department FindDepartment(@PathParam("id")long id){
        return departmentService.getDepartmentById(Showid);
    }

}
