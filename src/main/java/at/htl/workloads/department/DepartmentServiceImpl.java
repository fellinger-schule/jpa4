package at.htl.workloads.department;

import at.htl.model.kino.DepartmentDTO;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository dr) {
        departmentRepository = dr;
    }

    @Override
    public Department getDepartmentById(long id) {

        return null;
    }

    @Override
    public boolean addDepartment(DepartmentDTO dept) {
        var exists = departmentRepository.getDepartmentById(dept.getId());
        if (exists != null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeDepartment(DepartmentDTO dept) {
        return true;
    }

    @Override
    public List<Department> getAllDepartments() {
        return null;
    }
}
