package com.logixcess.epricenotifier.Business;

import java.util.UUID;

/**
 * Created by Usman on 18/10/2016.
 */

public class Shopkeeper extends User{

    public Shopkeeper() {
    }

    public Shopkeeper(UUID uId, String name, String email, String type, String password) {
        super(uId, name, email, type, password);
    }


}
