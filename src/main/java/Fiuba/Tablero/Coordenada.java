package Fiuba.Tablero;

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

    public Coordenada getCoordenadaArriba(){
        return new Coordenada(fila-1, columna);
    }

    public Coordenada getCoordenadaAbajo(){
        return new Coordenada(fila+1, columna);
    }

    public Coordenada getCoordenadaDerecha(){
        return new Coordenada(fila, columna+1);
    }

    public Coordenada getCoordenadaIzquierda(){
        return new Coordenada(fila, columna-1);
    }
}
