package com.vis.store.service.cartItem;

import stationary.store.model.CartItem;

import java.util.List;


public interface CartItemService {

    List<CartItem> getCartItems();

    void saveCartItem(CartItem theCartItem);

    CartItem getCartItem(int theId);

    void deleteCartItem(int theId);

}
