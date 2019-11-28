package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorMouseArrastrado;
import fiuba.algo3.TP2.Controlador.ControladorMousePresionado;
import fiuba.algo3.TP2.Controlador.ControladorMouseSoltado;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;

import fiuba.algo3.TP2.Modelo.Unidad.Catapulta;
import fiuba.algo3.TP2.Modelo.Unidad.Curandero;
import fiuba.algo3.TP2.Modelo.Unidad.Jinete;
import fiuba.algo3.TP2.Modelo.Unidad.Soldado;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private VistaTablero vistaTablero;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) throws Exception {

        theStage.setTitle("AlgoChess");

        Tablero tablero = new Tablero();

        Jugador jugador = new Jugador("agus", tablero);
        Jugador jugador2 = new Jugador("enemigo", tablero);

        //
        //por defecto las unidades son aliadas
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        Jinete jinete = new Jinete();
        Curandero curandero = new Curandero();

        tablero.colocarUnidad(soldado1,7,7);
        tablero.colocarUnidad(soldado3,9,7);
        tablero.colocarUnidad(soldado1,5,8);
        tablero.colocarUnidad(soldado2,3,9);

        tablero.cambiarEstado();

        tablero.colocarUnidad(jinete, 15,1);
        tablero.colocarUnidad(curandero, 17,6);
        //

        vistaTablero = new VistaTablero(tablero);

        VBox vbox = new VBox();
        vbox.getChildren().add(vistaTablero);

        ContenedorPantallaPrincipal contenedorPrincipal = new ContenedorPantallaPrincipal(theStage, vbox);
        Scene escenaComienzo = new Scene(contenedorPrincipal, 640, 480);
        vbox.setOnMousePressed(new ControladorMousePresionado(jugador, vistaTablero));
        vbox.getChildren().add(new ContenedorBotones(jugador, tablero));

        theStage.setScene(escenaComienzo);
        theStage.show();

    }

    /*TODO: El juego, los jugadores */



}
