package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Observer;
import javafx.scene.control.Label;

public class LabelPuntosJugador extends Label implements Observer {

    private Jugador jugador;

    public LabelPuntosJugador(Jugador jugador) {
        super();
        this.jugador = jugador;
        jugador.agregarObserver(this);
        this.setText("Puntos: " + jugador.getPuntos());

    }

    @Override
    public void actualizar() {
        this.setText("Puntos: " + jugador.getPuntos());
    }
}
