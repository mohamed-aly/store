package com.vis.store.bundle.shipper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vis.store.bundle.BaseEntity;
import com.vis.store.bundle.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "shipper")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Shipper extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "shipping_fees")
    private double shippingFees;

    @Column(name = "status")
    private boolean active;

    @OneToMany(mappedBy = "shipper",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JsonManagedReference
    private List<Order> orders;

}