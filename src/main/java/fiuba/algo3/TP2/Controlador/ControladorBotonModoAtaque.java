package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonModoAtaque implements EventHandler<ActionEvent> {

    private Jugador jugador;

    public ControladorBotonModoAtaque(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        jugador.cambiarAModoOfensivo();
        System.out.println("Modo Ofensivo");

    }
}
