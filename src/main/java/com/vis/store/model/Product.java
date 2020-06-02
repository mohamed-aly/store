package com.vis.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
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


    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private Set<OrderItem> orders;

    @OneToMany(
            cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<ProductImage> imageUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
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

}
