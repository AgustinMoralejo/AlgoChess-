package fiuba.algo3.TP2.Modelo.Unidad;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.TP2.Modelo.AlgoChess.EstadoAliado;
import fiuba.algo3.TP2.Modelo.Excepciones.NoSePuedenCurarUnidadesNoOrganicasException;
import fiuba.algo3.TP2.Modelo.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.TP2.Modelo.Excepciones.UnidadNoMovibleException;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.Armas.Arma;

public class Catapulta extends Unidad{

    public Catapulta(){
        vida = 50;
        costo = 5;
        danioADistancia = 20;
        danioCuerpoACuerpo = 0;
        estadoAlianzas = new EstadoAliado();
        simbolo = "CT";
        atacoEnEsteTurno = false;
    }

    @Override
    public Unidad copiar() {

        return new Catapulta();
    }


    @Override
    public void unirABatallon(ArrayList<Casillero> batallon) {

    }

    @Override
    public void seMovioEnEsteTurno() {

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
        int costo = casilleroDefensa.calcularCostoAtaque(danioADistancia);
        int costoTotal = defensa.calcularCostoUnidad(costo);

        ArrayList<Unidad> unidadesAtacadas = new ArrayList<Unidad>();
        unidadesAtacadas.add(casilleroDefensa.getUnidad());
        unidadesAtacadas = buscarUnidadesAdyacentes(unidadesAtacadas, casilleroDefensa);

        atacarUnidadesCorrespondientes(costoTotal, unidadesAtacadas);
        atacoEnEsteTurno = true;
        return defensa.getPuntosDeVida();
    }

    public ArrayList<Unidad> buscarUnidadesAdyacentes(ArrayList<Unidad> unidadesAtacadas, Casillero casillero){

        for(Casillero casilleroAdyacente: casillero.getCasillerosConUnidadesAdyacentes()){
            Unidad unidadAtacada = casilleroAdyacente.getUnidad();
            if(!unidadesAtacadas.contains(unidadAtacada)){
                unidadesAtacadas.add(unidadAtacada);
                buscarUnidadesAdyacentes(unidadesAtacadas, casilleroAdyacente);
            }
        }
        return unidadesAtacadas;
    }

    public void atacarUnidadesCorrespondientes(int costo, ArrayList<Unidad> unidadesAtacadas){
        for(Unidad unidad: unidadesAtacadas){
            unidad.perderVida(costo);
        }
    }

    @Override
    protected void dentroRango(int distancia) {
        if ( distancia < 6){
            throw new ObjetivoFueraDeRangoException();
        }
    }
    
    @Override 
    public
    Arma seleccionarArmasJinete(Arma armaAnterior) {
    	return estadoAlianzas.seleccionarArmaOtraUnidad(armaAnterior);
    }
    
    @Override
    public void agregarUnCasilleroAlBatallon(List<Casillero> batallon, Casillero casillero) {}

}