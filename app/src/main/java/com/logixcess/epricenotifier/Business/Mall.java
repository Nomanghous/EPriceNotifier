package com.logixcess.epricenotifier.Business;

import java.util.UUID;

/**
 * Created by Usman on 18/10/2016.
 */

public class Mall implements iCRUDE{
    UUID uid;
    String name,address,latitude,longitude,city,state,country;

    public Mall() {

    }

    public Mall(UUID uid, String name, String address, String latitude, String longitude, String city, String state, String country) {
        this.uid = uid;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /*Functions*/

    @Override
    public Object register(Object obj) {
        Mall mObj = (Mall) obj;
        return null;
    }

    @Override
    public Object get(UUID uid) {
        return null;
    }

    @Override
    public boolean delete(UUID uid) {
        return false;
    }

    @Override
    public Object update(Object obj) {
        Mall mObj = (Mall) obj;
        return null;
    }
}
