
package com.ecommerce.service.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
        private final Integer orderId;
        private final User user;  // User Mail address or UserId might be better
        private final Cart cart;
        private String name;        // might be different from user's
        private String phoneNumber; // might be different from user's
        private String address;
        private final BigDecimal totalPrice;
        private LocalDateTime orderDateTime;
        private Boolean isDelivered;

    public Order(Integer orderId, User user, Cart cart, String name, String phoneNumber, String address) {
        this.orderId = orderId;
        this.user = user;
        this.cart = cart;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.totalPrice = cart.getPrice();
        this.orderDateTime = LocalDateTime.now();
        this.isDelivered = Boolean.FALSE;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public Cart getCart() {
        return cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public Boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nOrder{");
        sb.append("orderId=").append(orderId);
        sb.append(", user=").append(user.getUserMail());
        sb.append(", name=").append(name);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", address=").append(address);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", orderDateTime=").append(orderDateTime);
        sb.append(", isDelivered=").append(isDelivered);
        sb.append(",\ncart=").append(cart);
        sb.append('}');
        return sb.toString();
    }
    
    
        
}
