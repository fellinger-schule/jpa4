package at.htl.workloads;

public class AwesomePeopleCount {
    private Boolean isAwesome;
    private Long count;

    public AwesomePeopleCount(Boolean isAwesome, Long count) {
        this.isAwesome = isAwesome;
        this.count = count;
    }

    public Boolean getAwesome() {
        return isAwesome;
    }

    public void setAwesome(Boolean awesome) {
        isAwesome = awesome;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
