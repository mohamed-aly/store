package com.vis.store.service.orderItem;

import stationary.store.model.OrderItem;
import stationary.store.model.Product;

import java.util.List;


public interface OrderItemService {

    List<OrderItem> getOrderItems();

    void saveOrderItem(OrderItem theOrderItem);

    OrderItem getOrderItem(int theId);

    void deleteOrderItem(int theId);

    //////

    List<Product> getBestSellers(Integer limit);


}
