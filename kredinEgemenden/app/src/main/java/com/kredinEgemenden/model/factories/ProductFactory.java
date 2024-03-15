

package com.kredinEgemenden.model.factories;

import com.kredinEgemenden.model.Bank;
import com.kredinEgemenden.model.Product;
import java.util.ArrayList;
import java.util.List;


public abstract class ProductFactory {

    protected ProductFactory() {} // Protected constructor
    public static List<Product> productList = new ArrayList<>();
    
    public abstract void addToBank(Bank bank, Product product);
    //public abstract Product findByName(String name);

}
