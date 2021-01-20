package at.htl.workloads.adress;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Address {

    @EmbeddedId
    private AddressId id;
    private String country;
    private String city;
    private String street;
    private Short streetNo;


    public AddressId getId() {
        return id;
    }

    public void setId(AddressId id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Short getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(Short streetNo) {
        this.streetNo = streetNo;
    }
}
