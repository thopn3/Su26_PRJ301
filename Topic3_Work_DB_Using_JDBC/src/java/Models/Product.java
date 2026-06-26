
package Models;

public class Product {
    private int id;
    private String name;
    private int price;
    private int unitsInStock;
    private int categoryId;

    public Product() {
    }

    public Product(String name, int price, int unitsInStock, int categoryId) {
        this.name = name;
        this.price = price;
        this.unitsInStock = unitsInStock;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
