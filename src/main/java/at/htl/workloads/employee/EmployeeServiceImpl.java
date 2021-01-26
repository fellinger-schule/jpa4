package at.htl.workloads.employee;

import at.htl.workloads.person.PersonRepository;

public class EmployeeServiceImpl implements EmployeeService{
     private final EmployeeRepository employeeRepositor;

    public EmployeeServiceImpl(EmployeeRepository er) {
        employeeRepositor = er ;
    }
}


