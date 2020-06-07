package com.vis.store.bundle.cart;


import com.vis.store.bundle.cart.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartDAO extends CrudRepository<Cart, Long> {


}
