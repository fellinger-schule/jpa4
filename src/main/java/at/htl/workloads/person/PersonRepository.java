package at.htl.workloads.person;

import at.htl.workloads.AwesomePeopleCount;

import java.util.List;

public interface PersonRepository {
    Person getPersonById(String ssn);
    void addPerson(Person person);
    List<Person> getAllPeople();
    List<Object[]> getAllPeopleWithAddresses();
    List<Object[]> getCityNames();
    List<AwesomePeopleCount> getAwesomePeopleCount();
}
