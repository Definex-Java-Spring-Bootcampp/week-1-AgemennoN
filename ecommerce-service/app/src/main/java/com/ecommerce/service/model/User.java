
package com.ecommerce.service.model;

import com.ecommerce.service.model.handlers.CartHandler;
import com.ecommerce.service.model.handlers.OrderHandler;
import java.time.LocalDate;
import java.time.Period;

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
    
    // MOVE to USerHandler
    public void addProductToCart(Product product, Integer quantity){
        this.cart = CartHandler.addProductToUserCart(product, quantity, this);
    }
    
    // MOVE to USerHandler
    public Order purchaseCart(String name, String phoneNumber, String address){
        // decrease quantitiy of the products after purchase
        if (this.cart == null){
            System.out.println("Cart is empty");
            return null;
        }
        Order order = OrderHandler.purchaseCart(this, name, phoneNumber, address);
        return order;
    }
    
    public Integer getAge(){
        return Period.between(this.userBirthDate, LocalDate.now()).getYears();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nUser{");
        sb.append("userName=").append(userName);
        //sb.append(", userPassword=").append(userPassword);
        sb.append(", userMail=").append(userMail);
        sb.append(", userPhoneNumber=").append(userPhoneNumber);
        sb.append(", userRegisterDate=").append(userRegisterDate);
        sb.append(", userBirthDate=").append(userBirthDate);
        sb.append(", age=").append(this.getAge());
        sb.append(", userActive=").append(userActive);
        sb.append("\n cart=").append(cart);
        sb.append('}');
        return sb.toString();
    }
    
    
}
