
package com.ecommerce.service.model.handlers;

import com.ecommerce.service.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserHandler {

    private static UserHandler instance = null;
    private static List<User> userList = new ArrayList<>();
    
    private UserHandler() {} // Private Constructer
    public static UserHandler getInstance() {
        if (instance == null){
            instance = new UserHandler();
        }
        return instance;
    }

    public static List<User> getUserList() {
        return userList;
    }
    
}
