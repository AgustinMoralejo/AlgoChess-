import Fiuba.AlgoChess.*;
import Fiuba.Tablero.Tablero;
import Fiuba.Excepciones.*;
import Fiuba.Unidad.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TableroTest {

    @Test
    public void testTableroTieneUnTamanioDe20Por20(){

        Tablero tablero = new Tablero();
        Assertions.assertEquals(20*20, tablero.getTamanio());
    }

    @Test
    public void testSeColocaUnaUnidadAliadaEnTerritorioAliadoVacioConExito(){
        Tablero tablero = new Tablero();
        Unidad soldado = new Soldado();
        soldado.setAlianza("aliado");
        tablero.colocarUnidad(soldado, 1, 1);
        Unidad unidadColocada = (tablero.getCasillero(1,1)).getUnidad();
        Assertions.assertTrue(unidadColocada == soldado);
    }

    @Test
    public void testJugadorColocaUnaUnidadAliadaEnTerritorioAliadoVacioConExito(){
        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("Juan", tablero, "aliado");
        jugadorAliado.comprarUnidad("soldado",1,1);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(1,1));
    }

    @Test
    public void testNoSePuedeColocarUnidadAliadaEnSectorAliadoOcupado(){
        Tablero tablero = new Tablero();
        Unidad jinete = new Jinete();
        jinete.setAlianza("aliado");
        tablero.colocarUnidad(jinete, 1,1);
        Unidad soldado = new Soldado();
        soldado.setAlianza("aliado");

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.colocarUnidad(soldado, 1, 1));
    }

    @Test void testNoSePuedeColocarUnidadEnemigaEnSectorAliado(){
        Tablero tablero = new Tablero();
        Unidad jinete = new Jinete();
        jinete.setAlianza("enemigo");

        Assertions.assertThrows(NoSePuedeColocarUnidadEnSectorEnemigoException.class, () -> tablero.colocarUnidad(jinete, 1,1));
    }

    @Test
    public void testNoSePuedeColocarUnidadAliadaEnSectorEnemigo(){
        Tablero tablero = new Tablero();
        Unidad jinete = new Jinete();
        jinete.setAlianza("aliado");

        Assertions.assertThrows(NoSePuedeColocarUnidadEnSectorEnemigoException.class, () -> tablero.colocarUnidad(jinete, 15,11));
    }
}
