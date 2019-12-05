package fiuba.algo3.TP2.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("ALGO CHESS: Reglas del Juego");
        String mensaje = "- Es un juego de DOS JUGADORES \n" +
                "- Cada jugador luego de terminar una acción debe presionar 'Terminar turno' \n' " +
                "- Cada jugador solo puede mover una unidad por turno \n" +
                "- El jugador que logre matar todas las unidades de su contrincante es el GANADOR.\n" +
                " ......... ";

        alert.setContentText(mensaje);
        alert.show();
    }
}
