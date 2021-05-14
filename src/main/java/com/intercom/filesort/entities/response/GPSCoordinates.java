package com.intercom.filesort.entities.response;

public class GPSCoordinates {
     double latitude;
     double longitude;
     double latitudeInRadian;
     double longitudeInRadian;

    public GPSCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
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

    public double getLatitudeInRadian() {
        return latitudeInRadian;
    }

    public void setLatitudeInRadian(double latitudeInRadian) {
        this.latitudeInRadian = latitudeInRadian;
    }

    public double getLongitudeInRadian() {
        return longitudeInRadian;
    }

    public void setLongitudeInRadian(double longitudeInRadian) {
        this.longitudeInRadian = longitudeInRadian;
    }
}
