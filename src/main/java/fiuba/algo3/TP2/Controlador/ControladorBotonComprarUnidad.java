package fiuba.algo3.TP2.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonComprarUnidad implements EventHandler<ActionEvent> {

    private ControladorJuego controladorJuego;
    private String nombreUnidad;

    public ControladorBotonComprarUnidad(ControladorJuego controladorJuego, String nombreUnidad) {
        this.controladorJuego = controladorJuego;
        this.nombreUnidad = nombreUnidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        controladorJuego.modoColocarUnidad(nombreUnidad);

    }
}
