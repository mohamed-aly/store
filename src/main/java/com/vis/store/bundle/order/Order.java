package com.vis.store.bundle.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vis.store.bundle.BaseEntity;
import com.vis.store.bundle.orderItem.OrderItem;
import com.vis.store.bundle.orderStatus.OrderStatus;
import com.vis.store.bundle.shipper.Shipper;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "orders")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Order extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_status_id")
    @JsonBackReference(value="order-orderStatus")
    private OrderStatus orderStatus;

    @Column(name = "submit_date")
    private Date sumbitDate;

    @Column(name = "estimated_days")
    private int estDelieveryDays;

    @Column(name = "delivery_date")
    private Date delieveryDate;

    @Column(name = "last_status_update_date")
    private Date lastUpdateDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference(value="orderItem-order")
    private Set<OrderItem> orderItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipper_id")
    @JsonBackReference(value="shipper-order")
    private Shipper shipper;
}
