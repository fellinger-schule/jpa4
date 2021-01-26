package at.htl.workloads.employee;

import at.htl.model.kino.DepartmentDTO;
import at.htl.model.kino.EmployeeDTO;
import at.htl.workloads.department.Department;
import at.htl.workloads.person.PersonRepository;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
     private final EmployeeRepository employeeRepositor;

    public EmployeeServiceImpl(EmployeeRepository er) {
        employeeRepositor = er ;
    }

    @Override
    public Employee getEmpById(long id) {
        return employeeRepositor.getEmpById(id);
    }

    @Override
    public boolean addEmp(EmployeeDTO employee) {

        var exists = employeeRepositor.getEmpById(employee.getId());
        if (exists != null) {
            return false;
        }
        var newemp = convertIntoNormal(employee);
        employeeRepositor.addEmp(newemp);
        return true;
    }

    @Override
    public boolean removeEmp(EmployeeDTO employee) {
        var exists = employeeRepositor.getEmpById(employee.getId());
        if (exists != null) {
            return false;
        }
        var newemp = convertIntoNormal(employee);
        employeeRepositor.removeEmp(newemp);
        return true;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepositor.getAllEmployees();
    }

    public Employee convertIntoNormal(EmployeeDTO emp){
        var newemp = new Employee();
        newemp.setDepartmentId(emp.getDepartmentId());
        newemp.setId(emp.getId());
        newemp.setSalary(emp.getSalary());
        return newemp;
    }
}


