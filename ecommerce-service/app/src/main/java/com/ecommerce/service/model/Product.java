
package com.ecommerce.service.model;

import com.ecommerce.service.enums.CategoryType;
import java.math.BigDecimal;
import java.util.List;

public class Product {
    private Integer productId;
    private String productName;
    private BigDecimal productPrice;
    private String productDescription;
    private List<CategoryType> productCategoryList;
    //private BigDecimal productPriceOnSale;
    //private BigDecimal productDiscountRate;
    private Integer productStock;
    private Boolean productActive;

    public Product(Integer productId, String productName, BigDecimal productPrice, String productDescription, List<CategoryType> productCategoryList, Integer productStock, Boolean productActive) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productCategoryList = productCategoryList;
        this.productStock = productStock;
        this.productActive = productActive;
    }
    
    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public List<CategoryType> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<CategoryType> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }

    public Boolean getProductActive() {
        return productActive;
    }

    public void setProductActive(Boolean productActive) {
        this.productActive = productActive;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    
    
 
        
        
}
