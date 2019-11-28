package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorModoAtaque implements EventHandler<ActionEvent> {

    private Jugador jugador;

    public ControladorModoAtaque(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        jugador.cambiarModoAtaqueOMovimiento();
        System.out.println("Modo Ofensivo: "+ jugador.estaEnModoOfensivo());

    }
}
