package at.htl.workloads.employee;

import at.htl.workloads.person.Person;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;

@Entity
public class Employee extends Person {
    /*TODO Wie regeln wir die Ids für Person to Employee? */

    private long departmentId;
    private float salary;

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
