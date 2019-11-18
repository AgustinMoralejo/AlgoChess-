package Fiuba.Unidad;

import Fiuba.Tablero.Casillero;

import java.util.ArrayList;

public interface EstadoBatallon {

    void moveteA(Casillero zonaInicial, int orientacion, ArrayList<Casillero> batallon);

    boolean perteneceABatallon();

}
