package com.logixcess.epricenotifier.Business;

import java.util.UUID;

/**
 * Created by Usman on 18/10/2016.
 */

public interface iCRUDE {
    public Object register(Object obj);
    public Object get(UUID uid);
    public boolean delete(UUID uid);
    public Object update(Object obj);

}
