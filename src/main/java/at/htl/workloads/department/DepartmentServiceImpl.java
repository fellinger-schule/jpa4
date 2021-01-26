package at.htl.workloads.department;

import at.htl.model.kino.CustomerDTO;
import at.htl.model.kino.DepartmentDTO;
import at.htl.workloads.customer.Customer;

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
        var newdept = convertIntoNormal(dept);
        departmentRepository.addDepartment(newdept);
        return true;
    }

    @Override
    public boolean removeDepartment(DepartmentDTO dept) {
        var exists = departmentRepository.getDepartmentById(dept.getId());
        if (exists != null) {
            return false;
        }
        var newdept = convertIntoNormal(dept);
        departmentRepository.removeDepartment(newdept);
        return true;
    }

    @Override
    public List<Department> getAllDepartments() {
        return null;
    }

    public Department convertIntoNormal(DepartmentDTO dept){
        var newdepartment = new Department();
        newdepartment.setId(dept.getId());
        newdepartment.setName(dept.getName());
        return newdepartment;
    }
}
