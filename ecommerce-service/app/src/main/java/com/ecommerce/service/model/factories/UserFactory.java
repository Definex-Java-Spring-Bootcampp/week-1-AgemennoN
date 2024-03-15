
package com.ecommerce.service.model.factories;

import com.ecommerce.service.model.User;
import com.ecommerce.service.model.handlers.UserHandler;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

public class UserFactory {
    public static User createUser(String userName, String userPassword, String userMail, String userPhoneNumber, LocalDate userBirthDate){
        User user = findUserByEmail(userMail);
        if (user != null){
            System.out.println("User already existed with email: " + userMail);
            return user;
        }
        String hashedPassword = hashString(userPassword);
        user = new User(userName, hashedPassword, userName, userPhoneNumber, userBirthDate);
        
        UserHandler.getUserList().add(user);
        return user;
    }
    
    public static String hashString(String originalString) {
        try {
            // Create MessageDigest instance for SHA-512
            MessageDigest digest = MessageDigest.getInstance("SHA-512");

            // Apply SHA-512 hashing to the input string
            byte[] hashBytes = digest.digest(originalString.getBytes());

            // Convert byte array to hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
    
    public static User findUserByEmail(String email){
        List<User> userList = UserHandler.getUserList();
        User user = userList.stream()
                .filter(u -> u.getUserMail().equals(email))
                .findFirst() // Find the first matching Bank (if any)
                .orElse(null);
        return user;
    }
}
