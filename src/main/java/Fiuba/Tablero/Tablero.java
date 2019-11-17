package Fiuba.Tablero;

import Fiuba.Unidad.Unidad;
import java.util.List;
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
    	for (int i = -1; i < 2 ; i++) {
            for (int j = -1; j < 2 ; j++) {
            	if (fila + i < 0 || fila + j < 0 || columna + i < 0 || columna + j < 0) {
            		continue;
            	}
            	if(fila + i > 19 || fila + j > 19 || columna + i > 19 || columna + j > 19){
            		continue;
            	}
            	if(i == fila && j == columna) {continue;}
            	
            	Casillero adyacente = tablero[fila + i][columna + j];
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

    public void moverUnidad(int fila, int columna, int[] offset){
        int offsetEnFila, offsetEnColumna;
        Casillero zonaInicial = tablero[fila][columna];
        offsetEnFila = offset[0];
        offsetEnColumna = offset[1];
        List<Casillero> batallon = new ArrayList<>();
        List<Unidad> bufferBatallon = new ArrayList<>();
        Casillero zonaAMover = tablero[fila + offsetEnFila][columna + offsetEnColumna];
        
        Unidad unidadAMover = zonaInicial.getUnidad();
        batallon.add(zonaInicial);
        
        if(unidadAMover.getSimbolo() == "S"){
            zonaInicial.agregarCasillerosAlBatallon(batallon, 1);
        }
        
        if(batallon.size() < 3){
            zonaInicial.moverUnidad(zonaAMover);
            return;
        }
        
        for(Casillero casilleroBatallon : batallon) {
            bufferBatallon.add(casilleroBatallon.getUnidad());
            casilleroBatallon.quitarUnidad();
        }
        
        for(Casillero casilleroBatallon : batallon){
        	int i=0;
        	
            Casillero zonaFinal = tablero[casilleroBatallon.getFila() + offsetEnFila]
            		[casilleroBatallon.getColumna() + offsetEnColumna];
            
            zonaFinal.ocuparUnidad(bufferBatallon.get(i));
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
    
    public boolean estaOcupado(int fila, int columna) {
    	return tablero[fila][columna].estaOcupado();
    }
    
    public int getDimension() {
    	return tablero.length * tablero[0].length;
    }


    


}