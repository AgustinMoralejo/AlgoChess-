package fiuba.algo3.TP2.Tablero;
import fiuba.algo3.TP2.Unidad.Unidad;

public class EstadoCasilleroVacio implements EstadoCasillero{
	
	public EstadoCasilleroVacio() {}

    @Override
    public void agregarUnidad(Unidad unaUnidad, Casillero CasilleroFinal, Casillero CasilleroAnterior){
        CasilleroAnterior.quitarUnidad();
        CasilleroFinal.ocuparUnidad(unaUnidad);   
    }

    @Override
    public void agregarUnidadBatallon(Unidad unaUnidad, Casillero CasilleroFinal) {
        CasilleroFinal.ocuparUnidad(unaUnidad);
    }


    @Override 
    public boolean estaOcupado() {
    	return false;
    }
    
    @Override 
    public void puedeColocar() {}
    
}