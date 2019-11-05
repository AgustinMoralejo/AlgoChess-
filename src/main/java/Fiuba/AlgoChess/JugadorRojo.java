package Fiuba.AlgoChess;

import Fiuba.Excepciones.NoSePuedeColocarUnidadEnSectorEnemigoException;
import Fiuba.Tablero.Tablero;
import Fiuba.Unidad.*;

import static Fiuba.AlgoChess.Alianza.ROJO;

public class JugadorRojo extends Jugador {

    public JugadorRojo(String unNombre, Tablero tablero) {
        super(unNombre,tablero);
    }

    public JugadorRojo(String nombreJugadorRojo) {
        super(nombreJugadorRojo);
    }

    @Override
    public void comprarUnidad(String nombreUnidad, int fila, int columna) {

        /*BRUTO hardcodeo para ver si estoy en el sector rojo*/

       /*

        if(fila > 10 ){
            throw new NoSePuedeColocarUnidadEnSectorEnemigoException();
        }
*/

        Unidad unidadComprada;
        unidadComprada = cuartel.getUnidad(nombreUnidad, this);
        unidadComprada.setAlianza(ROJO);
        tablero.colocarUnidad(unidadComprada, fila, columna);
        unidades.add(unidadComprada);


    }

    @Override
    public void unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(int filaAliada, int columnaAliado, int filaEnemigo, int columnaEnemigo) {

        tablero.unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(filaAliada, columnaAliado, filaEnemigo, columnaEnemigo);

    }


}
