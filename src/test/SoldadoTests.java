package test;

import Fiuba.TP3.Unidad.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public
class SoldadoTests {

    @Test
    public void testCrearSoldadoDeInfanteriaTiene100DeVidaYCuesta1Puntos() {

        Soldado soldado = new Soldado();

        Assertions.assertEquals(100, soldado.getPuntosDeVida());
        Assertions.assertEquals(1, soldado.getCosto());
    }
}
