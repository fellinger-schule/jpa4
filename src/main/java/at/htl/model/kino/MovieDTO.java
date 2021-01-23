package at.htl.model.kino;
public class MovieDTO {
    private long id;
    private String name;
    private float rating ;
    private float duration ;

    public MovieDTO() {
    }

    public MovieDTO(long id, String name, float rating, float duration) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
