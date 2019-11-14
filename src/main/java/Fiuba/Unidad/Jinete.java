package Fiuba.Unidad;

import Fiuba.Excepciones.*;

import Fiuba.AlgoChess.*;
import Fiuba.Tablero.*;
import java.util.ArrayList;


public class Jinete extends Unidad {

    public Jinete() {
        this.vida = 100;
        this.costo = 3;
        this.costoCuerpoACuerpo = 5;
        this.costoADistancia = 15;
        // estadoAlianzas = new EstadoAliado();
    }

    @Override
    public Unidad copiar() {
        return new Jinete();
    }

    @Override
    public void perderVida(int costoAtaque) {
        // int perdidaTotal = estadoAlianzas.calcularCostoUnidad(costoAtaque);
        // vida -= perdidaTotal;
        this.vida -= costoAtaque;
    }

    @Override
    public void sumarVida(int suma) {
        this.vida += suma;
    }

    @Override
    public void atacar(int distancia, Unidad unidadAAtacar) {

        if(this.alianza == unidadAAtacar.getAlianza()){
            throw new NoSePuedeAtacarAUnaUnidadAliadaException();
        }
        unidadAAtacar.perderVida(this.obtenerDanioEnRango(distancia));
    }


    protected int obtenerDanioEnRango(int distancia){
        if (distancia > 5) {
            throw new ObjetivoFueraDeRangoException();
        }
        else if(distancia < 3){
            return this.costoCuerpoACuerpo;
        }
        else{
            return this.costoADistancia;
        }
    }
/*
    @Override
    public void cambiarEstadoAlianzas(){
        estadoAlianzas = estadoAlianzas.cambiarEstadoAlianzas();
    }
*/
    //@Override
    // public void moveteA(Casillero zonaInicial, Casillero zonaFinal){
        /*
        estadoAlianzas.puedeActuar();
        zonaFinal.recibirUnidad(this, zonaFinal);

         */

/*
    //@Override
    public void atacar(CondicionesAtaqueMovimiento condiciones, int distancia, Casillero unidadDefensa) {
        ArrayList<Casillero> zonasCortaDistancia = condiciones.buscarCasilleros(2);
        Arma arma = new ArmaNull();
        for (int i = 0; i < zonasCortaDistancia.size(); i++) {
            Casillero casillero = zonasCortaDistancia.get(i);
            Unidad unidad = casillero.getUnidad();
            //arma = unidad.seleccionarArmasJinete(arma);

        }
        int costoArma = arma.atacar(distancia, costoCuerpoACuerpo, costoADistancia);
        //int costoZona = unidadDefensa.calcularCostoAtaque(costoArma);
        Unidad defensa = unidadDefensa.getUnidad();
        //int costoTotal = defensa.calcularCostoUnidad(costoZona);
        //defensa.perderVida(costoTotal);

    }
*/
    @Override
    protected void dentroRango(int distancia) {
        if (distancia < 6) {
            throw new ObjetivoFueraDeRangoException();
        }
    }

    //  @Override
    public Arma seleccionarArmasJinete(Arma armaAnterior) {
        //return estadoAlianzas.seleccionarArmaOtraUnidad(armaAnterior);
        return armaAnterior;
    }
}

