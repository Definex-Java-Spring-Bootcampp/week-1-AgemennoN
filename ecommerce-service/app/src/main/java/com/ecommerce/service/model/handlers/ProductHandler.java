
package com.ecommerce.service.model.handlers;

import com.ecommerce.service.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductHandler {
    public static List<Product> productList = new ArrayList<>();

    public static List<Product> getProductList() {
        return productList;
    }
}
