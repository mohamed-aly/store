package com.vis.store.bundle.cart;


import com.vis.store.bundle.cart.Cart;

import java.util.Set;

public interface CartService {

    Cart save(Cart cart);

    Cart findById(Long l);

    Set<Cart> findAll();

    void deleteById(Long idToDelete);

}
