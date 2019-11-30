package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;

public class ControladorJuego {

    private AlgoChess juego;
    private Tablero tablero;

    public void setJuego(AlgoChess juego) {

        this.juego = juego;
        this.tablero = juego.getTablero();


    }

    public void asignarVistasACasilleros() {

    }

}
