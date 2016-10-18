package com.logixcess.epricenotifier.Business;

import java.util.UUID;

/**
 * Created by Usman on 18/10/2016.
 */

public class Shop implements iCRUDE {

    UUID uid;
    String name,shopNo,city,state,country,latitude,longitude;

    public Shop() {

    }

    public Shop(UUID uid, String name, String shopNo, String city, String state, String country, String latitude, String longitude) {
        this.uid = uid;
        this.name = name;
        this.shopNo = shopNo;
        this.city = city;
        this.state = state;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
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

    /*Functions*/

    @Override
    public Object register(Object obj) {
        Shop sObj = (Shop) obj;
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
        Shop sObj = (Shop) obj;
        return null;
    }



}
