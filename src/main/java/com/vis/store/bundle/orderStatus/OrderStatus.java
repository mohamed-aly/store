package com.vis.store.bundle.orderStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vis.store.bundle.BaseEntity;
import com.vis.store.bundle.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "order_status")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderStatus extends BaseEntity {

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "orderStatus",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JsonManagedReference(value="order-orderStatus")
    private Set<Order> orders;

}
