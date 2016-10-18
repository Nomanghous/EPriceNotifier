package com.logixcess.epricenotifier.Business;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Usman on 18/10/2016.
 */

public class Products implements iCRUDE {

    UUID uid;
    String name,make,model,category,price,quantity;
    Date releaseDate;


    public Products(UUID uid, String name, String make, String model, String category, String price, String quantity, Date releaseDate) {
        this.uid = uid;
        this.name = name;
        this.make = make;
        this.model = model;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.releaseDate = releaseDate;
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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public Object register(Object obj) {

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
        return null;

    }



}
