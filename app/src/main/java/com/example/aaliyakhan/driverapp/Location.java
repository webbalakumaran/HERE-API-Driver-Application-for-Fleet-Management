package com.example.aaliyakhan.driverapp;

/**
 * Created by AaliyaKhan on 27-05-2019.
 */

public class Location {
    private String fromlocation;
    private String tolocation;

    public Location(String fromlocation, String tolocation) {
        this.fromlocation = fromlocation;
        this.tolocation = tolocation;
    }

    public void setFromlocation(String fromlocation) {
        this.fromlocation = fromlocation;
    }

    public void setTolocation(String tolocation) {
        this.tolocation = tolocation;
    }

    public String getFromlocation() {

        return fromlocation;
    }

    public String getTolocation() {
        return tolocation;
    }
}
