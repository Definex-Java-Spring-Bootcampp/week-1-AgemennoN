
package com.ecommerce.service.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Integer cartId;
    private User user;
    private Map<Product, Integer> productMap;
    private BigDecimal price;
    private Boolean isOrdered;

    public Cart(Integer cartId, User user) {
        this.cartId = cartId;
        this.user = user;
        this.productMap = new HashMap<>();
        this.isOrdered = false;
        this.price = BigDecimal.ZERO;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getIsOrdered() {
        return isOrdered;
    }

    public void setIsOrdered(Boolean isOrdered) {
        this.isOrdered = isOrdered;
    }

    
}
