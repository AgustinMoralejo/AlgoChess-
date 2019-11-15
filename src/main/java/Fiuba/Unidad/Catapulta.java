package Fiuba.Unidad;

import Fiuba.Excepciones.*;
import Fiuba.AlgoChess.*;
import Fiuba.Tablero.*;

import java.util.ArrayList;

public class Catapulta extends Unidad{

    public Catapulta(){
        this.vida = 50;
        this.costo = 5;
        this.costoADistancia = 20;
        this.costoCuerpoACuerpo = 0;
        this.simbolo = "CT";
       // estadoAlianzas = new EstadoAliado();
        this.unidadesContiguas = new ArrayList<>();
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
    public void atacar(int distancia, Unidad unidadAAtacar) {

        this.dentroRango(distancia);
        unidadAAtacar.perderVida(this.costoADistancia);
    }
/*
    @Override
    public void moveteA(Casillero zonaInicial, Casillero zonaFinal){
        throw new UnidadNoMovibleException();   
    }

    // @Override
//    public void cambiarEstadoAlianzas(){
  //      estadoAlianzas = estadoAlianzas.cambiarEstadoAlianzas();
    //}
*/

    @Override
    public void sumarVida(int suma) {
        throw new NoSePuedenCurarUnidadesNoOrganicasException();
    }

    /*
        @Override
        public void atacar(CondicionesAtaqueMovimiento condidiones, int distancia, Casillero unidadDefensa){
            this.dentroRango(distancia);
            Unidad defensa = unidadDefensa.getUnidad();
            int costo = unidadDefensa.calcularCostoAtaque(costoADistancia);
            int costo_total = defensa.calcularCostoUnidad(costo);
            defensa.perderVida(costo_total);
        }
    */
    @Override
    protected void dentroRango(int distancia) {
        if ( distancia < 6){
            throw new ObjetivoFueraDeRangoException();
        }
    }
  /*
    @Override 
    public Arma seleccionarArmasJinete(Arma armaAnterior) {
    	return estadoAlianzas.seleccionarArmaOtraUnidad(armaAnterior);
    }
*/
}