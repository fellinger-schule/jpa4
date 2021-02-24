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
    public void addPerson(PersonDTO newPerson) {
        var existingPerson = personRepository.getPersonById(newPerson.getId());
        if (existingPerson != null) {

        }
        else {
            var person = new Person();
            person.setId(newPerson.getId());
            person.setName(newPerson.getName());
            personRepository.addPerson(person);
        }
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.getAllPeople();
    }


    public Person getPersonById(long id) {return personRepository.getPersonById(id);}

    @Override
    public void deletePerson(long id) {
        var existingPerson = personRepository.getPersonById(id);
        if (existingPerson != null) {

            personRepository.deletePerson(id);
        }

    }
}
