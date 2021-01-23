package at.htl.workloads.employee;

import at.htl.workloads.department.Department;
import at.htl.workloads.person.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EntityManager entityManager;

    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee getEmpById(long id) {
        var query = entityManager.createQuery("select p from Employee p where p.id = :id", Employee.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void addEmp(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void removeEmp(Employee employee) {
        entityManager.remove(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        var query = entityManager.createQuery("select p from Employee p", Employee.class);
        return query.getResultList();
    }
}
