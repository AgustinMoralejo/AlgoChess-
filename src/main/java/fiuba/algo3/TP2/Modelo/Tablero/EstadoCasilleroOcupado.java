package fiuba.algo3.TP2.Modelo.Tablero;

import fiuba.algo3.TP2.Modelo.Excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;

public class EstadoCasilleroOcupado implements EstadoCasillero{
	
	public EstadoCasilleroOcupado(){}

    @Override
    public void agregarUnidad(Unidad unaUnidad, Casillero casilleroFinal, Casillero CasilleroAnterior){
        throw new CasilleroEstaOcupadoException();
    }

    @Override
    public void agregarUnidadBatallon(Unidad unaUnidad, Casillero zonaFinal) {
        throw new CasilleroEstaOcupadoException();
    }

    @Override 
    public boolean estaOcupado() {
    	return true;
    }
    
    @Override
    public void puedeColocar() {
    	throw new CasilleroEstaOcupadoException();
    }
    
}