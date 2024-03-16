
package com.ecommerce.service.model.factories;

import com.ecommerce.service.model.Cart;
import com.ecommerce.service.model.Order;
import com.ecommerce.service.model.User;
import com.ecommerce.service.model.handlers.OrderHandler;

public class OrderFactory {

    public static Order createOrder(User user, Cart cart, String name, String phoneNumber, String address){
        Integer orderId = OrderHandler.getOrderList().size() + 1;
        Order order = new Order(orderId, user, cart, name, phoneNumber, address);
        OrderHandler.getOrderList().add(order);
        return order;
    }
}
