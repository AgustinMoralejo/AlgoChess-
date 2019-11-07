package Fiuba.Tablero;

import Fiuba.Unidad.*;
import Fiuba.AlgoChess.*;


import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Casillero{

    private Unidad unidad = new UnidadNull();
    private EstadoCasillero estado = new EstadoCasilleroVacio();
    private EstadoAlianzas estadoAlianzas = new EstadoAliado();
    private int fila;
    private int columna;


    public Casillero(int fil, int col){
        fila = fil;
        columna = col;
    }

    public void recibirUnidad(Unidad unaUnidad, Casillero CasilleroAnterior){
        estado.agregarUnidad(unaUnidad, this, CasilleroAnterior);
    }

    public void ocuparUnidad(Unidad unaUnidad){
        unidad = unaUnidad;
        estado = new EstadoCasilleroOcupado();
    }

    public void quitarUnidad(){
        unidad = new UnidadNull();
        estado = new EstadoCasilleroVacio();
    }

    public void cambiarEstadoAlianzas(){
       estadoAlianzas = estadoAlianzas.cambiarEstadoAlianzas();
    }

    public void iniciarZonaAliada(){
        estadoAlianzas = new EstadoAliado();
    }

    public void iniciarZonaEnemiga(){
        estadoAlianzas = new EstadoEnemigo();
    }

    public int calcularCostoAtaque(int costo){
        return estadoAlianzas.calcularCostoCasillero(costo);
    }
    
    public int getFila() {
    	return fila;
    }
    
    public int getColumna() {
    	return columna;
    }

    public int calcularDistancia(Casillero otroCasillero){
        int otraFila = otroCasillero.getFila();
        int otraColumna = otroCasillero.getColumna();
        int distancia = max(abs(fila - otraFila), abs(columna - otraColumna));
        return distancia;
    }

    public void moverUnidad(Casillero otroCasillero){
        unidad.moveteA(this, otroCasillero);
    }

    public Unidad getUnidad(){
        return unidad;
    }

}