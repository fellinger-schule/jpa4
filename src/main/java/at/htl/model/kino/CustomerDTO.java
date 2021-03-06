package at.htl.model.kino;
public class CustomerDTO {
    private long id;

    private String name;
    private boolean isPrimeMember;
    private int numberOfVisits;

    public CustomerDTO(){

    }

    public CustomerDTO(long id,String name, boolean isPrimeMember,int numberOfVisits){
        this.id=id;
        this.name = name;
        this.isPrimeMember=isPrimeMember;
        this.numberOfVisits=numberOfVisits;
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
