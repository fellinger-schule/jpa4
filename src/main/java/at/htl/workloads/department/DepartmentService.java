package at.htl.workloads.department;

import at.htl.model.kino.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    Department getDepartmentById(long id);
    boolean addDepartment(DepartmentDTO dept);
    boolean removeDepartment(DepartmentDTO dept);
    List<Department> getAllDepartments();
}
