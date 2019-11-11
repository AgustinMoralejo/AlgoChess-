package Fiuba.Unidad;

import Fiuba.Excepciones.*;
import Fiuba.AlgoChess.*;
import Fiuba.Tablero.*;


public class Soldado extends Unidad {

    public Soldado() {
        vida = 100;
        costo = 1;
        costoCuerpoACuerpo = 10;
        costoADistancia = 0;
        //estadoAlianzas = new EstadoAliado();
    }

    @Override
    public Unidad copiar() {
        return new Soldado();
    }

    //@Override
    public void perderVida(int costoAtaque) {
        vida -= costoAtaque;
    }
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

         *//*
    }
        @Override
        public void atacar(CondicionesAtaqueMovimiento condidiones, int distancia, Casillero unidadDefensa){
           /* estadoAlianzas.puedeActuar();
            this.dentroRango(distancia);
            Unidad defensa = unidadDefensa.getUnidad();
            int costo = unidadDefensa.calcularCostoAtaque(costoCuerpoACuerpo);
            int costo_total = defensa.calcularCostoUnidad(costo);
            defensa.perderVida(costo_total);

            */
        /*

    @Override
    protected void dentroRango(int distancia) {
        if (distancia > 2) {
            throw new ObjetivoFueraDeRangoException();
        }
    }

    @Override
    public Arma seleccionarArmasJinete(Arma armaAnterior) {
    	//return estadoAlianzas.seleccionarArmaSoldado(armaAnterior);
        return armaAnterior;
    }
*/
