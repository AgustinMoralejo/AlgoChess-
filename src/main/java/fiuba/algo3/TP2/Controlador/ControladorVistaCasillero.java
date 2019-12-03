package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.Excepciones.*;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
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

        //ventana.resaltar();

        if(controladorJuego.estaColocandoUnaUnidad()){

            try {
                controladorJuego.comprarUnidad(fila,columna);
            } catch (NoSePuedeColocarUnidadEnSectorEnemigoException e) {
                System.out.println("¡NoSePuedeColocarUnidadEnSectorEnemigoException !");
//                System.out.println("Seleccione nuevamente un casillero que este en sector aliado");
            } catch (CasilleroEstaOcupadoException e) {
                System.out.println("¡CasilleroEstaOcupadoException !");
  //              System.out.println("¡Seleccione nuevamente un casillero que no este ocupado!");
            } catch (PuntosInsuficientesException e) {
                System.out.println("¡PuntosInsuficientesException!");
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
                } catch (UnidadSoloSePuedeMoverUnCasilleroException e) {
                    System.out.println("¡ UnidadSoloSePuedeMoverUnCasilleroException !");
                } catch (CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException e) {
                    System.out.println("¡¡¡ CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException !!!");
                } catch (NoSePuedeAtacarAUnaUnidadAliadaException e) {
                    System.out.println("¡¡¡ NoSePuedeAtacarAUnaUnidadAliadaException !!!");
                }catch (NoHayUnidadEnCasilleroException e) {
                    System.out.println("¡¡¡ NoHayUnidadEnCasilleroException !!!");
                }catch (CasilleroEstaOcupadoException e) {
                    System.out.println("¡¡¡ CasilleroEstaOcupadoException !!!");
                }

            }

        }
    }

}
