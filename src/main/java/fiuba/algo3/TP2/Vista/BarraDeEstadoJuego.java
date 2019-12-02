package fiuba.algo3.TP2.Vista;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;

public class BarraDeEstadoJuego extends HBox {

    private Button resetButton;
    public Label alertaJugadorAzul;
    public Label alertaJugadorRojo;
    public Label whitePlayerTimer;
    public Label blackPlayerTimer;
    public Label winner;
    private GridPane barraDeEstado;


    public BarraDeEstadoJuego() {
        barraDeEstado = new GridPane();
        resetButton = new Button("Reset");
        alertaJugadorAzul = new Label("dummy text");
        alertaJugadorRojo = new Label("dummy text");
        whitePlayerTimer = new Label("dummy text");
        blackPlayerTimer = new Label("dummy text");
        winner = new Label("");

//	    statusBarGp.setGridLinesVisible(true);

        ColumnConstraints columna = new ColumnConstraints();
        columna.setPercentWidth(30);
        barraDeEstado.getColumnConstraints().add(columna);

        columna = new ColumnConstraints();
        columna.setPercentWidth(30);
        barraDeEstado.getColumnConstraints().add(columna);

        columna = new ColumnConstraints();
        columna.setPercentWidth(30);
        barraDeEstado.getColumnConstraints().add(columna);

        barraDeEstado.setPrefSize(640, 60);
        barraDeEstado.getRowConstraints().add(new RowConstraints(70 / 2));
        barraDeEstado.getRowConstraints().add(new RowConstraints(70 / 2));

        barraDeEstado.addRow(0, alertaJugadorAzul, resetButton, alertaJugadorRojo);
        barraDeEstado.addRow(1, whitePlayerTimer, winner, blackPlayerTimer);

        for (Node n : barraDeEstado.getChildren()) {
            GridPane.setHalignment(n, HPos.CENTER);
            GridPane.setValignment(n, VPos.CENTER);
            if (n instanceof Label) {
                n.setStyle("-fx-font-size: 10pt; -fx-font-weight: bold; -fx-opacity: 1.0;");
            }
        }

        barraDeEstado.setVgap(10);
        barraDeEstado.setHgap(10);
        barraDeEstado.setPadding(new Insets(10, 10, 10, 10));

        barraDeEstado.setStyle("-fx-background-color: burlyWood; -fx-effect: innershadow(gaussian, rgba(0,0,0,0.4), 75, 0.5, 0, 10);");
        barraDeEstado.setSnapToPixel(false);
        getChildren().add(barraDeEstado);


    }
}
