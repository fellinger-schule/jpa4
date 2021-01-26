package at.htl.model.kino;
public class SeatDTO {
    private long id;
    private String categoryName;
    private long hallId;
    private boolean taken;

    public SeatDTO() {
    }

    public SeatDTO(long id, String categoryName, long hallId) {
        this.id = id;
        this.categoryName = categoryName;
        this.hallId = hallId;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getHallId() {
        return hallId;
    }

    public void setHallId(long hallId) {
        this.hallId = hallId;
    }
}
