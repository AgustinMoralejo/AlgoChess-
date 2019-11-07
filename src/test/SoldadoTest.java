import Fiuba.Excepciones.ObjetivoFueraDeRangoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Fiuba.AlgoChess.Alianza.AZUL;
import static Fiuba.AlgoChess.Alianza.ROJO;
import Fiuba.Unidad.*;

public
class SoldadoTest {

    @Test
    public void testCrearSoldadoDeInfanteriaTiene100DeVidaYCuesta1Puntos() {

        Soldado soldado = new Soldado();

        Assertions.assertEquals(100, soldado.getPuntosDeVida());
        Assertions.assertEquals(1, soldado.getCosto());
    }

    @Test
    public void testSoldadoRecibe50PuntosDeDanio() {

        Soldado soldado = new Soldado();

        soldado.perderVida(50);
        Assertions.assertEquals(50, soldado.getPuntosDeVida());
    }


    @Test
    public void testSoldadoAtacaSoldadoEnRango() {

        Soldado soldado = new Soldado();
        Soldado soldado1 = new Soldado();
        soldado.setAlianza(AZUL);
        soldado1.setAlianza(ROJO);
        soldado.atacar(1, soldado1);
        Assertions.assertEquals(90, soldado1.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAtacaCatapultaEnRango() {

        Soldado soldado = new Soldado();
        Catapulta catapulta = new Catapulta();
        soldado.setAlianza(AZUL);
        catapulta.setAlianza(ROJO);
        soldado.atacar(1, catapulta);
        Assertions.assertEquals(40, catapulta.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAtacaJineteEnRango() {

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();
        soldado.setAlianza(AZUL);
        jinete.setAlianza(ROJO);
        soldado.atacar(1, jinete);
        Assertions.assertEquals(90, jinete.getPuntosDeVida());
    }


    @Test
    public void testSoldadoAtacaCuranderoEnRango() {

        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();
        soldado.setAlianza(AZUL);
        curandero.setAlianza(ROJO);
        soldado.atacar(1, curandero);
        Assertions.assertEquals(65, curandero.getPuntosDeVida());
    }


    @Test
    public void testSoldadoAtacaSoldadoFueraDeRango() {

        Soldado soldado = new Soldado();
        Soldado soldado1 = new Soldado();
        soldado.setAlianza(AZUL);
        soldado1.setAlianza(ROJO);
        Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> soldado.atacar(3,soldado1));
    }


}
