package at.htl.workloads.person;

import at.htl.model.person.AddressDTO;
import at.htl.model.person.PersonDTO;
import at.htl.workloads.AwesomePeopleCount;

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
        var existingPerson = personRepository.getPersonById(newPerson.getSSN());
        if (existingPerson != null) {
            return false;
        }

        var person = new Person();
        person.setSSN(newPerson.getSSN());
        person.setDateOfBirth(newPerson.getDateOfBirth());
        person.setFirstName(newPerson.getFirstName());
        person.setLastName(newPerson.getLastName());
        person.setAwesome(newPerson.isAwesome());
        person.setAwesomeness(newPerson.getAwesomeness());
        person.setWealth(newPerson.getWealth());
        personRepository.addPerson(person);
        return true;
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.getAllPeople();
    }

    @Override
    public boolean addAddress(AddressDTO newAddress) {
        var person = this.personRepository.getPersonById(newAddress.getPersonId());
        person.addAddress(newAddress.getCity(), newAddress.getCountry(), newAddress.getHouseNo(), newAddress.getStreet());
        return true;
    }

    @Override
    public List<Object[]> getAllAddresses() {
        return personRepository.getAllPeopleWithAddresses();
    }

    @Override
    public List<Object[]> getCityNames() {
        return personRepository.getCityNames();
    }

    @Override
    public List<AwesomePeopleCount> getAwesomePeopleCount() {
        return personRepository.getAwesomePeopleCount();
    }
}
