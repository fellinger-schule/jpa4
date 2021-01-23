package at.htl.model.kino;
public class CustomerDTO {
    private long id;
    private boolean isPrimeMember;
    private int numberOfVisits;

    public CustomerDTO(){

    }

    public CustomerDTO(long id,boolean isPrimeMember,int numberOfVisits){
        this.id=id;
        this.isPrimeMember=isPrimeMember;
        this.numberOfVisits=numberOfVisits;
    }

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
