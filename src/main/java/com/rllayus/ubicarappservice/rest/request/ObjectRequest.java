package com.rllayus.ubicarappservice.rest.request;

import java.io.Serializable;

/**
 * Created by Ricardo Laredo on 13/05/2017.
 */

public class ObjectRequest<T> implements Serializable {
    private HeaderRequest headerRequest;
    private T values;

    public HeaderRequest getHeaderRequest() {
        return headerRequest;
    }

    public void setHeaderRequest(HeaderRequest headerRequest) {
        this.headerRequest = headerRequest;
    }

    public T getValues() {
        return values;
    }

    public void setValues(T values) {
        this.values = values;
    }
}
