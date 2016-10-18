package com.logixcess.epricenotifier.Business;

import java.util.UUID;

/**
 * Created by Usman on 18/10/2016.
 */

public class User implements iCRUDE{
    UUID uId;
    String name,address,email,type,password,city,state,country,phone;

    public User() {

    }

    public User(UUID uId, String name,String email, String type, String password) {
        this.uId = uId;
        this.name = name;
        this.email = email;
        this.type = type;
        this.password = password;
    }

    public UUID getuId() {
        return uId;
    }

    public void setuId(UUID uId) {
        this.uId = uId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }




    @Override
    public Object register(Object obj) {
        User uObj = (User) obj;

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
        User uObj = (User) obj;

        return null;
    }





}
