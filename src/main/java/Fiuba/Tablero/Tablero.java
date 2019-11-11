package Fiuba.Tablero;

import Fiuba.Unidad.Unidad;
import Fiuba.AlgoChess.*;

public class Tablero{

    private Casillero tablero[][];

    public Tablero(){
        int i,j;
        tablero = new Casillero[20][20];
        for ( i = 0; i < 20 ; i++) {
            for (j = 0; j < 20; j++) {
                tablero[i][j] = new Casillero(i, j);
            }
        }
        this.iniciarEstado();
    }

    public void iniciarEstado(){
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10 ; j++) {
                tablero[i][j].iniciarZonaPorAlianza("aliado");
            }
        }

        for (int i = 10; i < 20 ; i++) {
            for (int j = 10; j < 20 ; j++) {
                tablero[i][j].iniciarZonaPorAlianza("enemigo");
            }
        }
    }
/*
    public void cambiarEstado(){
        for (int i = 0; i < 20 ; i++) {
            for (int j = 0; j < 20 ; j++) {
                tablero[i][j].cambiarEstadoAlianzas();
            }
        }
    }


 */
    public int getTamanio(){

        return tablero.length * tablero[0].length;
    }
    
    public void colocarUnidad(Unidad unaUnidad, int fila, int columna){
        Casillero casillero = tablero[fila][columna];
        casillero.ocuparConUnidad(unaUnidad);
    }

    public Casillero getCasillero(int fila, int columna){
        return tablero[fila][columna];
    }

    public void moverUnidad(int fila, int columna, int[] offset){

        int offsetEnFila, offsetEnColumna;
        offsetEnFila = offset[0];
        offsetEnColumna = offset[1];

        Casillero casilleroActual = tablero[fila][columna];
        Unidad unidadAMover = casilleroActual.getUnidad();

        Casillero casilleroAOcupar = tablero[fila + offsetEnFila][columna + offsetEnColumna];
        casilleroAOcupar.colocarNuevaUnidad(unidadAMover);

        casilleroActual.quitarUnidad();
    }


    public int getPuntosDeVidaUnidadEnPosicion(int fila, int columna){
        Unidad unidad = tablero[fila][columna].getUnidad();
        return unidad.getPuntosDeVida();
    }
    
    public Casillero[][] getTablero(){
    	return tablero;
    }

    public boolean estaOcupado(int fila, int columna){
        tablero[fila][columna].casilleroEstaOcupado();
        return false;
    }

}