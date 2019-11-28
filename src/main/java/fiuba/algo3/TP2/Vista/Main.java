package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorMouseArrastrado;
import fiuba.algo3.TP2.Controlador.ControladorMousePresionado;
import fiuba.algo3.TP2.Controlador.ControladorMouseSoltado;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;

import fiuba.algo3.TP2.Modelo.Unidad.Soldado;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
        Jugador jugador = new Jugador("agus", tablero);
        Jugador jugador2 = new Jugador("enemigo", tablero);

        //
        //por defecto las unidades son aliadas
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();

        Soldado soldadoEnemigo1 = new Soldado();
        soldadoEnemigo1.cambiarEstadoAlianzas();

        tablero.colocarUnidad(soldadoEnemigo1,7,7);

        tablero.colocarUnidad(soldado3,9,7);
        tablero.colocarUnidad(soldado1,5,8);
        tablero.colocarUnidad(soldado2,3,9);
        //

        vistaTablero = new VistaTablero(tablero);

        VBox vbox = new VBox();
        vbox.getChildren().add(vistaTablero);

        ContenedorPantallaPrincipal contenedorPrincipal = new ContenedorPantallaPrincipal(theStage, vbox);
        Scene escenaComienzo = new Scene(contenedorPrincipal, 640, 480);

        vbox.setOnMousePressed(new ControladorMousePresionado(jugador, vistaTablero));
        vbox.getChildren().add(new ContenedorBotones(jugador));

        theStage.setScene(escenaComienzo);
        theStage.show();

    }

    /*TODO: todavia no estoy trabajando con el modelo,
       solo con las vistas*/



}
