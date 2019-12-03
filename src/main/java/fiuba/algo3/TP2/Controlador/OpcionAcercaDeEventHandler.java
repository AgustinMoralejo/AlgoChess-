package fiuba.algo3.TP2.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("Ejemplo de mensaje de alerta");
        String mensaje = "¡Completar!.";
        alert.setContentText(mensaje);
        alert.show();
    }
}
