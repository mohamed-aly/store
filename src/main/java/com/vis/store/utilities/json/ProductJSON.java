package com.vis.store.utilities.json;

import stationary.store.model.ProductImage;

import java.util.List;

public class ProductJSON {

    private int classifiedProductId;
    private int productId;
    private String productName;
    private String categoryName;
    private String description;
    private List<ProductImage> imageUrl;
    private double discount;
    private int minStock;

    public int getClassifiedProductId() {
        return classifiedProductId;
    }

    public void setClassifiedProductId(int classifiedProductId) {
        this.classifiedProductId = classifiedProductId;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductImage> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<ProductImage> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }
}
