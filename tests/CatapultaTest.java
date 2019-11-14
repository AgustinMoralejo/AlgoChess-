import Fiuba.Unidad.Catapulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatapultaTest {

    @Test
    public void testCrearCatapultaTiene50DeVidaYCuesta5Puntos(){

        Catapulta catapulta = new Catapulta();

        Assertions.assertEquals(50, catapulta.getPuntosDeVida());
        Assertions.assertEquals(5, catapulta.getCosto());
    }

    @Test
    public void testCatapultaRecibe50PuntosDeDanio() {

        Catapulta catapulta = new Catapulta();

        catapulta.perderVida(50);
        Assertions.assertEquals(0, catapulta.getPuntosDeVida());
    }
}
