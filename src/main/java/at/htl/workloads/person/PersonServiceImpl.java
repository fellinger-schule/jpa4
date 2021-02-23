package at.htl.workloads.person;

import at.htl.model.kino.PersonDTO;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public boolean addPerson(PersonDTO newPerson) {
        var existingPerson = personRepository.getPersonById(newPerson.getId());
        if (existingPerson != null) {
            return false;
        }

        var person = new Person();
        person.setId(newPerson.getId());
        person.setName(newPerson.getName());
        personRepository.addPerson(person);
        return true;
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.getAllPeople();
    }

}
