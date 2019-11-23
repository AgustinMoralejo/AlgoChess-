package fiuba.algo3.TP2.Unidad;
import fiuba.algo3.TP2.AlgoChess.EstadoAlianzas;
import fiuba.algo3.TP2.Tablero.Casillero;
import fiuba.algo3.TP2.Unidad.Armas.Arma;

import java.util.*;

public abstract class Unidad {

    protected int vida;
    protected int costo;
    protected int danioCuerpoACuerpo;
    protected int danioADistancia;
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
    
    public abstract void agregarUnCasilleroAlBatallon(List<Casillero> batallon, Casillero casillero);
    public abstract Arma seleccionarArmasJinete(Arma armaAnterior);
    public abstract void perderVida(int costoAtaque);
    public abstract int atacar(ArrayList<Casillero> zonasCercanas, int distancia, Casillero unidadDefensa);
    public abstract void moveteA(Casillero zonaInicial, int orientacion);
    protected abstract void dentroRango(int distancia);
    public abstract Unidad copiar();

    public abstract void unirABatallon(ArrayList<Casillero> batallon);


    }