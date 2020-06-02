package com.vis.store.dao.orderDetails;

import stationary.store.model.OrderDetails;

import java.util.List;

public interface OrderDetailsDAO {

    List<OrderDetails> getOrdersDetails();

    void saveOrderDetails(OrderDetails OrderDetails);

    OrderDetails getOrderDetails(int id);

    void deleteOrderDetails(int id);

}
