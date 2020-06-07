package com.vis.store.bundle.cartItem;

import com.vis.store.bundle.cartItem.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemDAO extends CrudRepository<CartItem, Long> {


}
