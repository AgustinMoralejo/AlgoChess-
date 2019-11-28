package fiuba.algo3.TP2;

import fiuba.algo3.TP2.Modelo.Excepciones.NoSePuedeAtacarAUnaUnidadAliadaException;
import fiuba.algo3.TP2.Modelo.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.Catapulta;
import fiuba.algo3.TP2.Modelo.Unidad.Curandero;
import fiuba.algo3.TP2.Modelo.Unidad.Jinete;
import fiuba.algo3.TP2.Modelo.Unidad.Soldado;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class SoldadoTest {

    @Test
    public void testCrearSoldadoDeInfanteriaTiene100DeVidaYCuesta1Puntos() {

        Soldado soldado = new Soldado();

        Assertions.assertEquals(100, soldado.getPuntosDeVida());
        Assertions.assertEquals(1, soldado.getCosto());
    }

    @Test
    public void testSoldadoRecibe50PuntosDeDanio() {

        Soldado soldado = new Soldado();

        soldado.perderVida(50);
        Assertions.assertEquals(50, soldado.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAtacaSoldadoEnRango() {

        Soldado soldado = new Soldado();
        Soldado soldadoAAtacar = new Soldado();
        soldadoAAtacar.cambiarEstadoAlianzas();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(soldadoAAtacar);
        ArrayList<Casillero> zonas = new ArrayList();
        soldado.atacar(zonas,  2, casillero);
        Assertions.assertEquals(90, soldadoAAtacar.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAtacaCatapultaEnRango() {

        Soldado soldado = new Soldado();
        Catapulta catapulta = new Catapulta();
        catapulta.cambiarEstadoAlianzas();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(catapulta);
        ArrayList<Casillero> zonas = new ArrayList();
        soldado.atacar(zonas,  2, casillero);
        Assertions.assertEquals(40, catapulta.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAtacaJineteEnRango() {

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(jinete);
        jinete.cambiarEstadoAlianzas();
        ArrayList<Casillero> zonas = new ArrayList();
        soldado.atacar(zonas,  2, casillero);
        Assertions.assertEquals(90, jinete.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAtacaCuranderoEnRango() {

        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();
        curandero.cambiarEstadoAlianzas();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(curandero);
        ArrayList<Casillero> zonas = new ArrayList();
        soldado.atacar(zonas,  2, casillero);
        Assertions.assertEquals(65, curandero.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAtacaSoldadoFueraDeRango() {

        Soldado soldado = new Soldado();
        Soldado soldadoAAtacar = new Soldado();
        soldadoAAtacar.cambiarEstadoAlianzas();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(soldadoAAtacar);
        ArrayList<Casillero> zonas = new ArrayList();
        Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> soldado.atacar(zonas, 3, casillero));
    }

    @Test
    public void testSoldadoNoPuedeAtacarAOtroSoldadoAliado(){

        Soldado soldado = new Soldado();
        Soldado soldadoAAtacar = new Soldado();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(soldadoAAtacar);
        ArrayList<Casillero> zonas = new ArrayList();
        Assertions.assertThrows(NoSePuedeAtacarAUnaUnidadAliadaException.class, () -> soldado.atacar(zonas,1,casillero));
    }
}
