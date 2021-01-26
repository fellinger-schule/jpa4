package at.htl.workloads.customer;

import at.htl.model.kino.CustomerDTO;
import at.htl.model.person.PersonDTO;
import at.htl.workloads.person.PersonRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    public final CustomerRepository CustomerRepository;

    public CustomerServiceImpl(CustomerRepository cr) {
        this.CustomerRepository = cr;
    }

    @Override
    public Customer getCustomerById(long id) {
        return null;
    }

    @Override
    public boolean addCustomer(CustomerDTO customer) {
        var exists = CustomerRepository.getCustomerById((customer.getId()));
        if (exists != null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeCustomer(CustomerDTO customer) {
        return false;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }
}
