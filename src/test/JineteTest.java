
import Fiuba.Unidad.Jinete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public
class JineteTest {


    @Test
    public void testCrearJineteTiene100DeVidaYCuesta3Puntos(){

        Jinete jinete = new Jinete();

        Assertions.assertEquals(100, jinete.getPuntosDeVida());
        Assertions.assertEquals(3, jinete.getCosto());
    }


}