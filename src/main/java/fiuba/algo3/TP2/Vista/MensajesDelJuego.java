package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorJuego;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class MensajesDelJuego extends VBox {

    public Label mensajes;

    private GridPane contenedor;


    public MensajesDelJuego() {


        contenedor = new GridPane();
        mensajes = new Label("hola soy un label que deberia ocupar toda la cajaaaaaaaaaaaa");

        ColumnConstraints columna = new ColumnConstraints();
        columna.setPercentWidth(100);
        contenedor.getColumnConstraints().add(columna);

        contenedor.setPrefSize(150, 200);

        contenedor.getRowConstraints().add(new RowConstraints(200));

        contenedor.addRow(0, mensajes);

        contenedor.setVgap(10);
        contenedor.setHgap(10);
        contenedor.setPadding(new Insets(10, 10, 10, 10));

        mensajes.setStyle("-fx-font-size: 10pt; -fx-font-weight: bold; -fx-opacity: 1.0;");

        contenedor.setStyle("-fx-background-color: burlyWood; -fx-effect: innershadow(gaussian, rgba(0,0,0,0.4), 75, 0.5, 0, 10);");
        contenedor.setSnapToPixel(false);

        getChildren().add(contenedor);

    }

    public void setMensaje(String mensaje) {
        mensajes.setText(mensaje);
    }
}
