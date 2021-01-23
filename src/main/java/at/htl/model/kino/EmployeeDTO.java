package at.htl.model.kino;
public class EmployeeDTO {
    private long id;
    private long departmentId;
    private float salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(long id, long departmentId, float salary) {
        this.id = id;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
