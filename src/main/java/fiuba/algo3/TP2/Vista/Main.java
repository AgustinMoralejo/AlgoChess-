package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorMouseArrastrado;
import fiuba.algo3.TP2.Controlador.ControladorMousePresionado;
import fiuba.algo3.TP2.Controlador.ControladorMouseSoltado;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;

import fiuba.algo3.TP2.Modelo.Unidad.Soldado;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private VistaTablero vistaTablero;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) throws Exception {

        theStage.setTitle("AlgoChess");

        Tablero tablero = new Tablero();

        //
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        tablero.colocarUnidad(soldado3,9,7);
        tablero.colocarUnidad(soldado1,7,8);
        tablero.colocarUnidad(soldado2,7,9);
        //

        vistaTablero = new VistaTablero(tablero);

        VBox vbox = new VBox();
        vbox.getChildren().add(vistaTablero);


        vbox.setOnMousePressed(new ControladorMousePresionado(tablero, vistaTablero));
        //vbox.setOnMouseDragged(new ControladorMouseArrastrado(tablero));
        //vbox.setOnMouseReleased(new ControladorMouseSoltado(tablero));


        Scene theScene = new Scene(vbox);
        theStage.setScene(theScene);
        theStage.show();

    }

    /*TODO: todavia no estoy trabajando con el modelo,
       solo con las vistas*/

}
