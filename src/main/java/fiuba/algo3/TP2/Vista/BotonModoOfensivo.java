package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorBotonModoAtaque;
import fiuba.algo3.TP2.Controlador.ControladorJuego;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import javafx.scene.control.Button;
import javafx.scene.paint.ImagePattern;

public class BotonModoOfensivo extends Button {

    public BotonModoOfensivo(ControladorJuego controladorJuego) {

        super();
        this.setText("Modo Ofensivo");
        this.setMinHeight(30);
        this.setOnAction(new ControladorBotonModoAtaque(controladorJuego));

    }
}
