package at.htl.model.kino;
public class PersonDTO {
    private long id;
    private String name;

    public PersonDTO(String name) {
        this.name = name;
    }
    public PersonDTO(){}

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
}
