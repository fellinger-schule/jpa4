package at.htl.workloads.person;

import java.util.List;

public interface PersonRepository {
    Person getPersonById(long id);
    void addPerson(Person person);
    List<Person> getAllPeople();
    void deletePerson(long id);
}
