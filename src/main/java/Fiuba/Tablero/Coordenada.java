package Fiuba.Tablero;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Coordenada {

    private int fila;
    private int columna;

    public Coordenada (int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila(){
        return this.fila;
    }

    public int getColumna(){
        return this.columna;
    }

    public int calcularDistanciaEntreCoordenadas(Coordenada unaCoordenada){
        int distancia = max(abs(unaCoordenada.getFila() - this.getFila()), abs(unaCoordenada.getColumna() - this.getColumna()));
        return distancia;
    }
}
