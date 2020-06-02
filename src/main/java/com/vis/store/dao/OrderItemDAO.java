package com.vis.store.dao;

import com.vis.store.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemDAO extends CrudRepository<OrderItem, Long> {

}
