package at.htl.workloads.person;

import at.htl.model.person.AddressDTO;
import at.htl.model.person.PersonDTO;
import at.htl.workloads.AwesomePeopleCount;

import java.util.List;

public interface PersonService {
    boolean addPerson(PersonDTO newPerson);
    List<Person> getAllPeople();
    boolean addAddress(AddressDTO newAddress);
    List<Object[]> getAllAddresses();
    List<Object[]> getCityNames();
    List<AwesomePeopleCount> getAwesomePeopleCount();

/*
    Person getPersonById(String ssn);
    void addPerson(Person person);
    List<Person> getAllPeople();
    List<Object[]> getAllPeopleWithAddresses();
    List<Object[]> getCityNames();
    List<AwesomePeopleCount> getAwesomePeopleCount();*/
}
