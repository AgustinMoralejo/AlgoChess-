package Fiuba.Unidad;

import Fiuba.Excepciones.*;
import Fiuba.AlgoChess.*;
import Fiuba.Tablero.*;


public class Soldado extends Unidad {

    boolean estaEnUnBatallon;

    public Soldado() {
        this.vida = 100;
        this.costo = 1;
        this.costoCuerpoACuerpo = 10;
        this.costoADistancia = 0;
        this.simbolo = "S";
        this.estaEnUnBatallon = false;
        //estadoAlianzas = new EstadoAliado();
    }

    @Override
    public Unidad copiar() {
        return new Soldado();
    }

    @Override
    public void sumarVida(int suma) {
        this.vida += suma;
    }


    /*
        @Override
        public void cambiarEstadoAlianzas(){
            estadoAlianzas = estadoAlianzas.cambiarEstadoAlianzas();
        }


         *//*
    @Override
    public void moveteA(Casillero zonaInicial, Casillero zonaFinal) {
        /*
        estadoAlianzas.puedeActuar();
        zonaFinal.recibirUnidad(this, zonaFinal);

         */

    @Override
    public void atacar(int distancia, Unidad unidadAAtacar) {

        // estadoAlianzas.puedeActuar();
        //int costo = unidadDefensa.calcularCostoAtaque(costoCuerpoACuerpo);
        //int costo_total = defensa.calcularCostoUnidad(costo);

        if(this.alianza == unidadAAtacar.getAlianza()){
            throw new NoSePuedeAtacarAUnaUnidadAliadaException();
        }
        this.dentroRango(distancia);
        unidadAAtacar.perderVida(this.costoCuerpoACuerpo);
    }


    @Override
    protected void dentroRango(int distancia) {
        if (distancia > 2) {
            throw new ObjetivoFueraDeRangoException();
        }
    }
}
/*
    @Override
    public Arma seleccionarArmasJinete(Arma armaAnterior) {
        //return estadoAlianzas.seleccionarArmaSoldado(armaAnterior);
        return armaAnterior;
    }
*/
