package fiuba.algo3.TP2.Modelo.AlgoChess;

import fiuba.algo3.TP2.Modelo.Tablero.Tablero;

public class AlgoChess {

    private Tablero tablero;
    private Jugador jugadorAzul;
    private Jugador jugadorRojo;

    public AlgoChess(String nombreJugadorAzul, String nombreJugadorRojo){

        tablero = new Tablero();
        jugadorAzul = new Jugador(nombreJugadorAzul);
        jugadorRojo = new Jugador(nombreJugadorRojo);
    }


    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugadorAzul() {
        return jugadorAzul;
    }
}
