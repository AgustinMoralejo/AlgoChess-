package Fiuba.Unidad;

import Fiuba.Excepciones.*;
import Fiuba.AlgoChess.*;
import Fiuba.Tablero.*;

public class Catapulta extends Unidad{

    public Catapulta(){
        vida = 50;
        costo = 5;
        costoADistancia = 20;
        costoCuerpoACuerpo = 0;
       // estadoAlianzas = new EstadoAliado();
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
    public void atacar(int distancia, Unidad unidadDefensa) {

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
    public void perderVida(int costo) {
        if (costo < 0) {
            throw (new NoSePuedenCurarUnidadesNoOrganicasException());
        }
        vida -= costo;
    }

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