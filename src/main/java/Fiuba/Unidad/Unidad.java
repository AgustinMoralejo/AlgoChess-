package Fiuba.Unidad;
import Fiuba.Excepciones.UnidadEstaMuertaException;
import Fiuba.Tablero.*;
import Fiuba.AlgoChess.*;

import java.util.ArrayList;

public abstract class Unidad {

    protected int vida;
    protected int costo;
    protected int costoCuerpoACuerpo;
    protected int costoADistancia;
    protected String alianza;

    protected Coordenada coordenada;

    protected ArrayList<Unidad> unidadesContiguas;

    protected String simbolo;

    public Unidad(){
        unidadesContiguas = new ArrayList<>();
    }

    public String getSimbolo(){ return this.simbolo; }

    public void setCoordenada(Coordenada coordenada){
        this.coordenada = coordenada;
    }

    public void setAlianza(String alianza){
        this.alianza = alianza;
    }

    public String getAlianza(){
        return this.alianza;
    }

    public Coordenada getCoordenada(){
        return this.coordenada;
    }
/*
    public void cambiarEstadoAlianzas(){
        estadoAlianzas = estadoAlianzas.cambiarEstadoAlianzas();
    }


 */
    public int getPuntosDeVida(){
        return vida;
    }

    public int getCosto(){
        return costo;
    }

    public void perderVida(int costoAtaque){

        if(this.vida < 0){
            throw new UnidadEstaMuertaException();
        }
        this.vida -= costoAtaque;
    }

    public abstract void sumarVida(int suma);

    public abstract void atacar(int distancia, Unidad unidadDefensa);

/*
    public int calcularCostoUnidad(int costo){
        return estadoAlianzas.calcularCostoUnidad(costo);
    }


    public int calcularCostoCuracion(int costo){
        return estadoAlianzas.calcularCostoCuracion(costo);
    }

*/
 /*
    public abstract Arma seleccionarArmasJinete(Arma armaAnterior);
    public abstract void moveteA(Casillero zonaInicial, Casillero zonaFinal);
    */

    protected abstract void dentroRango(int distancia);
    public abstract Unidad copiar();


    public void agregarUnidadesContiguas(Unidad unidadContigua){
        unidadesContiguas.add(unidadContigua);
    }

    public ArrayList<Unidad> getUnidadesContiguas(){
        return unidadesContiguas;
    }
}