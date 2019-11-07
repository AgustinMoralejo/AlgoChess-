package Fiuba.AlgoChess;
import Fiuba.Excepciones.*;
import Fiuba.Unidad.Arma;

public class EstadoEnemigo implements EstadoAlianzas{
	
	public EstadoEnemigo() {}

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

}