package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.Excepciones.UnidadSoloSePuedeMoverUnCasilleroException;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Vista.Ventana;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorVistaCasillero implements EventHandler<MouseEvent> {

    private ControladorMouse mouse;
    private ControladorJuego controladorJuego;
    private Ventana ventana;


    public ControladorVistaCasillero(Ventana ventana, Tablero tablero) {
        this.ventana = ventana;
        this.mouse = ControladorMouse.getInstancia();
    }

    public ControladorVistaCasillero(Ventana ventana, ControladorJuego controladorJuego) {
        this.ventana = ventana;
        this.mouse = ControladorMouse.getInstancia();
        this.controladorJuego = controladorJuego;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        int fila, columna;

        if (mouse.esPrimerClick()) {

            fila = ventana.getCasillero().getFila();
            columna = ventana.getCasillero().getColumna();

            mouse.setPrimerClick(fila,columna);

            System.out.println("has clickeado el casillero: " + fila + " , " + columna);


        } else {

            fila = ventana.getCasillero().getFila();
            columna = ventana.getCasillero().getColumna();

            mouse.setSegundoClick(fila,columna);

            System.out.println("has clickeado el casillero: " + fila + " , " + columna);

            try {
                controladorJuego.realizarAccion(mouse.getPrimerClick(), mouse.getSegundoClick());
            } catch (UnidadSoloSePuedeMoverUnCasilleroException e) {
                System.out.println("¡¡¡ La unidad se puede mover solo un casillero a la vez !!!");
            }

        }

    }

}
