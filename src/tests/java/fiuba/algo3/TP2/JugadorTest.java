package fiuba.algo3.TP2;

import fiuba.algo3.TP2.AlgoChess.Jugador;
import fiuba.algo3.TP2.Excepciones.NoSePuedeColocarUnidadEnSectorEnemigoException;
import fiuba.algo3.TP2.Excepciones.PuntosInsuficientesException;
import fiuba.algo3.TP2.Tablero.Tablero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JugadorTest {

    @Test
    public void testCrearJugadorConNombreAgustinY20Puntos(){

        Jugador jugador = new Jugador("agustin");

        Assertions.assertEquals("agustin", jugador.getNombre());
        Assertions.assertEquals(20, jugador.getPuntos());
    }

    @Test
    public void testJugadorCompraUnSoldadoPor1Punto(){

        Jugador jugador = new Jugador("agustin");

        jugador.comprarUnidad("soldado");
        Assertions.assertEquals(19, jugador.getPuntos());

    }

    @Test
    public void testJugadorCompraUnJinetePor3Puntos(){

        Jugador jugador = new Jugador("agustin");

        jugador.comprarUnidad("jinete");
        Assertions.assertEquals(17, jugador.getPuntos());

    }

    @Test
    public void testJugadorCompraUnCuranderoPor2Puntos(){

        Jugador jugador = new Jugador("agustin");

        jugador.comprarUnidad("curandero");
        Assertions.assertEquals(18, jugador.getPuntos());
    }

    @Test
    public void testJugadorCompraUnaCatapultaPor5Puntos(){

        Jugador jugador = new Jugador("agustin");

        jugador.comprarUnidad("catapulta");
        Assertions.assertEquals(15, jugador.getPuntos());
    }

    @Test
    public void testJugadorConMenosDe5PuntosNoCompraUnaCatapultaPorInsuficienciaDePuntos(){

        Jugador jugador = new Jugador("agustin");

        jugador.comprarUnidad("catapulta");
        jugador.comprarUnidad("catapulta");
        jugador.comprarUnidad("catapulta");
        jugador.comprarUnidad("jinete");

        Assertions.assertThrows(PuntosInsuficientesException.class, () -> jugador.comprarUnidad("catapulta"));
        Assertions.assertEquals(2, jugador.getPuntos());
    }
    
    @Test
    public void testJugadorNoPuedeComprarUnidadEnTerritorioEnemigo() {
    	
    	Tablero tablero = new Tablero();
    	Jugador jugador = new Jugador("agustin", tablero);
    	Assertions.assertThrows(NoSePuedeColocarUnidadEnSectorEnemigoException.class, ()
    			-> jugador.comprarUnidad("catapulta", 15, 15));
    }
}
