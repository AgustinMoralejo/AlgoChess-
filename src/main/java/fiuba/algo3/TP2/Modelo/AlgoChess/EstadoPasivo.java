package fiuba.algo3.TP2.Modelo.AlgoChess;

import fiuba.algo3.TP2.Modelo.Tablero.Tablero;

public class EstadoPasivo implements EstadoAccion {

    @Override
    public void realizarAccion(int[] posUnidad, int[] destino, Jugador jugador) {

        jugador.moverUnidad(posUnidad, destino);

    }
}
