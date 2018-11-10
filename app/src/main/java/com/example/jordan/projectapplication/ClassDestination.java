package com.example.jordan.projectapplication;

public class ClassDestination {

    private String type, display, media;
    private double distance;
    private double latitudejson, longitudejson;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public ClassDestination(String type, String display, String media, double latitudejson, double longitudejson) {
        this.type = type;
        this.display = display;
        this.media = media;
        this.distance = 0;
        this.latitudejson = latitudejson;
        this.longitudejson = longitudejson;
    }

    public double calculdistance(double mylatitude, double mylongitude) {

        double lat1 = mylatitude * Math.PI / 180;

        double lat2 = latitudejson * Math.PI / 180;



        double long1 = mylongitude * Math.PI / 180;

        double long2 = longitudejson * Math.PI / 180;



        double R = 6371d;



        distance = R * Math.acos(Math.cos(lat1) * Math.cos(lat2) *

                Math.cos(long2 - long1) + Math.sin(lat1) *

                Math.sin(lat2));



        return distance;

    }
}
