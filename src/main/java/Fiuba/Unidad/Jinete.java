package Fiuba.Unidad;

import Fiuba.Excepciones.ObjetivoFueraDeRangoException;

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
