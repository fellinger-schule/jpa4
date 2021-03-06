package at.htl.workloads.customer;

import at.htl.workloads.person.Person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer extends Person {
    private boolean isPrimeMember;
    private int numberOfVisits;

    public boolean isPrimeMember() {
        return isPrimeMember;
    }

    public void setPrimeMember(boolean primeMember) {
        isPrimeMember = primeMember;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(int numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }
}


