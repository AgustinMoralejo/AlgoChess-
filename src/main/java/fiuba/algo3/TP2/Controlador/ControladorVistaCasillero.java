package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.Excepciones.*;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;
import fiuba.algo3.TP2.Vista.Ventana;
import javafx.event.EventHandler;
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



        controladorJuego.desResaltarVentanas();

        Unidad unidad = ventana.getCasillero().getUnidad();

        distancia = unidad.getDistanciaAtaque();

        controladorJuego.resaltarVentanas(distancia,fila,columna);

        ventana.resaltar();

        //if (mouseEvent.getButton() == MouseButton.SECONDARY) {
        	controladorJuego.removerMensajes();
        	controladorJuego.setMensaje("Unidad: " + unidad.getSimbolo());
        	if(unidad.esAliado()) {controladorJuego.setMensaje("Alianza: Aliado");}
        	else {controladorJuego.setMensaje("Alianza: Enemigo");}
        	controladorJuego.setMensaje("Vida: " + Integer.toString(unidad.getPuntosDeVida()));
        	controladorJuego.setMensaje("Costo de compra: " + Integer.toString(unidad.getCosto()));
        	controladorJuego.setMensaje("Daño cuerpo a cuerpo: " + Integer.toString(unidad.getAlcanceCorto()));
        	controladorJuego.setMensaje("Daño a distancia: " + Integer.toString(unidad.getAlcanceADistancia()));
       // }
        /*else*/

        if(controladorJuego.estaColocandoUnaUnidad()){

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

                System.out.println("has clickeado el casillero: " + fila + " , " + columna);

            } else if (!mouse.esPrimerClick()) {

                mouse.setSegundoClick(fila,columna);

                System.out.println("has clickeado el casillero: " + fila + " , " + columna);

                try {
                	
                	controladorJuego.removerMensajes();
                    controladorJuego.realizarAccion(mouse.getPrimerClick(), mouse.getSegundoClick());
                

                } catch (UnidadSoloSePuedeMoverAUnCasilleroAdyacenteException e) {
                    controladorJuego.setMensajeError("¡ Solo puede moverse a un casillero contiguo !");
                } catch (CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException e) {
                    controladorJuego.setMensajeError("¡ Casillero seleccionado no posee ninguna unidad aliada !");
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
