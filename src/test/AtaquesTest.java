import Fiuba.*;
import Fiuba.Jugador.JugadorAzul;
import Fiuba.Jugador.JugadorRojo;
import Fiuba.Tablero.Tablero;;
import Fiuba.Unidad.Soldado;
import Fiuba.Unidad.Curandero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public
class AtaquesTest {

    @Test
    public void testSoldadoAtacaAOtroSoldadoQueEstaEnDistanciaCercanaYLeQuita10PuntosDeVida(){

        Soldado soldado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();

        soldado.setAlianza(Alianza.AZUL);
        soldadoEnemigo.setAlianza(Alianza.ROJO);

        soldado.atacar(2,soldadoEnemigo);

        Assertions.assertEquals(90, soldadoEnemigo.getPuntosDeVida());
    }


    @Test
    public void testSoldadoAtacaAOtroSoldadoQueNoEstaEnDistanciaCercanaYNoLeQuitaVida(){

        Soldado soldado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();

        soldado.setAlianza(Alianza.AZUL);
        soldadoEnemigo.setAlianza(Alianza.ROJO);

        Assertions.assertEquals(100, soldadoEnemigo.getPuntosDeVida());
        Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> soldado.atacar(3,soldadoEnemigo));
    }


    @Test
    public void testSoldadoAzulAtacaAUnSoldadoRojoQueEstaEnDistanciaCercanaYLeQuita10PuntosDeVida(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);
        JugadorRojo jugadorRojo = new JugadorRojo("lego",tablero);

        jugadorAzul.comprarUnidad("soldado",11,5);
        jugadorRojo.comprarUnidad("soldado",10,5);
        jugadorAzul.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(11,5,10,5);

        Assertions.assertEquals(90, tablero.getPuntosDeVidaUnidadEnPosicion(10,5));
    }


    @Test
    public void testSoldadoRojoAtacaAUnSoldadoAzulQueNoEstaEnDistanciaCercanaYNoLeQuitaVida(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);
        JugadorRojo jugadorRojo = new JugadorRojo("lego",tablero);

        jugadorRojo.comprarUnidad("soldado",4,10);
        jugadorAzul.comprarUnidad("soldado",12,5);

        Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> tablero.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(12,5,4,10));
        Assertions.assertEquals(100, tablero.getPuntosDeVidaUnidadEnPosicion(12,5));
    }

    @Test
    public void testJineteAzulAtacaAUnSoldadoRojoQueEstaEnDistanciaMedianaYLeQuita15PuntosDeVida(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);
        JugadorRojo jugadorRojo = new JugadorRojo("lego",tablero);

        jugadorAzul.comprarUnidad("jinete",10,12);
        jugadorRojo.comprarUnidad("jinete",6,14);
        jugadorAzul.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(10,12,6,14);

        Assertions.assertEquals(85, tablero.getPuntosDeVidaUnidadEnPosicion(6,14));
    }


    @Test
    public void testCuranderoAzulCuraAUnSoldadoAliadoQueEstaEnDistanciaCercanaYLeDa15PuntosDeVida(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);

        jugadorAzul.comprarUnidad("curandero",18,12);
        jugadorAzul.comprarUnidad("soldado",17,14);
        jugadorAzul.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(18,12,17,14);

        Assertions.assertEquals(115, tablero.getPuntosDeVidaUnidadEnPosicion(17,14));
    }

    @Test
    public void testCuranderoAzulNoPuedeCurarAUnaCatapultaAzul(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);

        jugadorAzul.comprarUnidad("curandero",18,12);
        jugadorAzul.comprarUnidad("catapulta",17,14);

        Assertions.assertThrows(NoSePuedenCurarUnidadesNoOrganicasException.class, () -> tablero.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(18,12,17,14));
    }

    /**Unidades aliadas no pueden atacarse y curanderos no pueden curar unidades enemigas*/
    @Test
    public void testCuranderoAzulNoPuedeCurarAUnSoldadoRojo(){

        Tablero tablero = new Tablero();

        Curandero curanderoAzul = new Curandero();
        Soldado soldadoRojo = new Soldado();

        soldadoRojo.setAlianza(Alianza.ROJO);
        curanderoAzul.setAlianza(Alianza.AZUL);

        curanderoAzul.atacar(2,soldadoRojo);

        Assertions.assertEquals(100, soldadoRojo.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAzulNoPuedeAtacarAUnSoldadoAzul(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);

        jugadorAzul.comprarUnidad("soldado",18,12);
        jugadorAzul.comprarUnidad("soldado",17,14);

        jugadorAzul.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(18,12,17,14);

        Assertions.assertEquals(100, tablero.getPuntosDeVidaUnidadEnPosicion(17,14));
    }



}
