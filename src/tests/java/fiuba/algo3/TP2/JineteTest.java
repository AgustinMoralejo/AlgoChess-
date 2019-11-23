package fiuba.algo3.TP2;

import fiuba.algo3.TP2.Modelo.Excepciones.NoEstanDadasLasCondicionesDeAtaqueException;
import fiuba.algo3.TP2.Modelo.Excepciones.NoSePuedeAtacarAUnaUnidadAliadaException;
import fiuba.algo3.TP2.Modelo.Excepciones.ObjetivoFueraDeRangoException;

import java.util.ArrayList;

import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JineteTest {

    @Test
    public void testCrearJineteTiene100DeVidaYCuesta3Puntos(){

        Jinete jinete = new Jinete();

        Assertions.assertEquals(100, jinete.getPuntosDeVida());
        Assertions.assertEquals(3, jinete.getCosto());
    }


    @Test
    public void testJineteRecibe50PuntosDeDanio() {

        Jinete jinete = new Jinete();

        jinete.perderVida(50);
        Assertions.assertEquals(50, jinete.getPuntosDeVida());
    }
    
    @Test 
    public void testJineteAtacaEnemigoMediaDistanciaSinUnidadesCercanas() {
    	
    	Unidad unidad1 = new UnidadNull();
    	Unidad unidad2 = new UnidadNull();
    	Unidad unidad3 = new UnidadNull();
    	Unidad unidad4 = new UnidadNull();
    	
    	Casillero zona1 = new Casillero(1,1);
    	Casillero zona2 = new Casillero(2,2);
    	Casillero zona3 = new Casillero(3,3);
    	Casillero zona4 = new Casillero(4,4);
    	
    	zona1.ocuparUnidad(unidad1);
    	zona2.ocuparUnidad(unidad2);
    	zona3.ocuparUnidad(unidad3);
    	zona4.ocuparUnidad(unidad4);
    	
    	ArrayList<Casillero> zonasCercanas = new ArrayList();
    	zonasCercanas.add(zona1);
    	zonasCercanas.add(zona2);
    	zonasCercanas.add(zona3);
    	zonasCercanas.add(zona4);
    	
    	Jinete jinete = new Jinete();
    	Soldado soldado = new Soldado();
    	soldado.cambiarEstadoAlianzas();
    	
    	Casillero zonaDefensa = new Casillero(1,2);
    	zonaDefensa.ocuparUnidad(soldado);
    	
    	jinete.atacar(zonasCercanas, 4, zonaDefensa);
    	
    	Assertions.assertEquals(85, soldado.getPuntosDeVida());
    }
    
    @Test
    public void testJineteNoPuedeAtacarCortaDistanciaSinUnidadesCercanas() {
    	
    	Unidad unidad1 = new UnidadNull();
    	Unidad unidad2 = new UnidadNull();
    	Unidad unidad3 = new UnidadNull();
    	Unidad unidad4 = new UnidadNull();
    	
    	Casillero zona1 = new Casillero(1,1);
    	Casillero zona2 = new Casillero(2,2);
    	Casillero zona3 = new Casillero(3,3);
    	Casillero zona4 = new Casillero(4,4);
    	
    	zona1.ocuparUnidad(unidad1);
    	zona2.ocuparUnidad(unidad2);
    	zona3.ocuparUnidad(unidad3);
    	zona4.ocuparUnidad(unidad4);
    	
    	ArrayList<Casillero> zonasCercanas = new ArrayList();
    	zonasCercanas.add(zona1);
    	zonasCercanas.add(zona2);
    	zonasCercanas.add(zona3);
    	zonasCercanas.add(zona4);
    	
    	Jinete jinete = new Jinete();
    	Soldado soldado = new Soldado();
    	soldado.cambiarEstadoAlianzas();
    	
    	Casillero zonaDefensa = new Casillero(1,2);
    	zonaDefensa.ocuparUnidad(soldado);
    	
    	Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> jinete.atacar(zonasCercanas, 2, zonaDefensa));
    	
    }
    
    @Test
    public void testJineteAtacaConArcoSiHayUnSoldadoCerca() {
    	
    	Unidad unidad1 = new UnidadNull();
    	Unidad unidad2 = new UnidadNull();
    	Unidad unidad3 = new Soldado();
    	Unidad unidad4 = new UnidadNull();
    	
    	Casillero zona1 = new Casillero(1,1);
    	Casillero zona2 = new Casillero(2,2);
    	Casillero zona3 = new Casillero(3,3);
    	Casillero zona4 = new Casillero(4,4);
    	
    	zona1.ocuparUnidad(unidad1);
    	zona2.ocuparUnidad(unidad2);
    	zona3.ocuparUnidad(unidad3);
    	zona4.ocuparUnidad(unidad4);
    	
    	ArrayList<Casillero> zonasCercanas = new ArrayList();
    	zonasCercanas.add(zona1);
    	zonasCercanas.add(zona2);
    	zonasCercanas.add(zona3);
    	zonasCercanas.add(zona4);
    	
    	Jinete jinete = new Jinete();
    	Soldado soldado = new Soldado();
    	soldado.cambiarEstadoAlianzas();
    	
    	Casillero zonaDefensa = new Casillero(1,2);
    	zonaDefensa.ocuparUnidad(soldado);
    	
    	jinete.atacar(zonasCercanas, 4, zonaDefensa);
    	
    	Assertions.assertEquals(85, soldado.getPuntosDeVida());
    }
    
    @Test
    public void testJineteNoPuedeAtacarDistanciaCortaConUnSoldadoAliadoCerca() {
    	
    	Unidad unidad1 = new UnidadNull();
    	Unidad unidad2 = new UnidadNull();
    	Unidad unidad3 = new Soldado();
    	Unidad unidad4 = new UnidadNull();
    	
    	Casillero zona1 = new Casillero(1,1);
    	Casillero zona2 = new Casillero(2,2);
    	Casillero zona3 = new Casillero(3,3);
    	Casillero zona4 = new Casillero(4,4);
    	
    	zona1.ocuparUnidad(unidad1);
    	zona2.ocuparUnidad(unidad2);
    	zona3.ocuparUnidad(unidad3);
    	zona4.ocuparUnidad(unidad4);
    	
    	ArrayList<Casillero> zonasCercanas = new ArrayList();
    	zonasCercanas.add(zona1);
    	zonasCercanas.add(zona2);
    	zonasCercanas.add(zona3);
    	zonasCercanas.add(zona4);
    	
    	Jinete jinete = new Jinete();
    	Soldado soldado = new Soldado();
    	soldado.cambiarEstadoAlianzas();
    	
    	Casillero zonaDefensa = new Casillero(1,2);
    	zonaDefensa.ocuparUnidad(soldado);
    	
    	Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> jinete.atacar(zonasCercanas, 2, zonaDefensa));
    }
    
    @Test
    public void testJineteAtacaConArcoSiEstaRodeadoSoloDeAliados() {
    	
    	Unidad unidad1 = new Catapulta();
    	Unidad unidad2 = new Curandero();
    	Unidad unidad3 = new Soldado();
    	Unidad unidad4 = new Jinete();
    	
    	Casillero zona1 = new Casillero(1,1);
    	Casillero zona2 = new Casillero(2,2);
    	Casillero zona3 = new Casillero(3,3);
    	Casillero zona4 = new Casillero(4,4);
    	
    	zona1.ocuparUnidad(unidad1);
    	zona2.ocuparUnidad(unidad2);
    	zona3.ocuparUnidad(unidad3);
    	zona4.ocuparUnidad(unidad4);
    	
    	ArrayList<Casillero> zonasCercanas = new ArrayList();
    	zonasCercanas.add(zona1);
    	zonasCercanas.add(zona2);
    	zonasCercanas.add(zona3);
    	zonasCercanas.add(zona4);
    	
    	Jinete jinete = new Jinete();
    	Soldado soldado = new Soldado();
    	soldado.cambiarEstadoAlianzas();
    	
    	Casillero zonaDefensa = new Casillero(1,2);
    	zonaDefensa.ocuparUnidad(soldado);
    	
    	jinete.atacar(zonasCercanas, 4, zonaDefensa);
    	Assertions.assertEquals(85, soldado.getPuntosDeVida());
    }
    
    @Test
    public void testJineteSinAliadosYConUnEnemigoCercaAtacaConEspada() {
    	
    	Unidad unidad1 = new UnidadNull();
    	Unidad unidad2 = new UnidadNull();
    	Unidad unidad3 = new Soldado();
    	Unidad unidad4 = new UnidadNull();
    	
    	unidad3.cambiarEstadoAlianzas();
    	
    	Casillero zona1 = new Casillero(1,1);
    	Casillero zona2 = new Casillero(2,2);
    	Casillero zona3 = new Casillero(3,3);
    	Casillero zona4 = new Casillero(4,4);
    	
    	zona1.ocuparUnidad(unidad1);
    	zona2.ocuparUnidad(unidad2);
    	zona3.ocuparUnidad(unidad3);
    	zona4.ocuparUnidad(unidad4);
    	
    	ArrayList<Casillero> zonasCercanas = new ArrayList();
    	zonasCercanas.add(zona1);
    	zonasCercanas.add(zona2);
    	zonasCercanas.add(zona3);
    	zonasCercanas.add(zona4);
    	
    	Jinete jinete = new Jinete();
    	Soldado soldado = new Soldado();
    	soldado.cambiarEstadoAlianzas();
    	
    	Casillero zonaDefensa = new Casillero(1,2);
    	zonaDefensa.ocuparUnidad(soldado);
    	
    	jinete.atacar(zonasCercanas, 2, zonaDefensa);
    	
    	Assertions.assertEquals(95, soldado.getPuntosDeVida());
    }
    
    @Test
    public void testJineteSinAliadosYConUnEnemigoCercaNoPuedeAtacarEnDistanciaMedia() {
    	
    	Unidad unidad1 = new UnidadNull();
    	Unidad unidad2 = new UnidadNull();
    	Unidad unidad3 = new Soldado();
    	Unidad unidad4 = new UnidadNull();
    	
    	unidad3.cambiarEstadoAlianzas();
    	
    	Casillero zona1 = new Casillero(1,1);
    	Casillero zona2 = new Casillero(2,2);
    	Casillero zona3 = new Casillero(3,3);
    	Casillero zona4 = new Casillero(4,4);
    	
    	zona1.ocuparUnidad(unidad1);
    	zona2.ocuparUnidad(unidad2);
    	zona3.ocuparUnidad(unidad3);
    	zona4.ocuparUnidad(unidad4);
    	
    	ArrayList<Casillero> zonasCercanas = new ArrayList();
    	zonasCercanas.add(zona1);
    	zonasCercanas.add(zona2);
    	zonasCercanas.add(zona3);
    	zonasCercanas.add(zona4);
    	
    	Jinete jinete = new Jinete();
    	Soldado soldado = new Soldado();
    	soldado.cambiarEstadoAlianzas();
    	
    	Casillero zonaDefensa = new Casillero(1,2);
    	zonaDefensa.ocuparUnidad(soldado);
    	
    	Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> jinete.atacar(zonasCercanas, 4, zonaDefensa));
    }
    
    @Test
    public void testJineteNoPuedeAtacarConArmasConAliadosQueNoSonSoldadosYConEnemigosCerca() {
    	
    	Unidad unidad1 = new Curandero();
    	Unidad unidad2 = new Catapulta();
    	Unidad unidad3 = new Soldado();
    	Unidad unidad4 = new UnidadNull();
    	
    	unidad3.cambiarEstadoAlianzas();
    	
    	Casillero zona1 = new Casillero(1,1);
    	Casillero zona2 = new Casillero(2,2);
    	Casillero zona3 = new Casillero(3,3);
    	Casillero zona4 = new Casillero(4,4);
    	
    	zona1.ocuparUnidad(unidad1);
    	zona2.ocuparUnidad(unidad2);
    	zona3.ocuparUnidad(unidad3);
    	zona4.ocuparUnidad(unidad4);
    	
    	ArrayList<Casillero> zonasCercanas = new ArrayList();
    	zonasCercanas.add(zona1);
    	zonasCercanas.add(zona2);
    	zonasCercanas.add(zona3);
    	zonasCercanas.add(zona4);
    	
    	Jinete jinete = new Jinete();
    	Soldado soldado = new Soldado();
    	soldado.cambiarEstadoAlianzas();
    	
    	Casillero zonaDefensa = new Casillero(1,2);
    	zonaDefensa.ocuparUnidad(soldado);
    	
    	Assertions.assertThrows(NoEstanDadasLasCondicionesDeAtaqueException.class, () -> jinete.atacar(zonasCercanas, 2, zonaDefensa));
    	Assertions.assertThrows(NoEstanDadasLasCondicionesDeAtaqueException.class, () -> jinete.atacar(zonasCercanas, 2, zonaDefensa));
    } 
    
    @Test
    public void testJineteNoPuedeAtacarUnidadAliada() {
    	
    	Jinete jinete = new Jinete();
    	Soldado soldado = new Soldado();
    	
    	Casillero zonaDefensa = new Casillero(1,2);
    	zonaDefensa.ocuparUnidad(soldado);
    	ArrayList<Casillero> zonasCercanas = new ArrayList();
    	
    	Assertions.assertThrows(NoSePuedeAtacarAUnaUnidadAliadaException.class, () -> jinete.atacar(zonasCercanas, 4, zonaDefensa));
    }
}
