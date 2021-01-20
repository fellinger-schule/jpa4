package at.htl.workloads.person;

import at.htl.workloads.adress.Address;
import at.htl.workloads.adress.AddressId;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    private String SSN;
    private LocalDate dateOfBirth;
    private String firstName;
    private String lastName;
    private Boolean isAwesome;
    private Float awesomeness;
    private BigDecimal wealth;

    @OneToMany(mappedBy = "id.person", cascade = CascadeType.PERSIST)
    private List<Address> addresses = new ArrayList<>();
    // getter and setter

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getAwesome() {
        return isAwesome;
    }

    public void setAwesome(Boolean awesome) {
        isAwesome = awesome;
    }

    public Float getAwesomeness() {
        return awesomeness;
    }

    public void setAwesomeness(Float awesomeness) {
        this.awesomeness = awesomeness;
    }

    public BigDecimal getWealth() {
        return wealth;
    }

    public void setWealth(BigDecimal wealth) {
        this.wealth = wealth;
    }

    public void addAddress(String city, String country, Long houseNo, String street) {
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
        this.addresses.add(address);
    }
}
