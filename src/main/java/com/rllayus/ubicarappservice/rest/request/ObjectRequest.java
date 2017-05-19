package com.rllayus.ubicarappservice.rest.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Ricardo Laredo on 13/05/2017.
 */
@Getter
@Setter
public class ObjectRequest<T> implements Serializable {
    private HeaderRequest headerRequest;
    private T values;

}
