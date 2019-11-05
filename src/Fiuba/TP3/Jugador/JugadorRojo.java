package Fiuba.TP3.Jugador;

import Fiuba.TP3.NoSePuedeColocarUnidadEnSectorEnemigoException;
import Fiuba.TP3.Tablero.Tablero;
import Fiuba.TP3.Unidad.Unidad;

public class JugadorRojo extends Jugador {

    public JugadorRojo(String unNombre, Tablero tablero) {
        super(unNombre,tablero);
    }

    @Override
    public void comprarUnidad(String nombreUnidad, int fila, int columna) {

        /*BRUTO hardcodeo para ver si estoy en el sector rojo*/
        if(fila > 10 ){
            throw new NoSePuedeColocarUnidadEnSectorEnemigoException();
        }

        Unidad unidadComprada;
        unidadComprada = cuartel.getUnidad(nombreUnidad, puntos);
        puntos -= unidadComprada.getCosto();
        tablero.colocarUnidad(unidadComprada, fila, columna);
        unidades.add(unidadComprada);

    }

    @Override
    public void unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(int filaAliada, int columnaAliado, int filaEnemigo, int columnaEnemigo) {

    }
}
