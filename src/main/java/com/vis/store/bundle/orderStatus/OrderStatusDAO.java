package com.vis.store.bundle.orderStatus;

import com.vis.store.bundle.orderStatus.OrderStatus;
import org.springframework.data.repository.CrudRepository;

public interface OrderStatusDAO extends CrudRepository<OrderStatus, Long> {

}
