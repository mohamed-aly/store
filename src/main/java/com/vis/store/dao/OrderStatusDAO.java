package com.vis.store.dao;

import com.vis.store.model.OrderStatus;
import org.springframework.data.repository.CrudRepository;

public interface OrderStatusDAO extends CrudRepository<OrderStatus, Long> {

}
