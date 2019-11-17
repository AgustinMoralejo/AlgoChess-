package Fiuba.AlgoChess;
import java.util.List;

import Fiuba.Excepciones.*;
import Fiuba.Tablero.Casillero;
import Fiuba.Unidad.Arma;

public class EstadoEnemigo implements EstadoAlianzas{
	
	public EstadoEnemigo() {}
	
	@Override
	public void comprarUnidad() {
		throw new NoSePuedeColocarUnidadEnSectorEnemigoException();
	}
	
    @Override
    public EstadoAliado cambiarEstadoAlianzas(){
        return new EstadoAliado();
    }

    @Override
    public int calcularCostoUnidad(int costo){
        return costo;
    }

    @Override
    public int calcularCostoCasillero(int costo){
        return costo;
    }

    @Override 
    public int calcularCostoCuracion(int costo){
        throw new NoSePuedeCurarEnemigoException();
    }

    @Override 
    public void puedeActuar(){
        throw new CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException();
    }
    
    @Override
    public Arma seleccionarArmaSoldado(Arma armaAnterior) {
    	return armaAnterior.cambiarArmaEnemiga();
    }
    
    @Override 
    public Arma seleccionarArmaOtraUnidad(Arma armaAnterior) {
    	return armaAnterior.cambiarArmaEnemiga();
    }
    
    @Override
    public Arma seleccionarArmaNull(Arma armaAnterior) {
    	return armaAnterior.cambiarArmaEnemiga();
    }
    
    @Override
    public void agregarCasilleroAlBatallon(List<Casillero>batallon, Casillero casillero) {}

}