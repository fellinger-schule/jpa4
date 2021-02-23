package at.htl.workloads.person;

import at.htl.model.kino.PersonDTO;

import java.util.List;

public interface PersonService {
    boolean addPerson(PersonDTO newPerson);
    List<Person> getAllPeople();

}
