package com.vis.store.utilities.json;

import stationary.store.model.ProductImage;

import java.util.Set;

public class BestSellerJson {
    private int productId;
    private String productName;
    private String description;
    private Set<ProductImage> imageUrl;
    private int minStock;
    private double price;
    private double discount;

    public BestSellerJson(){

    }

    public BestSellerJson(int productId, String productName, String description, Set<ProductImage> imageUrl, int minStock, double price, double discount) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.minStock = minStock;
        this.price = price;
        this.discount = discount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ProductImage> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Set<ProductImage> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
