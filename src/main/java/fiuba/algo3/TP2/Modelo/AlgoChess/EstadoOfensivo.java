package fiuba.algo3.TP2.Modelo.AlgoChess;

import fiuba.algo3.TP2.Modelo.Tablero.Tablero;

public class EstadoOfensivo implements EstadoAccion {

    @Override
    public void realizarAccion(int[] posUnidad, int[] destino, Jugador jugador) {

        jugador.atacar(posUnidad[0],posUnidad[1],destino[0],destino[1]);
    }
}
