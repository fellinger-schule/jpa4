package at.htl.workloads.employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmpById(long id);
    boolean addEmp(Employee employee);
    boolean removeEmp(Employee employee);
    List<Employee> getAllEmployees();
}
