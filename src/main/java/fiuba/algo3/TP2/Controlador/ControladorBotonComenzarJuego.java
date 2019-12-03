package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Vista.BarraDeEstadoJuego;
import fiuba.algo3.TP2.Vista.BarraDeMenu;
import fiuba.algo3.TP2.Vista.ContenedorBotones;
import fiuba.algo3.TP2.Vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;

public class ControladorBotonComenzarJuego implements EventHandler<ActionEvent> {

    private ControladorJuego controladorJuego;
    private Stage stage;

    public ControladorBotonComenzarJuego(ControladorJuego controladorJuego, Stage stage){
        this.controladorJuego = controladorJuego;
        this.stage = stage;
}

    @Override
    public void handle(ActionEvent event) {
        VistaTablero vistaTablero = controladorJuego.getVistaTablero();
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        ContenedorBotones contenedorBotones = new ContenedorBotones(this.controladorJuego);
        BarraDeEstadoJuego barraDeEstadoJuego = new BarraDeEstadoJuego(this.controladorJuego.getJuego());
        BarraDeMenu menuBar = new BarraDeMenu(stage);
        
        
        vbox.getChildren().addAll(menuBar, barraDeEstadoJuego, contenedorBotones, vistaTablero);
        ScrollPane barraDesplazamiento = new ScrollPane();
        barraDesplazamiento.setContent(vbox);
        hbox.getChildren().addAll(vbox, barraDesplazamiento);
        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        //stage.setFullScreenExitHint("");
        //stage.setFullScreen(true);
        System.out.println("Comienzo de juego");
    }
}
