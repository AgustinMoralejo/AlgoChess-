package fiuba.algo3.TP2.Unidad;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.TP2.AlgoChess.EstadoAliado;
import fiuba.algo3.TP2.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.TP2.Tablero.Casillero;
import fiuba.algo3.TP2.Unidad.Armas.Arma;

public class Curandero extends Unidad{

    public Curandero(){
        vida = 75;
        costo = 2;
        danioADistancia = 0;
        danioCuerpoACuerpo = -15;
        estadoAlianzas = new EstadoAliado();
        simbolo = "C";
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
        return defensa.getPuntosDeVida();
    }

    @Override
    protected void dentroRango(int distancia) {
        if(distancia > 2){
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