package at.htl.workloads.department;

import at.htl.workloads.person.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final EntityManager entityManager;

    public DepartmentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Department getDepartmentById(long id) {
        var query = entityManager.createQuery("select p from Department p where p.id = :id", Department.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void addDepartment(Department dept) {
        entityManager.persist(dept);
    }

    @Override
    public void removeDepartment(Department dept) {
        entityManager.remove(dept);
    }

    @Override
    public List<Department> getAllDepartments() {
        var query = entityManager.createQuery("select p from Department p", Department.class);
        return query.getResultList();
    }
}
