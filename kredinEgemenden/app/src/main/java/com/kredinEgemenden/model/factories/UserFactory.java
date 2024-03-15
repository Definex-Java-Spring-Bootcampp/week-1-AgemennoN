

package com.kredinEgemenden.model.factories;

import com.kredinEgemenden.model.User;
import java.time.LocalDate;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class UserFactory {
    public static User createUser(String email, String password, String name, String surname, LocalDate birthDate, String phoneNumber){
        User user = findUserByEmail(email);
        if (user != null){
            System.out.println("User already existed with email: " + email);
            return user;
        }
        String hashedPassword = hashString(password);
        user = new User(name, surname, birthDate, email, hashedPassword, phoneNumber, Boolean.TRUE);
        
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
                .filter(u -> u.getEmail().equals(email))
                .findFirst() // Find the first matching Bank (if any)
                .orElse(null);
        return user;
    }
    
}
