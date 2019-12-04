package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorBotonModoAtaque;
import fiuba.algo3.TP2.Controlador.ControladorBotonModoPasivo;
import fiuba.algo3.TP2.Controlador.ControladorJuego;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class BotonModoPasivo extends Button {

    public BotonModoPasivo(ControladorJuego controladorJuego) {
        super();
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        this.setEffect(dropShadow);
        this.setStyle("-fx-base: burlyWood;");
        this.setText("Modo Pasivo");
        this.setMinHeight(30);
        this.setOnAction(new ControladorBotonModoPasivo(controladorJuego));

    }
}
