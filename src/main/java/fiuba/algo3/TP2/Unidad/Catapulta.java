package fiuba.algo3.TP2.Unidad;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.TP2.AlgoChess.EstadoAliado;
import fiuba.algo3.TP2.Excepciones.NoSePuedenCurarUnidadesNoOrganicasException;
import fiuba.algo3.TP2.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.TP2.Excepciones.UnidadNoMovibleException;
import fiuba.algo3.TP2.Tablero.Casillero;

public class Catapulta extends Unidad{

    private ArrayList<Unidad> unidadesAtacadas;

    public Catapulta(){
        vida = 50;
        costo = 5;
        costoADistancia = 20;
        costoCuerpoACuerpo = 0;
        estadoAlianzas = new EstadoAliado();
        simbolo = "CT";
    }

    @Override
    public Unidad copiar() {

        return new Catapulta();
    }

    @Override
    public int getCosto() {
        return costo;
    }

    @Override
    public void moveteA(Casillero zonaInicial, int orientacion) {
            throw new UnidadNoMovibleException();
    }

    @Override
    public void cambiarEstadoAlianzas(){
        estadoAlianzas = estadoAlianzas.cambiarEstadoAlianzas();
    }

    @Override
    public void perderVida(int costo) {
        if (costo < 0) {
            throw (new NoSePuedenCurarUnidadesNoOrganicasException());
        }
        vida -= costo;
    }

    @Override
    public int atacar(ArrayList<Casillero> zonasCercanas, int distancia, Casillero casilleroDefensa){
        this.unidadesAtacadas = new ArrayList<>();

        estadoAlianzas.puedeActuar();
        this.dentroRango(distancia);
        Unidad defensa = casilleroDefensa.getUnidad();
        int costo = casilleroDefensa.calcularCostoAtaque(costoADistancia);
        int costoTotal = defensa.calcularCostoUnidad(costo);

        unidadesAtacadas.add(casilleroDefensa.getUnidad());
        casilleroDefensa.getUnidad().perderVida(costoTotal);

        atacarCasillerosAdyacentes(casilleroDefensa, costoTotal);

        return defensa.getPuntosDeVida();
    }

    public void atacarCasillerosAdyacentes(Casillero casillero, int costo){

        for(Casillero casilleroAdyacente: casillero.getCasillerosConUnidadesAdyacentes()){
            Unidad unidadAtacada = casilleroAdyacente.getUnidad();
            if(!this.unidadesAtacadas.contains(unidadAtacada)){
                this.unidadesAtacadas.add(unidadAtacada);
                unidadAtacada.perderVida(costo);
                atacarCasillerosAdyacentes(casilleroAdyacente, costo);
            }
        }
    }

    @Override
    protected void dentroRango(int distancia) {
        if ( distancia < 6){
            throw new ObjetivoFueraDeRangoException();
        }
    }
    
    @Override 
    public Arma seleccionarArmasJinete(Arma armaAnterior) {
    	return estadoAlianzas.seleccionarArmaOtraUnidad(armaAnterior);
    }
    
    @Override
    public void agregarUnCasilleroAlBatallon(List<Casillero> batallon, Casillero casillero) {}

}