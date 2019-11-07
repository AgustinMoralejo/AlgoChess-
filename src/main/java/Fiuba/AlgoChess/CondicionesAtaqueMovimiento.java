package Fiuba.AlgoChess;
import java.util.ArrayList;

import Fiuba.Tablero.*;

public class CondicionesAtaqueMovimiento {
	
	private int fila;
	private int columna;
	private Casillero[][] tablero;
	
	public CondicionesAtaqueMovimiento(int fil, int col, Casillero[][] tabla) {
		fila = fil;
		columna = col;
		tablero = tabla;
	}
	
	public ArrayList<Casillero> buscarCasilleros(int distancia){
    	ArrayList<Casillero> casilleros = new ArrayList<Casillero>();
    	for(int i = fila - distancia; i < columna + distancia + 1; i++) {
    		for(int j = fila - distancia; j < columna + distancia + 1; i++) {
    			casilleros.add(tablero[i][j]);
    		}
    	}
    	return casilleros;
    }
	
}
