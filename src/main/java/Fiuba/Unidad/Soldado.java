package Fiuba.Unidad;

import Fiuba.Excepciones.*;

import java.util.ArrayList;
import java.util.List;

import Fiuba.AlgoChess.*;
import Fiuba.Tablero.*;


public class Soldado extends Unidad{

    EstadoBatallon estadoBatallon;

    public Soldado(){
        vida = 100;
        costo = 1;
        costoCuerpoACuerpo = 10;
        costoADistancia = 0;
        estadoAlianzas = new EstadoAliado();
        estadoBatallon = new SoldadoSolo();
        simbolo = "S";
    }
    
    @Override
    public Unidad copiar() {
    	return new Soldado();
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
    public void moveteA(Casillero zonaInicial, int orientacion){
        estadoAlianzas.puedeActuar();

        ArrayList<Casillero> batallon = new ArrayList<>();

        batallon.add(zonaInicial);
        zonaInicial.agregarCasillerosAlBatallon(batallon,1);

        if(batallon.size() > 2){
            estadoBatallon = new SoldadoEnBatallon();
        }

        estadoBatallon.moveteA(zonaInicial, orientacion, batallon);

        /*Puede pasar que si alguno no se logra mover el batallon se disuelva en cada movimiento se tiene que
         * ver que siga siendo un batallon*/
        estadoBatallon = new SoldadoSolo();
    }

    @Override
    public int atacar(ArrayList<Casillero> zonasCercanas, int distancia, Casillero unidadDefensa){
        estadoAlianzas.puedeActuar();
        this.dentroRango(distancia);
        Unidad defensa = unidadDefensa.getUnidad();
        int costo = unidadDefensa.calcularCostoAtaque(costoCuerpoACuerpo);
        int costo_total = defensa.calcularCostoUnidad(costo);
        defensa.perderVida(costo_total);
        return defensa.getPuntosDeVida();
    }

    @Override
    protected void dentroRango(int distancia) {
        if(distancia > 2){
            throw new ObjetivoFueraDeRangoException();
        }
    }
    
    @Override
    public Arma seleccionarArmasJinete(Arma armaAnterior) {
    	return estadoAlianzas.seleccionarArmaSoldado(armaAnterior);
    }
    
    @Override
    public void agregarCasillerosAlBatallon(List<Casillero> batallon, Casillero casillero) {
    	
    	estadoAlianzas.agregarCasilleroAlBatallon(batallon, casillero);
    }

}