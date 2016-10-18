package com.logixcess.epricenotifier.Business;

import java.util.UUID;

/**
 * Created by Usman on 18/10/2016.
 */

public class Customer extends User {

    public Customer() {

    }

    public Customer(UUID uId, String name, String email, String type, String password) {
        super(uId, name, email, type, password);
    }

}
