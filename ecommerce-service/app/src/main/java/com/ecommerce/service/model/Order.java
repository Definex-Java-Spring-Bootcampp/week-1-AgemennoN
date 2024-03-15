
package com.ecommerce.service.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
        private Integer orderId;
        private User user;
        private Cart cart;
        private String name;        // might be different from user's
        private String phoneNumber; // might be different from user's
        private String address;
        private BigDecimal totalPrice;
        private LocalDateTime orderDateTime;
        private Boolean isDelivered;

    public Order(Integer orderId, User user, Cart cart, String name, String phoneNumber, String address) {
        this.orderId = orderId;
        this.user = user;
        this.cart = cart;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
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
    
        
        
}
