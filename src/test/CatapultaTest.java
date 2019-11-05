import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Fiuba.Unidad.*;

public
class CatapultaTest {




    @Test
    public void testCrearCatapultaTiene50DeVidaYCuesta5Puntos(){

        Catapulta catapulta = new Catapulta();

        Assertions.assertEquals(50, catapulta.getPuntosDeVida());
        Assertions.assertEquals(5, catapulta.getCosto());
    }


}
