package at.htl.workloads.employee;

import at.htl.model.kino.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    Employee getEmpById(long id);
    boolean addEmp(EmployeeDTO employee);
    boolean removeEmp(long id);
    List<Employee> getAllEmployees();
}
