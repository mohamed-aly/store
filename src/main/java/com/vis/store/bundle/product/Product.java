package com.vis.store.bundle.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vis.store.bundle.BaseEntity;
import com.vis.store.bundle.cartItem.CartItem;
import com.vis.store.bundle.category.Category;
import com.vis.store.bundle.offer.Offer;
import com.vis.store.bundle.orderItem.OrderItem;
import com.vis.store.bundle.packages.Package;
import com.vis.store.bundle.productImage.ProductImage;
import com.vis.store.bundle.productPatch.ProductPatch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Product extends BaseEntity {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonBackReference(value="category-product")
    private Category category;

    @Column(name = "name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "min_stock")
    private int minStock;


    @OneToMany(mappedBy = "product")
    @JsonManagedReference(value = "orderItem-product")
    private Set<OrderItem> orders;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference(value="productImage-product")
    private Set<ProductImage> imageUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonManagedReference(value="cartItem-product")
    private Set<CartItem> cartItems;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonManagedReference(value="productPatch-product")
    @OrderBy("dateIn")
    @Where(clause = "quantity > 0")
    private Set<ProductPatch> patches;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference(value="offer-product")
    @OrderBy("endDate desc")
    @Where(clause = "end_date > sysdate()")
    private Set<Offer> offers;

    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL)
    @JsonManagedReference(value="package-product")
    private Set<Package> packages;

    public Product(Long id, int minStock) {
        this.id=id;
        this.minStock=minStock;
    }
}
