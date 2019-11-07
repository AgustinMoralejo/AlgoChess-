import Fiuba.Excepciones.CasilleroEstaOcupadoException;
import Fiuba.Excepciones.UnidadNoMovibleException;
import Fiuba.Unidad.*;
import Fiuba.Tablero.Tablero;
import Fiuba.AlgoChess.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovimientoUnidadesTest {

    /* Norte */

    @Test
    public void testSoldadoEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(14,15));


    }

    @Test
    public void testJineteEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(14,15));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(14,15));

    }

    @Test
    public void testCatapultaEnTableroSeMueveAlNorteYLoOcupaConExito(){


        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("catapulta",15,15);


        Assertions.assertThrows(UnidadNoMovibleException.class, () -> tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]));

    }

    /* Noreste */

    @Test
    public void testSoldadoEnTableroSeMueveAlNoresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(14,16));

    }

    @Test
    public void testJineteEnTableroSeMueveAlNoresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(14,16));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlNoresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(14,16));

    }

    @Test
    public void testCatapultaEnTableroSeMueveAlNoresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("catapulta",15,15);


        Assertions.assertThrows(UnidadNoMovibleException.class, () -> tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]));

    }



    /* Este */
    @Test
    public void testSoldadoEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(15,16));

    }

    @Test
    public void testJineteEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(15,16));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(15,16));

    }

    @Test
    public void testCatapultaEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("catapulta",15,15);


        Assertions.assertThrows(UnidadNoMovibleException.class, () -> tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]));

    }



    /* Sureste */

    @Test
    public void testSoldadoEnTableroSeMueveAlSuresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(16,16));


    }


    @Test
    public void testJineteEnTableroSeMueveAlSurEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(16,16));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlSurEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);


        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(16,16));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlSurEsteYLoOcupaConExito(){
        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("catapulta",15,15);


        Assertions.assertThrows(UnidadNoMovibleException.class, () -> tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]));

    }

    /* Sur */

    @Test
    public void testSoldadoEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(16,15));

    }


    @Test
    public void testJineteEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(16,15));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);


        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(16,15));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlSurYLoOcupaConExito(){
        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("catapulta",15,15);


        Assertions.assertThrows(UnidadNoMovibleException.class, () -> tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]));

    }



    /* Suroeste */

    @Test
    public void testSoldadoEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(16,14));

    }


    @Test
    public void testJineteEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);


        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(16,14));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(16,14));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlSuroesteYLoOcupaConExito(){
        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("catapulta",15,15);


        Assertions.assertThrows(UnidadNoMovibleException.class, () -> tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]));

    }


    /* Oeste */

    @Test
    public void testSoldadoEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(15,14));


    }


    @Test
    public void testJineteEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(15,14));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);


        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(15,14));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlOesteYLoOcupaConExito(){
        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("catapulta",15,15);


        Assertions.assertThrows(UnidadNoMovibleException.class, () -> tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]));

    }


    /* Noroeste */

    @Test
    public void testSoldadoEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("soldado",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);

        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(14,14));

    }


    @Test
    public void testJineteEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("jinete",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);


        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(14,14));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("curandero",15,15);
        tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);


        Assertions.assertTrue(tablero.estaVacio(15,15));
        Assertions.assertFalse(tablero.estaVacio(14,14));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("catapulta",15,15);


        Assertions.assertThrows(UnidadNoMovibleException.class, () -> tablero.moverUnidad(15,15,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]));


    }

    @Test
    public void testUnidadNoPuedeMoverseAUnEspacioOcupado(){

        Tablero tablero = new Tablero();
        JugadorRojo jugadorRojo = new JugadorRojo("agus",tablero);

        jugadorRojo.comprarUnidad("catapulta",15,15);
        jugadorRojo.comprarUnidad("soldado",15,16);

        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () -> tablero.moverUnidad(15,16,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]));


    }

}
