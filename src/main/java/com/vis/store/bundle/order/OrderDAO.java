package com.vis.store.bundle.order;

import com.vis.store.bundle.order.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDAO extends CrudRepository<Order, Long> {

}
