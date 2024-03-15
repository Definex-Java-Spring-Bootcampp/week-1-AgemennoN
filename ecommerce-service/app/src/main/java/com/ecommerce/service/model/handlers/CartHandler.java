
package com.ecommerce.service.model.handlers;

import com.ecommerce.service.model.Cart;
import com.ecommerce.service.model.Product;
import com.ecommerce.service.model.User;
import com.ecommerce.service.model.factories.CartFactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartHandler {
    public static List<Cart> cartList = new ArrayList<>();
    
    
    public static Cart addProductToUserCart(Product product, Integer quantity, User user){
        Cart cart = user.getCart();
        if (cart == null){
            cart = CartFactory.createCart(user);
        }
        
        cart.getProductMap().put(product, getQuantityOfProductFromCart(cart, product) + quantity);
        cart.setPrice(calculateTotalPrice(cart));
        
        return cart;
    }
    
    public static Integer getQuantityOfProductFromCart(Cart cart, Product product){
        return cart.getProductMap().getOrDefault(product, 0);
    }
    
    public static BigDecimal calculateTotalPrice(Cart cart) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        
        for (Map.Entry<Product, Integer> entry : cart.getProductMap().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            BigDecimal subtotal = product.getProductPrice().multiply(BigDecimal.valueOf(quantity));
            totalPrice = totalPrice.add(subtotal);
        }
        return totalPrice;
    }

    public static List<Cart> getCartList() {
        return cartList;
    }

    public static void setCartList(List<Cart> cartList) {
        CartHandler.cartList = cartList;
    }

    
    
}
