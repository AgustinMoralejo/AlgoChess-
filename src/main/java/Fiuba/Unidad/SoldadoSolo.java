package Fiuba.Unidad;

import Fiuba.Tablero.Casillero;

import java.util.ArrayList;

public class SoldadoSolo implements EstadoBatallon {

    @Override
    public void moveteA(Casillero zonaInicial, int orientacion, ArrayList<Casillero> batallon) {

        Casillero zonaFinal = zonaInicial.getAdyacente(orientacion);
        zonaFinal.recibirUnidad(zonaInicial.getUnidad(), zonaInicial);

    }

    @Override
    public boolean perteneceABatallon() {
        return false;
    }


}
