package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.Excepciones.*;
import fiuba.algo3.TP2.Vista.Ventana;
import javafx.event.EventHandler;
import javafx.scene.effect.Glow;
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

        ventana.setEffect(new Glow(20));

        if(controladorJuego.estaColocandoUnaUnidad()){

            try {
                controladorJuego.comprarUnidad(fila,columna);
            } catch (NoSePuedeColocarUnidadEnSectorEnemigoException e) {
                controladorJuego.setMensaje("¡ No se puede colocar unidad en sector enemigo !");
            } catch (CasilleroEstaOcupadoException e) {
                controladorJuego.setMensaje("¡ Casillero seleccionado esta ocupado !");
            } catch (PuntosInsuficientesException e) {
                controladorJuego.setMensaje("¡ Puntos insuficientes !");
            }

            controladorJuego.modoDefault();

        }

        else{

            if (mouse.esPrimerClick()) {

                mouse.setPrimerClick(fila,columna);

                System.out.println("has clickeado el casillero: " + fila + " , " + columna);

            } else {

                mouse.setSegundoClick(fila,columna);

                System.out.println("has clickeado el casillero: " + fila + " , " + columna);

                try {

                    controladorJuego.realizarAccion(mouse.getPrimerClick(), mouse.getSegundoClick());

                } catch (UnidadSoloSePuedeMoverAUnCasilleroAdyacenteException e) {
                    controladorJuego.setMensaje("¡ Solo puede moverse a un casillero contiguo !");
                } catch (CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException e) {
                    controladorJuego.setMensaje("¡ Casillero seleccionado no posee ninguna unidad aliada !");
                } catch (NoSePuedeAtacarAUnaUnidadAliadaException e) {
                    controladorJuego.setMensaje("¡ No se puede atacar a una unidad aliada !");
                }catch (NoHayUnidadEnCasilleroException e) {
                    controladorJuego.setMensaje("¡ No hay unidad en casillero !");
                }catch (CasilleroEstaOcupadoException e) {
                    controladorJuego.setMensaje("¡ Casillero seleccionado esta ocupado !");
                }catch (LasUnidadesSoloSePuedenMoverUnCasilleroPorTurnoException e) {
                    controladorJuego.setMensaje("¡ Ya ha movido a esta unidad !");
                }catch (UnidadNoMovibleException e) {
                    controladorJuego.setMensaje("¡ La catapulta no se puede mover !");
                }catch (ObjetivoFueraDeRangoException e) {
                    controladorJuego.setMensaje("¡ Objetivo esta fuera de alcance !");
                }catch (NoEstanDadasLasCondicionesDeAtaqueException e) {
                    controladorJuego.setMensaje("¡ El jinete no esta en condiciones de atacar !");
                }catch (NoSePuedeCurarEnemigoException | NoSePuedenCurarUnidadesNoOrganicasException e) {
                    controladorJuego.setMensaje("¡ Curandero no puede curar a esta unidad ! ");
                }catch (UnidadSoloPuedeAtacarUnaVezException e) {
                    controladorJuego.setMensaje("¡ Esta unidad ya ha atacado ! ");
                }

                }

        }
    }

}
