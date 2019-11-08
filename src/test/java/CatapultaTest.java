import Fiuba.AlgoChess.JugadorAzul;
import Fiuba.AlgoChess.JugadorRojo;
import Fiuba.Tablero.Tablero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Fiuba.Unidad.*;

import static Fiuba.AlgoChess.Alianza.AZUL;
import static Fiuba.AlgoChess.Alianza.ROJO;

public
class CatapultaTest {




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


    @Test
    public void testCatapultaAtacaSoldadoEnRango() {

        Catapulta catapulta = new Catapulta();
        Soldado soldado1 = new Soldado();
        catapulta.setAlianza(AZUL);
        soldado1.setAlianza(ROJO);
        catapulta.atacar(7, soldado1);
        Assertions.assertEquals(80, soldado1.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaCatapultaEnRango() {

        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta = new Catapulta();
        catapulta1.setAlianza(AZUL);
        catapulta.setAlianza(ROJO);
        catapulta1.atacar(7, catapulta);
        Assertions.assertEquals(30, catapulta.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaJineteEnRango() {

        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();
        catapulta.setAlianza(AZUL);
        jinete.setAlianza(ROJO);
        catapulta.atacar(7, jinete);
        Assertions.assertEquals(80, jinete.getPuntosDeVida());
    }


    @Test
    public void testCatapultaAtacaCuranderoEnRango() {

        Catapulta catapulta = new Catapulta();
        Curandero curandero = new Curandero();
        catapulta.setAlianza(AZUL);
        curandero.setAlianza(ROJO);
        catapulta.atacar(7, curandero);
        Assertions.assertEquals(55, curandero.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaAUnaDistanciaLejana(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("pedro", tablero);
        JugadorRojo jugadorRojo = new JugadorRojo("juan", tablero);
        jugadorAzul.comprarUnidad("soldado", 3,1);
        jugadorAzul.comprarUnidad("curandero", 3,3);
        jugadorAzul.comprarUnidad("soldado", 3, 2);
        jugadorRojo.comprarUnidad("catapulta", 15, 15);

        tablero.unidadAliadaAtacaAUnidadEnemiga(15,15,3,2);
        Unidad soldado1 = tablero.getUnidad(3,1);
        Unidad soldado2 = tablero.getUnidad(3,2);
        Unidad curandero = tablero.getUnidad(3,3);
        Assertions.assertEquals(80, soldado1.getPuntosDeVida());
        Assertions.assertEquals(80, soldado2.getPuntosDeVida());
        Assertions.assertEquals(55, curandero.getPuntosDeVida());
    }
}