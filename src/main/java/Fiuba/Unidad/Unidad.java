package Fiuba.Unidad;
import Fiuba.Tablero.*;
import Fiuba.AlgoChess.*;
import java.util.*;

public abstract class Unidad {

    protected int vida;
    protected int costo;
    protected int costoCuerpoACuerpo;
    protected int costoADistancia;
    protected EstadoAlianzas estadoAlianzas;
    protected String simbolo;

    public void cambiarEstadoAlianzas(){
        estadoAlianzas = estadoAlianzas.cambiarEstadoAlianzas();
    }

    public int getPuntosDeVida(){
        return vida;
    }

    public int getCosto(){
        return costo;
    }

    public int calcularCostoUnidad(int costo){
        return estadoAlianzas.calcularCostoUnidad(costo);
    }

    public int calcularCostoCuracion(int costo){
        return estadoAlianzas.calcularCostoCuracion(costo);
    }
    
    public String getSimbolo() {
    	return this.simbolo;
    }
    
    public abstract void agregarCasillerosAlBatallon(List<Casillero> batallon, Casillero casillero);
    public abstract Arma seleccionarArmasJinete(Arma armaAnterior);
    public abstract void perderVida(int costoAtaque);
    public abstract int atacar(ArrayList<Casillero> zonasCercanas, int distancia, Casillero unidadDefensa);
    public abstract void moveteA(Casillero zonaInicial, Casillero zonaFinal);
    protected abstract void dentroRango(int distancia);
    public abstract Unidad copiar();
}