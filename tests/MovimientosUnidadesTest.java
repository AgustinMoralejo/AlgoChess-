import Fiuba.Excepciones.CasilleroEstaOcupadoException;
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

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(0,1));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }

    @Test
    public void testJineteEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(14,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }


    @Test
    public void testCuranderoEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(14,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }


    @Test
    public void testCatapultaEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(14,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    /* Noreste */

    @Test
    public void testSoldadoEnTableroSeMueveAlNoresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(14,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }

    @Test
    public void testJineteEnTableroSeMueveAlNoresteYLoOcupaConExito(){


        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(14,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlNoresteYLoOcupaConExito(){


        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(14,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }

    @Test
    public void testCatapultaEnTableroSeMueveAlNoresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(14,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }

    /* Este */

    @Test
    public void testSoldadoEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(15,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    @Test
    public void testJineteEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(15,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(15,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }

    @Test
    public void testCatapultaEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(15,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    /* Sureste */

    @Test
    public void testSoldadoEnTableroSeMueveAlSuresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(16,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }


    @Test
    public void testJineteEnTableroSeMueveAlSurEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(16,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }


    @Test
    public void testCuranderoEnTableroSeMueveAlSurEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(16,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlSurEsteYLoOcupaConExito(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(16,16));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    /* Sur */

    @Test
    public void testSoldadoEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(16,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testJineteEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(16,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));


    }


    @Test
    public void testCuranderoEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(16,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }

    @Test
    public void testCatapultaEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(16,15));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }

    /* Suroeste */

    @Test
    public void testSoldadoEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(16,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testJineteEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(16,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(16,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(16,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    /* Oeste */

    @Test
    public void testSoldadoEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(15,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }


    @Test
    public void testJineteEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(15,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(15,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(15,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    /* Noroeste */

    @Test
    public void testSoldadoEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(14,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));

    }


    @Test
    public void testJineteEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(14,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }


    @Test
    public void testCuranderoEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(14,14));
        Assertions.assertFalse(tablero.estaOcupado(15,15));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("agus",tablero, "enemigo");

        jugador.comprarUnidad("catapulta",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () ->  tablero.estaOcupado(14,14));
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

}
