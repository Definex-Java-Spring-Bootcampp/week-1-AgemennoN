/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kredinEgemenden.model;

import com.kredinEgemenden.enums.ApplicationStatus;
import java.time.LocalDateTime;


public class Application {
    
    private Product product;
    private User user;
    private LocalDateTime applicationDate;
    private ApplicationStatus applicationStatus;

    
    public Application(Product product, User user, LocalDateTime localDateTime) {
        this.product = product;
        this.user = user;
        this.applicationDate = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Application{");
        sb.append(", product=").append(product);
        sb.append(", user=").append(user.getName());
        sb.append(", applicationDate=").append(applicationDate);
        //sb.append(", applicationStatus=").append(applicationStatus);
        sb.append("}\n");
        return sb.toString();
    }
    
}
