package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorBotonModoAtaque;
import fiuba.algo3.TP2.Controlador.ControladorJuego;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class BotonModoOfensivo extends Button {

    public BotonModoOfensivo(ControladorJuego controladorJuego) {

        super();
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        this.setEffect(dropShadow);
        this.setStyle("-fx-base: burlyWood;");
        this.setText("Modo Ofensivo");
        this.setMinHeight(30);
        this.setOnAction(new ControladorBotonModoAtaque(controladorJuego));

    }
}
