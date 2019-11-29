package fiuba.algo3.TP2.Modelo.Tablero;

import fiuba.algo3.TP2.Modelo.AlgoChess.Movimiento;
import fiuba.algo3.TP2.Modelo.Excepciones.UnidadSoloSePuedeMoverUnCasilleroException;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Tablero{

    private Casillero[][] tablero;

    private static final int FILAS = 20;
    private static final int COLUMNAS = 20;
    private boolean primerClick;

    public Tablero(){
        int i,j;
        tablero = new Casillero[FILAS][COLUMNAS];
        for ( i = 0; i < FILAS ; i++) {
            for (j = 0; j < COLUMNAS ; j++) {
                Casillero casillero = new Casillero(i, j);
                tablero[i][j] = casillero;
            }
        }
        this.iniciarEstado();
        this.agregarTodosAdyacentes();
        setPrimerClickTrue();
    }

    public void iniciarEstado(){
        for (int i = FILAS/2; i < FILAS ; i++) {
            for (int j = 0; j < COLUMNAS ; j++) {
                tablero[i][j].iniciarZonaEnemiga();
            }
        }
    }
    
    public void agregarTodosAdyacentes() {
    	for ( int i = 0; i < FILAS ; i++) {
            for (int j = 0; j < COLUMNAS ; j++) {
                for (int k = 0; k < 8; k++) {

                    int casilleroAdyacenteHorizontal = i + Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[k][0];
                    int casilleroAdyacenteVertical = j + Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[k][1];

                    if(estaEnRangoValido(casilleroAdyacenteHorizontal, casilleroAdyacenteVertical)){
                        tablero[i][j].agregarAdyacente(tablero[casilleroAdyacenteHorizontal]
                                [casilleroAdyacenteVertical]);
                    }
                    else{
                        tablero[i][j].agregarAdyacente(
                                new Casillero(casilleroAdyacenteHorizontal,
                                        casilleroAdyacenteVertical));
                    }

                }
            }
    	}
    }


    public boolean estaEnRangoValido(int fila, int columna){
        return ((fila > -1) && (fila < 20) && (columna > -1) && (columna < 20));
    }


    public void imprimirTablero(){

        int i,j;

        System.out.print(" *****************Tablero del juego******************** \n") ;
        System.out.print("\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t14\t15\t16\t17\t18\t19\t\n") ;

        for ( i = 0; i < FILAS ; i++) {
            System.out.print(i +"\t| ") ;
            for (j = 0; j < COLUMNAS ; j++) {
                System.out.print(tablero[i][j].getSimbolo() + " | ") ;
            }
            System.out.print("\n") ;
        }
    }



    public ArrayList<Casillero> buscarCasilleros(int distancia, int fila, int columna){
    	ArrayList<Casillero> casilleros = new ArrayList<Casillero>();
    	for(int i = fila - distancia; i < fila + distancia + 1; i++) {
    		for(int j = columna - distancia; j < columna + distancia + 1; j++) {
    			if (i > 19 || j > 19 || i < 0 || j < 0) {
    				continue;
    			}
    			if (i == fila && j == columna) {continue;}
    			Casillero zona = tablero[i][j];
    			casilleros.add(zona);
    		}
    	}
    	return casilleros;
    }
    
    public void cambiarEstado(){
        for (int i = 0; i < FILAS ; i++) {
            for (int j = 0; j < COLUMNAS ; j++) {
                tablero[i][j].cambiarEstadoAlianzas();
            }
        }
    }


    public void moverUnidad(int fila, int columna, int orientacion){

        /*Como los casillero ya saben cuales son adyacentes podemos delegar la responsabilidad al casillero*/

        Casillero casilleroInicial = tablero[fila][columna];
        casilleroInicial.moverUnidad(orientacion);

    }
    
    public void colocarUnidad(Unidad unaUnidad, int fila, int columna){
        Casillero casillero = tablero[fila][columna];
        casillero.comprarUnidad(unaUnidad);
    }

    public Casillero getCasillero(int fila, int columna){
        return tablero[fila][columna];
    }


    public int getPuntosDeVidaUnidadEnPosicion(int fila, int columna){
        Unidad unidad = tablero[fila][columna].getUnidad();
        return unidad.getPuntosDeVida();
    }
    
    public Casillero[][] getTablero(){
    	return tablero;
    }
    
    public boolean estaOcupado(int fila, int columna) {
    	return tablero[fila][columna].estaOcupado();
    }
    
    public int getDimension() {
    	return tablero.length * tablero[0].length;
    }

    public int getColumnas() {
        return COLUMNAS;
    }

    public int getFilas() {
        return FILAS;
    }


    public Unidad getUnidad(int fila, int columna){
        return tablero[fila][columna].getUnidad();
    }

    //vista

    public int darOrientacion(int[] posUnidad, int[] destino) {

        int orientacion = -9;

        int difFil = destino[0] - posUnidad[0] ;
        int difCol = destino[1] - posUnidad[1] ;


        System.out.println("diferencias, fil:"+ difFil +"col:" + difCol);

            if(abs(difFil) > 1 || abs(difCol) > 1 || (difCol == 0 && difFil==0)){

                throw new UnidadSoloSePuedeMoverUnCasilleroException();
            }

        //si, no estoy muy orgullos pero fue lo mejor que se me ocurrio
        String sentido = "" + difFil + "," + difCol + "";


        System.out.println("sentido: "+ sentido);




        switch (sentido) {
            case "-1,0": orientacion = 0;
                break;
            case "-1,1": orientacion=1;
                break;
            case "0,1": orientacion=2;
                break;
            case "1,1": orientacion=3;
                break;
            case "1,0": orientacion=4;
                break;
            case "1,-1": orientacion=5;
            break;
            case "0,-1": orientacion=6;
                break;
            case "-1,-1": orientacion=7;
                break;

        }


        System.out.println("orientacion: "+ orientacion);


        return orientacion;
    }

    public void moverUnidad(Casillero primerCasilleroSeleccionado, Casillero segundoCasilleroSeleccionado) {

        int[] posUnidad = new int[2];
        int[] destino = new int[2];
        posUnidad[0] = primerCasilleroSeleccionado.getFila();
        posUnidad[1] = primerCasilleroSeleccionado.getColumna();
        destino[0] = segundoCasilleroSeleccionado.getFila();
        destino[1] = segundoCasilleroSeleccionado.getColumna();

        int orientacion = this.darOrientacion(posUnidad, destino);

        this.moverUnidad(posUnidad[0], posUnidad[1], orientacion);
    }

    public void setPrimerClickFalse() {
        primerClick = false;
    }

    public boolean esPrimerClick() {
        return primerClick;
    }

    public void setPrimerClickTrue() {
        primerClick = true;
    }
}