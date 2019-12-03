package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import fiuba.algo3.TP2.Modelo.Observer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;

public class BarraDeInformacion extends HBox implements Observer {
    public Label alertaJugadorAzul;
    public Label alertaJugadorRojo;
    public Label unidadesJugadorAzul;
    public Label unidadesJugadorRojo;
    public Label espacio;

    private GridPane barra;

    private AlgoChess juego;

    public BarraDeInformacion(AlgoChess juego){
        this.barra = new GridPane();
        this.alertaJugadorAzul = new Label("Turno jugador Azul");
        this.alertaJugadorRojo = new Label("");
        this.unidadesJugadorAzul = new LabelCantidadDeUnidades(juego, 0);
        this.unidadesJugadorRojo = new LabelCantidadDeUnidades(juego,1);


        juego.agregarObserver(this);

        ColumnConstraints columna = new ColumnConstraints();
        columna.setPercentWidth(30);
        barra.getColumnConstraints().add(columna);

        columna = new ColumnConstraints();
        columna.setPercentWidth(30);
        barra.getColumnConstraints().add(columna);

        columna = new ColumnConstraints();
        columna.setPercentWidth(30);
        barra.getColumnConstraints().add(columna);

        barra.setPrefSize(640, 60);
        barra.getRowConstraints().add(new RowConstraints(70.0 / 2));
        barra.getRowConstraints().add(new RowConstraints(70.0 / 2));

        barra.addRow(0, alertaJugadorAzul, alertaJugadorRojo);
        barra.addRow(1, unidadesJugadorAzul, unidadesJugadorRojo);

        for (Node n : barra.getChildren()) {
            GridPane.setHalignment(n, HPos.CENTER);
            GridPane.setValignment(n, VPos.CENTER);
            if (n instanceof Label) {
                n.setStyle("-fx-font-size: 10pt; -fx-font-weight: bold; -fx-opacity: 1.0;");
            }
        }

        barra.setVgap(10);
        barra.setHgap(10);
        barra.setPadding(new Insets(10, 10, 10, 10));

        barra.setStyle("-fx-background-color: burlyWood; -fx-effect: innershadow(gaussian, rgba(0,0,0,0.4), 75, 0.5, 0, 10);");
        barra.setSnapToPixel(false);
        getChildren().add(barra);
    }
    @Override
    public void actualizar() {
        int indice = juego.getIndiceJugadorActual();
        if (indice == 0) {
            alertaJugadorAzul.setText("Turno jugador Azul");
            alertaJugadorRojo.setText("");
        } else {
            alertaJugadorAzul.setText("");
            alertaJugadorRojo.setText("Turno jugador Rojo");
        }
    }
}
