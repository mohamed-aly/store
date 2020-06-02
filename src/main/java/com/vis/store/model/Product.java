package com.vis.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "product")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "min_stock")
    private int minStock;


    @OneToMany(mappedBy = "product",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JsonManagedReference
    private Set<OrderItem> orders;

    @OneToMany(
            cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<ProductImage> imageUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CartItem> cartItems;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonManagedReference
    @OrderBy("dateIn")
    @Where(clause = "quantity > 0")
    private Set<ProductPatch> patches;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    @OrderBy("endDate desc")
    @Where(clause = "end_date > sysdate()")
    private Set<Offer> offers;

    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ClassifiedProduct> packages;

    public Product() {
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public Set<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderItem> orders) {
        this.orders = orders;
    }

    public Set<ProductImage> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Set<ProductImage> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Set<ProductPatch> getPatches() {
        return patches;
    }

    public void setPatches(Set<ProductPatch> patches) {
        this.patches = patches;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public Set<ClassifiedProduct> getPackages() {
        return packages;
    }

    public void setPackages(Set<ClassifiedProduct> packages) {
        this.packages = packages;
    }
}
