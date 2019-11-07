package Fiuba.Tablero;

import Fiuba.Excepciones.CasilleroEstaOcupadoException;
import Fiuba.Excepciones.NoSePuedeColocarUnidadEnSectorEnemigoException;
import Fiuba.Excepciones.UnidadNoMovibleException;
import Fiuba.Unidad.NullUnidad;
import Fiuba.Unidad.Unidad;
import Fiuba.Excepciones.noHayUnidadEnCasilleroException;

import static Fiuba.AlgoChess.Alianza.AZUL;
import static Fiuba.AlgoChess.Alianza.ROJO;
import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Tablero {

    private Unidad tablero[][];

    public Tablero(){

        int i,j;

        tablero = new Unidad[20][20];
        for ( i = 0; i < 20 ; i++) {
            for (j = 0; j < 20 ; j++) {
                tablero[i][j] = new NullUnidad();
            }
        }
        this.dividirTableroAzul();
        this.dividirTableroRojo();
    }

    public void dividirTableroAzul(){
        int i,j;
        for ( i = 0; i < 20 ; i++) {
            for (j = 0; j < 10 ; j++) {
                (tablero[i][j]).setAlianza(AZUL);
            }
        }
    }


    public void dividirTableroRojo(){
        int i,j;
        for ( i = 0; i < 20 ; i++) {
            for (j = 10; j < 20 ; j++) {
                (tablero[i][j]).setAlianza(ROJO);
            }
        }
    }

    public int getTamanio(){

        return tablero.length * tablero[0].length;
    }


    public boolean estaVacio(int fila, int columna){

        return tablero[fila][columna].getSimbolo() == "-";
    }

    public boolean posicionValida(int fila, int columna){
        return((fila >= 0) && (fila < 20) && (columna >= 0) && (columna < 20));
    }

    public void casilleroEstaOcupado(int fila, int columna){

        if(tablero[fila][columna].getSimbolo() != "-"){
            throw new CasilleroEstaOcupadoException();
        }
    }

    public void colocarUnidad(Unidad unaUnidad, int fila, int columna) {

        casilleroEstaOcupado(fila,columna);

        if(esTerritorioAliado(fila, columna, unaUnidad)){
            tablero[fila][columna] = unaUnidad;
            unaUnidad.setPosicion(fila,columna);
        }
        else{
            throw new NoSePuedeColocarUnidadEnSectorEnemigoException();
        }

    }

    public boolean esTerritorioAliado(int fila, int columna, Unidad unaUnidad){

        return ((tablero[fila][columna]).getAlianza()==unaUnidad.getAlianza());

    }
    private Unidad punteroAUnidad(int fila, int columna) {

        Unidad unidadAMover = tablero[fila][columna];
        tablero[fila][columna] = new NullUnidad();
        return unidadAMover;
    }

    public void moverUnidad(int fila, int columna, int[] offset) {
        Unidad unidadAMover;
        int offsetEnFila, offsetEnColumna;

        offsetEnFila = offset[0];
        offsetEnColumna = offset[1];
        unidadAMover = this.punteroAUnidad(fila,columna);
        if( unidadAMover.esMovible()){
            this.colocarUnidad(unidadAMover,fila+offsetEnFila,columna+offsetEnColumna);

        }
        else{
            throw new UnidadNoMovibleException();
        }
    }

    public void unidadAliadaEnPosicionAtacarUnidadEnemigaEnPosicion(int filaAliado, int columnaAliado, int filaEnemigo, int columnaEnemigo) {

        Unidad unidadAliada, unidadEnemiga;

        unidadAliada = tablero[filaAliado][columnaAliado];
        unidadEnemiga = tablero[filaEnemigo][columnaEnemigo];

        if(unidadAliada.getSimbolo() == "-" || unidadEnemiga.getSimbolo() == "-"){
            throw new noHayUnidadEnCasilleroException();
        }
        int distancia = max(abs(filaAliado - filaEnemigo), abs(columnaAliado - columnaEnemigo));

        unidadAliada.atacar(distancia, unidadEnemiga);
    }

    public int getPuntosDeVidaUnidadEnPosicion(int fila, int columna) {

        return tablero[fila][columna].getPuntosDeVida();
    }

    public int cantidadDeUnidadesAlrrededor(int filaActual, int columnaActual, String simboloUnidad){
        int cantidadDeUnidades = 0;

        for (int i = -1; i < 2 ; i++) {
            for (int j = -1; j < 2 ; j++) {
                if(!(j==0 && i ==0) && (this.posicionValida(filaActual+i, columnaActual+j) && (simboloUnidad == tablero[filaActual+i][columnaActual+j].getSimbolo()))){
                    cantidadDeUnidades ++;
                }
            }
        }
        return cantidadDeUnidades;
    }

    /*

    public ArrayList<Unidad> obtenerUnidadesContiguas(int fila, int columna){

        ArrayList<Unidad> unidadesContiguas = ArrayList<Unidad> new();
        int i,j;
        for( i = fila-1, i< fila+1, i++){
            for( j = columna-1, j<columna+1,j++){
                if(!(i==fila && j==columna)&&(tablero[i][j].getSimbolo()!="-")){
                    unidadesContiguas.add(tablero[i][j]);
                }
            }
        }
        return unidadesContiguas;
    }
    */

    /*
    public void imprimirTablero(){

        int i,j;

        System.out.print(" *****************Tablero del juego******************** \n") ;
        System.out.print("\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t14\t15\t16\t17\t18\t19\t\n") ;

        for ( i = 0; i < 20 ; i++) {
            System.out.print(i +"\t| ") ;
            for (j = 0; j < 20 ; j++) {
                System.out.print(tablero[i][j].getSimbolo() + " | ") ;
            }
            System.out.print("\n") ;
        }
    }


     */


}
