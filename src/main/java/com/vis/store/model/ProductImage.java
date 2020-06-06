package com.vis.store.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "product_images")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductImage extends BaseEntity {



    @Column(name = "image_url")
    private String imageUrl;



}
