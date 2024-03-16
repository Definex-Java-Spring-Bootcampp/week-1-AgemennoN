
package com.ecommerce.service;

import com.ecommerce.service.enums.CategoryType;
import com.ecommerce.service.model.Order;
import com.ecommerce.service.model.Product;
import com.ecommerce.service.model.User;
import com.ecommerce.service.model.factories.ProductFactory;
import com.ecommerce.service.model.factories.UserFactory;
import com.ecommerce.service.model.handlers.OrderHandler;
import com.ecommerce.service.model.handlers.ProductHandler;
import com.ecommerce.service.model.handlers.UserHandler;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class App {

    public static void main(String[] args) {
        
        
        System.out.println("\n\n########################################################");
        System.out.println("##########   ----------   PRODUCTS   ----------   ##########");
        Product product1 = ProductFactory.createProduct("AsusLaptop", BigDecimal.valueOf(25000), "Laptop",List.of(CategoryType.ELECTRONIC), 20, Boolean.TRUE);
        Product product2 = ProductFactory.createProduct("BasketBall", BigDecimal.valueOf(60), "Basketball",List.of(CategoryType.SPORT, CategoryType.HOBBY), 250, Boolean.TRUE);
        Product product3 = ProductFactory.createProduct("DogToy", BigDecimal.valueOf(45), "toy for goodBoys",List.of(CategoryType.PET), 30, Boolean.TRUE);
        Product product4 = ProductFactory.createProduct("TV", BigDecimal.valueOf(23000), "notVestel",List.of(CategoryType.ELECTRONIC), 10, Boolean.TRUE);
        Product product5 = ProductFactory.createProduct("Banana", BigDecimal.valueOf(30), "kgBanana",List.of(CategoryType.FOOD), 20, Boolean.TRUE);
        Product product6 = ProductFactory.createProduct("Apple", BigDecimal.valueOf(25), "kgApple",List.of(CategoryType.FOOD), 25, Boolean.TRUE);

        System.out.println(ProductHandler.getProductList());
        
        
        
        System.out.println("\n\n########################################################");
        System.out.println("##########   ----------   USERS   ----------   ##########");
        User user1 = UserFactory.createUser("Egemen", "YeYo", "Egemen@gmail.com", "55544432", LocalDate.now().minusYears(25));
        User user2 = UserFactory.createUser("CemD", "GizliSifre", "Cem@gmail.com", "55443432", LocalDate.now().minusYears(28));
        User user3 = UserFactory.createUser("YasliAdam", "123", "old@gmail.com", "55443432", LocalDate.now().minusYears(50));
        User user4 = UserFactory.createUser("CemD", "Gi1Sifre", "Cem35@gmail.com", "55443432", LocalDate.now().minusYears(35));
        User user5 = UserFactory.createUser("CemD", "Gi2Sifre", "Cem22@gmail.com", "55443432", LocalDate.now().minusYears(22));
        
        System.out.println(UserHandler.getUserList());
        
        user1.addProductToCart(product1, 1);
        user1.addProductToCart(product3, 2);
        
        user2.addProductToCart(product4, 1);
        
        user3.addProductToCart(product5, 2);
        user3.addProductToCart(product6, 2);
        
        user5.addProductToCart(product6, 5);
        user5.addProductToCart(product6, 10);
        user5.addProductToCart(product2, 2);
        user5.purchaseCart("GencoCem", "123456789", "XXL Migros");
        user5.addProductToCart(product1, 1);
        System.out.println("Number of Users: " +  UserHandler.getUserList().size());
        
        
        System.out.println("\n\n########################################################");
        System.out.println("##########   ----------   Added to Cart   ----------   ##########");
        System.out.println(user1);
        
        
        System.out.println("\n\n########################################################");
        System.out.println("##########   ----------   Purchased   ----------   ##########");
    
        Order order1 = user1.purchaseCart("Egemen", "1234568", "Manisa Falan Filan");
        Order order2 = user2.purchaseCart("Cemd", "1234568", "BaskaYerler");
        Order order3 = user3.purchaseCart("OldBoy", "1234568", "FarFarDiyar");
        System.out.println(OrderHandler.getOrderList());
        
        
        System.out.println("\n\n##############################");
        user1.addProductToCart(product5, 5);
        user1.addProductToCart(product6, 5);
        System.out.println(user1);
        System.out.println("\n\n##############################");
        Order order4 = user1.purchaseCart("Egemen", "1234568", "Manisa Falan Filan");
        System.out.println(OrderHandler.getOrderList());
        
        
        System.out.println("\n\n------------------------------------------------");
        UserHandler.printUserPurchases(user1);
        UserHandler.printUserPurchases(user2);
        System.out.println("------------------------------------------------\n\n");
        
        user1.addProductToCart(product1, 1);
        Order order5 = user1.purchaseCart("Egemen", "1234568", "Manisa Falan Filan");
        
        Integer age1 = 20;
        Integer age2 = 30;

        System.out.println("\n\n####AGE BETWEEN %d and %d USERS ".formatted(age1,age2));
        System.out.println(UserHandler.getUsersWithAgeBetween(age1, age2));
        
        
        System.out.println("\n\n####AGE BETWEEN %d and %d users purchases ".formatted(age1,age2));
        UserHandler.printUserPurchases(UserHandler.getUsersWithAgeBetween(age1, age2));
        
        System.out.println("\n\n########################################################");
        System.out.println("---------Purchases ALL USERS WITH NAME CemD between age 20-30---------------");
        UserHandler.printUserPurchases(UserHandler.findUsers("userName", "CemD", UserHandler.getUsersWithAgeBetween(age1, age2)));
        System.out.println("\n\n---------FIND ALL USERS ACTIVE---------------");
        System.out.println(UserHandler.findUsers("userActive", Boolean.TRUE));
        
        
        BigDecimal price = BigDecimal.valueOf(20000);
        System.out.println("\n\n###################Orders Above Price %.2f ##################".formatted(price));
        System.out.println(OrderHandler.getOrdersAbovePrice(price));
        
    }
}
