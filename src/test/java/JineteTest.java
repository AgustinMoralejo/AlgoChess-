
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Fiuba.Unidad.*;

import static Fiuba.AlgoChess.Alianza.AZUL;
import static Fiuba.AlgoChess.Alianza.ROJO;

public
class JineteTest {


    @Test
    public void testCrearJineteTiene100DeVidaYCuesta3Puntos(){

        Jinete jinete = new Jinete();

        Assertions.assertEquals(100, jinete.getPuntosDeVida());
        Assertions.assertEquals(3, jinete.getCosto());
    }


    @Test
    public void testJineteRecibe50PuntosDeDanio() {

        Jinete jinete = new Jinete();

        jinete.perderVida(50);
        Assertions.assertEquals(50, jinete.getPuntosDeVida());
    }


    @Test
    public void testJineteAtacaSoldadoConArco() {

        Jinete jinete = new Jinete();
        Soldado soldado1 = new Soldado();
        jinete.setAlianza(AZUL);
        soldado1.setAlianza(ROJO);
        jinete.atacar(1, soldado1);
        Assertions.assertEquals(95, soldado1.getPuntosDeVida());
    }

    @Test
    public void testJineteAtacaCatapultaConArco() {

        Jinete jinete = new Jinete();
        Catapulta catapulta = new Catapulta();
        jinete.setAlianza(AZUL);
        catapulta.setAlianza(ROJO);
        jinete.atacar(4, catapulta);
        Assertions.assertEquals(35, catapulta.getPuntosDeVida());
    }

    @Test
    public void testJineteAtacaJineteConArco() {

        Jinete jinete1 = new Jinete();
        Jinete jinete = new Jinete();
        jinete1.setAlianza(AZUL);
        jinete.setAlianza(ROJO);
        jinete1.atacar(1, jinete);
        Assertions.assertEquals(95, jinete.getPuntosDeVida());
    }


    @Test
    public void testJineteAtacaCuranderoConArco() {

        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();
        jinete.setAlianza(AZUL);
        curandero.setAlianza(ROJO);
        jinete.atacar(1, curandero);
        Assertions.assertEquals(70, curandero.getPuntosDeVida());
    }

}
