package fiuba.algo3.TP2;

import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.TP2.Modelo.Excepciones.NoSePuedeColocarUnidadEnSectorEnemigoException;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Modelo.Unidad.Jinete;
import fiuba.algo3.TP2.Modelo.Unidad.Soldado;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;


public class TableroTest {

    @Test
    public void testTableroTieneUnaDimensionDe20Por20(){

        Tablero tablero = new Tablero();
        Assertions.assertEquals(20*20, tablero.getDimension());
    }

    @Test
    public void testSeColocaUnaUnidadAliadaEnTerritorioAliadoVacioConExito(){
        Tablero tablero = new Tablero();
        Unidad soldado = new Soldado();
        tablero.colocarUnidad(soldado, 1, 1);
        Unidad unidadColocada = (tablero.getCasillero(1,1)).getUnidad();
        Assertions.assertTrue(unidadColocada == soldado);
    }

    @Test
    public void testJugadorColocaUnaUnidadAliadaEnTerritorioAliadoVacioConExito(){
        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("Juan", tablero);
        jugadorAliado.comprarUnidad("soldado",1,1);

        Assertions.assertTrue(tablero.estaOcupado(1,1));
    }

    @Test
    public void testNoSePuedeColocarUnidadAliadaEnSectorAliadoOcupado(){
        Tablero tablero = new Tablero();
        Unidad jinete = new Jinete();
        tablero.colocarUnidad(jinete, 1,1);
        Unidad soldado = new Soldado();

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.colocarUnidad(soldado, 1, 1));
    }

    @Test
    public void testNoSePuedeColocarUnidadAliadaEnSectorEnemigo(){
        Tablero tablero = new Tablero();
        Unidad jinete = new Jinete();

        Assertions.assertThrows(NoSePuedeColocarUnidadEnSectorEnemigoException.class, () -> tablero.colocarUnidad(jinete, 15,11));
    }

    @Test
    public void testSePuedeColocarUnidadLuegoDeQueOtraMueraEnLaMismaPosicion() {

        Tablero tablero = new Tablero();
        Jugador jugadorAzul = new Jugador("agus", tablero);
        Jugador enemigo = new Jugador("lego", tablero);

        jugadorAzul.comprarUnidad("soldado", 9, 9);
        tablero.cambiarEstado();

        enemigo.comprarUnidad("soldado", 11, 10);

        tablero.cambiarEstado();

        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);

        tablero.cambiarEstado();
        enemigo.comprarUnidad("soldado",11,10);
        Assertions.assertEquals(100, tablero.getUnidad(11,10).getPuntosDeVida());

    }

}
