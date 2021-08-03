package com.example.testing.entities.response;

import java.util.HashMap;

public class Cart {
    String id;
    HashMap<Product, Integer> productQuantityMap = new HashMap<>();
    Customer customer;
    double cartAmt;
    double discountAmt;
    double finalCartVal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<Product, Integer> getProductQuantityMap() {
        return productQuantityMap;
    }

    public void setProductQuantityMap(HashMap<Product, Integer> productQuantityMap) {
        this.productQuantityMap = productQuantityMap;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getFinalCartVal() {
        return finalCartVal;
    }

    public void setFinalCartVal(double finalCartVal) {
        this.finalCartVal = finalCartVal;
    }

    public double getCartAmt() {
        return cartAmt;
    }

    public void setCartAmt(double cartAmt) {
        this.cartAmt = cartAmt;
    }

    public double getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(double discountAmt) {
        this.discountAmt = discountAmt;
    }

    public Cart(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", productQuantityMap=" + productQuantityMap +
                ", customer=" + customer +
                ", cartAmt=" + cartAmt +
                ", discountAmt=" + discountAmt +
                ", finalCartVal=" + finalCartVal +
                '}';
    }
}
