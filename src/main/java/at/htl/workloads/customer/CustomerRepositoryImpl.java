package at.htl.workloads.customer;

import at.htl.workloads.person.Person;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class CustomerRepositoryImpl implements CustomerRepository{
    private final EntityManager entityManager;

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Customer getCustomerById(long id) {
        var query = entityManager.createQuery("select p from Customer p where p.id = :id", Customer.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }


    @Override
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        entityManager.remove(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        var query = entityManager.createQuery("select p from Customer p", Customer.class);
        return query.getResultList();
    }
}
