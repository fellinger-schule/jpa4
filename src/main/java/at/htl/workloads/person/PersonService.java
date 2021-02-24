package at.htl.workloads.person;

import at.htl.model.kino.PersonDTO;

import java.util.List;

public interface PersonService {
    void addPerson(PersonDTO newPerson);
    List<Person> getAllPeople();
    Person getPersonById(long id);
    void deletePerson(long id);
}
