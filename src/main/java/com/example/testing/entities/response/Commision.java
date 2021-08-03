package com.example.testing.entities.response;

public class Commision {

    Seller seller;
    UNITS units;
    double amount;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public UNITS getUnits() {
        return units;
    }

    public void setUnits(UNITS units) {
        this.units = units;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Commision(Seller seller, UNITS units, double amount) {
        this.seller = seller;
        this.units = units;
        this.amount = amount;
    }
}
