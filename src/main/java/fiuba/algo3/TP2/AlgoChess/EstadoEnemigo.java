package fiuba.algo3.TP2.AlgoChess;
import java.util.List;

import fiuba.algo3.TP2.Excepciones.CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException;
import fiuba.algo3.TP2.Excepciones.NoSePuedeColocarUnidadEnSectorEnemigoException;
import fiuba.algo3.TP2.Tablero.Casillero;
import fiuba.algo3.TP2.Unidad.Arma;
import fiuba.algo3.TP2.Excepciones.NoSePuedeCurarEnemigoException;

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