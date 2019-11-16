import Fiuba.Excepciones.CasilleroEstaOcupadoException;
import Fiuba.Excepciones.CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException;
import Fiuba.Excepciones.UnidadNoMovibleException;
import Fiuba.Unidad.*;
import Fiuba.Tablero.Tablero;
import Fiuba.AlgoChess.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovimientosUnidadesTest {

    /* Norte */

    @Test
    public void testSoldadoEnTableroSeMueveHaciaArribaYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero, "aliado");
        jugador.comprarUnidad("soldado",1,1);

        tablero.moverUnidad(1,1, Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertTrue(tablero.estaOcupado(0,1));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }

    @Test
    public void testJineteEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertTrue(tablero.estaOcupado(14,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }


    @Test
    public void testCuranderoEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertTrue(tablero.estaOcupado(14,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }


    @Test
    public void testCatapultaEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertTrue(tablero.estaOcupado(14,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    /* Noreste */

    @Test
    public void testSoldadoEnTableroSeMueveAlNoresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertTrue(tablero.estaOcupado(14,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }

    @Test
    public void testJineteEnTableroSeMueveAlNoresteYLoOcupaConExito(){


        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertTrue(tablero.estaOcupado(14,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlNoresteYLoOcupaConExito(){


        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertTrue(tablero.estaOcupado(14,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }

    @Test
    public void testCatapultaEnTableroSeMueveAlNoresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertTrue(tablero.estaOcupado(14,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }

    /* Este */

    @Test
    public void testSoldadoEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertTrue(tablero.estaOcupado(15,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    @Test
    public void testJineteEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertTrue(tablero.estaOcupado(15,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertTrue(tablero.estaOcupado(15,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }

    @Test
    public void testCatapultaEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertTrue(tablero.estaOcupado(15,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    /* Sureste */

    @Test
    public void testSoldadoEnTableroSeMueveAlSuresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertTrue(tablero.estaOcupado(16,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }


    @Test
    public void testJineteEnTableroSeMueveAlSurEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertTrue(tablero.estaOcupado(16,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }


    @Test
    public void testCuranderoEnTableroSeMueveAlSurEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertTrue(tablero.estaOcupado(16,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlSurEsteYLoOcupaConExito(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertTrue(tablero.estaOcupado(16,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    /* Sur */

    @Test
    public void testSoldadoEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertTrue(tablero.estaOcupado(16,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testJineteEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertTrue(tablero.estaOcupado(16,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));


    }


    @Test
    public void testCuranderoEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertTrue(tablero.estaOcupado(16,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }

    @Test
    public void testCatapultaEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertTrue(tablero.estaOcupado(16,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }

    /* Suroeste */

    @Test
    public void testSoldadoEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertTrue(tablero.estaOcupado(16,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testJineteEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertTrue(tablero.estaOcupado(16,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertTrue(tablero.estaOcupado(16,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertTrue(tablero.estaOcupado(16,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    /* Oeste */

    @Test
    public void testSoldadoEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertTrue(tablero.estaOcupado(15,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }


    @Test
    public void testJineteEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertTrue(tablero.estaOcupado(15,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertTrue(tablero.estaOcupado(15,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertTrue(tablero.estaOcupado(15,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    /* Noroeste */

    @Test
    public void testSoldadoEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);

        Assertions.assertTrue(tablero.estaOcupado(14,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testJineteEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);

        Assertions.assertTrue(tablero.estaOcupado(14,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }


    @Test
    public void testCuranderoEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);

        Assertions.assertTrue(tablero.estaOcupado(14,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);

        Assertions.assertTrue(tablero.estaOcupado(14,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }


    @Test
    public void testUnidadNoPuedeMoverseAUnEspacioOcupado(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        jugador.comprarUnidad("soldado",15,16);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () -> tablero.moverUnidad(15,16,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]));


    }

    @Test
    public void testJugadorAliadoTrataDeMoverUnaUnidadEnemigaYNoPuede(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");
        Jugador jugadorEnemigo = new Jugador("lego", tablero, "enemigo");

        jugadorAliado.comprarUnidad("jinete",15,6);
        jugadorEnemigo.comprarUnidad("soldado", 8,15);

        Assertions.assertThrows(CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException.class,
                () -> jugadorAliado.moverUnidad(8,15,0));


    }


    @Test
    public void testJugadorAliadoTrataDeMoverUnaUnidadQueNoEstaEnElCasilleroYNoPuede(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");

        jugadorAliado.comprarUnidad("jinete",15,6);

        Assertions.assertThrows(CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException.class,
                () -> jugadorAliado.moverUnidad(3,3,0));

    }

    @Test
    public void testJugadorAliadoMueveUnSoldadoQueTieneOtrosDosAdyacentesYLosTresSeMuevenALaVez(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");

        jugadorAliado.comprarUnidad("soldado",14,5);
        jugadorAliado.comprarUnidad("soldado",14,6);
        jugadorAliado.comprarUnidad("soldado",14,7);

        jugadorAliado.moverUnidad(14,6,0);


        Assertions.assertFalse(tablero.estaOcupado(14,5));
        Assertions.assertFalse(tablero.estaOcupado(14,6));
        Assertions.assertFalse(tablero.estaOcupado(14,7));
        Assertions.assertTrue(tablero.estaOcupado(13,5));
        Assertions.assertTrue(tablero.estaOcupado(13,6));
        Assertions.assertTrue(tablero.estaOcupado(13,7));

    }

    @Test
    public void testJugadorAliadoMueveUnSoldadoQueTieneSoloUnoAdyacenteYElOtroNoSeMueve(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");

        jugadorAliado.comprarUnidad("soldado",14,5);
        jugadorAliado.comprarUnidad("soldado",14,6);

        jugadorAliado.moverUnidad(14,5,0);

        Assertions.assertTrue(tablero.estaOcupado(13,5));

        Assertions.assertFalse(tablero.estaOcupado(13,6));
        Assertions.assertTrue(tablero.estaOcupado(14,6));

    }

    @Test
    public void testJugadorAliadoMueveUnSoldadoQueTieneUnoSoloAdyacentePeroEsteTieneOtroAdyacentePorLoQueSeMuevenLosTres(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");

        jugadorAliado.comprarUnidad("soldado",14,5);
        jugadorAliado.comprarUnidad("soldado",14,6);
        jugadorAliado.comprarUnidad("soldado",14,7);

        jugadorAliado.moverUnidad(14,5,0);


        Assertions.assertFalse(tablero.estaOcupado(14,5));
        Assertions.assertFalse(tablero.estaOcupado(14,6));
        Assertions.assertFalse(tablero.estaOcupado(14,7));
        Assertions.assertTrue(tablero.estaOcupado(13,5));
        Assertions.assertTrue(tablero.estaOcupado(13,6));
        Assertions.assertTrue(tablero.estaOcupado(13,7));

    }


    @Test
    public void testJugadorAliadoMueveUnBatallonEnColumnaHaciaElNorteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");

        jugadorAliado.comprarUnidad("soldado",14,5);
        jugadorAliado.comprarUnidad("soldado",15,5);
        jugadorAliado.comprarUnidad("soldado",16,5);

        jugadorAliado.moverUnidad(14,5,0);

        Assertions.assertFalse(tablero.estaOcupado(16,5));
        Assertions.assertTrue(tablero.estaOcupado(13,5));
        Assertions.assertTrue(tablero.estaOcupado(14,5));
        Assertions.assertTrue(tablero.estaOcupado(15,5));

    }

    @Test
    public void testJugadorAliadoMueveUnBatallonEnFilaHaciaElEsteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");

        jugadorAliado.comprarUnidad("soldado",14,5);
        jugadorAliado.comprarUnidad("soldado",14,6);
        jugadorAliado.comprarUnidad("soldado",14,7);

        jugadorAliado.moverUnidad(14,5,2);

        Assertions.assertFalse(tablero.estaOcupado(14,5));
        Assertions.assertTrue(tablero.estaOcupado(14,6));
        Assertions.assertTrue(tablero.estaOcupado(14,7));
        Assertions.assertTrue(tablero.estaOcupado(14,8));

    }


    @Test
    public void testJugadorAliadoMueveUnBatallonEnColumnaHaciaElSurYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");

        jugadorAliado.comprarUnidad("soldado",14,5);
        jugadorAliado.comprarUnidad("soldado",15,5);
        jugadorAliado.comprarUnidad("soldado",16,5);

        jugadorAliado.moverUnidad(14,5,4);

        Assertions.assertFalse(tablero.estaOcupado(14,5));
        Assertions.assertTrue(tablero.estaOcupado(15,5));
        Assertions.assertTrue(tablero.estaOcupado(16,5));
        Assertions.assertTrue(tablero.estaOcupado(17,5));

    }

    @Test
    public void testJugadorAliadoMueveUnBatallonEnFilaHaciaElOesteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");

        jugadorAliado.comprarUnidad("soldado",14,5);
        jugadorAliado.comprarUnidad("soldado",14,6);
        jugadorAliado.comprarUnidad("soldado",14,7);

        jugadorAliado.moverUnidad(14,5,6);

        Assertions.assertFalse(tablero.estaOcupado(14,7));
        Assertions.assertTrue(tablero.estaOcupado(14,4));
        Assertions.assertTrue(tablero.estaOcupado(14,5));
        Assertions.assertTrue(tablero.estaOcupado(14,6));

    }


    @Test
    public void testJugadorAliadoMueveUnBatallonHaciaElNoresteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");

        jugadorAliado.comprarUnidad("soldado",14,5);
        jugadorAliado.comprarUnidad("soldado",13,6);
        jugadorAliado.comprarUnidad("soldado",14,7);

        jugadorAliado.moverUnidad(14,5,1);

        Assertions.assertTrue(tablero.estaOcupado(13,6));
        Assertions.assertTrue(tablero.estaOcupado(12,7));
        Assertions.assertTrue(tablero.estaOcupado(13,8));

    }

    @Test
    public void testJugadorAliadoMueveUnBatallonHaciaElSuresteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");

        jugadorAliado.comprarUnidad("soldado",12,5);
        jugadorAliado.comprarUnidad("soldado",11,6);
        jugadorAliado.comprarUnidad("soldado",10,7);

        jugadorAliado.moverUnidad(10,7,1);

        Assertions.assertTrue(tablero.estaOcupado(11,6));
        Assertions.assertTrue(tablero.estaOcupado(10,7));
        Assertions.assertTrue(tablero.estaOcupado(9,8));

    }

    @Test
    public void testJugadorAliadoMueveUnBatallonHaciaElSuroesteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");

        jugadorAliado.comprarUnidad("soldado",4,3);
        jugadorAliado.comprarUnidad("soldado",5,4);
        jugadorAliado.comprarUnidad("soldado",6,5);

        jugadorAliado.moverUnidad(4,3,5);

        Assertions.assertTrue(tablero.estaOcupado(5,2));
        Assertions.assertTrue(tablero.estaOcupado(6,3));
        Assertions.assertTrue(tablero.estaOcupado(7,4));

    }

    @Test
    public void testJugadorAliadoMueveUnBatallonHaciaElNoroesteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");

        jugadorAliado.comprarUnidad("soldado",7,5);
        jugadorAliado.comprarUnidad("soldado",7,6);
        jugadorAliado.comprarUnidad("soldado",8,7);

        jugadorAliado.moverUnidad(8,7,5);

        Assertions.assertTrue(tablero.estaOcupado(8,4));
        Assertions.assertTrue(tablero.estaOcupado(8,5));
        Assertions.assertTrue(tablero.estaOcupado(9,6));

    }

    @Test
    public void testJugadorAliadoMueveUnSoldadoQueNoConformaUnBatallonYLosOtrosSoldadosNoSeMueven(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero, "aliado");

        jugadorAliado.comprarUnidad("soldado",7,5);
        jugadorAliado.comprarUnidad("soldado",7,7);
        jugadorAliado.comprarUnidad("soldado",9,5);

        jugadorAliado.moverUnidad(7,5,0);

        Assertions.assertTrue(tablero.estaOcupado(6,5));
        Assertions.assertTrue(tablero.estaOcupado(7,7));
        Assertions.assertTrue(tablero.estaOcupado(9,5));

    }





}
