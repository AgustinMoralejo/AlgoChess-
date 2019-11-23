package fiuba.algo3.TP2.Modelo.Unidad;

import fiuba.algo3.TP2.Modelo.Tablero.Casillero;

public interface EstadoBatallon {

    void moveteA(Casillero zonaInicial, int orientacion);

    boolean estaSolo();
}
