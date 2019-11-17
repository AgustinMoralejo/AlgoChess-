import Fiuba.Excepciones.NoSePuedeCurarEnemigoException;
import Fiuba.Excepciones.NoSePuedenCurarUnidadesNoOrganicasException;

import java.util.ArrayList;

import Fiuba.Unidad.Catapulta;
import Fiuba.Unidad.Curandero;
import Fiuba.Unidad.Jinete;
import Fiuba.Unidad.Soldado;
import Fiuba.Tablero.Casillero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CuranderoTest {

    @Test
    public void testCrearCuranderoTiene75DeVidaYCuesta2Puntos(){

        Curandero curandero = new Curandero();

        Assertions.assertEquals(75, curandero.getPuntosDeVida());
        Assertions.assertEquals(2, curandero.getCosto());
    }


    @Test
    public void testCuranderoRecibe50PuntosDeDanio() {

        Curandero curandero = new Curandero();

        curandero.perderVida(50);
        Assertions.assertEquals(25, curandero.getPuntosDeVida());
    }

    @Test
    public void testCuranderoCuraSoldadoEnRango() {

        Curandero curandero = new Curandero();
        Soldado soldadoACurar = new Soldado();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(soldadoACurar);
        ArrayList<Casillero> zonas = new ArrayList();
        curandero.atacar(zonas,  2, casillero);
        Assertions.assertEquals(115, soldadoACurar.getPuntosDeVida());
    }

    @Test
    public void testCuranderoCuraJineteEnRango() {

    	Curandero curandero = new Curandero();
        Jinete jinete = new Jinete();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(jinete);
        ArrayList<Casillero> zonas = new ArrayList();
        curandero.atacar(zonas,  2, casillero);
        Assertions.assertEquals(115, jinete.getPuntosDeVida());
    }


    @Test
    public void testCuranderoCuraCuranderoEnRango() {

        Curandero curandero = new Curandero();
        Curandero curanderoACurar = new Curandero();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(curanderoACurar);
        ArrayList<Casillero> zonas = new ArrayList();
        curandero.atacar(zonas,  2, casillero);
        Assertions.assertEquals(90, curanderoACurar.getPuntosDeVida());
    }

    @Test
    public void testCuranderoNoPuedeCurarAUnidadEnemiga(){
        Curandero curandero = new Curandero();
        Jinete jinete = new Jinete();
        jinete.cambiarEstadoAlianzas();
        Casillero casillero = new Casillero(1,1);
        casillero.ocuparUnidad(jinete);
        ArrayList<Casillero> zonas = new ArrayList();
        
        Assertions.assertThrows(NoSePuedeCurarEnemigoException.class, () -> curandero.atacar(zonas, 1, casillero));
    }
    
    @Test
    public void testCuranderoNoPuedeCurarCatapultas() {
    	
    	Catapulta catapulta = new Catapulta();
    	Curandero curandero = new Curandero();
    	
    	Casillero casillero = new Casillero(2,2);
    	casillero.ocuparUnidad(catapulta);
    	
    	ArrayList<Casillero> zonasCercanas = new ArrayList();
    	
    	Assertions.assertThrows(NoSePuedenCurarUnidadesNoOrganicasException.class, () -> curandero.atacar(zonasCercanas, 2, casillero));
    	Assertions.assertEquals(50, catapulta.getPuntosDeVida());
    }
}
