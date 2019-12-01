package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonModoAtaque implements EventHandler<ActionEvent> {

    private ControladorJuego controladorJuego;

    public ControladorBotonModoAtaque(ControladorJuego controladorJuego) {
        this.controladorJuego = controladorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        controladorJuego.cambiarAModoOfensivo();
        System.out.println("Modo Ofensivo");

    }
}
