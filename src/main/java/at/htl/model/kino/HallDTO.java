package at.htl.model.kino;
public class HallDTO {
    private long id;
    private String location;
    private int numberOfSeats ;

    public HallDTO() {
    }

    public HallDTO(long id, String location, int numberOfSeats) {
        this.id = id;
        this.location = location;
        this.numberOfSeats = numberOfSeats;
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
