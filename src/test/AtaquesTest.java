
import Fiuba.AlgoChess.*;
import Fiuba.Unidad.*;
import Fiuba.Tablero.Tablero;
import Fiuba.Excepciones.*;

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

        jugadorAzul.comprarUnidad("soldado",11,9);
        jugadorRojo.comprarUnidad("soldado",11,10);
        jugadorAzul.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(11,9,11,10);

        Assertions.assertEquals(90, tablero.getPuntosDeVidaUnidadEnPosicion(11,10));
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

        jugadorAzul.comprarUnidad("jinete",11,9);
        jugadorRojo.comprarUnidad("jinete",11,10);
        jugadorAzul.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(11,9,11,10);

        Assertions.assertEquals(95, tablero.getPuntosDeVidaUnidadEnPosicion(11,10));
    }


    @Test
    public void testCuranderoAzulCuraAUnSoldadoAliadoQueEstaEnDistanciaCercanaYLeDa15PuntosDeVida(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);

        jugadorAzul.comprarUnidad("curandero",7,7);
        jugadorAzul.comprarUnidad("soldado",7,8);
        jugadorAzul.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(7,7,7,8);

        Assertions.assertEquals(115, tablero.getPuntosDeVidaUnidadEnPosicion(7,8));
    }

    @Test
    public void testCuranderoAzulNoPuedeCurarAUnaCatapultaAzul(){

        Tablero tablero = new Tablero();
        JugadorAzul jugadorAzul = new JugadorAzul("agus",tablero);

        jugadorAzul.comprarUnidad("curandero",15,2);
        jugadorAzul.comprarUnidad("catapulta",15,3);

        Assertions.assertThrows(NoSePuedenCurarUnidadesNoOrganicasException.class, () -> tablero.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(15,2,15,3));
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




}
