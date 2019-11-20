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
        this.unidadesAtacadas = new ArrayList<>();
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
    	estadoAlianzas.puedeActuar();
        this.dentroRango(distancia);
        Unidad defensa = casilleroDefensa.getUnidad();
        int costo = casilleroDefensa.calcularCostoAtaque(costoADistancia);
        int costoTotal = defensa.calcularCostoUnidad(costo);

        atacarCasillerosAdyacentes(casilleroDefensa, costoTotal);
        return defensa.getPuntosDeVida();
    }

    public void atacarCasillerosAdyacentes(Casillero casillero, int costo){
        for(Casillero casilleroAdyacente: casillero.getAdyacentes()){
            atacarAUnidadesAdyacentes(casilleroAdyacente.getUnidadesAdyacentes(), costo);
        }
    }

    public void atacarAUnidadesAdyacentes(ArrayList<Unidad> unidadesAdyacentes, int costo){

        for(Unidad unidadAAtacar: unidadesAdyacentes) {
            if(!unidadesAtacadas.contains(unidadAAtacar))
            unidadAAtacar.perderVida(costo);
            unidadesAtacadas.add(unidadAAtacar);
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