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

    public boolean casilleroEstaOcupado(){
        return this.estaOcupado;
    }

    public void ocuparConUnidad(Unidad unaUnidad){

        if(casilleroEstaOcupado()){
            throw new CasilleroEstaOcupadoException();
        }

        if(unaUnidad.getAlianza() != this.alianza) {
            throw new NoSePuedeColocarUnidadEnSectorEnemigoException();
        }

        this.unidad = unaUnidad;
        this.estaOcupado = true;
        unidad.setCoordenada(coordenada);
    }

    public void colocarNuevaUnidad(Unidad unaUnidad){
        if(this.casilleroEstaOcupado()){
            throw new CasilleroEstaOcupadoException();
        }
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

     */

    public int calcularDistancia(Casillero otroCasillero){
        Coordenada coordenadaOtroCasillero = otroCasillero.getCoordenada();
        int distancia = this.coordenada.calcularDistanciaEntreCoordenadas(coordenadaOtroCasillero);
        return distancia;
    }

    public void moverUnidad(Coordenada coordenadaFinal){

    }

    public Unidad getUnidad(){
        return this.unidad;
    }

}