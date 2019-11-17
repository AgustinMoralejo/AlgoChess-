package Fiuba.Tablero;

import Fiuba.Unidad.*;

public interface EstadoCasillero{

    public abstract void agregarUnidad(Unidad unaUnidad,Casillero zonaFinal, Casillero zonaAnterior);
    public abstract boolean estaOcupado();
    public abstract void puedeColocar();
    public abstract void recibirUnidadBatallon(Casillero casillero, Unidad unidad);
}