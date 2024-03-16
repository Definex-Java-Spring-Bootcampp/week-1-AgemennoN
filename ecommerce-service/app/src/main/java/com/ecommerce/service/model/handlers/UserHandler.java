
package com.ecommerce.service.model.handlers;

import com.ecommerce.service.model.Cart;
import com.ecommerce.service.model.Order;
import com.ecommerce.service.model.Product;
import com.ecommerce.service.model.User;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static List<Order> getOrdersOfUser(User user){
        return OrderHandler.getOrderList()
                           .stream()
                           .filter(order -> order.getUser().equals(user))
                           .toList();
    }
    
    public static BigDecimal getTotalMoneySpend(User user){
        List<Order> usersOrders = getOrdersOfUser(user);
        BigDecimal totalSpend = usersOrders.stream()
                                           .map(Order::getTotalPrice)
                                           .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalSpend;
    }
    
    public static Map<Product, Integer> getProductsPurchasedBy(User user){
        List<Order> usersOrders = getOrdersOfUser(user);
        List<Cart> cartList = usersOrders.stream()
                                         .map(Order::getCart)
                                         .toList();
        return CartHandler.sumProductsInCarts(cartList);
    }
    
    public static Integer totalProductsPurchasedBy(User user){
        return getProductsPurchasedBy(user).values()
                                    .stream()
                                    .reduce(0, Integer::sum);
    }
        
    public static void printUserPurchases(User user){
        System.out.println("\n\n# %s Spent total of %s \n Purchases:\n Item Count %s \n%s"
                .formatted(user.getUserMail(),
                           UserHandler.getTotalMoneySpend(user),
                           UserHandler.totalProductsPurchasedBy(user),
                           UserHandler.getProductsPurchasedBy(user)));
    }
    
    public static void printUserPurchases(List<User> users){
        users.forEach(user -> printUserPurchases(user));
    }
    
    public static List<User> getUsersWithAgeBetween(int age1, int age2) {
        return userList.stream()
                       .filter(user -> {
                           int age = user.getAge();
                           return age >= age1 && age <= age2;
                       })
                       .collect(Collectors.toList());
    }
    
    public static List<User> getUsersWithAgeBetween(int age1, int age2, List<User> users) {
        LocalDate startDate = LocalDate.now().minusYears(age2);
        LocalDate endDate = LocalDate.now().minusYears(age1);
        
        return userList.stream()
                       .filter(user -> {
                           LocalDate userBirthDate = user.getUserBirthDate();
                           return userBirthDate.isAfter(startDate) && userBirthDate.isBefore(endDate);
                       })
                       .collect(Collectors.toList());
    }
    
    
    public static List<User> findUsers(String fieldName, Object value, List<User> users) {
        List<User> foundUsers = new ArrayList<>();
        try {
            Field field = User.class.getDeclaredField(fieldName);
            field.setAccessible(true);

            for (User user : users) {
                Object fieldValue = field.get(user);
                if (fieldValue.equals(value)) {
                    foundUsers.add(user);
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.err.println(e);
        }
        return foundUsers;
    }
        
    public static List<User> findUsers(String fieldName, Object value) {
        return UserHandler.findUsers(fieldName, value, userList);
    }

}
