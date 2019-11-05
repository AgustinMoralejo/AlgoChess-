import Fiuba.Excepciones.NoSePuedenCurarUnidadesNoOrganicasException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Fiuba.Unidad.*;

import static Fiuba.AlgoChess.Alianza.AZUL;
import static Fiuba.AlgoChess.Alianza.ROJO;

public
class CuranderoTest {

    @Test
    public void testCrearCuranderoTiene75DeVidaYCuesta2Puntos(){

        Curandero curandero = new Curandero();

        Assertions.assertEquals(75, curandero.getPuntosDeVida());
        Assertions.assertEquals(2, curandero.getCosto());
    }


    @Test
    public void testCuranderoRecibe50PuntosDeDanio() {

        Curandero curandero = new Curandero();

        curandero.perderVida(50);
        Assertions.assertEquals(25, curandero.getPuntosDeVida());
    }


    @Test
    public void testCuranderoCuraSoldadoEnRango() {

        Curandero curandero = new Curandero();
        Soldado soldado1 = new Soldado();
        curandero.setAlianza(AZUL);
        soldado1.setAlianza(AZUL);
        curandero.atacar(2, soldado1);
        Assertions.assertEquals(115, soldado1.getPuntosDeVida());
    }

    @Test
    public void testCuranderoCuraJineteEnRango() {

        Curandero curandero = new Curandero();
        Jinete jinete = new Jinete();
        curandero.setAlianza(AZUL);
        jinete.setAlianza(AZUL);
        curandero.atacar(2, jinete);
        Assertions.assertEquals(115, jinete.getPuntosDeVida());
    }


    @Test
    public void testCuranderCuraCuranderoEnRango() {

        Curandero curandero1 = new Curandero();
        Curandero curandero = new Curandero();
        curandero1.setAlianza(AZUL);
        curandero.setAlianza(AZUL);
        curandero1.atacar(2, curandero);
        Assertions.assertEquals(90, curandero.getPuntosDeVida());
    }



}
