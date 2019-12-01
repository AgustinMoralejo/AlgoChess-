package fiuba.algo3.TP2.Modelo.AlgoChess;
import java.util.List;

import fiuba.algo3.TP2.Modelo.Excepciones.NoSePuedeAtacarAUnaUnidadAliadaException;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.Armas.Arma;

public class EstadoAliado implements EstadoAlianzas{
	
	public EstadoAliado() {}
	
	@Override
	public void setUnidad() {}
    
	@Override
    public EstadoEnemigo cambiarEstadoAlianzas(){
        return new EstadoEnemigo();
    }

    @Override
    public int calcularCostoUnidad(int costo){
        throw new NoSePuedeAtacarAUnaUnidadAliadaException();
    }
    
    @Override
    public int calcularCostoCasillero(int costo){
        return costo + (costo * 5 ) / 100;
    }

    @Override 
    public int calcularCostoCuracion(int costo){
        return costo;
    }

    @Override
    public void puedeActuar(){

    }
    
    @Override
    public Arma seleccionarArmaSoldado(Arma armaAnterior) {
    	return armaAnterior.cambiarArmaSoldado();
    }
    
    @Override 
    public Arma seleccionarArmaOtraUnidad(Arma armaAnterior) {
    	return armaAnterior.cambiarArmaOtraUnidad();
    }
    
    @Override
    public Arma seleccionarArmaNull(Arma armaAnterior) {
    	return armaAnterior.cambiarArmaNull();
    }
    
    @Override
    public void agregarCasilleroAlBatallon(List<Casillero> batallon, Casillero casillero) {
    	batallon.add(casillero);
    }

    @Override
    public boolean esAliado() {
        return true;
    }

}