import Fiuba.AlgoChess.Jugador;
import Fiuba.Excepciones.*;
import Fiuba.Tablero.Tablero;
import Fiuba.Unidad.Curandero;
import Fiuba.Unidad.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtaquesTest {

    @Test
    public void testSoldadoAtacaAOtroSoldadoQueEstaEnDistanciaCercanaYLeQuita10PuntosDeVida() {

        Soldado soldado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();

        soldado.setAlianza("aliado");
        soldadoEnemigo.setAlianza("enemigo");

        soldado.atacar(2, soldadoEnemigo);

        Assertions.assertEquals(90, soldadoEnemigo.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAtacaAOtroSoldadoQueNoEstaEnDistanciaCercanaYNoLeQuitaVida() {

        Soldado soldado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();

        soldado.setAlianza("aliado");
        soldadoEnemigo.setAlianza("enemigo");

        Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> soldado.atacar(3, soldadoEnemigo));
        Assertions.assertEquals(100, soldadoEnemigo.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAliadoAtacaAUnSoldadoEnemigoQueEstaEnDistanciaCercanaYLeQuita10PuntosDeVida() {

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus", tablero, "aliado");
        Jugador jugadorEnemigo = new Jugador("lego", tablero, "enemigo");

        jugadorAliado.comprarUnidad("soldado", 11, 9);
        jugadorEnemigo.comprarUnidad("soldado", 11, 10);
        jugadorAliado.atacar(11, 9, 11, 10);

        Assertions.assertEquals(90, tablero.getPuntosDeVidaUnidadEnPosicion(11, 10));
    }

    @Test
    public void testSoldadoAliadoAtacaAUnSoldadoEnemigoQueNoEstaEnDistanciaCercanaYNoLeQuitaVida() {

        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("agus", tablero, "aliado");
        Jugador jugador2 = new Jugador("lego", tablero, "enemigo");

        jugador1.comprarUnidad("soldado", 12, 5);
        jugador2.comprarUnidad("soldado", 4, 10);

        Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> jugador1.atacar(12, 5, 4, 10));
        Assertions.assertEquals(100, tablero.getPuntosDeVidaUnidadEnPosicion(12, 5));
    }

    @Test
    public void testJineteAliadoAtacaAUnSoldadoEnemigoQueEstaEnDistanciaMedianaYLeQuita15PuntosDeVida() {

        Tablero tablero = new Tablero();
        Jugador jugadorAzul = new Jugador("agus", tablero, "aliado");
        Jugador jugadorRojo = new Jugador("lego", tablero, "enemigo");

        jugadorAzul.comprarUnidad("jinete", 11, 9);
        jugadorRojo.comprarUnidad("soldado", 11, 10);
        jugadorAzul.atacar(11, 9, 11, 10);

        Assertions.assertEquals(95, tablero.getPuntosDeVidaUnidadEnPosicion(11, 10));
    }

    @Test
    public void testCuranderoAzulCuraAUnSoldadoAliadoQueEstaEnDistanciaCercanaYLeDa15PuntosDeVida() {

        Tablero tablero = new Tablero();
        Jugador jugadorAzul = new Jugador("agus", tablero, "aliado");

        jugadorAzul.comprarUnidad("curandero", 7, 7);
        jugadorAzul.comprarUnidad("soldado", 7, 8);
        jugadorAzul.atacar(7, 7, 7, 8);

        Assertions.assertEquals(115, tablero.getPuntosDeVidaUnidadEnPosicion(7, 8));
    }

    @Test
    public void testCuranderoAzulNoPuedeCurarAUnaCatapultaAzul() {

        Tablero tablero = new Tablero();
        Jugador jugadorAzul = new Jugador("agus", tablero, "aliado");

        jugadorAzul.comprarUnidad("curandero", 15, 2);
        jugadorAzul.comprarUnidad("catapulta", 15, 3);

        Assertions.assertThrows(NoSePuedenCurarUnidadesNoOrganicasException.class, () -> jugadorAzul.atacar(15, 2, 15, 3));
    }

    /**
     * Unidades aliadas no pueden atacarse y curanderos no pueden curar unidades enemigas
     */
    @Test
    public void testCuranderoAzulNoPuedeCurarAUnSoldadoRojo() {

        Tablero tablero = new Tablero();

        Curandero curanderoAzul = new Curandero();
        Soldado soldadoRojo = new Soldado();

        soldadoRojo.setAlianza("aliado");
        curanderoAzul.setAlianza("enemigo");

        Assertions.assertThrows(NoSePuedeCurarEnemigoException.class, () -> curanderoAzul.atacar(2, soldadoRojo));
        Assertions.assertEquals(100, soldadoRojo.getPuntosDeVida());
    }

    @Test
    public void testNoSePuedeAtacarUnidadesAliadas() {

        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("agus", tablero, "aliado");
        Jugador jugador2 = new Jugador("lego", tablero, "aliado");

        jugador1.comprarUnidad("soldado", 11, 9);
        jugador2.comprarUnidad("soldado", 11, 8);

        Assertions.assertThrows(NoSePuedeAtacarAUnaUnidadAliadaException.class, () -> jugador1.atacar(11, 9, 11, 8));

    }

    @Test
    public void testNoSePuedeAtacarNoExisteUnidadEnPosicionParaRealizarElAtaque(){

        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("agus",tablero, "aliado");

        jugador1.comprarUnidad("soldado",11,9);

        Assertions.assertThrows(NoHayUnidadEnCasilleroException.class, ()-> jugador1.atacar(11,7,11,8));

    }

    @Test
    public void testSoldadoNoPuedeAtacarAUnidadYaMuerta(){

        Tablero tablero = new Tablero();
        Jugador jugadorAzul = new Jugador("agus",tablero, "aliado");
        Jugador jugadorRojo = new Jugador("lego",tablero, "enemigo");

        jugadorAzul.comprarUnidad("soldado",11,9);
        jugadorRojo.comprarUnidad("soldado",11,10);

        jugadorAzul.atacar(11,9,11,10);
        jugadorAzul.atacar(11,9,11,10);
        jugadorAzul.atacar(11,9,11,10);
        jugadorAzul.atacar(11,9,11,10);
        jugadorAzul.atacar(11,9,11,10);
        jugadorAzul.atacar(11,9,11,10);
        jugadorAzul.atacar(11,9,11,10);
        jugadorAzul.atacar(11,9,11,10);
        jugadorAzul.atacar(11,9,11,10);
        jugadorAzul.atacar(11,9,11,10);
        jugadorAzul.atacar(11,9,11,10);

        Assertions.assertThrows(UnidadEstaMuertaException.class, () ->jugadorAzul.atacar(11,9,11,10));
    }

}
