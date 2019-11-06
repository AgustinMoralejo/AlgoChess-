package Fiuba.Unidad;
import Fiuba.Excepciones.*;

public class Catapulta extends Unidad {

    public Catapulta(){
        this.vida = 50;
        this.costo = 5;
        this.danioADistancia = 20;
        this.danioCuerpoACuerpo = 0;
        this.simbolo = "CT";
    }

    @Override
    public int getCosto() {
        return costo;
    }

    @Override
    public void atacar(int distancia, Unidad unidadObjetivo) {

        this.dentroRango(distancia);
        unidadObjetivo.perderVida(danioADistancia);
     }



    @Override
    public void perderVida(int danio) {
        if (danio < 0) {
            throw (new NoSePuedenCurarUnidadesNoOrganicasException());
        }
        vida -= danio;
    }

    @Override
    protected void dentroRango(int distancia) {

        if ( distancia < 6){
            throw new ObjetivoFueraDeRangoException();
        }
    }

    @Override
    public Unidad copiar() {

        return new Catapulta();
    }

    @Override
    public int getPuntosDeVida() {
        return vida;
    }

    @Override
    public boolean esMovible(){
        return false;
    }

    @Override
    public void pasoAlNorte(){
        throw new UnidadNoMovibleException();
    }

    @Override
    public void pasoAlEste(){
        throw new UnidadNoMovibleException();
    }

    @Override
    public void pasoAlSur(){ throw new UnidadNoMovibleException();
    }

    @Override
    public void pasoAlOeste(){
        throw new UnidadNoMovibleException();
    }

}
