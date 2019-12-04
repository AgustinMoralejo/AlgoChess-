package fiuba.algo3.TP2.Modelo.Unidad;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.TP2.Modelo.AlgoChess.EstadoAliado;
import fiuba.algo3.TP2.Modelo.Excepciones.LasUnidadesSoloSePuedenMoverUnCasilleroPorTurnoException;
import fiuba.algo3.TP2.Modelo.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.Armas.Arma;

public class Curandero extends Unidad{

    public Curandero(){
        vida = 75;
        costo = 2;
        danioADistancia = 0;
        danioCuerpoACuerpo = -15;
        estadoAlianzas = new EstadoAliado();
        simbolo = "C";
        atacoEnEsteTurno = false;
    }
    
    @Override
    public Unidad copiar() {
    	return new Curandero();
    }

    @Override
    public void unirABatallon(ArrayList<Casillero> batallon) {

    }


    @Override
    public void perderVida(int costoAtaque){
        vida -= costoAtaque;
    }

    @Override
    public void cambiarEstadoAlianzas(){
        estadoAlianzas = estadoAlianzas.cambiarEstadoAlianzas();
    }

    @Override
    public void moveteA(Casillero zonaInicial, int orientacion) {
        estadoAlianzas.puedeActuar();
        Casillero zonaFinal = zonaInicial.getAdyacente(orientacion);
        zonaFinal.recibirUnidad(this, zonaInicial);
    }

    @Override
    public int atacar(ArrayList<Casillero> zonasCercanas, int distancia, Casillero unidadDefensa){
        estadoAlianzas.puedeActuar();
        this.dentroRango(distancia);
        Unidad defensa = unidadDefensa.getUnidad();
        int costoCuracion = defensa.calcularCostoCuracion(danioCuerpoACuerpo);

        defensa.perderVida(costoCuracion);
        atacoEnEsteTurno = true;
        return defensa.getPuntosDeVida();
    }

    @Override
    protected void dentroRango(int distancia) {
        if(distancia > DISTANCIA_CERCANA){
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


    @Override
    public void seMovioEnEsteTurno() {
        if(seMovioEnEsteTurno){
            throw new LasUnidadesSoloSePuedenMoverUnCasilleroPorTurnoException();
        }
    }

    @Override
    public int getDistanciaAtaque() {
        return DISTANCIA_CERCANA;
    }

}