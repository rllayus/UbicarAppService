package com.rllayus.ubicarappservice.bussiness.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Ricardo Laredo on 18/05/2017.
 */
@Getter
@Setter
public class VentaDto implements Serializable {
    private int cantVentas;
    private int objetivo;
}
