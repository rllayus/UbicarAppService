package com.rllayus.ubicarappservice.rest.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ricardo Laredo on 13/05/2017.
 */
@Getter
@Setter
public class ListRequest<T> implements Serializable {
    private HeaderRequest headerRequest;
    private List<T> values;
}
