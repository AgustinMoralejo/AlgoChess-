package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Vista.ContenedorBotones;
import fiuba.algo3.TP2.Vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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

        /**No debe ir aca, es para que ande*/
        Tablero tablero = algoChess.getTablero();
        Jugador jugadorAzul = algoChess.getJugadorAzul();
        /**No debe ir aca, es para que ande*/

        /**esto lo deberia hacer el motodo asignarVistasACasilleros*/
        VistaTablero vistaTablero = new VistaTablero(tablero);

        VBox vbox = new VBox();
        vbox.getChildren().add(vistaTablero);

        vbox.getChildren().add(new ContenedorBotones(jugadorAzul, tablero));

        controladorJuego.asignarVistasACasilleros(vistaTablero);
        /***/


        Scene escenaPartida = new Scene(vbox);
        theStage.setScene(escenaPartida);

        controladorJuego.setInicioParaPruebas();

        /*
        theStage.setFullScreenExitHint("");
        theStage.setFullScreen(true);
        */



    }

}
