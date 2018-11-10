package com.example.jordan.projectapplication;

public class ClassDestination {

    private String type, display, media;
    private float distance;



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

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public ClassDestination(String type, String display, String media, float distance) {
        this.type = type;
        this.display = display;
        this.media = media;
        this.distance = distance;
    }
}
