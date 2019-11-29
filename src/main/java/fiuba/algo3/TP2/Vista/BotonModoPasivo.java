package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorBotonModoAtaque;
import fiuba.algo3.TP2.Controlador.ControladorBotonModoPasivo;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class BotonModoPasivo extends Button {
    public BotonModoPasivo(Jugador jugador) {
        super();
        this.setText("Modo Pasivo");
        this.setMinHeight(30);
        this.setOnAction(new ControladorBotonModoPasivo(jugador));

    }
}
