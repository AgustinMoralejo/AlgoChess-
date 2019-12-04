package fiuba.algo3.TP2;

import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Excepciones.NoSePuedeColocarUnidadEnSectorEnemigoException;
import fiuba.algo3.TP2.Modelo.Excepciones.PuntosInsuficientesException;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

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

    @Test
    public void testUnidadesVivasDeUnJugador() {

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agustin", tablero);

        jugador.comprarUnidad("soldado", 8,8);
        jugador.comprarUnidad("soldado", 8,9);
        jugador.comprarUnidad("soldado", 8,7);


        Assertions.assertEquals(3,jugador.unidadesRestantesVivas());


    }


    @Test
    public void testJugadorPierde() {

        Tablero tablero = new Tablero();
        Jugador jugadorAzul = new Jugador("agus", tablero);
        Jugador enemigo = new Jugador("lego", tablero);

        jugadorAzul.comprarUnidad("soldado", 9, 9);
        tablero.cambiarEstado();
        enemigo.comprarUnidad("soldado", 10, 8);
        tablero.cambiarEstado();

        //ataque

        jugadorAzul.atacar(9,9,10,8);
        jugadorAzul.resetMovimientoUnidades();
        tablero.cambiarEstado();

        enemigo.atacar(10,8,9,9);
        enemigo.resetMovimientoUnidades();
        tablero.cambiarEstado();

        jugadorAzul.atacar(9,9,10,8);
        jugadorAzul.resetMovimientoUnidades();
        tablero.cambiarEstado();

        enemigo.atacar(10,8,9,9);
        enemigo.resetMovimientoUnidades();
        tablero.cambiarEstado();

        jugadorAzul.atacar(9,9,10,8);
        jugadorAzul.resetMovimientoUnidades();
        tablero.cambiarEstado();

        enemigo.atacar(10,8,9,9);
        enemigo.resetMovimientoUnidades();
        tablero.cambiarEstado();

        jugadorAzul.atacar(9,9,10,8);
        jugadorAzul.resetMovimientoUnidades();
        tablero.cambiarEstado();

        enemigo.atacar(10,8,9,9);
        enemigo.resetMovimientoUnidades();
        tablero.cambiarEstado();

        jugadorAzul.atacar(9,9,10,8);
        jugadorAzul.resetMovimientoUnidades();
        tablero.cambiarEstado();

        enemigo.atacar(10,8,9,9);
        enemigo.resetMovimientoUnidades();
        tablero.cambiarEstado();

        jugadorAzul.atacar(9,9,10,8);
        jugadorAzul.resetMovimientoUnidades();
        tablero.cambiarEstado();

        enemigo.atacar(10,8,9,9);
        enemigo.resetMovimientoUnidades();
        tablero.cambiarEstado();

        jugadorAzul.atacar(9,9,10,8);
        jugadorAzul.resetMovimientoUnidades();
        tablero.cambiarEstado();

        enemigo.atacar(10,8,9,9);
        enemigo.resetMovimientoUnidades();
        tablero.cambiarEstado();

        jugadorAzul.atacar(9,9,10,8);
        jugadorAzul.resetMovimientoUnidades();
        tablero.cambiarEstado();

        enemigo.atacar(10,8,9,9);
        enemigo.resetMovimientoUnidades();
        tablero.cambiarEstado();

        jugadorAzul.atacar(9,9,10,8);
        jugadorAzul.resetMovimientoUnidades();
        tablero.cambiarEstado();

        enemigo.atacar(10,8,9,9);
        enemigo.resetMovimientoUnidades();
        tablero.cambiarEstado();

        jugadorAzul.atacar(9,9,10,8);
        jugadorAzul.resetMovimientoUnidades();
        tablero.cambiarEstado();


        Assertions.assertTrue(enemigo.perdio());

    }

    //vista
    @Test
    public void testTantoJugadorAzulComoRojoPuedenMoverLasMismasUnidadesSiempreYCuandoNoSeCambieDeEstado() {

        Tablero tablero = new Tablero();
        Jugador azul = new Jugador("agus", tablero);
        Jugador rojo = new Jugador("lego", tablero);

        azul.comprarUnidad("soldado", 9, 3);

        tablero.cambiarEstado();

        rojo.comprarUnidad("soldado", 10,3);

        tablero.cambiarEstado();

        rojo.atacar(9,3,10,3);



    }



}
