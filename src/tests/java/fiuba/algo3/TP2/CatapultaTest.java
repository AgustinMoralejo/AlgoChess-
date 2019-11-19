package fiuba.algo3.TP2;

import fiuba.algo3.TP2.Tablero.Casillero;

import java.util.ArrayList;

import fiuba.algo3.TP2.Unidad.Catapulta;
import fiuba.algo3.TP2.Unidad.Curandero;
import fiuba.algo3.TP2.Unidad.Jinete;
import fiuba.algo3.TP2.Unidad.Soldado;
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

    
}
