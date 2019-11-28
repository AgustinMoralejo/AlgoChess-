package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import javafx.scene.layout.HBox;

public class ContenedorBotones extends HBox {

    public ContenedorBotones(Jugador jugador) {
        super();
        this.setHeight(20);
        this.getChildren().add(new BotonUnidadModoAtaque(jugador));

    }

}
