package at.htl.model.kino;
public class PersonDTO {
    private long id;
    private String name;

    public PersonDTO(){}

    public PersonDTO(String name) {
        this.name = name;
    }
    public PersonDTO(long id,String name){
        this.id = id;
        this.name = name;
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
}
