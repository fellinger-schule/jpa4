package at.htl.workloads.adress;

import at.htl.workloads.person.Person;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AddressId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ssn")
    private Person person;
    private Short addressNo;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Short getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(Short addressNo) {
        this.addressNo = addressNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressId addressId = (AddressId) o;
        return Objects.equals(person.getSSN(), addressId.person.getSSN()) &&
                Objects.equals(addressNo, addressId.addressNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person.getSSN(), addressNo);
    }
}
