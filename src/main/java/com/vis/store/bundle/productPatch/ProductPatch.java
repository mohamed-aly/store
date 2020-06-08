package com.vis.store.bundle.productPatch;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vis.store.bundle.BaseEntity;
import com.vis.store.bundle.product.Product;
import com.vis.store.bundle.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "product_patch")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductPatch extends BaseEntity {


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "purchasing_price")
    private double purchasePrice;

    @Column(name = "selling_price")
    private double sellPrice;


    @Column(name = "date_in")
    private Date dateIn;

}
