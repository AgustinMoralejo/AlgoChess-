package fiuba.algo3.TP2.Unidad;

import fiuba.algo3.TP2.Tablero.Casillero;

import java.util.ArrayList;

public interface EstadoBatallon {

    void moveteA(Casillero zonaInicial, int orientacion, ArrayList<Casillero> batallon);

    boolean perteneceABatallon();

}
