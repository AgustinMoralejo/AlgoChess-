package fiuba.algo3.TP2.Unidad;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.TP2.AlgoChess.EstadoAliado;
import fiuba.algo3.TP2.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.TP2.Tablero.Casillero;


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
    public void moveteA(Casillero casilleroInicial, int orientacion){

        estadoAlianzas.puedeActuar();

        ArrayList<Casillero> batallon = new ArrayList<>();

        batallon.add(casilleroInicial);
        casilleroInicial.agregarCasillerosAlBatallon(batallon,1);

        if(batallon.size() > 2){
            estadoBatallon = new SoldadoEnBatallon();
        }
        else{
            estadoBatallon = new SoldadoSolo();
        }

        estadoBatallon.moveteA(casilleroInicial, orientacion, batallon);


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
    public void agregarUnCasilleroAlBatallon(List<Casillero> batallon, Casillero casillero) {

        /*no funciona pq excluye a los mismos soldados del batallon*/
        //if(estadoBatallon.perteneceABatallon()){
            estadoAlianzas.agregarCasilleroAlBatallon(batallon, casillero);
        //}
    }

}