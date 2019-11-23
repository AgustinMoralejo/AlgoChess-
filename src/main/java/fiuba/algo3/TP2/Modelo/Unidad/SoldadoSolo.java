package fiuba.algo3.TP2.Modelo.Unidad;

import fiuba.algo3.TP2.Modelo.Tablero.Casillero;

public class SoldadoSolo implements EstadoBatallon {

    Casillero casilleroInicial;

    public SoldadoSolo(){
    }


    public SoldadoSolo(Casillero casilleroInicial){
        this.casilleroInicial = casilleroInicial;
    }

    @Override
    public void moveteA(Casillero zonaInicial, int orientacion) {

        Casillero zonaFinal = casilleroInicial.getAdyacente(orientacion);
        zonaFinal.recibirUnidad(casilleroInicial.getUnidad(), casilleroInicial);

    }

    @Override
    public boolean estaSolo() {
        return true;
    }


}
