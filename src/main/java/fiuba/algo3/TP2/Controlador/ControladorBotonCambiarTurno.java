package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonCambiarTurno implements EventHandler<ActionEvent> {


    private ControladorJuego controladorJuego;

    public ControladorBotonCambiarTurno(ControladorJuego controladorJuego){
        this.controladorJuego = controladorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        controladorJuego.terminarTurno();

    }
}
