package Fiuba.Unidad;

import Fiuba.Excepciones.ObjetivoFueraDeRangoException;

import static java.lang.Math.abs;

public class Jinete extends Unidad {


    public Jinete(){

        vida = 100;
        costo = 3;
        danioCuerpoACuerpo = 5;
        danioADistancia = 15;
        simbolo = "J";
    }

    @Override
    public void atacar(int distancia, Unidad unidadObjetivo) {

        /*
        if(distancia < 3){
            unidadObjetivo.perderVida(danioCuerpoACuerpo);

        }

        this.dentroRango(distancia);
        unidadObjetivo.perderVida(danioADistancia);

         */
        unidadObjetivo.perderVida(this.obtenerDanioEnRango(distancia));


    }


    protected int obtenerDanioEnRango(int distancia){
        if (distancia > 5) {
            throw new ObjetivoFueraDeRangoException();
        }
        else if(distancia < 3){
            return danioCuerpoACuerpo;
        }
        else{
            return danioADistancia;
        }
    }

    @Override
    public Unidad copiar() {
        return new Jinete();
    }

}
