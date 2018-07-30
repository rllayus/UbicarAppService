package com.rllayus.ubicarappservice.rest.responce;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class ObjectResponse<T> implements Serializable{
    /**
     * Mensaje de retorno para el usuario
     */
    private String message;
    /**
     * Codigo de error
     */
    private int error;
    /**
     * Valore que se retorna al cliente
     */
    private T values;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public T getValues() {
        return values;
    }

    public void setValues(T values) {
        this.values = values;
    }
}
