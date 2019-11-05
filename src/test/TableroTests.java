import Fiuba.Jugador.*;
import Fiuba.*;
import Fiuba.Tablero.Tablero;
import Fiuba.Unidad.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public
class TableroTests {


    @Test
    public void testTableroTieneUnTamanioDe20Por20(){

        Tablero tablero = new Tablero();

        Assertions.assertEquals(20*20, tablero.getTamanio());
    }

    @Test
    public void testJugadorAzulColocaUnSoldadoEnUnCasilleroVacioDelSectorAliadoConExito() {

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);

        jugadorAzul.comprarUnidad("soldado",15,15);

        Assertions.assertFalse(tablero.estaVacio(15, 15));

    }

    @Test
    public void testJugadorAzulNoPuedeColocarUnSoldadoEnUnCasilleroDelSectorEnemigo() {

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);

        Assertions.assertThrows(NoSePuedeColocarUnidadEnSectorEnemigoException.class, () -> jugadorAzul.comprarUnidad("soldado",5,5));

    }


    @Test
    public void testJugadorRojoColocaUnSoldadoEnUnCasilleroDelSectorAliadoConExito() {

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("soldado",3,8);

        Assertions.assertFalse(tablero.estaVacio(3,8));
    }

    @Test
    public void testJugadorRojoNoPuedeColocarUnSoldadoEnUnCasilleroDelSectorEnemigo() {

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        Assertions.assertThrows(NoSePuedeColocarUnidadEnSectorEnemigoException.class, () -> jugadorRojo.comprarUnidad("soldado",11,18));
    }


    @Test
    public void testAlColocarUnSoldadoEnUnCasilleroEstePasaAEstarOcupadoYNoSePuedeColocarOtraUnidadEncima(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();
        Soldado otroSoldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () -> tablero.colocarUnidad(otroSoldado, 5, 5));
    }

    @Test
    public void testSoldadoSeMueveUnCasilleroAlNorteYLoOcupa(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.pasoAlNorte(5,5);


        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,5));

    }

    @Test
    public void testSoldadoSeMueveUnCasilleroAlEsteYLoOcupa(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.pasoAlEste(5,5);


        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(5,6));

    }

    @Test
    public void testSoldadoSeMueveUnCasilleroAlSurYLoOcupa(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.pasoAlSur(5,5);


        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,5));

    }


    @Test
    public void testSoldadoSeMueveUnCasilleroAlOesteYLoOcupa(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.pasoAlOeste(5,5);


        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(5,4));

    }

    @Test
    public void testSoldadoNoSePuedeMoverAlEstePorqueElCasilleroEstaOcupado(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();
        Soldado otroSoldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.colocarUnidad(otroSoldado,5,6);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () -> tablero.pasoAlEste(5,5));


    }

}
