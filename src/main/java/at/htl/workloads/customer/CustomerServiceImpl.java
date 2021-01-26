package at.htl.workloads.customer;

import at.htl.workloads.person.PersonRepository;

public class CustomerServiceImpl implements CustomerService{
    public final CustomerRepository CustomerRepository;

    public CustomerServiceImpl(CustomerRepository cr) {
        this.CustomerRepository = cr;
    }

}
