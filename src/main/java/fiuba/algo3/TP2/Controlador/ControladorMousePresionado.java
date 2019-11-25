package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Vista.VistaTablero;
import fiuba.algo3.TP2.Vista.VistaUnidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class ControladorMousePresionado implements EventHandler<MouseEvent> {

    private Tablero tablero;

    private VistaTablero vistaTablero;

    private double mouseX;
    private double mouseY;

    public ControladorMousePresionado(Tablero tablero, VistaTablero vistaTablero) {
        this.tablero = tablero;
        this.vistaTablero = vistaTablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        double mouseX = mouseEvent.getSceneX();
        double mouseY = mouseEvent.getSceneY();

        int fila = convertir(mouseX);
        int columna = convertir(mouseY);

        tablero.moverUnidad(fila, columna, 0 );

        /*
        vistaTablero.setMouseX(mouseX);
        vistaTablero.setMouseY(mouseY);
        */

    }

    private int convertir(double posicionImagen){
        return (int)(posicionImagen + VistaTablero.ALTO_CASILLERO / 2)
                / VistaTablero.ALTO_CASILLERO;
    }

}
