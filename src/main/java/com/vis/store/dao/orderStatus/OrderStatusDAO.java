package com.vis.store.dao.orderStatus;

import stationary.store.model.OrderStatus;

import java.util.List;

public interface OrderStatusDAO {

    List<OrderStatus> getOrderStatuses();

    void saveOrderStatus(OrderStatus OrderStatus);

    OrderStatus getOrderStatus(int id);

    void deleteOrderStatus(int id);

}
