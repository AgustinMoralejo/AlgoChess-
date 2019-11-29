package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import javafx.scene.layout.HBox;

public class ContenedorBotones extends HBox {

    public ContenedorBotones(Jugador jugador, Tablero tablero) {
        super();
        this.setHeight(20);
        this.getChildren().add(new BotonModoAtaque(jugador));
        this.getChildren().add(new BotonModoPasivo(jugador));
        this.getChildren().add(new BotonCambiarTurno(tablero));

    }

}
