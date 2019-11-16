package Fiuba.Tablero;

import Fiuba.Excepciones.NoHayUnidadEnCasilleroException;
import Fiuba.Unidad.Unidad;
import Fiuba.AlgoChess.*;

import java.util.ArrayList;
import java.util.List;

import static Fiuba.AlgoChess.Movimiento.OFFSET_COORDENADAS_MOVIMIENTO;

public class Tablero{

    private Casillero tablero[][];

    public static final int FILAS_TABLERO = 20;

    public static final int COLUMNAS_TABLERO = 20;

    public Tablero(){
        int i,j;
        tablero = new Casillero[FILAS_TABLERO][COLUMNAS_TABLERO];
        for ( i = 0; i < FILAS_TABLERO ; i++) {
            for (j = 0; j < COLUMNAS_TABLERO; j++) {
                tablero[i][j] = new Casillero(i, j);
            }
        }
        this.iniciarEstado();
    }

    public void iniciarEstado(){
        for (int i = 0; i < FILAS_TABLERO ; i++) {
            for (int j = 0; j < COLUMNAS_TABLERO/2 ; j++) {
                tablero[i][j].iniciarZonaPorAlianza("aliado");
            }
        }

        for (int i = 0; i < FILAS_TABLERO ; i++) {
            for (int j = COLUMNAS_TABLERO/2; j < COLUMNAS_TABLERO ; j++) {
                tablero[i][j].iniciarZonaPorAlianza("enemigo");
            }
        }

        /*El tablero le asigna los casilleros contiguos a cada casillero de la iteracion utilizando el static offset
         * no lo pruebo en los bordes pq si no tengo un puntero a la nada*/

        for (int i = 1; i < 19 ; i++) {
            for (int j = 1; j < 19 ; j++) {
                tablero[i][j].agregarUnCasilleroContiguo(tablero[i+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0][0]][j+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[0][1]]);
                tablero[i][j].agregarUnCasilleroContiguo(tablero[i+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1][0]][j+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[1][1]]);
                tablero[i][j].agregarUnCasilleroContiguo(tablero[i+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2][0]][j+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[2][1]]);
                tablero[i][j].agregarUnCasilleroContiguo(tablero[i+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3][0]][j+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[3][1]]);
                tablero[i][j].agregarUnCasilleroContiguo(tablero[i+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4][0]][j+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[4][1]]);
                tablero[i][j].agregarUnCasilleroContiguo(tablero[i+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5][0]][j+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[5][1]]);
                tablero[i][j].agregarUnCasilleroContiguo(tablero[i+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6][0]][j+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[6][1]]);
                tablero[i][j].agregarUnCasilleroContiguo(tablero[i+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7][0]][j+Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[7][1]]);
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

    public Unidad getUnidad(int fila, int columna){ return tablero[fila][columna].getUnidad();}

    public void moverUnidad(int fila, int columna, int[] offset){

        int offsetEnFila, offsetEnColumna;
        offsetEnFila = offset[0];
        offsetEnColumna = offset[1];
        List<Casillero> batallon = new ArrayList<>();
        List<Unidad> bufferBatallon = new ArrayList<>();

        Casillero casilleroSeleccionado = tablero[fila][columna];
        Unidad unidadAMover = casilleroSeleccionado.getUnidad();
        batallon.add(casilleroSeleccionado);

        if(unidadAMover.getSimbolo() == "S"){
            tablero[fila][columna].agregarCasillerosAlBatallon(batallon, 1);

        }

        /*si no se forma un batallon quita al unico soldado adyacente*/
        if(batallon.size() == 2){
            batallon.remove(1);
        }


        for(Casillero casilleroBatallon : batallon) {
            bufferBatallon.add(casilleroBatallon.getUnidad());
            casilleroBatallon.quitarUnidad();
        }

        for(Casillero casilleroBatallon : batallon){
            int i=0;

            Casillero casilleroAOcupar = tablero[casilleroBatallon.getCoordenada().getFila() + offsetEnFila]
            [casilleroBatallon.getCoordenada().getColumna() + offsetEnColumna];

            casilleroAOcupar.colocarNuevaUnidad(bufferBatallon.get(i));
            i++;
        }


    }

    public int getPuntosDeVidaUnidadEnPosicion(int fila, int columna){
        Unidad unidad = tablero[fila][columna].getUnidad();
        return unidad.getPuntosDeVida();
    }
    
    public Casillero[][] getTablero(){
    	return tablero;
    }

    public boolean estaOcupado(int fila, int columna){
       return tablero[fila][columna].casilleroEstaOcupado();
    }

    public void obtenerUnidadesContiguas(int filaAtaque, int columnaAtaque){
        Casillero casilleroActual = tablero[filaAtaque][columnaAtaque];
        Unidad unidadActual = casilleroActual.getUnidad();

        for (int i = -1; i < 2 ; i++) {
            for (int j = -1; j < 2 ; j++) {
                if(!(j==0 && i ==0) && (estaOcupado(filaAtaque+i, columnaAtaque+j))){
                    Casillero casillero = tablero[filaAtaque+i][columnaAtaque+j];
                    unidadActual.agregarUnidadesContiguas(casillero.getUnidad());
                }
            }
        }
    }

}