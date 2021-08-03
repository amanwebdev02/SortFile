package com.example.testing.service;

import com.example.testing.entities.response.Commision;
import com.example.testing.entities.response.Seller;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class CommisionService {
    public  static HashMap<Seller, Commision> commisionHashMap = new HashMap();

    public void addCommision(Commision c, Seller s){

        commisionHashMap.put(s, c);
    }

}
