package Fiuba.Unidad;
import Fiuba.Excepciones.*;

public class Catapulta extends Unidad {


    private int costo;
    private int vida;
    private int danio;
    private int danioADistancia;

    public Catapulta(){
        this.vida = 50;
        this.costo = 5;
        this.danioADistancia = 20;
        this.danio = 0;
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
