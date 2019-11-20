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

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("pedro", tablero);
        Jugador jugadorEnemigo = new Jugador("juan", tablero);

        jugadorAliado.comprarUnidad("catapulta", 1, 1);

        tablero.cambiarEstado();

        jugadorEnemigo.comprarUnidad("curandero", 15,15);

        tablero.cambiarEstado();

        jugadorAliado.atacar(1,1,15,15);

        Unidad curandero = tablero.getUnidad(15,15);

        Assertions.assertEquals(55, curandero.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaAUnaDistanciaLejana(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("pedro", tablero);
        Jugador jugadorEnemigo = new Jugador("juan", tablero);

        jugadorAliado.comprarUnidad("soldado", 3,1);
        jugadorAliado.comprarUnidad("curandero", 3,3);
        jugadorAliado.comprarUnidad("soldado", 3, 2);

        tablero.cambiarEstado();

        jugadorEnemigo.comprarUnidad("catapulta", 15, 15);

        jugadorEnemigo.atacar(15,15,3,2);

        Unidad soldado1 = tablero.getUnidad(3,1);
        Unidad soldado2 = tablero.getUnidad(3,2);
        Unidad curandero = tablero.getUnidad(3,3);

        Assertions.assertEquals(80, soldado1.getPuntosDeVida());
        Assertions.assertEquals(80, soldado2.getPuntosDeVida());
        Assertions.assertEquals(55, curandero.getPuntosDeVida());
    }

    @Test
    public void testCatapultaAtacaATodasLasUnidadesAdyacentes(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("pedro", tablero);
        Jugador jugadorEnemigo = new Jugador("juan", tablero);

        jugadorAliado.comprarUnidad("soldado", 3,1);
        jugadorAliado.comprarUnidad("curandero", 3,3);
        jugadorAliado.comprarUnidad("soldado", 3, 2);
        jugadorAliado.comprarUnidad("jinete", 4,1);
        jugadorAliado.comprarUnidad("catapulta", 2,4);
        jugadorAliado.comprarUnidad("curandero",1,5);

        tablero.cambiarEstado();

        jugadorEnemigo.comprarUnidad("catapulta", 15, 15);

        jugadorEnemigo.atacar(15,15,3,2);

        Unidad soldado1 = tablero.getUnidad(3,1);
        Unidad curandero = tablero.getUnidad(3,3);
        Unidad soldado2 = tablero.getUnidad(3,2);
        Unidad jinete = tablero.getUnidad(4,1);
        Unidad catapulta = tablero.getUnidad(2,4);
        Unidad curandero2 = tablero.getUnidad(1,5);

        Assertions.assertEquals(80, soldado1.getPuntosDeVida());
        Assertions.assertEquals(80, soldado2.getPuntosDeVida());
        Assertions.assertEquals(55, curandero.getPuntosDeVida());
        Assertions.assertEquals(80, jinete.getPuntosDeVida());
        Assertions.assertEquals(30, catapulta.getPuntosDeVida());
        Assertions.assertEquals(55, curandero2.getPuntosDeVida());
    }
}
