package at.htl.model.kino;

import java.time.LocalDateTime;
import java.util.Date;

public class TicketDTO {
    private long id;
    private long showId;
    private long customerId;
    private String price ;
    private LocalDateTime purchase_date;

    public TicketDTO() {
    }

    public TicketDTO(long id, long showId, long customerId, String price) {
        this.id = id;
        this.showId = showId;
        this.customerId = customerId;
        this.price = price;
    }

    public LocalDateTime getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDateTime purchase_date) {
        this.purchase_date = purchase_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
