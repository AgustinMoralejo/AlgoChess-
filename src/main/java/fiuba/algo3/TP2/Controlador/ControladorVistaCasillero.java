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
                System.out.println("¡NoSePuedeColocarUnidadEnSectorEnemigoException !");
                controladorJuego.setMensaje("¡NoSePuedeColocarUnidadEnSectorEnemigoException!");
            //System.out.println("Seleccione nuevamente un casillero que este en sector aliado");
            } catch (CasilleroEstaOcupadoException e) {
                System.out.println("¡CasilleroEstaOcupadoException !");
                controladorJuego.setMensaje("¡CasilleroEstaOcupadoException!");
                //              System.out.println("¡Seleccione nuevamente un casillero que no este ocupado!");
            } catch (PuntosInsuficientesException e) {
                System.out.println("¡PuntosInsuficientesException!");
            }

            controladorJuego.modoDefault();

        }

        else{

            if (mouse.esPrimerClick()) {

                controladorJuego.reproducirSonido("media/accion/horseselect1.wav");

                mouse.setPrimerClick(fila,columna);

                System.out.println("has clickeado el casillero: " + fila + " , " + columna);

            } else {

                controladorJuego.reproducirSonido("media/accion/horseflop1.wav");

                mouse.setSegundoClick(fila,columna);

                System.out.println("has clickeado el casillero: " + fila + " , " + columna);

                try {

                    controladorJuego.realizarAccion(mouse.getPrimerClick(), mouse.getSegundoClick());

                } catch (UnidadSoloSePuedeMoverAUnCasilleroAdyacenteException e) {
                    System.out.println("¡ UnidadSoloSePuedeMoverAUnCasilleroAdyacenteException !");
                    controladorJuego.setMensaje("¡Solo puede moverse a un casillero contiguo!");
                } catch (CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException e) {
                    controladorJuego.setMensaje("¡CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException!");
                    System.out.println("¡¡¡ CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException !!!");
                } catch (NoSePuedeAtacarAUnaUnidadAliadaException e) {
                    System.out.println("¡¡¡ NoSePuedeAtacarAUnaUnidadAliadaException !!!");
                    controladorJuego.setMensaje("¡¡¡ NoSePuedeAtacarAUnaUnidadAliadaException !!!");
                }catch (NoHayUnidadEnCasilleroException e) {
                    System.out.println("¡¡¡ NoHayUnidadEnCasilleroException !!!");
                    controladorJuego.setMensaje("¡¡¡ NoHayUnidadEnCasilleroException !!!");
                }catch (CasilleroEstaOcupadoException e) {
                    System.out.println("¡¡¡ CasilleroEstaOcupadoException !!!");
                    controladorJuego.setMensaje("¡¡¡ CasilleroEstaOcupadoException !!!");
                }catch (LasUnidadesSoloSePuedenMoverUnCasilleroPorTurnoException e) {
                    System.out.println("¡¡¡ LasUnidadesSoloSePuedenMoverUnCasilleroPorTurnoException !!!");
                    controladorJuego.setMensaje("¡Ya ha movido a esta unidad!");
                }

            }

        }
    }

}
