
package com.ecommerce.service.model.factories;

import com.ecommerce.service.enums.CategoryType;
import com.ecommerce.service.model.Product;
import com.ecommerce.service.model.handlers.ProductHandler;
import java.math.BigDecimal;
import java.util.List;

public class ProductFactory {
    public static Product createProduct(String productName,
                                        BigDecimal productPrice,
                                        String productDescription,
                                        List<CategoryType> productCategoryList,
                                        Integer productStock,
                                        Boolean productActive){
        
        Integer productId = ProductHandler.getProductList().size();
        
        Product product = new Product(productId, productName, productPrice, productDescription, productCategoryList, productStock, productActive);
        ProductHandler.getProductList().add(product);
        return product;
    }
}
