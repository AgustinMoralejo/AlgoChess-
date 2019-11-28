package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Vista.BotonUnidadModoAtaque;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class ContenedorBotones extends Button {

    public ContenedorBotones(Jugador jugador) {
        super();
        this.setHeight(20);
        this.getChildren().add(new BotonUnidadModoAtaque(jugador));

    }

}
