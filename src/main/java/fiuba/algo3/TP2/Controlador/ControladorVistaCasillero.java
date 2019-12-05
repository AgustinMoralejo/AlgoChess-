package fiuba.algo3.TP2.Controlador;

import java.util.ArrayList;

import fiuba.algo3.TP2.Modelo.Excepciones.*;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;
import fiuba.algo3.TP2.Vista.Ventana;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ControladorVistaCasillero implements EventHandler<MouseEvent> {

    private ControladorMouse mouse;
    private ControladorJuego controladorJuego;
    private Ventana ventana;

    public ControladorVistaCasillero(Ventana ventana, ControladorJuego controladorJuego) {
        this.ventana = ventana;
        this.mouse = ControladorMouse.getInstancia();
        this.controladorJuego = controladorJuego;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        int fila = ventana.getCasillero().getFila();
        int columna = ventana.getCasillero().getColumna();
        int distancia;
        Unidad unidad = ventana.getCasillero().getUnidad();
        controladorJuego.desResaltarVentanas();
    	Tablero tablero = controladorJuego.getTablero();
    	ArrayList<Casillero> zonasCercanas = tablero.buscarCasilleros(3, fila, columna);

    	distancia = unidad.getDistanciaAtaque(zonasCercanas);

    	controladorJuego.resaltarVentanas(distancia,fila,columna, unidad);

    	ventana.resaltar();
    	
    	if (mouseEvent.getButton() == MouseButton.SECONDARY) {
        	controladorJuego.removerAtributos();
        	controladorJuego.setAtributos(unidad);
        	controladorJuego.modoDefault();
        	
        }

        else if(controladorJuego.estaColocandoUnaUnidad()){

        	try {
        		controladorJuego.comprarUnidad(fila,columna);
        	} catch (NoSePuedeColocarUnidadEnSectorEnemigoException e) {
        		controladorJuego.setMensajeError("¡ No se puede colocar unidad en sector enemigo !");
        	} catch (CasilleroEstaOcupadoException e) {
        		controladorJuego.setMensajeError("¡ Casillero seleccionado esta ocupado !");
        	} catch (PuntosInsuficientesException e) {
        		controladorJuego.setMensajeError("¡ Puntos insuficientes !");
        	}

        	controladorJuego.modoDefault();

        }
        else{

        	if (mouse.esPrimerClick() && !unidad.getSimbolo().equals("-")) {

        		mouse.setPrimerClick(fila,columna);

        	} else if (!mouse.esPrimerClick()) {

        		mouse.setSegundoClick(fila,columna);

        	try {
                	
        		controladorJuego.realizarAccion(mouse.getPrimerClick(), mouse.getSegundoClick());

        		} catch (UnidadSoloSePuedeMoverAUnCasilleroAdyacenteException e) {
        			controladorJuego.setMensajeError("¡ Solo puede moverse a un casillero contiguo !");
        		} catch (CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException e) {
        			controladorJuego.setMensajeError("¡ Casillero seleccionado no posee unidad aliada !");
        		} catch (NoSePuedeAtacarAUnaUnidadAliadaException e) {
        			controladorJuego.setMensajeError("¡ No se puede atacar a una unidad aliada !");
        		}catch (NoHayUnidadEnCasilleroException e) {
        			controladorJuego.setMensajeError("¡ No hay unidad en casillero !");
        		}catch (CasilleroEstaOcupadoException e) {
        			controladorJuego.setMensajeError("¡ Casillero seleccionado esta ocupado !");
        		}catch (LasUnidadesSoloSePuedenMoverUnCasilleroPorTurnoException e) {
        			controladorJuego.setMensajeError("¡ Ya ha movido a esta unidad !");
        		}catch (UnidadNoMovibleException e) {
        			controladorJuego.setMensajeError("¡ La catapulta no se puede mover !");
        		}catch (ObjetivoFueraDeRangoException e) {
        			controladorJuego.setMensajeError("¡ Objetivo esta fuera de alcance !");
        		}catch (NoEstanDadasLasCondicionesDeAtaqueException e) {
        			controladorJuego.setMensajeError("¡ El jinete no esta en condiciones de atacar !");
        		}catch (NoSePuedeCurarEnemigoException | NoSePuedenCurarUnidadesNoOrganicasException e) {
        			controladorJuego.setMensajeError("¡ Curandero no puede curar a esta unidad ! ");
        		}catch (UnidadSoloPuedeAtacarUnaVezException e) {
        			controladorJuego.setMensajeError("¡ Esta unidad ya ha atacado ! ");
        		}
        	
                controladorJuego.modoDefault();
        	}
           }
        }
    
        
}
