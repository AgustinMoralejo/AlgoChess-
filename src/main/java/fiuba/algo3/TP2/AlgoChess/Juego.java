package fiuba.algo3.TP2.AlgoChess;

import fiuba.algo3.TP2.Tablero.Tablero;

public class Juego {

    private Tablero tablero;
    private Jugador jugadorAzul;
    private Jugador jugadorRojo;

    public Juego(String nombreJugadorAzul, String nombreJugadorRojo){

        tablero = new Tablero();
        jugadorAzul = new Jugador(nombreJugadorAzul);
        jugadorRojo = new Jugador(nombreJugadorRojo);
    }





}
