package at.htl;

import at.htl.model.person.PersonDTO;
import at.htl.workloads.adress.Address;
import at.htl.workloads.adress.AddressId;
import at.htl.workloads.person.Person;
import at.htl.workloads.person.PersonRepository;
import at.htl.workloads.person.PersonServiceImpl;
import org.testng.annotations.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.*;
import static org.assertj.core.api.Assertions.*;

public class PersonServiceTest {

    @Test
    public void addPerson_simple_success(){
        var dto = new PersonDTO();
        dto.setSSN("1234");
        dto.setDateOfBirth(LocalDate.now());
        dto.setFirstName("Horst");
        dto.setLastName("Fuchs");
        dto.setAwesome(true);
        dto.setAwesomeness(12.44f);
        dto.setWealth(BigDecimal.valueOf(200.45));

        var repoMock = Mockito.mock(PersonRepository.class);
        Mockito.when(repoMock.getPersonById(anyString())).thenReturn(null);
        ArgumentCaptor<Person> storedPerson = ArgumentCaptor.forClass(Person.class);

        var service = new PersonServiceImpl(repoMock);
        var res = service.addPerson(dto);

        assertThat(res).isTrue();
        Mockito.verify(repoMock, Mockito.times(1)).getPersonById(dto.getSSN());
        Mockito.verify(repoMock, Mockito.times(1)).addPerson(storedPerson.capture());
        var personEntity = storedPerson.getValue();
        assertThat(personEntity).isNotNull();
        assertThat(personEntity.getSSN()).isEqualTo(dto.getSSN());
        assertThat(personEntity.getDateOfBirth()).isEqualTo(dto.getDateOfBirth());
        assertThat(personEntity.getFirstName()).isEqualTo(dto.getFirstName());
        assertThat(personEntity.getLastName()).isEqualTo(dto.getLastName());
        assertThat(personEntity.getAwesome()).isEqualTo(dto.isAwesome());
        assertThat(personEntity.getAwesomeness()).isEqualTo(dto.getAwesomeness());
        assertThat(personEntity.getWealth()).isEqualTo(dto.getWealth());
    }

    @Test
    public void addPerson_already_exists(){
        var dto = new PersonDTO();
        dto.setSSN("1234");

        var repoMock = Mockito.mock(PersonRepository.class);
        Mockito.when(repoMock.getPersonById(dto.getSSN())).thenReturn(Mockito.mock(Person.class));

        var service = new PersonServiceImpl(repoMock);
        var res = service.addPerson(dto);

        assertThat(res).isFalse();
        Mockito.verify(repoMock, Mockito.times(1)).getPersonById(dto.getSSN());
        Mockito.verify(repoMock, Mockito.times(0)).addPerson(any(Person.class));
    }

    @Test
    public void addPerson_no_dto(){
        var repoMock = Mockito.mock(PersonRepository.class);

        var service = new PersonServiceImpl(repoMock);

        assertThatThrownBy(()->service.addPerson(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void addAddress_simple_success(){
        /*
        var address = new Address();
        var id = new AddressId();
        id.setPerson(this);
        var no = (short) (this.addresses.size()+1);
        id.setAddressNo(no);
        address.setId(id);
        address.setCity(city);
        address.setCountry(country);
        var hNo = (short) (long) houseNo;
        address.setStreetNo(hNo);
        address.setStreet(street);

        var person = this.personRepository.getPersonById(address.getPersonId());

       wie funktioniert mockito ?
        */
    }

}
