package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;

public class ControladorBotonComenzarJuego implements EventHandler<ActionEvent> {

    private ControladorJuego controladorJuego;
    private ContenedorBotonesFaseInicial botones;
    private VBox vbox;
    private BotonComenzarJuego botonComenzar;

    public ControladorBotonComenzarJuego(ControladorJuego controladorJuego, ContenedorBotonesFaseInicial contenedorBotones, BotonComenzarJuego botonComenzar, VBox vbox){
        this.controladorJuego = controladorJuego;
        this.botones = contenedorBotones;
        this.vbox = vbox;
        this.botonComenzar = botonComenzar;

}

    @Override
    public void handle(ActionEvent event) {
        vbox.getChildren().remove(this.botones);
        vbox.setSpacing(30);
        ContenedorBotones contenedorBotones = new ContenedorBotones(this.controladorJuego);
        contenedorBotones.setAlignment(Pos.TOP_CENTER);

        vbox.getChildren().add(contenedorBotones);
        vbox.getChildren().remove(this.botonComenzar);

        //stage.setFullScreenExitHint("");
        //stage.setFullScreen(true);
        System.out.println("Comienzo de juego");
    }
}
