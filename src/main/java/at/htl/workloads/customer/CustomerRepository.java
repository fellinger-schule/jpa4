package at.htl.workloads.customer;

import java.util.List;

public interface CustomerRepository {
    Customer getCustomerById(long id);
    void addCustomer(Customer customer);
    void removeCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
