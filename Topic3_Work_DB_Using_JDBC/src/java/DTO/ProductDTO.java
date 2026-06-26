package DTO;

public class ProductDTO {
    private int productId;
    private String productName;
    private int productPrice;
    private String categoryName;

    public ProductDTO(int productId, String productName, int productPrice, String categoryName) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.categoryName = categoryName;
    }

    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    
}
