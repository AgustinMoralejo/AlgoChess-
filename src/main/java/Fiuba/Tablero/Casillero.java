package Fiuba.Tablero;

import Fiuba.Excepciones.CasilleroEstaOcupadoException;
import Fiuba.Excepciones.NoSePuedeColocarUnidadEnSectorEnemigoException;
import Fiuba.Unidad.*;
import Fiuba.AlgoChess.*;

import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Casillero{

    private Unidad unidad;
    private boolean estaOcupado;
    private Coordenada coordenada;

    private ArrayList<Casillero> casillerosContiguos;


    private String alianza;

    public Casillero(int fila, int columna){
        this.unidad = new UnidadNull();
        this.estaOcupado = false;
        this.coordenada = new Coordenada(fila, columna);
    }

    public void casilleroEstaOcupado(){
        if(this.estaOcupado){
            throw new CasilleroEstaOcupadoException();
        }
    }

    public void ocuparConUnidad(Unidad unaUnidad){

        this.casilleroEstaOcupado();

        if(unaUnidad.getAlianza() != this.alianza) {
            throw new NoSePuedeColocarUnidadEnSectorEnemigoException();
        }

        this.unidad = unaUnidad;
        this.estaOcupado = true;
        unidad.setCoordenada(coordenada);
    }

    public void colocarNuevaUnidad(Unidad unaUnidad){
        this.casilleroEstaOcupado();
        this.unidad = unaUnidad;
        this.estaOcupado = true;
    }

    public void quitarUnidad(){
        unidad = new UnidadNull();
        this.estaOcupado = false;
    }

    public void iniciarZonaPorAlianza(String alianza){
        this.alianza = alianza;
    }

    public String getAlianza(){
        return alianza;
    }

    public Coordenada getCoordenada(){
        return this.coordenada;
    }
    /*
    public int calcularCostoAtaque(int costo){
        return estadoAlianzas.calcularCostoCasillero(costo);
    }

    /*
    public int calcularDistancia(Casillero otroCasillero){
        int otraFila = otroCasillero.getFila();
        int otraColumna = otroCasillero.getColumna();
        int distancia = max(abs(fila - otraFila), abs(columna - otraColumna));
        return distancia;
    }
    */

    public void moverUnidad(Coordenada coordenadaFinal){

    }

    public Unidad getUnidad(){
        return this.unidad;
    }

}