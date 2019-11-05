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
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,5));

    }

    @Test
    public void testJineteEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();

        tablero.colocarUnidad(jinete,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,5));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero();

        tablero.colocarUnidad(curandero,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,5));

    }

    @Test
    public void testCatapultaEnTableroSeMueveAlNorteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta();
        String resultado = "Sin excepciones.";

        tablero.colocarUnidad(catapulta,5,5);
        try {
            tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);
        }
        catch(UnidadNoMovibleException ex){
            resultado = "NoEsPosibleMoverLaUnidad";
        }

        assertEquals("NoEsPosibleMoverLaUnidad",resultado);

    }

    /* Noreste */

    @Test
    public void testSoldadoEnTableroSeMueveAlNoresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,6));

    }

    @Test
    public void testJineteEnTableroSeMueveAlNoresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();

        tablero.colocarUnidad(jinete,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,6));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlNoresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero();

        tablero.colocarUnidad(curandero,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,6));

    }

    @Test
    public void testCatapultaEnTableroSeMueveAlNoresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta();
        String resultado = "Sin excepciones.";

        tablero.colocarUnidad(catapulta,5,5);
        try {
            tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1]);
        }
        catch(UnidadNoMovibleException ex){
            resultado = "NoEsPosibleMoverLaUnidad";
        }

        assertEquals("NoEsPosibleMoverLaUnidad",resultado);

    }



    /* Este */
    @Test
    public void testSoldadoEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(5,6));

    }

    @Test
    public void testJineteEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();

        tablero.colocarUnidad(jinete,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(5,6));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero();

        tablero.colocarUnidad(curandero,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(5,6));

    }

    @Test
    public void testCatapultaEnTableroSeMueveAlEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta();
        String resultado = "Sin excepciones.";

        tablero.colocarUnidad(catapulta,5,5);
        try {
            tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);
        }
        catch(UnidadNoMovibleException ex){
            resultado = "NoEsPosibleMoverLaUnidad";
        }

        assertEquals("NoEsPosibleMoverLaUnidad",resultado);

    }



    /* Sureste */

    @Test
    public void testSoldadoEnTableroSeMueveAlSuresteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,6));

    }


    @Test
    public void testJineteEnTableroSeMueveAlSurEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();

        tablero.colocarUnidad(jinete,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,6));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlSurEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero();

        tablero.colocarUnidad(curandero,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,6));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlSurEsteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta();
        String resultado = "Sin excepciones.";

        tablero.colocarUnidad(catapulta,5,5);
        try {
            tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);
        }
        catch(UnidadNoMovibleException ex){
            resultado = "NoEsPosibleMoverLaUnidad";
        }

        assertEquals("NoEsPosibleMoverLaUnidad",resultado);

    }

    /* Sur */

    @Test
    public void testSoldadoEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,5));

    }


    @Test
    public void testJineteEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();

        tablero.colocarUnidad(jinete,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,5));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero();

        tablero.colocarUnidad(curandero,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,5));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlSurYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta();
        String resultado = "Sin excepciones.";

        tablero.colocarUnidad(catapulta,5,5);
        try {
            tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);
        }
        catch(UnidadNoMovibleException ex){
            resultado = "NoEsPosibleMoverLaUnidad";
        }

        assertEquals("NoEsPosibleMoverLaUnidad",resultado);

    }



    /* Suroeste */

    @Test
    public void testSoldadoEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,4));

    }


    @Test
    public void testJineteEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();

        tablero.colocarUnidad(jinete,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,4));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero();

        tablero.colocarUnidad(curandero,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(6,4));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta();
        String resultado = "Sin excepciones.";

        tablero.colocarUnidad(catapulta,5,5);
        try {
            tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);
        }
        catch(UnidadNoMovibleException ex){
            resultado = "NoEsPosibleMoverLaUnidad";
        }

        assertEquals("NoEsPosibleMoverLaUnidad",resultado);

    }


    /* Oeste */

    @Test
    public void testSoldadoEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(5,4));

    }


    @Test
    public void testJineteEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();

        tablero.colocarUnidad(jinete,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(5,4));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero();

        tablero.colocarUnidad(curandero,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(5,4));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlOesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta();
        String resultado = "Sin excepciones.";

        tablero.colocarUnidad(catapulta,5,5);
        try {
            tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);
        }
        catch(UnidadNoMovibleException ex){
            resultado = "NoEsPosibleMoverLaUnidad";
        }

        assertEquals("NoEsPosibleMoverLaUnidad",resultado);

    }


    /* Noroeste */

    @Test
    public void testSoldadoEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();

        tablero.colocarUnidad(soldado,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,4));

    }


    @Test
    public void testJineteEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();

        tablero.colocarUnidad(jinete,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,4));

    }


    @Test
    public void testCuranderoEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero();

        tablero.colocarUnidad(curandero,5,5);
        tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7]);

        Assertions.assertTrue(tablero.estaVacio(5,5));
        Assertions.assertFalse(tablero.estaVacio(4,4));
    }

    @Test
    public void testCatapultaEnTableroSeMueveAlNoroesteYLoOcupaConExito(){

        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta();
        String resultado = "Sin excepciones.";

        tablero.colocarUnidad(catapulta,5,5);
        try {
            tablero.moverUnidad(5,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);
        }
        catch(UnidadNoMovibleException ex){
            resultado = "NoEsPosibleMoverLaUnidad";
        }

        assertEquals("NoEsPosibleMoverLaUnidad",resultado);

    }

    /** De integracion */

    @Test
    public void testJineteEnTableroSeMueveNorteEsteSurOesteSurYVuelveASuPosicionInicial(){

        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();

        tablero.colocarUnidad(jinete,12,4);
        tablero.moverUnidad(12,4,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);
        tablero.moverUnidad(11,4,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);
        tablero.moverUnidad(11,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);
        tablero.moverUnidad(12,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);

        Assertions.assertFalse(tablero.estaVacio(12,4));

    }


    @Test
    public void testCuranderoEnTableroSeMueveNorteEsteSurOesteSurYVuelveASuPosicionInicial(){

        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero();

        tablero.imprimirTablero();
        tablero.colocarUnidad(curandero,12,4);
        tablero.imprimirTablero();
        tablero.moverUnidad(12,4,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0]);
        tablero.imprimirTablero();
        tablero.moverUnidad(11,4,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2]);
        tablero.imprimirTablero();
        tablero.moverUnidad(11,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4]);
        tablero.imprimirTablero();
        tablero.moverUnidad(12,5,Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6]);
        tablero.imprimirTablero();

        Assertions.assertFalse(tablero.estaVacio(12,4));

    }



}
