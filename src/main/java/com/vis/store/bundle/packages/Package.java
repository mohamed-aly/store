package com.vis.store.bundle.packages;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vis.store.bundle.BaseEntity;
import com.vis.store.bundle.grade.Grade;
import com.vis.store.bundle.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "package")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Package extends BaseEntity {


    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "grade_id")
    @JsonBackReference
    private Grade grade;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;
}
