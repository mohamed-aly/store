package com.vis.store.dao;


import com.vis.store.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartDAO extends CrudRepository<Cart, Long> {


}
