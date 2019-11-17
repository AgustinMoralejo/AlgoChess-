import Fiuba.AlgoChess.*;
import Fiuba.Excepciones.*;
import Fiuba.Tablero.*;
import Fiuba.Unidad.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class AtaquesTest {

    @Test
    public void testSoldadoAtacaAOtroSoldadoQueEstaEnDistanciaCercanaYLeQuita10PuntosDeVida() {

        Soldado soldado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        soldadoEnemigo.cambiarEstadoAlianzas();
        
        Casillero zonaDefensa = new Casillero(2,2);
        zonaDefensa.ocuparUnidad(soldadoEnemigo);
        
        
        ArrayList<Casillero> zonasCercanas = new ArrayList(); 
        
        soldado.atacar(zonasCercanas, 2, zonaDefensa);

        Assertions.assertEquals(90, soldadoEnemigo.getPuntosDeVida());
    }
    
    @Test
    public void testSoldadoNoAtacaAOtroSoldadoEnDistanciaMedia() {
    	Soldado soldado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        soldadoEnemigo.cambiarEstadoAlianzas();
        
        Casillero zonaDefensa = new Casillero(2,2);
        zonaDefensa.ocuparUnidad(soldadoEnemigo);
        
        ArrayList<Casillero> zonasCercanas = new ArrayList(); 
        

        Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> soldado.atacar(zonasCercanas, 4, zonaDefensa));
        Assertions.assertEquals(100, soldadoEnemigo.getPuntosDeVida());
    }
    
    @Test
    public void testSoldadoAliadoAtacaAUnSoldadoEnemigoQueEstaEnDistanciaCercanaYLeQuita10PuntosDeVida() {
    	
    	Tablero tablero = new Tablero();
    	Jugador aliado = new Jugador("agus", tablero);
    	Jugador enemigo = new Jugador("lego", tablero);
    	
    	aliado.comprarUnidad("soldado", 9, 9);
    	tablero.cambiarEstado();
    	
    	enemigo.comprarUnidad("soldado", 11, 10);
    	
    	tablero.cambiarEstado();
    	
    	aliado.atacar(9, 9, 11, 10);
    	
    	Assertions.assertEquals(90, tablero.getPuntosDeVidaUnidadEnPosicion(11, 10));
    }
    
    @Test
    public void testSoldadoAliadoAtacaAUnSoldadoEnemigoQueNoEstaEnDistanciaCercanaYNoLeQuitaVida() {
    	
    	Tablero tablero = new Tablero();
    	Jugador aliado = new Jugador("agus", tablero);
    	Jugador enemigo = new Jugador("lego", tablero);
    	
    	aliado.comprarUnidad("soldado", 1, 8);
    	tablero.cambiarEstado();
    	
    	enemigo.comprarUnidad("soldado", 12, 14);
    	
    	tablero.cambiarEstado();
    	
    	Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> aliado.atacar(1, 8, 12, 14));
    }
    
    @Test
    public void testSoldadoNoPuedeAtacarUnaUnidadAliada() {
    	
    	Soldado soldado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        
        
        Casillero zonaDefensa = new Casillero(2,2);
        zonaDefensa.ocuparUnidad(soldadoEnemigo);
        
        
        ArrayList<Casillero> zonasCercanas = new ArrayList(); 
        
        Assertions.assertThrows(NoSePuedeAtacarAUnaUnidadAliadaException.class, () -> soldado.atacar(zonasCercanas, 2, zonaDefensa));
        
        

        Assertions.assertEquals(100, soldadoEnemigo.getPuntosDeVida());
    }
    
    
    @Test
    public void testCuranderoAzulCuraAUnSoldadoAliadoQueEstaEnDistanciaCercanaYLeDa15PuntosDeVida() {
    	
    	Soldado soldado = new Soldado();
    	Curandero curandero = new Curandero();
    	
    	Casillero casillero = new Casillero(2,2);
    	casillero.ocuparUnidad(soldado);
    	
    	ArrayList<Casillero> zonasCercanas = new ArrayList();
    	
    	curandero.atacar(zonasCercanas, 1, casillero);
    	
    	Assertions.assertEquals(115, soldado.getPuntosDeVida());
    	
    }
    
    @Test
    public void testCuranderoNoPuedeCurarCatapultas() {
    	
    	Tablero tablero = new Tablero();
    	Jugador jugadorAzul = new Jugador("agus", tablero);
    	jugadorAzul.comprarUnidad("curandero", 1,1);
    	jugadorAzul.comprarUnidad("catapulta", 1, 2);
    	
    	Assertions.assertThrows(NoSePuedenCurarUnidadesNoOrganicasException.class, () 
    			-> jugadorAzul.atacar(1, 1, 1, 2));
    	
    }
    
    @Test
    public void testCuranderoNoPuedeCurarEnemigos() {
    	
    	Soldado soldado = new Soldado();
    	Curandero curandero = new Curandero();
    	soldado.cambiarEstadoAlianzas();
    	
    	Casillero casillero = new Casillero(2,2);
    	casillero.ocuparUnidad(soldado);
    	
    	ArrayList<Casillero> zonasCercanas = new ArrayList();
    	
    	Assertions.assertThrows(NoSePuedeCurarEnemigoException.class, () -> curandero.atacar(zonasCercanas, 2, casillero));
    	Assertions.assertEquals(100, soldado.getPuntosDeVida());
    }
    
    @Test
    public void testNoSePuedeAtacarCasilleroVacio() {
    	
    	Soldado soldado = new Soldado();
    	
    	Casillero casillero = new Casillero(2,2);
    	casillero.cambiarEstadoAlianzas();
    	
    	ArrayList<Casillero> zonasCercanas = new ArrayList();
    	
    	Assertions.assertThrows(NoHayUnidadEnCasilleroException.class, () -> soldado.atacar(zonasCercanas, 2, casillero));
    }
    
    @Test
    public void testSoldadoNoPuedeAtacarAUnidadYaMuerta() {
    	
    	Tablero tablero = new Tablero();
    	Jugador jugadorAzul = new Jugador("agus", tablero);
    	Jugador enemigo = new Jugador("lego", tablero);
    	
    	jugadorAzul.comprarUnidad("soldado", 9, 9);
    	tablero.cambiarEstado();
    	
    	enemigo.comprarUnidad("soldado", 11, 10);
    	
    	tablero.cambiarEstado();
    	
    	jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        jugadorAzul.atacar(9,9,11,10);
        
        Assertions.assertThrows(NoHayUnidadEnCasilleroException.class, () -> jugadorAzul.atacar(9,9,11,10));
    }
    
    @Test
    public void testNoSePuedeAtacarNoExisteUnidadEnPosicionParaRealizarElAtaque() {
    	
    	Tablero tablero = new Tablero();
    	Jugador jugador1 = new Jugador("agus", tablero);
    	
    	jugador1.comprarUnidad("soldado",1,9);

        Assertions.assertThrows(NoHayUnidadEnCasilleroException.class, ()-> jugador1.atacar(11,7,11,8));
    }
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    