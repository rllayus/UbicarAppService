package com.rllayus.ubicarappservice.rest.request;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ricardo Laredo on 13/05/2017.
 */
public class ListRequest<T> implements Serializable {
    private HeaderRequest headerRequest;
    private List<T> values;

    public HeaderRequest getHeaderRequest() {
        return headerRequest;
    }

    public void setHeaderRequest(HeaderRequest headerRequest) {
        this.headerRequest = headerRequest;
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
}
