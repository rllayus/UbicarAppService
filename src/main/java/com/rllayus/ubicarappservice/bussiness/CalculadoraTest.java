package com.rllayus.ubicarappservice.bussiness;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Ricardo Laredo on 12-08-18.
 */
public class CalculadoraTest  {
    @Test
    public void testSuma() throws Exception {
        Calculadora suma = new Calculadora();
        int resultado = suma.suma(2,5);
        TestCase.assertEquals(7, resultado);
    }

    @Test
    public void testMultiplicacion() throws Exception {
        Calculadora suma = new Calculadora();
        long resultado = suma.multiplicacion(2,5);
        TestCase.assertEquals(10, resultado);
    }



}