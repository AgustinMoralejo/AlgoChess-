package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Vista.VistaTablero;
import fiuba.algo3.TP2.Vista.VistaUnidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorMouseSoltado implements EventHandler<MouseEvent> {

    private Tablero tablero;

    public ControladorMouseSoltado(Tablero tablero) {

        this.tablero = tablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        VistaUnidad vistaUnidad = null;

        int filaDestino = convertir(vistaUnidad.getLayoutY());
        int columnaDestino = convertir(vistaUnidad.getLayoutX());

        vistaUnidad.moverVista(filaDestino, columnaDestino);


    }

    private int convertir(double pixel){
        return (int)(pixel + VistaTablero.ALTO_CASILLERO / 2)
                / VistaTablero.ALTO_CASILLERO;
    }
}


    /*
    if (columnaDestino < 0 || filaDestino < 0 ||
            columnaDestino >= tablero.getColumnas()  ||
            filaDestino >= tablero.getFilas()) {
        //resultado = new MoveResult(MoveType.NONE);
    } else {
        //result = tryMove(piece, newX, newY);
    }
    */