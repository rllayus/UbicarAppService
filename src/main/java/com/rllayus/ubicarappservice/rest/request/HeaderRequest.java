package com.rllayus.ubicarappservice.rest.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Ricardo Laredo on 13/05/2017.
 */
@Getter
@Setter
public class HeaderRequest implements Serializable {
   private String ime;
   private String jsessionid;
   private String appName;
   private String eh;
   private String user;
}
