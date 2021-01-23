package at.htl.model.kino;
public class TicketDTO {
    private long id;
    private long movieId;
    private long customerId;
    private float price ;

    public TicketDTO() {
    }

    public TicketDTO(long id, long movieId, long customerId, float price) {
        this.id = id;
        this.movieId = movieId;
        this.customerId = customerId;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
