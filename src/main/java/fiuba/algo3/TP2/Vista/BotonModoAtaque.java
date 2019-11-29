package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorBotonModoAtaque;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import javafx.scene.control.Button;

public class BotonModoAtaque extends Button {

    public BotonModoAtaque(Jugador jugador) {

        super();
        this.setText("Modo Ofensivo");
        this.setMinHeight(30);
        this.setOnAction(new ControladorBotonModoAtaque(jugador));

    }
}
