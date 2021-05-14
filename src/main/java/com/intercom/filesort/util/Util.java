package com.intercom.filesort.util;


import com.intercom.filesort.entities.response.Customer;
import com.intercom.filesort.entities.response.GPSCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

import static com.intercom.filesort.constants.AppConstant.*;


@Component
public class Util {

    /*
     * This method returns radian form of degree
     */

    public  double convertToRadians(double  degree){

        return Math.toRadians(degree);
    }

    public  void populateCoordinatesInRadian(GPSCoordinates gpsCoordinates){
        if(gpsCoordinates!=null){
            double latitude = convertToRadians(gpsCoordinates.getLatitude());
            double longitude = convertToRadians(gpsCoordinates.getLongitude());
            gpsCoordinates.setLatitudeInRadian(latitude);
            gpsCoordinates.setLongitudeInRadian(longitude);
        }
    }

    public  void populateCoordinatesInRadian(Customer customer){
        GPSCoordinates gpsCoordinates = customer.getGpsCoordinates();

        if(gpsCoordinates ==null) {
            gpsCoordinates = new GPSCoordinates(customer.getLatitude(), customer.getLongitude());
            customer.setGpsCoordinates(gpsCoordinates);
        }
            double latitude = convertToRadians(gpsCoordinates.getLatitude());
            double longitude = convertToRadians(gpsCoordinates.getLongitude());
            gpsCoordinates.setLatitudeInRadian(latitude);
            gpsCoordinates.setLongitudeInRadian(longitude);

    }


    public  double calculateDistanceFromDublin(GPSCoordinates gpsCoordinates){
        populateCoordinatesInRadian(gpsCoordinates);
        double deltaLongitude = 0.d;
        if(gpsCoordinates.getLongitudeInRadian() > 0){
            deltaLongitude = Math.abs(gpsCoordinates.getLongitudeInRadian() + DUBLIN_LONGITUDE_IN_RADIAN);

        }else{
            deltaLongitude = Math.abs(-DUBLIN_LONGITUDE_IN_RADIAN + gpsCoordinates.getLongitudeInRadian()) ;
        }
        double distance = Math.acos(Math.sin(gpsCoordinates.getLatitudeInRadian())* SINE_FUNCTION_DUBLIN_LATITUDE
                + Math.cos(gpsCoordinates.getLatitudeInRadian())* COSINE_FUNCTION_DUBLIN_LATITUDE *
                Math.cos(deltaLongitude));
        distance = EARTH_RADIUS_IN_KM * distance;
        return distance;
    }

    public  long getFileSize(){
        File file = new File(INPUT_FILE_NAME);
        if (!file.exists() || !file.isFile())
            return -1;
        return file.length();
    }
}
