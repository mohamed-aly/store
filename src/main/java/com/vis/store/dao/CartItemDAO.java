package com.vis.store.dao;

import com.vis.store.model.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemDAO extends CrudRepository<CartItem, Long> {


}
