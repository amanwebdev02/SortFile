package com.example.testing.entities.response;

public class Product {
    Seller seller;
    ProductType productType;
    double amount;
   // String curr;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Product(Seller seller, ProductType productType, double amount) {
        this.seller = seller;
        this.productType = productType;
        this.amount = amount;
    }
}
