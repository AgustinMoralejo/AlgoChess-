package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Vista.BarraDeEstadoJuego;
import fiuba.algo3.TP2.Vista.ContenedorBotones;
import fiuba.algo3.TP2.Vista.ContenedorBotonesFaseInicial;
import fiuba.algo3.TP2.Vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    Stage theStage;

    public BotonEntrarEventHandler(Stage theStage) {
        this.theStage = theStage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        AlgoChess algoChess = new AlgoChess("juan","pedro");

        ControladorJuego controladorJuego = new ControladorJuego();

        controladorJuego.setJuego(algoChess);

        /**esto lo deberia hacer el motodo asignarVistasACasilleros*/
        VistaTablero vistaTablero = new VistaTablero(controladorJuego);

        HBox contenederoPrincipal = new HBox();

        VBox vbox = new VBox();
        BarraDeEstadoJuego barraEstado = new BarraDeEstadoJuego();
        vbox.getChildren().addAll(barraEstado, vistaTablero);


        ContenedorBotonesFaseInicial contenedorBotones = new ContenedorBotonesFaseInicial(controladorJuego, theStage);
        //ContenedorBotones contenedorBotones = new ContenedorBotones(controladorJuego);
        contenederoPrincipal.getChildren().addAll(vbox,contenedorBotones);//vbox.getChildren().add(contenedorBotones);
        //vbox.getChildren().remove(contenedorBotones);

        controladorJuego.asignarVistasACasilleros(vistaTablero);
        /***/


        Scene escenaPartida = new Scene(contenederoPrincipal);
        theStage.setScene(escenaPartida);

        controladorJuego.setInicioParaPruebas();

        /*
        theStage.setFullScreenExitHint("");
        theStage.setFullScreen(true);
        */



    }

}
