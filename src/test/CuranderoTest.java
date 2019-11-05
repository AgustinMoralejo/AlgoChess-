import Fiuba.Unidad.Curandero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public
class CuranderoTest {

    @Test
    public void testCrearCuranderoTiene75DeVidaYCuesta2Puntos(){

        Curandero curandero = new Curandero();

        Assertions.assertEquals(75, curandero.getPuntosDeVida());
        Assertions.assertEquals(2, curandero.getCosto());
    }



}
