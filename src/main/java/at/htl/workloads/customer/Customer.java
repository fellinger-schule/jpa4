package at.htl.workloads.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    /*TODO Wie regeln wir die Ids für Person to Customer? */
    @Id
    private long id;
    private boolean isPrimeMember;
    private int numberOfVisits;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

