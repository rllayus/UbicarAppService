package com.rllayus.ubicarappservice.rest.responce;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ListResponse<T> implements Serializable{
    /**
     * Mensaje de retorno para el usuario
     */
    private String message;
    /**
     * Codigo de error
     */
    private int error;
    /**
     * Lista de valores que se retorna al cliente
     */
    private List<T> values;

}
