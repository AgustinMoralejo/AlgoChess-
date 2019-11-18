package Fiuba.Unidad;

import java.util.ArrayList;
import java.util.List;

import Fiuba.AlgoChess.*;

import Fiuba.Excepciones.*;
import Fiuba.Tablero.*;

public class UnidadNull extends Unidad{



    public UnidadNull(){
    	estadoAlianzas = new EstadoAliado();
    }

    @Override
    public String getSimbolo(){
      return "-";
    };

    @Override 
    public int calcularCostoUnidad(int costo) {
    	throw new NoHayUnidadEnCasilleroException();
    }
    
    @Override
    public void perderVida(int costoAtaque){
    }

    @Override
    public void cambiarEstadoAlianzas(){
    	estadoAlianzas = estadoAlianzas.cambiarEstadoAlianzas();
    }
    
    public Unidad copiar() {
    	return new UnidadNull();
    }

    @Override
    public int atacar(ArrayList<Casillero> zonasCercanas, int distancia, Casillero unidadDefensa){
        throw new NoHayUnidadEnCasilleroException();
    }

    @Override
    public void moveteA(Casillero zonaInicial, int orientacion) {
        throw new NoHayUnidadEnCasilleroException();
    }

    @Override
    public void dentroRango(int distancia) {
    }
    
    @Override
    public Arma seleccionarArmasJinete(Arma armaAnterior) {
    	return estadoAlianzas.seleccionarArmaNull(armaAnterior);
    }
    
    @Override
    public void agregarUnCasilleroAlBatallon(List<Casillero> batallon, Casillero casillero) {}
    

}