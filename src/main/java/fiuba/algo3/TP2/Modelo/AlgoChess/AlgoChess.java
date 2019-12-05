package fiuba.algo3.TP2.Modelo.AlgoChess;

import fiuba.algo3.TP2.Modelo.Subject;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;

public class AlgoChess extends Subject {

    private Tablero tablero;
    private Jugador[] jugadores;
    private int indiceJugadorActual;

    public AlgoChess(String nombreJugadorAzul, String nombreJugadorRojo){

        jugadores = new Jugador[2];
        tablero = new Tablero();

        indiceJugadorActual = 0;

        Jugador jugadorAzul = new Jugador(nombreJugadorAzul,tablero);
        Jugador jugadorRojo = new Jugador(nombreJugadorRojo,tablero);

        jugadores[0] = jugadorAzul;
        jugadores[1] = jugadorRojo;

    }


    public Tablero getTablero() {
        return tablero;
    }

    public int getIndiceJugadorActual(){
        return indiceJugadorActual;
    }

    public Jugador getJugadorActual() {
        return jugadores[indiceJugadorActual];
    }

    public void terminarTurnoYVerSiHayGanador(){

        indiceJugadorActual++;

        if(indiceJugadorActual >= 2){
            indiceJugadorActual = 0;
        }

        //unidades se pueden mover de nuevo
        jugadores[0].resetMovimientoUnidades();
        jugadores[1].resetMovimientoUnidades();

        //barra de estado
        notificarObservers();

        tablero.cambiarEstado();
    }

    public Jugador getJugador(int indice) {
        return jugadores[indice];
    }
}
