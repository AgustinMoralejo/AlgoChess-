package Fiuba.Tablero;

import Fiuba.Unidad.Unidad;
import java.util.ArrayList;

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
        this.agregarTodosAdyacentes();
    }

    public void iniciarEstado(){
        for (int i = 10; i < 20 ; i++) {
            for (int j = 0; j < 20 ; j++) {
                tablero[i][j].iniciarZonaEnemiga();
            }
        }
    }
    
    public void agregarTodosAdyacentes() {
    	for ( int i = 0; i < 20 ; i++) {
            for (int j = 0; j < 20 ; j++) {
            	this.agregarAdyacente(i, j);
            }
    	}
    }

    public void agregarAdyacente(int fila, int columna) {
    	for (int i = fila -1; i < fila + 2 ; i++) {
            for (int j = columna - 1; j < columna + 2 ; j++) {
            	if (i < 0 || j < 0 || i > 19 || j > 19) {continue;}
            	if(i == fila && j == columna) {continue;}
            	
            	Casillero adyacente = tablero[i][j];
            	tablero[fila][columna].agregarAdyacentes(adyacente);
            }
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
        for (int i = 0; i < 20 ; i++) {
            for (int j = 0; j < 20 ; j++) {
                tablero[i][j].cambiarEstadoAlianzas();
            }
        }
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


    


}