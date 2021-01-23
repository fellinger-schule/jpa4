package at.htl.workloads.department;

import at.htl.workloads.AwesomePeopleCount;
import at.htl.workloads.person.Person;

import java.util.List;

public interface DepartmentRepository {

    Department getDepartmentById(long id);
    void addDepartment(Department dept);
    void removeDepartment(Department dept);
    List<Department> getAllDepartments();

}
