package Fiuba.Tablero;

import Fiuba.Unidad.*;
import Fiuba.Excepciones.*;

public class EstadoCasilleroOcupado implements EstadoCasillero{
	
	public EstadoCasilleroOcupado(){}

    @Override
    public void agregarUnidad(Unidad unaUnidad, Casillero casilleroFinal, Casillero CasilleroAnterior){
        throw new CasilleroEstaOcupadoException();
    }
}