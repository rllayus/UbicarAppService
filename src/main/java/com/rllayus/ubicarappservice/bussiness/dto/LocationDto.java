package com.rllayus.ubicarappservice.bussiness.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by Ricardo Laredo on 14/05/2017.
 */
@Getter
@Setter
@ToString
public class LocationDto implements Serializable {
   private long usuarioId;
   private String latitude;
   private String longitude;
   private String provider;
   private String accuracy;
   private String altitude;
}
