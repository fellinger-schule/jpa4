package at.htl.workloads.employee;

import at.htl.workloads.person.PersonRepository;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
     private final EmployeeRepository employeeRepositor;

    public EmployeeServiceImpl(EmployeeRepository er) {
        employeeRepositor = er ;
    }

    @Override
    public Employee getEmpById(long id) {
        return null;
    }

    @Override
    public boolean addEmp(Employee employee) {
        return false;
    }

    @Override
    public boolean removeEmp(Employee employee) {
        return false;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }
}


