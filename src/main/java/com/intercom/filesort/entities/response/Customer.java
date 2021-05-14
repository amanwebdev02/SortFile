package com.intercom.filesort.entities.response;


public class Customer implements Comparable<Customer>{
    int user_id;
    String name;
    double distance;
    double latitude;
    double longitude;
    GPSCoordinates gpsCoordinates;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public GPSCoordinates getGpsCoordinates() {
        return gpsCoordinates;
    }

    public void setGpsCoordinates(GPSCoordinates gpsCoordinates) {
        this.gpsCoordinates = gpsCoordinates;
    }

    @Override
    public String toString() {
        return "{" +
                "\"user_id\" :"  + user_id  +
                ", \"name\" : " + "\"" + name + "\"" +
                ", \"distance\" :"  + distance +
                ", \"latitude\" :" + "\"" + latitude + "\"" +
                ", \"longitude\" :" + "\"" + longitude + "\"" +
                "}";
    }

    @Override
    public int compareTo(Customer o) {
        return this.user_id - (o.user_id) ;
    }
}
