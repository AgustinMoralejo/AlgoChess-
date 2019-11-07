package Fiuba.Tablero;
import Fiuba.Unidad.*;

public class EstadoCasilleroVacio implements EstadoCasillero{
	
	public EstadoCasilleroVacio() {}

    @Override
    public void agregarUnidad(Unidad unaUnidad, Casillero CasilleroFinal, Casillero CasilleroAnterior){
        CasilleroAnterior.quitarUnidad();
        CasilleroFinal.ocuparUnidad(unaUnidad);   
    }
}