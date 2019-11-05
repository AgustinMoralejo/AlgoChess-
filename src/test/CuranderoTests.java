package test;

import Fiuba.TP3.Unidad.Curandero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public
class CuranderoTests {


    @Test
    public void testCrearCuranderoTiene75DeVidaYCuesta2Puntos(){

        Curandero curandero = new Curandero();

        Assertions.assertEquals(75, curandero.getPuntosDeVida());
        Assertions.assertEquals(2, curandero.getCosto());
    }

}
