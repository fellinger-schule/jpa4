package at.htl.workloads.customer;

import at.htl.model.kino.CustomerDTO;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(long id);
    boolean addCustomer(CustomerDTO customer);
    boolean removeCustomer(CustomerDTO customer);
    List<Customer> getAllCustomers();
}
