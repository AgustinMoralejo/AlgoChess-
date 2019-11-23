package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.Tablero.Tablero;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) throws Exception {

        theStage.setTitle("AlgoChess");

        Tablero tablero = new Tablero();
        VistaTablero vistaTablero = new VistaTablero(tablero);

        VBox vbox = new VBox();

        vbox.getChildren().add(vistaTablero);

        Scene theScene = new Scene(vbox);
        theStage.setScene(theScene);
        theStage.show();

    }

}
