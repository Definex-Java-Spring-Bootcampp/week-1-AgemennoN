
package com.ecommerce.service.model.handlers;

import com.ecommerce.service.model.Cart;
import com.ecommerce.service.model.Order;
import com.ecommerce.service.model.User;
import com.ecommerce.service.model.factories.OrderFactory;
import java.util.ArrayList;
import java.util.List;

public class OrderHandler {
    public static List<Order> orderList = new ArrayList<>();
    
    public static Order purchaseCart(User user, String name, String phoneNumber, String address){
        Cart cart = user.getCart();
        cart.setIsOrdered(Boolean.TRUE);
        Order order = OrderFactory.createOrder(user, cart, name, phoneNumber, address);
        user.setCart(null); // Instead of null should have make an Empty Cart
        return order;
    }

    public static List<Order> getOrderList() {
        return orderList;
    }

    public static void setOrderList(List<Order> orderList) {
        OrderHandler.orderList = orderList;
    }
    
}
