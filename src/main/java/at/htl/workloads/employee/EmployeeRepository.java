package at.htl.workloads.employee;

import java.util.List;

public interface EmployeeRepository {
    Employee getEmpById(long id);
    void addEmp(Employee employee);
    void removeEmp(Employee employee);
    List<Employee> getAllEmployees();

}
