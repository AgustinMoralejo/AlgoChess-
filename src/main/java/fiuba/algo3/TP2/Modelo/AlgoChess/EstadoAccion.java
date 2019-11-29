package fiuba.algo3.TP2.Modelo.AlgoChess;

import fiuba.algo3.TP2.Modelo.Tablero.Tablero;

public interface EstadoAccion {

    void realizarAccion(int[] posUnidad, int[] destino, Jugador jugador);


}
