package at.ac.fhwn.sae.lesson4;

import java.util.ArrayList;

public class SaePoint {
    private String time;
    private double latitude;
    private double longitude;
    private int numberOfSatelites;
    private int fix;
    //$GNGGA,061013.00,4812.773795,N,01445.351457,E,1,12,0.7,252.9,M,44.6,M,,*7B
//    public SaePoint(String latitude, String longitude, String time, String numberOfSatelites, String fix){
//        this.time = time;
//        this.latitude = Double.parseDouble(latitude);
//        this.longitude = Double.parseDouble();
//        this.numberOfSatelites = numberOfSatelites;
//        this.fix = fix;
//    }
    public SaePoint(){}
    public SaePoint(double latitude, double longitude, String time, int numberOfSatelites, int fix){
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.numberOfSatelites = numberOfSatelites;
        this.fix = fix;
    }
    public SaePoint(String[] data){
        fix = Integer.parseInt(data[6]);
        numberOfSatelites = Integer.parseInt(data[7]);
        time = data[1];
        //ersten zwei oder drei stellen +  den rest/60
        if (data[3].equals("N")){

            latitude = Double.parseDouble(data[2].substring(0,2));
            latitude += Double.parseDouble(data[2].substring(2))/60;

        } else if(data[3].equals("E")){
            latitude = Double.parseDouble(data[2].substring(0,2));
            latitude += Double.parseDouble(data[2].substring(2))/60;
            latitude *= (-1);
        }
        if (data[5].equals("E")){
            longitude = Double.parseDouble(data[4].substring(0,3));
            longitude += Double.parseDouble(data[4].substring(3))/60;
        } else if(data[5].equals("W")){
            longitude = Double.parseDouble(data[4].substring(0,3));
            longitude += Double.parseDouble(data[4].substring(3))/60;
            longitude *=(-1);
        }

    }

    public int getNumberOfSatelites() {
        return numberOfSatelites;
    }

    public void setNumberOfSatelites(int numberOfSatelites) {
        this.numberOfSatelites = numberOfSatelites;
    }

    public int getFix() {
        return fix;
    }

    public void setFix(int fix) {
        this.fix = fix;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
