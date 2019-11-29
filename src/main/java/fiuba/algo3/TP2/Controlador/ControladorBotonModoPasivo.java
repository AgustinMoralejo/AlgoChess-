package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonModoPasivo implements EventHandler<ActionEvent> {

    private Jugador jugador;

    public ControladorBotonModoPasivo(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        jugador.cambiarAModoPasivo();
        System.out.println("Modo Pasivo" );

    }

}
