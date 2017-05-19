package com.rllayus.ubicarappservice.bussiness.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Ricardo Laredo on 14/05/2017.
 */
@Getter
@Setter
public class UserDto implements Serializable {
    private long id;
    private int eh;
    private String name;
    private String role;
    private String phone;
    private String email;
}
