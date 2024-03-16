
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
        User user2 = UserFactory.createUser("CemD", "GizliSifre", "Cem@gmail.com", "55443432", LocalDate.now().minusYears(27));
        User user3 = UserFactory.createUser("YasliAdam", "123", "old@gmail.com", "55443432", LocalDate.now().minusYears(50));
        
        System.out.println(UserHandler.getUserList());
        
        user1.addProductToCart(product1, 1);
        user1.addProductToCart(product3, 2);
        
        user2.addProductToCart(product4, 1);
        
        user3.addProductToCart(product5, 2);
        user3.addProductToCart(product6, 2);
        
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

    }
}
