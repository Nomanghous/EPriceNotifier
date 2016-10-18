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

    










    public class Category implements iCRUDE{

        UUID uid;
        String categoryName;

        public Category(String categoryName) {
            this.categoryName = categoryName;
        }

        public UUID getUid() {
            return uid;
        }

        public void setUid(UUID uid) {
            this.uid = uid;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
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

        // Category class ends
    }


    public class Manufacturer implements iCRUDE{

        UUID uid;
        String manufacturerName;

        public Manufacturer(String name) {
            this.manufacturerName = name;
        }

        public UUID getUid() {
            return uid;
        }

        public void setUid(UUID uid) {
            this.uid = uid;
        }

        public String getName() {
            return manufacturerName;
        }

        public void setName(String name) {
            this.manufacturerName = name;
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

        // Manufacturer class ends

    }


}
