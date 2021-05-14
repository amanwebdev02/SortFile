package com.intercom.filesort.entities.response;

public class PQCustomer {
    Customer customer;
    int index;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "PQCustomer{" +
                "customer=" + customer +
                ", index=" + index +
                '}';
    }
}
