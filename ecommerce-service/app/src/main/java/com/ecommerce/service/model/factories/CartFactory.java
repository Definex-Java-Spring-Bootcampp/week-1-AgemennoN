
package com.ecommerce.service.model.factories;

import com.ecommerce.service.model.Cart;
import com.ecommerce.service.model.User;
import com.ecommerce.service.model.handlers.CartHandler;

public class CartFactory {
    
    public static Cart createCart(User user){
        Integer cartId = CartHandler.getCartList().size() + 1;
        Cart cart = new Cart(cartId, user);
        CartHandler.getCartList().add(cart);
        return cart;
    }
}
