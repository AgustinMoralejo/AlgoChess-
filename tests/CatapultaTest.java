import Fiuba.AlgoChess.Jugador;
import Fiuba.Tablero.Tablero;
import Fiuba.Unidad.*;
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

    @Test
    public void testCatapultaAtacaSoldadoEnRango() {

        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();
        catapulta.setAlianza("aliado");
        soldado.setAlianza("enemigo");
        catapulta.atacar(7, soldado);
        Assertions.assertEquals(80, soldado.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaCatapultaEnRango() {

        Catapulta catapulta1 = new Catapulta();
        Catapulta catapulta = new Catapulta();
        catapulta1.setAlianza("aliado");
        catapulta.setAlianza("enemigo");
        catapulta1.atacar(7, catapulta);
        Assertions.assertEquals(30, catapulta.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaJineteEnRango() {

        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();
        catapulta.setAlianza("aliado");
        jinete.setAlianza("enemigo");
        catapulta.atacar(7, jinete);
        Assertions.assertEquals(80, jinete.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaCuranderoEnRango() {

        Catapulta catapulta = new Catapulta();
        Curandero curandero = new Curandero();
        catapulta.setAlianza("aliado");
        curandero.setAlianza("enemigo");
        catapulta.atacar(7, curandero);
        Assertions.assertEquals(55, curandero.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaAUnaDistanciaLejana(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("pedro", tablero, "aliado");
        Jugador jugadorEnemigo = new Jugador("juan", tablero, "enemigo");
        jugadorAliado.comprarUnidad("soldado", 3,1);
        jugadorAliado.comprarUnidad("curandero", 3,3);
        jugadorAliado.comprarUnidad("soldado", 3, 2);
        jugadorEnemigo.comprarUnidad("catapulta", 15, 15);

        jugadorEnemigo.atacar(15,15,3,2);
        Unidad soldado1 = tablero.getUnidad(3,1);
        Unidad soldado2 = tablero.getUnidad(3,2);
        Unidad curandero = tablero.getUnidad(3,3);
        Assertions.assertEquals(80, soldado1.getPuntosDeVida());
        Assertions.assertEquals(80, soldado2.getPuntosDeVida());
        Assertions.assertEquals(55, curandero.getPuntosDeVida());
    }
}
