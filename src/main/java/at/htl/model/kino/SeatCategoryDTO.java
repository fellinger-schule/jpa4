package at.htl.model.kino;
public class SeatCategoryDTO {
    private long id;
    private String categoryName;
    private float price ;

    public SeatCategoryDTO() {
    }

    public SeatCategoryDTO(long id, String categoryName, float price) {
        this.id = id;
        this.categoryName = categoryName;
        this.price = price;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
