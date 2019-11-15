package Fiuba.Unidad;

import Fiuba.Excepciones.*;
import Fiuba.AlgoChess.*;
import Fiuba.Tablero.*;

public class Curandero extends Unidad{

    public Curandero(){
        vida = 75;
        costo = 2;
        costoADistancia = 0;
        costoCuerpoACuerpo = 15;
       // estadoAlianzas = new EstadoAliado();
    }

    @Override
    public void atacar(int distancia, Unidad unidadACurar) {
        if(unidadACurar.getAlianza() != this.alianza ){
            throw new NoSePuedeCurarEnemigoException();
        }
        this.dentroRango(distancia);
        unidadACurar.sumarVida(this.costoCuerpoACuerpo);
    }

    @Override
    public Unidad copiar() {
    	return new Curandero();
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

    @Override
    public void moveteA(Casillero zonaInicial, Casillero zonaFinal){
        /*
        estadoAlianzas.puedeActuar();
        zonaFinal.recibirUnidad(this, zonaFinal);

         */
    //}

/*
    @Override
    public void atacar(CondicionesAtaqueMovimiento condidiones, int distancia, Casillero unidadDefensa){
        estadoAlianzas.puedeActuar();
        this.dentroRango(distancia);
        Unidad defensa = unidadDefensa.getUnidad();
        int costoCuracion = defensa.calcularCostoCuracion(costoCuerpoACuerpo);

        defensa.perderVida(costoCuracion);
    }
*/
    @Override
    protected void dentroRango(int distancia) {
        if(distancia > 2){
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