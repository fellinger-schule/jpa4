package at.htl.workloads.hall;

import javax.persistence.*;

@Entity
public class Hall {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String location;
    private int numberOfSeats;

    public Hall() {
    }

    public Hall(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
