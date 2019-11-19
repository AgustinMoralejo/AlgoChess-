package fiuba.algo3.TP2.Unidad;

import fiuba.algo3.TP2.Tablero.Casillero;

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
