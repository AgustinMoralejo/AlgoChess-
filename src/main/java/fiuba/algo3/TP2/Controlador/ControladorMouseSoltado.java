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
    }

}


