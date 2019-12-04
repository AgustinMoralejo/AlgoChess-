package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import fiuba.algo3.TP2.Modelo.Observer;
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

public class BarraDeEstadoJuego extends HBox implements Observer {

    private Button botonActualizar;
    public Label alertaJugadorAzul;
    public Label alertaJugadorRojo;
    public Label puntosJugadorAzul;
    public Label puntosJugadorRojo;
    public Label mensajes;
    private GridPane barraDeEstado;

    private AlgoChess juego;

    public BarraDeEstadoJuego(AlgoChess juego) {
        barraDeEstado = new GridPane();
        botonActualizar = new Button("Actualizar");
        alertaJugadorAzul = new Label("Turno jugador Azul");
        alertaJugadorRojo = new Label("");
        puntosJugadorAzul = new LabelPuntosJugador(juego.getJugador(0));
        puntosJugadorRojo = new LabelPuntosJugador(juego.getJugador(1));
        mensajes = new Label("");
        this.juego = juego;

        juego.agregarObserver(this);

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
        barraDeEstado.getRowConstraints().add(new RowConstraints(70.0 / 2));
        barraDeEstado.getRowConstraints().add(new RowConstraints(70.0 / 2));

        barraDeEstado.addRow(0, alertaJugadorAzul, botonActualizar, alertaJugadorRojo);
        barraDeEstado.addRow(1, puntosJugadorAzul, mensajes, puntosJugadorRojo);


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

        //ControladorBotonActualizar controladorBotonActualizar = new ControladorBotonActualizar(juego);
        //botonActualizar.setOnAction(controladorBotonActualizar);

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
