import Fiuba.Excepciones.CasilleroEstaOcupadoException;
import Fiuba.Excepciones.CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException;
import Fiuba.Excepciones.NoHayUnidadEnCasilleroException;
import Fiuba.Excepciones.ObjetivoFueraDeRangoException;
import Fiuba.Excepciones.UnidadNoMovibleException;
import Fiuba.Unidad.*;
import Fiuba.Tablero.*;
import Fiuba.AlgoChess.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

public class MovimientosUnidadesTest {

	/* Norte */

    @Test
    public void testSoldadoEnTableroSeMueveHaciaArribaYLoOcupaConExito(){

    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("soldado",1,1);
        
        jugador.moverUnidad(1,1, 1);
        
        Assertions.assertTrue(tablero.estaOcupado(0,1));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testJineteEnTableroSeMueveAlNorteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("jinete",1,1);
        
        jugador.moverUnidad(1,1, 1);
        
        Assertions.assertTrue(tablero.estaOcupado(0,1));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCuranderoEnTableroSeMueveAlNorteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("curandero",1,1);
        
        jugador.moverUnidad(1,1,1);
        
        Assertions.assertTrue(tablero.estaOcupado(0,1));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCatapultaNoSeMueveAlNorte() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("catapulta",1,1);
        
        Assertions.assertThrows(UnidadNoMovibleException.class, () -> jugador.moverUnidad(1, 1, 1));
    }
    
/* Este */
    
    @Test
    public void testSoldadoEnTableroSeMueveAlesteYLoOcupaConExito(){

    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("soldado",1,1);
        
        jugador.moverUnidad(1,1,4);
        
        Assertions.assertTrue(tablero.estaOcupado(1,2));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testJineteEnTableroSeMueveAlesteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("jinete",1,1);
        
        jugador.moverUnidad(1,1,4);
        
        Assertions.assertTrue(tablero.estaOcupado(1,2));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCuranderoEnTableroSeMueveAlesteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("curandero",1,1);
        
        jugador.moverUnidad(1,1,4);
        
        Assertions.assertTrue(tablero.estaOcupado(1,2));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCatapultaNoSeMueveAleste() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("catapulta",1,1);
        
        Assertions.assertThrows(UnidadNoMovibleException.class, () -> jugador.moverUnidad(1, 1, 4));
    
    }
    
/* Sureste */
    
    @Test
    public void testSoldadoEnTableroSeMueveAlSuresteYLoOcupaConExito(){

    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("soldado",1,1);
        
        jugador.moverUnidad(1,1,7);
        
        Assertions.assertTrue(tablero.estaOcupado(2,2));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testJineteEnTableroSeMueveAlSuresteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("jinete",1,1);
        
        jugador.moverUnidad(1,1,7);
        
        Assertions.assertTrue(tablero.estaOcupado(2,2));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCuranderoEnTableroSeMueveAlSuresteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("curandero",1,1);
        
        jugador.moverUnidad(1,1, 7);
        
        Assertions.assertTrue(tablero.estaOcupado(2,2));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCatapultaNoSeMueveAlSureste() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("catapulta",1,1);
        
        Assertions.assertThrows(UnidadNoMovibleException.class, () -> jugador.moverUnidad(1, 1, 7));
    
    }
    
    
/* Noreste */
    
    @Test
    public void testSoldadoEnTableroSeMueveAlNoresteYLoOcupaConExito(){

    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("soldado",1,1);
        
        jugador.moverUnidad(1,1, 2);
        
        Assertions.assertTrue(tablero.estaOcupado(0,2));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testJineteEnTableroSeMueveAlNoresteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("jinete",1,1);
        
        jugador.moverUnidad(1,1,2);
        
        Assertions.assertTrue(tablero.estaOcupado(0,2));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCuranderoEnTableroSeMueveAlNoresteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("curandero",1,1);
        
        jugador.moverUnidad(1,1,2);
        
        Assertions.assertTrue(tablero.estaOcupado(0,2));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCatapultaNoSeMueveAlNoreste() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("catapulta",1,1);
        
        Assertions.assertThrows(UnidadNoMovibleException.class, () -> jugador.moverUnidad(1, 1, 2));
    
    }
    
/* Sur */
    
