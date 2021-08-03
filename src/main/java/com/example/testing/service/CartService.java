package com.example.testing.service;

import com.example.testing.entities.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CartService {
    //CommisionMap
    public void createCart(Cart c, Customer customer){
        c.setCustomer(customer);

    }
    public void addProductToCart(Cart c, Product p, int quantity){

        HashMap<Product, Integer> map  = c.getProductQuantityMap();
        int currentQuantity = map.getOrDefault(p,0);
        map.put(p,currentQuantity + quantity);

    }

    public void removeProduct(Cart c, Product p, int quantity){

        HashMap<Product, Integer> map  = c.getProductQuantityMap();
        int currentQuantity = map.getOrDefault(p,0);
        //
        if(quantity > currentQuantity){
            throw new RuntimeException("The number of quantity requsted to delete does not exists");
        }
        map.put(p,currentQuantity - quantity);

    }

    public void calculateCartVal(Cart c){

       // CommisionService.commisionList ;

        double cartAmnt =0,  discountAmt = 0;
        for (Product p:c.getProductQuantityMap().keySet() ) {
            double currentAmt = p.getAmount() * c.getProductQuantityMap().get(p);
            Seller tempSeller = p.getSeller();
            Commision tempCommision = CommisionService.commisionHashMap.get(tempSeller);
            if(tempCommision.equals(UNITS.PERCENTAGE)){
                discountAmt+= currentAmt * (tempCommision.getAmount()/100);
            }
            cartAmnt+=currentAmt;
            //same for flar
        }
        c.setCartAmt(cartAmnt);
        c.setDiscountAmt(discountAmt);
        c.setFinalCartVal(cartAmnt-discountAmt);
        System.out.println(c);

    }
}
