package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorModoAtaque;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import javafx.scene.control.Button;

public class BotonUnidadModoAtaque extends Button {

    public BotonUnidadModoAtaque(Jugador jugador) {

        super();
        this.setText("Modo Ataque");
        this.setMinHeight(30);
        this.setOnAction(new ControladorModoAtaque(jugador));

    }
}
