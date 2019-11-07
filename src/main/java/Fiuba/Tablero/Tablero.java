package Fiuba.Tablero;

import Fiuba.Unidad.Unidad;

public class Tablero{

    private Casillero tablero[][];

    public Tablero(){
        int i,j;
        tablero = new Casillero[20][20];
        for ( i = 0; i < 20 ; i++) {
            for (j = 0; j < 20 ; j++) {
                Casillero casillero = new Casillero(i, j);
                tablero[i][j] = casillero;
            }
        }
        this.iniciarEstado();
    }

    public void iniciarEstado(){
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10 ; j++) {
                tablero[i][j].iniciarZonaAliada();
            }
        }

        for (int i = 10; i < 20 ; i++) {
            for (int j = 10; j < 20 ; j++) {
                tablero[i][j].iniciarZonaEnemiga();
            }
        }
    }

    public void cambiarEstado(){
        for (int i = 0; i < 20 ; i++) {
            for (int j = 0; j < 20 ; j++) {
                tablero[i][j].cambiarEstadoAlianzas();
            }
        }
    }

    
    
    public void colocarUnidad(Unidad unaUnidad, int fila, int columna){
        Casillero casillero = tablero[fila][columna];
        casillero.ocuparUnidad(unaUnidad);
    }

    public Casillero getCasillero(int fila, int columna){
        return tablero[fila][columna];
    }

    public void moverUnidad(int fila, int columna, int[] offset){
        int offsetEnFila, offsetEnColumna;
        Casillero zonaInicial = tablero[fila][columna];
        offsetEnFila = offset[0];
        offsetEnColumna = offset[1];
        Casillero zonaFinal = tablero[fila + offsetEnFila][columna + offsetEnColumna];
        zonaInicial.moverUnidad(zonaFinal);
    }


    public int getPuntosDeVidaUnidadEnPosicion(int fila, int columna){
        Unidad unidad = tablero[fila][columna].getUnidad();
        return unidad.getPuntosDeVida();
    }
    
    public Casillero[][] getTablero(){
    	return tablero;
    }



    


}