    @Test
    public void testSoldadoEnTableroSeMueveAlSurYLoOcupaConExito(){

    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("soldado",1,1);
        
        jugador.moverUnidad(1,1, 6);
        
        Assertions.assertTrue(tablero.estaOcupado(2,1));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testJineteEnTableroSeMueveAlSurYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("jinete",1,1);
        
        jugador.moverUnidad(1,1,6);
        
        Assertions.assertTrue(tablero.estaOcupado(2,1));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCuranderoEnTableroSeMueveAlSurYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("curandero",1,1);
        
        jugador.moverUnidad(1,1, 6);
        
        Assertions.assertTrue(tablero.estaOcupado(2,1));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCatapultaNoSeMueveAlSur() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("catapulta",1,1);
        
        Assertions.assertThrows(UnidadNoMovibleException.class, () -> jugador.moverUnidad(1, 1, 6));
    
    }
    
    
/* Suroeste */
    
    @Test
    public void testSoldadoEnTableroSeMueveAlSuroesteYLoOcupaConExito(){

    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("soldado",1,1);
        
        jugador.moverUnidad(1,1, 5);
        
        Assertions.assertTrue(tablero.estaOcupado(2,0));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testJineteEnTableroSeMueveAlSuroesteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("jinete",1,1);
        
        jugador.moverUnidad(1,1, 5);
        
        Assertions.assertTrue(tablero.estaOcupado(2,0));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCuranderoEnTableroSeMueveAlSuroesteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("curandero",1,1);
        
        jugador.moverUnidad(1,1, 5);
        
        Assertions.assertTrue(tablero.estaOcupado(2,0));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCatapultaNoSeMueveAlSuroeste() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("catapulta",1,1);
        
        Assertions.assertThrows(UnidadNoMovibleException.class, () -> jugador.moverUnidad(1, 1, 5));
    
    }
    
    
/* Oeste */
    
    @Test
    public void testSoldadoEnTableroSeMueveAlOesteYLoOcupaConExito(){

    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("soldado",1,1);
        
        jugador.moverUnidad(1,1, 3);
        
        Assertions.assertTrue(tablero.estaOcupado(1,0));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testJineteEnTableroSeMueveAOesteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("jinete",1,1);
        
        jugador.moverUnidad(1,1,3);
        
        Assertions.assertTrue(tablero.estaOcupado(1,0));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCuranderoEnTableroSeMueveAlOesteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("curandero",1,1);
        
        jugador.moverUnidad(1,1, 3);
        
        Assertions.assertTrue(tablero.estaOcupado(1,0));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCatapultaNoSeMueveAlOeste() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("catapulta",1,1);
        
        Assertions.assertThrows(UnidadNoMovibleException.class, () -> jugador.moverUnidad(1, 1, 3));
    
    }
    
    
/* NorOeste */
    
    @Test
    public void testSoldadoEnTableroSeMueveAlNorOesteYLoOcupaConExito(){

    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("soldado",1,1);
        
        jugador.moverUnidad(1,1,0);
        
        Assertions.assertTrue(tablero.estaOcupado(0,0));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testJineteEnTableroSeMueveAlNorOesteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("jinete",1,1);
        
        jugador.moverUnidad(1,1,0);
        
        Assertions.assertTrue(tablero.estaOcupado(0,0));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCuranderoEnTableroSeMueveAlNorOesteYLoOcupaConExito() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("curandero",1,1);
        
        jugador.moverUnidad(1,1,0);
        
        Assertions.assertTrue(tablero.estaOcupado(0,0));
        Assertions.assertFalse(tablero.estaOcupado(1,1));
    }
    
    @Test
    public void testCatapultaNoSeMueveAlNoOreste() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("catapulta",1,1);
        
