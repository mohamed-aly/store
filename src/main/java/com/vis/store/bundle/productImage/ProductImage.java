package com.vis.store.bundle.productImage;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vis.store.bundle.BaseEntity;
import com.vis.store.bundle.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "product_images")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductImage extends BaseEntity {

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;



}
