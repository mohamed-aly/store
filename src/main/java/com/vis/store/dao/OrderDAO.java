package com.vis.store.dao;

import com.vis.store.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDAO extends CrudRepository<Order, Long> {

}
