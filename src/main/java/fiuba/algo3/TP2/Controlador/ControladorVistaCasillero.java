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

    private final ControladorMouse mouse;
    private Ventana ventana;
    private Tablero tablero;


    public ControladorVistaCasillero(Ventana ventana, Tablero tablero) {
        this.ventana = ventana;
        this.tablero = tablero;
        this.mouse = ControladorMouse.getInstancia();
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        int fila, columna;

        if (mouse.esPrimerClick()) {

            fila = ventana.getCasillero().getFila();
            columna = ventana.getCasillero().getColumna();

            mouse.guardarPrimerClick(fila,columna);

            System.out.println("has clickeado el casillero: " + fila + " , " + columna);


        } else {

            fila = ventana.getCasillero().getFila();
            columna = ventana.getCasillero().getColumna();

            mouse.guardarSegundoClick(fila,columna);

            System.out.println("has clickeado el casillero: " + fila + " , " + columna);

            tablero.setPrimerClickTrue();

            try {
                tablero.moverUnidad(mouse.getPrimerClick(), mouse.getSegundoClick());
            } catch (UnidadSoloSePuedeMoverUnCasilleroException e) {
                System.out.println("¡¡¡ La unidad se puede mover solo un casillero a la vez !!!");
            }

        }

    }

}
