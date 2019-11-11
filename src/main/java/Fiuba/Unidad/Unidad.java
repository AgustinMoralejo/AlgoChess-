package Fiuba.Unidad;
import Fiuba.Tablero.*;
import Fiuba.AlgoChess.*;

public abstract class Unidad {

    protected int vida;
    protected int costo;
    protected int costoCuerpoACuerpo;
    protected int costoADistancia;
    protected String alianza;

    protected Coordenada coordenada;


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
/*
    public abstract void perderVida(int costoAtaque);
    public abstract void atacar(CondicionesAtaqueMovimiento condiciones, int distancia, Casillero unidadDefensa);

    /*
    public int calcularCostoUnidad(int costo){
        return estadoAlianzas.calcularCostoUnidad(costo);
    }


    public int calcularCostoCuracion(int costo){
        return estadoAlianzas.calcularCostoCuracion(costo);
    }


 *//*
    public abstract Arma seleccionarArmasJinete(Arma armaAnterior);
    public abstract void moveteA(Casillero zonaInicial, Casillero zonaFinal);
    protected abstract void dentroRango(int distancia);
    */
    public abstract Unidad copiar();
}