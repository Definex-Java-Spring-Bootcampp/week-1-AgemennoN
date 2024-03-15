

package com.kredinEgemenden.model.factories;

import com.kredinEgemenden.model.Application;
import com.kredinEgemenden.model.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


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
    
    public static User newUser(String email, String password, String name, String surname, LocalDate birthDate, String phoneNumber){
        User user = UserFactory.createUser(email, password, name, surname, birthDate, phoneNumber);
        return user;
    }
    
    public static User getUserWithMostApplications(){
        User user = userList.stream()
                           .max(Comparator.comparingInt(u -> u.getApplicationList().size()))
                           .orElse(null);
        return user;
    }
    
    public static User getUserWithMostAmountLoanApplication(){
        return ApplicationHandler.getLoanApplicationWithMostAmount().getUser();
    }
    
    public static ArrayList<Application> getApplicationsOfTheUserByEmail(String email){
        User user = UserFactory.findUserByEmail(email);
        return (ArrayList)user.getApplicationList();
    }
}
