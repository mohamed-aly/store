package com.vis.store.bundle.orderItem;

import com.vis.store.bundle.orderItem.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemDAO extends CrudRepository<OrderItem, Long> {

}
