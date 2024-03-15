
package com.ecommerce.service.model;

import java.math.BigDecimal;
import java.util.Map;

public class Cart {
        private Integer cartId;
        private Integer userId;
        private Map<Product, Integer> productMap;
        private BigDecimal price;
        private Boolean isOrdered;
    
}
