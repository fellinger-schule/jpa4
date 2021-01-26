package at.htl.workloads.department;

public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository dr) {
        departmentRepository = dr;
    }
}
