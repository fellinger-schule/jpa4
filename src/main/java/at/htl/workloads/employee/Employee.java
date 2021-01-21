package at.htl.workloads.employee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    /*TODO Wie regeln wir die Ids für Person to Employee? */

    @Id
    private long id;
    private long departmentId;
    private float salary;

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
