package fiuba.algo3.TP2;

import fiuba.algo3.TP2.AlgoChess.Jugador;
import fiuba.algo3.TP2.Tablero.Casillero;

import java.util.ArrayList;

import fiuba.algo3.TP2.Tablero.Tablero;
import fiuba.algo3.TP2.Unidad.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatapultaTest {

    @Test
    public void testCrearCatapultaTiene50DeVidaYCuesta5Puntos(){

        Catapulta catapulta = new Catapulta();

        Assertions.assertEquals(50, catapulta.getPuntosDeVida());
        Assertions.assertEquals(5, catapulta.getCosto());
    }

    @Test
    public void testCatapultaRecibe50PuntosDeDanio() {

        Catapulta catapulta = new Catapulta();

        catapulta.perderVida(50);
        Assertions.assertEquals(0, catapulta.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaSoldadoEnRango() {

        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();
        soldado.cambiarEstadoAlianzas();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(soldado);
        ArrayList<Casillero> zonas = new ArrayList();
        catapulta.atacar(zonas, 7, casillero);
        Assertions.assertEquals(79, soldado.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaCatapultaEnRango() {

    	Catapulta catapulta = new Catapulta();
        Catapulta catapulta1 = new Catapulta();
        catapulta1.cambiarEstadoAlianzas();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(catapulta1);
        ArrayList<Casillero> zonas = new ArrayList();
        catapulta.atacar(zonas, 7, casillero);
        Assertions.assertEquals(29, catapulta1.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaJineteEnRango() {

        Catapulta catapulta = new Catapulta();
        Jinete jinete = new Jinete();
        jinete.cambiarEstadoAlianzas();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(jinete);
        ArrayList<Casillero> zonas = new ArrayList();
        catapulta.atacar(zonas, 7, casillero);
        Assertions.assertEquals(79, jinete.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaCuranderoEnRango() {

        Catapulta catapulta = new Catapulta();
        Curandero curandero = new Curandero();
        curandero.cambiarEstadoAlianzas();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(curandero);
        ArrayList<Casillero> zonas = new ArrayList();
        catapulta.atacar(zonas, 7, casillero);
        Assertions.assertEquals(54, curandero.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaAUnaDistanciaLejana(){

        Tablero tablero = new Tablero();
        Jugador jugadorAzul = new Jugador("pedro", tablero);
        Jugador jugadorRojo = new Jugador("juan", tablero);
        jugadorAzul.comprarUnidad("soldado", 3,1);
        jugadorAzul.comprarUnidad("curandero", 3,3);
        jugadorAzul.comprarUnidad("soldado", 3, 2);

        tablero.cambiarEstado();

        jugadorRojo.comprarUnidad("catapulta", 15, 15);

        jugadorRojo.atacar(15,15,3,2);
        Unidad soldado1 = tablero.getUnidad(3,1);
        Unidad soldado2 = tablero.getUnidad(3,2);
        Unidad curandero = tablero.getUnidad(3,3);
        Assertions.assertEquals(80, soldado1.getPuntosDeVida());
        Assertions.assertEquals(80, soldado2.getPuntosDeVida());
        Assertions.assertEquals(55, curandero.getPuntosDeVida());
    }
}
