package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorBotonComenzarJuego;
import fiuba.algo3.TP2.Controlador.ControladorJuego;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonComenzarJuego extends Button {

    public BotonComenzarJuego(ControladorJuego controladorJuego, ContenedorBotonesFaseInicial contenedorBotones, VBox vbox){

        super();
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        this.setEffect(dropShadow);
        this.setStyle("-fx-base: burlyWood;");
        this.setText("Comenzar Juego");
        this.setMinHeight(30);
        this.setOnAction(new ControladorBotonComenzarJuego(controladorJuego, contenedorBotones, this, vbox));

    }
}
