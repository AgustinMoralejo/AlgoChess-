package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonActualizar implements EventHandler<ActionEvent> {

    private AlgoChess juego;

    public ControladorBotonActualizar(AlgoChess juego) {
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
