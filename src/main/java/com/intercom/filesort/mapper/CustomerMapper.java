package com.intercom.filesort.mapper;

import com.google.gson.Gson;
import com.intercom.filesort.entities.response.Customer;
import com.intercom.filesort.entities.response.PQCustomer;
import com.intercom.filesort.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    @Autowired
    Gson gson;

    @Autowired
    Util util;
    public Customer mapRequest(String s)  {

        Customer customer  = null;
        customer = gson.fromJson(s, Customer.class);

        if(customer != null) {
                 util.populateCoordinatesInRadian(customer);
                 customer.setDistance(util.calculateDistanceFromDublin(customer.getGpsCoordinates()));
             }

        return customer;

    }

    public PQCustomer mapResponse(String s){
        PQCustomer pqCustomer = null;
        Customer customer = gson.fromJson(s, Customer.class);

        pqCustomer = new PQCustomer();
        if(customer !=null) {
            pqCustomer.setCustomer(customer);
        }
        return pqCustomer;

    }

}
