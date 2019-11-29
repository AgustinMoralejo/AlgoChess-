package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.Excepciones.UnidadSoloSePuedeMoverUnCasilleroException;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Vista.Ventana;
import fiuba.algo3.TP2.Vista.VistaTablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorVistaCasillero implements EventHandler<MouseEvent> {

    private Ventana ventana;
    private Tablero tablero;
    private Casillero primerCasilleroSeleccionado;
    private Casillero segundoCasilleroSeleccionado;


    public ControladorVistaCasillero(Ventana ventana, Tablero tablero) {
        this.ventana = ventana;
        this.tablero = tablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        if (tablero.esPrimerClick()) {

            System.out.println("primer click");

            primerCasilleroSeleccionado = ventana.getCasillero();

            System.out.println("has clickeado la ventana: " +
                    primerCasilleroSeleccionado.getFila() + " , " + primerCasilleroSeleccionado.getColumna());

            tablero.setPrimerClickFalse();

        } else {


            System.out.println("segundo click");

            segundoCasilleroSeleccionado = ventana.getCasillero();
            //si esta para moverse
            // si ya se que el controlador no deberia saber como funciona el modelo

            System.out.println("has clickeado la ventana: " +
                    segundoCasilleroSeleccionado.getFila() + " , " + segundoCasilleroSeleccionado.getColumna());

            tablero.setPrimerClickTrue();
/*
            try {
                tablero.moverUnidad(primerCasilleroSeleccionado, segundoCasilleroSeleccionado);
            } catch (UnidadSoloSePuedeMoverUnCasilleroException e) {
                System.out.println("¡¡¡ La unidad se puede mover solo un casillero a la vez !!!");
            }
*/

        }

    }

}
