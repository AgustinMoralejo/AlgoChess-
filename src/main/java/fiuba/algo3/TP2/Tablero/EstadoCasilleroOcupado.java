package fiuba.algo3.TP2.Tablero;

import fiuba.algo3.TP2.Excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.TP2.Unidad.Unidad;

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