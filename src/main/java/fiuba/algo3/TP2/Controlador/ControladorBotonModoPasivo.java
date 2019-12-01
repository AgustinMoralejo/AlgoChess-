package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonModoPasivo implements EventHandler<ActionEvent> {

    private ControladorJuego controladorJuego;

    public ControladorBotonModoPasivo(ControladorJuego controladorJuego) {
        this.controladorJuego = controladorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        controladorJuego.cambiarAModoPasivo();
        System.out.println("Modo Pasivo" );

    }

}
