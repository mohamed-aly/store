package com.vis.store.service.cart;


import com.vis.store.model.Cart;

import java.util.Set;

public interface CartService {

    Cart save(Cart cart);

    Cart findById(Long l);

    Set<Cart> findAll();

    void deleteById(Long idToDelete);

}
