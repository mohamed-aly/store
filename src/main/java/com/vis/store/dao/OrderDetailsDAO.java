package com.vis.store.dao;

import com.vis.store.model.OrderDetails;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsDAO extends CrudRepository<OrderDetails, Long> {

}
