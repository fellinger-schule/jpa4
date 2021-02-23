package at.htl.workloads.customer;

import at.htl.model.kino.CustomerDTO;

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
        var newcustomer = convertIntoNormal(customer);
        CustomerRepository.addCustomer(newcustomer);
        return true;
    }

    @Override
    public boolean removeCustomer(CustomerDTO customer) {
        var exists = CustomerRepository.getCustomerById((customer.getId()));
        if (exists != null) {
            return false;
        }
        var newcustomer = convertIntoNormal(customer);
        CustomerRepository.removeCustomer(newcustomer);
        return false;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    public Customer convertIntoNormal(CustomerDTO customer){
        var newcustomer = new Customer();
        newcustomer.setId(customer.getId());
        newcustomer.setNumberOfVisits(customer.getNumberOfVisits());
        newcustomer.setPrimeMember(customer.isPrimeMember());
        return newcustomer;
    }
}