        Assertions.assertThrows(UnidadNoMovibleException.class, () -> jugador.moverUnidad(1, 1, 0));
    
    }
    
    @Test
    public void testUnidadNoPuedeMoverseAUnEspacioOcupado() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("jinete",1,1);
        jugador.comprarUnidad("jinete",0,0);
        
        Assertions.assertThrows(CasilleroEstaOcupadoException.class, () -> jugador.moverUnidad(1,1,0));
    }
    
    
    @Test
    public void testJugadorAliadoTrataDeMoverUnaUnidadQueNoEstaEnElCasilleroYNoPuede() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan", tablero);
        jugador.comprarUnidad("soldado",1,1);
        
        Assertions.assertThrows(NoHayUnidadEnCasilleroException.class,
                () -> jugador.moverUnidad(3,3,0));
    }
    
    
    
    
    @Test
    public void testJugadorNoPuedeMoverUnidadEnemiga() {
    	
    	Tablero tablero = new Tablero();
    	Jugador jugador1 = new Jugador("Juan", tablero);
    	Jugador jugador2 = new Jugador("Pedro", tablero);
    	
    	jugador1.comprarUnidad("jinete", 9, 10);
    	tablero.cambiarEstado();
    	jugador2.comprarUnidad("jinete", 11, 12);
    	tablero.cambiarEstado();
    	
    	Assertions.assertThrows(CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException.class,
                () -> jugador1.moverUnidad(11,12,0));
    	
    }
    
    @Test
    public void testJugadorAliadoMueveUnSoldadoQueTieneOtrosDosAdyacentesYLosTresSeMuevenALaVez() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero);
        
        jugadorAliado.comprarUnidad("soldado",2,5);
        jugadorAliado.comprarUnidad("soldado",2,6);
        jugadorAliado.comprarUnidad("soldado",2,7);
        
        jugadorAliado.moverUnidad(2,6,1);
        
        Assertions.assertFalse(tablero.estaOcupado(2,5));
        Assertions.assertFalse(tablero.estaOcupado(2,6));
        Assertions.assertFalse(tablero.estaOcupado(2,7));
        Assertions.assertTrue(tablero.estaOcupado(1,5));
        Assertions.assertTrue(tablero.estaOcupado(1,6));
        Assertions.assertTrue(tablero.estaOcupado(1,7));
    }
    
    @Test
    public void testJugadorAliadoMueveUnSoldadoQueTieneSoloUnoAdyacenteYElOtroNoSeMueve() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero);

        jugadorAliado.comprarUnidad("soldado",2,5);
        jugadorAliado.comprarUnidad("soldado",2,6);

        jugadorAliado.moverUnidad(2,5,1);

        Assertions.assertTrue(tablero.estaOcupado(1,5));

        Assertions.assertFalse(tablero.estaOcupado(1,6));
        Assertions.assertTrue(tablero.estaOcupado(2,6));
    }
    
    @Test
    public void testJugadorAliadoMueveUnSoldadoQueTieneUnoSoloAdyacentePeroEsteTieneOtroAdyacentePorLoQueSeMuevenLosTres() {
    	
    	Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero);

        jugadorAliado.comprarUnidad("soldado",2,5);
        jugadorAliado.comprarUnidad("soldado",2,6);
        jugadorAliado.comprarUnidad("soldado",2,7);

        jugadorAliado.moverUnidad(2,5,1);


        Assertions.assertFalse(tablero.estaOcupado(2,5));
        Assertions.assertFalse(tablero.estaOcupado(2,6));
        Assertions.assertFalse(tablero.estaOcupado(2,7));
        Assertions.assertTrue(tablero.estaOcupado(1,5));
        Assertions.assertTrue(tablero.estaOcupado(1,6));
        Assertions.assertTrue(tablero.estaOcupado(1,7));
    }
    
    @Test
    public void testJugadorAliadoMueveUnBatallonEnColumnaHaciaElNorteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero);
        tablero.cambiarEstado();

        jugadorAliado.comprarUnidad("soldado",14,5);
        jugadorAliado.comprarUnidad("soldado",15,5);
        jugadorAliado.comprarUnidad("soldado",16,5);

        jugadorAliado.moverUnidad(14,5,1);

        Assertions.assertFalse(tablero.estaOcupado(16,5));
        Assertions.assertTrue(tablero.estaOcupado(13,5));
        Assertions.assertTrue(tablero.estaOcupado(14,5));
        Assertions.assertTrue(tablero.estaOcupado(15,5));

    }
    
    @Test
    public void testJugadorAliadoMueveUnBatallonEnFilaHaciaElEsteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero);
        tablero.cambiarEstado();

        jugadorAliado.comprarUnidad("soldado",14,5);
        jugadorAliado.comprarUnidad("soldado",14,6);
        jugadorAliado.comprarUnidad("soldado",14,7);

        jugadorAliado.moverUnidad(14,5,4);

        Assertions.assertFalse(tablero.estaOcupado(14,5));
        Assertions.assertTrue(tablero.estaOcupado(14,6));
        Assertions.assertTrue(tablero.estaOcupado(14,7));
        Assertions.assertTrue(tablero.estaOcupado(14,8));

    }
    
    @Test
    public void testJugadorAliadoMueveUnBatallonEnColumnaHaciaElSurYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero);
        tablero.cambiarEstado();

        jugadorAliado.comprarUnidad("soldado",14,5);
        jugadorAliado.comprarUnidad("soldado",15,5);
        jugadorAliado.comprarUnidad("soldado",16,5);

        jugadorAliado.moverUnidad(14,5,6);

        Assertions.assertFalse(tablero.estaOcupado(14,5));
        Assertions.assertTrue(tablero.estaOcupado(15,5));
        Assertions.assertTrue(tablero.estaOcupado(16,5));
        Assertions.assertTrue(tablero.estaOcupado(17,5));

    }
    
    @Test
    public void testJugadorAliadoMueveUnBatallonEnFilaHaciaElOesteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero);
        tablero.cambiarEstado();

        jugadorAliado.comprarUnidad("soldado",14,5);
        jugadorAliado.comprarUnidad("soldado",14,6);
        jugadorAliado.comprarUnidad("soldado",14,7);

        jugadorAliado.moverUnidad(14,5,3);

        Assertions.assertFalse(tablero.estaOcupado(14,7));
        Assertions.assertTrue(tablero.estaOcupado(14,4));
        Assertions.assertTrue(tablero.estaOcupado(14,5));
        Assertions.assertTrue(tablero.estaOcupado(14,6));

    }
    
    @Test
    public void testJugadorAliadoMueveUnBatallonHaciaElNoresteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero);
        tablero.cambiarEstado();

        jugadorAliado.comprarUnidad("soldado",14,5);
        jugadorAliado.comprarUnidad("soldado",13,6);
        jugadorAliado.comprarUnidad("soldado",14,7);

        jugadorAliado.moverUnidad(14,5,2);

        Assertions.assertTrue(tablero.estaOcupado(13,6));
        Assertions.assertTrue(tablero.estaOcupado(12,7));
        Assertions.assertTrue(tablero.estaOcupado(13,8));

    }

    @Test
    public void testJugadorAliadoMueveUnBatallonHaciaElSuresteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero);
        tablero.cambiarEstado();

        jugadorAliado.comprarUnidad("soldado",12,5);
        jugadorAliado.comprarUnidad("soldado",11,6);
        jugadorAliado.comprarUnidad("soldado",10,7);

        jugadorAliado.moverUnidad(10,7,2);

        Assertions.assertTrue(tablero.estaOcupado(11,6));
        Assertions.assertTrue(tablero.estaOcupado(10,7));
        Assertions.assertTrue(tablero.estaOcupado(9,8));

    }
    
    @Test
    public void testJugadorAliadoMueveUnBatallonHaciaElSuroesteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero);

        jugadorAliado.comprarUnidad("soldado",4,3);
        jugadorAliado.comprarUnidad("soldado",5,4);
        jugadorAliado.comprarUnidad("soldado",6,5);

        jugadorAliado.moverUnidad(4,3,5);

        Assertions.assertTrue(tablero.estaOcupado(5,2));
        Assertions.assertTrue(tablero.estaOcupado(6,3));
        Assertions.assertTrue(tablero.estaOcupado(7,4));

    }
    
    @Test
    public void testJugadorAliadoMueveUnBatallonHaciaElNoroesteYCadaUnoOcupaSuNuevoCasilleroConExito(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero);

        jugadorAliado.comprarUnidad("soldado",7,5);
        jugadorAliado.comprarUnidad("soldado",7,6);
        jugadorAliado.comprarUnidad("soldado",8,7);

        jugadorAliado.moverUnidad(8,7,5);

        Assertions.assertTrue(tablero.estaOcupado(8,4));
        Assertions.assertTrue(tablero.estaOcupado(8,5));
        Assertions.assertTrue(tablero.estaOcupado(9,6));

    }
    
    @Test
    public void testJugadorAliadoMueveUnSoldadoQueNoConformaUnBatallonYLosOtrosSoldadosNoSeMueven(){

        Tablero tablero = new Tablero();
        Jugador jugadorAliado = new Jugador("agus",tablero);

        jugadorAliado.comprarUnidad("soldado",7,5);
        jugadorAliado.comprarUnidad("soldado",7,7);
        jugadorAliado.comprarUnidad("soldado",9,5);

        jugadorAliado.moverUnidad(7,5,1);

        Assertions.assertTrue(tablero.estaOcupado(6,5));
        Assertions.assertTrue(tablero.estaOcupado(7,7));
        Assertions.assertTrue(tablero.estaOcupado(9,5));

    }
    
    

}
