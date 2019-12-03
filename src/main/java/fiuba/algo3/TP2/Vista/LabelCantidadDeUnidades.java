package fiuba.algo3.TP2.Vista;


import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import fiuba.algo3.TP2.Modelo.Observer;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import javafx.scene.control.Label;

public class LabelCantidadDeUnidades extends Label implements Observer {

    private AlgoChess juego;

    public LabelCantidadDeUnidades(AlgoChess juego, int indice){
        super();
        this.juego = juego;
        juego.agregarObserver(this);
        this.setText("CantidadDeUnidadesVivas: " + this.juego.getTablero().getCantidadDeUnidades(indice));
    }

    @Override
    public void actualizar() {
        this.setText("cantidadDeUnidadesVivas: " + this.juego.getTablero().getCantidadDeUnidades(juego.getIndiceJugadorActual()));
    }
}