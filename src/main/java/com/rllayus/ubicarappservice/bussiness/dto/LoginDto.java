package com.rllayus.ubicarappservice.bussiness.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Ricardo Laredo on 14/05/2017.
 */
@Getter
@Setter
public class LoginDto implements Serializable {
    private String user;
    private String password;
}
