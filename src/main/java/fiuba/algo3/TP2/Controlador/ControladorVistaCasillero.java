package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.Excepciones.UnidadSoloSePuedeMoverUnCasilleroException;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Vista.Ventana;
import fiuba.algo3.TP2.Vista.VistaTablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ControladorVistaCasillero implements EventHandler<MouseEvent> {

    private Ventana ventana;
    private Tablero tablero;
    private static Casillero primerCasilleroSeleccionado;
    private static Casillero segundoCasilleroSeleccionado;


    public ControladorVistaCasillero(Ventana ventana, Tablero tablero) {
        this.ventana = ventana;
        this.tablero = tablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        if (tablero.esPrimerClick()) {

            ventana.resaltar(Color.GREEN);

            System.out.println("primer click");

            primerCasilleroSeleccionado = ventana.getCasillero();

            System.out.println("has clickeado la ventana: " +
                    primerCasilleroSeleccionado.getFila() + " , " + primerCasilleroSeleccionado.getColumna());

            tablero.setPrimerClickFalse();

        } else {

            ventana.desResaltar();

            System.out.println("segundo click");

            segundoCasilleroSeleccionado = ventana.getCasillero();

            System.out.println("has clickeado la ventana: " +
                    segundoCasilleroSeleccionado.getFila() + " , " + segundoCasilleroSeleccionado.getColumna());

            tablero.setPrimerClickTrue();
            try {
                tablero.moverUnidad(primerCasilleroSeleccionado, segundoCasilleroSeleccionado);
            } catch (UnidadSoloSePuedeMoverUnCasilleroException e) {
                System.out.println("¡¡¡ La unidad se puede mover solo un casillero a la vez !!!");
            }

        }

    }

}
