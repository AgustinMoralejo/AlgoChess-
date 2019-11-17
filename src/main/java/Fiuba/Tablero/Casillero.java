package Fiuba.Tablero;

import Fiuba.Unidad.*;

import Fiuba.AlgoChess.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Casillero{

    private Unidad unidad;
    private EstadoCasillero estado;
    private EstadoAlianzas estadoAlianzas;
    private int fila;
    private int columna;
    private ArrayList<Casillero> adyacentes;


    public Casillero(int fil, int col){
        fila = fil;
        columna = col;
        this.unidad = new UnidadNull();
        this.estado = new EstadoCasilleroVacio();
        this.estadoAlianzas = new EstadoAliado();
        this.adyacentes = new ArrayList<Casillero>();
    }
    
    public void comprarUnidad(Unidad unaUnidad) {
    	estadoAlianzas.comprarUnidad();
    	estado.puedeColocar();
    	unidad = unaUnidad;
    	estado = new EstadoCasilleroOcupado();
    }
    
    public void agregarAdyacentes(Casillero adyacente) {
    	adyacentes.add(adyacente);
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
       unidad.cambiarEstadoAlianzas();
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

    public void moverUnidad(int orientacion){
    	Casillero otroCasillero = adyacentes.get(orientacion);
        unidad.moveteA(this, otroCasillero, orientacion);
    }
    
    public void recibirUnidadBatallon(Unidad unidad) {
    	estado.recibirUnidadBatallon(this, unidad);
    }

    public Unidad getUnidad(){
        return unidad;
    }
    
    public boolean estaOcupado() {
    	return estado.estaOcupado();
    }
    
    public Casillero getAdyacente(int orientacion) {
    	return adyacentes.get(orientacion);
    }
    
    public void agregarCasillerosAlBatallon(List<Casillero> batallon, int i) {
    	
    	Casillero casilleroAdyacente;
        Iterator<Casillero> iterador = adyacentes.iterator();
        
        while(iterador.hasNext() && batallon.size() < 3) {
        	
        	casilleroAdyacente = iterador.next();
        	
        	if(!batallon.contains(casilleroAdyacente)) {
        		casilleroAdyacente.getUnidad().agregarCasillerosAlBatallon(batallon, casilleroAdyacente);
        	}
        }
        
        if(batallon.size() > i){
                batallon.get(i).agregarCasillerosAlBatallon(batallon, i+1);
        }
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}