package com.vis.store.service.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stationary.store.dao.cart.CartDAO;
import stationary.store.model.Cart;

import java.util.List;


@Service
public class CartServiceImpl implements CartService {

    // need to inject Cart dao
    @Autowired
    private CartDAO cartDAO;

    @Override
    @Transactional
    public List<Cart> getCarts() {
        return cartDAO.getCarts();
    }

    @Override
    @Transactional
    public void saveCart(Cart theCart) {

        cartDAO.saveCart(theCart);
    }

    @Override
    @Transactional
    public Cart getCart(int theId) {

        return cartDAO.getCart(theId);
    }

    @Override
    @Transactional
    public void deleteCart(int theId) {

        cartDAO.deleteCart(theId);
    }
}





