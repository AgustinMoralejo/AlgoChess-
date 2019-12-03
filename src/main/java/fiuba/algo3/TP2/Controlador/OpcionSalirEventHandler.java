package fiuba.algo3.TP2.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OpcionSalirEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        System.exit(0);
    }
}
