package Fiuba.Unidad;

import Fiuba.AlgoChess.*;

import Fiuba.Excepciones.*;
import Fiuba.Tablero.*;

public class UnidadNull extends Unidad{

    @Override
    public void perderVida(int costoAtaque) {

    }

    @Override
    public void sumarVida(int suma) {

    }

    @Override
    public void atacar(int distancia, Unidad unidadDefensa) {

    }

    @Override
    protected void dentroRango(int distancia) {

    }

    /*

        @Override
        public void cambiarEstadoAlianzas(){
        }
        */
    public Unidad copiar() {
    	return new UnidadNull();
    }
/*
    @Override
    public void atacar(CondicionesAtaqueMovimiento condidiones, int distancia, Casillero unidadDefensa){
        throw new NoHayUnidadEnCasilleroException();
    }

    @Override
    public void moveteA(Casillero zonaInicial, Casillero zonaFinal){
        throw new NoHayUnidadEnCasilleroException();
    }
    
    @Override
    public Arma seleccionarArmasJinete(Arma armaAnterior) {
    	return estadoAlianzas.seleccionarArmaNull(armaAnterior);
    }
    */

}