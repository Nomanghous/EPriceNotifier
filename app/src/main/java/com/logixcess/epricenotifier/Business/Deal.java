package com.logixcess.epricenotifier.Business;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Usman on 18/10/2016.
 */

public class Deal  implements iCRUDE{

    UUID uid,imageID;
    String name;
    Date starDate,endDate;

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
