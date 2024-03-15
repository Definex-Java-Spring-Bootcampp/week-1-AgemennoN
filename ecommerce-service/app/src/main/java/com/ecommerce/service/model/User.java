
package com.ecommerce.service.model;

import com.ecommerce.service.model.handlers.CartHandler;
import com.ecommerce.service.model.handlers.OrderHandler;
import java.time.LocalDate;

public class User {
        private String userName;
        private String userPassword;
        private String userMail;
        private String userPhoneNumber;
        private LocalDate userRegisterDate;
        private LocalDate userBirthDate;
        private Boolean userActive;
        private Cart cart;

    public User(String userName, String userPassword, String userMail, String userPhoneNumber, LocalDate userBirthDate) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMail = userMail;
        this.userPhoneNumber = userPhoneNumber;
        this.userBirthDate = userBirthDate;
        
        this.userRegisterDate = LocalDate.now();
        this.userActive = true;
    }
    
    public void addProductToCart(Product product, Integer quantity){
        CartHandler.addProductToUserCart(product, quantity, this);
    }
    
    public void purchaseCart(String name, String phoneNumber, String address){
        OrderHandler.purchaseCart(this, name, phoneNumber, address);
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public LocalDate getUserRegisterDate() {
        return userRegisterDate;
    }

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(LocalDate userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    
    public Boolean getUserActive() {
        return userActive;
    }

    public void setUserActive(Boolean userActive) {
        this.userActive = userActive;
    }
    
}
