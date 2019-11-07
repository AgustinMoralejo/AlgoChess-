package Fiuba.Unidad;

import Fiuba.Excepciones.ObjetivoFueraDeRangoException;

public class Curandero extends Unidad {

    public Curandero(){
        vida = 75;
        costo = 2;
        danioCuerpoACuerpo = 0;
        danioADistancia = -15;
        simbolo = "CR";
    }

    @Override
    public void atacar(int distancia, Unidad unidadObjetivo) {

        if(unidadObjetivo.getAlianza() == alianza ){
            this.dentroRango(distancia);
            unidadObjetivo.perderVida(danioADistancia);
        }
    }


    protected void dentroRango(int distancia) {

        if(distancia > 2){
            throw new ObjetivoFueraDeRangoException();
        }

    }

    @Override
    public Unidad copiar() {
        return new Curandero();
    }

}
