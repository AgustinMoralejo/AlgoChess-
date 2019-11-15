package Fiuba.AlgoChess;

import Fiuba.Alianza;
import Fiuba.Excepciones.CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException;
import Fiuba.Excepciones.NoHayUnidadEnCasilleroException;
import Fiuba.Excepciones.PuntosInsuficientesException;

import Fiuba.Tablero.*;
import Fiuba.Unidad.Cuartel;
import Fiuba.Unidad.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jugador {

    protected String nombre;
    protected int puntos;
    protected String alianza;

    /*Asi el jugador puede ver el estado de sus unidades sin tener que buscarlas,
    al colocar una unidad coloca en el casillero el puntero a la unidad presente en esta lista*/
    protected List<Unidad> unidades;

    /*El cuartal deberia ser una sola instancia para todos los jugadores, aca estoy duplicando por cada jugador? */
    protected Cuartel cuartel = new Cuartel();
    protected Tablero tablero;
    //protected int[][] movimientosPosible = Movimiento.OFFSET_COORDENADAS_MOVIMIENTO;

    public Jugador(String unNombre) {

        nombre = unNombre;
        puntos = 20;
        unidades =  new ArrayList<>();
    }

    public Jugador(String unNombre, Tablero tableroDelJuego, String unaAlianza) {

        this.nombre = unNombre;
        this.puntos = 20;
        this.unidades =  new ArrayList<>();
        this.tablero = tableroDelJuego;
        this.alianza = unaAlianza;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public String getAlianza(){
        return this.alianza;
    }

    public void comprarUnidad(String nombreUnidad){

        Unidad unidadComprada;
        unidadComprada = cuartel.getUnidad(nombreUnidad, this);
        unidades.add(unidadComprada);

    }

    public void comprarUnidad(String nombreUnidad, int fila, int columna){
        Unidad unidadComprada = cuartel.getUnidad(nombreUnidad, this);
        tablero.colocarUnidad(unidadComprada, fila, columna);
        unidades.add(unidadComprada);
    }

    public void seleccionarUnidad(int fila, int columna) {

        Iterator<Unidad> iterador = unidades.iterator();
        boolean encontro=false;
        Unidad unidadAliadaActual;

        /*busco una unidad en la lista del jugador cuya posicion sea la misma que las del parametro*/

        while(iterador.hasNext() && !encontro){
            unidadAliadaActual = iterador.next();
            encontro = (unidadAliadaActual.getCoordenada().getFila() == fila && unidadAliadaActual.getCoordenada().getColumna() == columna);
        }

        if(!encontro){
            throw new CasilleroSeleccionadoNoPoseeNingunaUnidadAliadaException();
        }

    }

    public void moverUnidad(int fila, int columna, int orientacion) {
        int[] offset = Movimiento.OFFSET_COORDENADAS_MOVIMIENTO[orientacion]; // 0 es norte {-1,0}

        seleccionarUnidad(fila, columna);
        tablero.moverUnidad(fila,columna,offset);

    }

    public void atacar(int filaAliada, int columnaAliada, int filaEnemigo, int columnaEnemigo){

        Casillero casilleroAliado = this.tablero.getCasillero(filaAliada,columnaAliada);
        Casillero casilleroEnemigo = this.tablero.getCasillero(filaEnemigo, columnaEnemigo);

        if(!casilleroEnemigo.casilleroEstaOcupado()){
            throw new NoHayUnidadEnCasilleroException();
        }

        int distancia = casilleroAliado.calcularDistancia(casilleroEnemigo);
        Unidad unidadAliada = casilleroAliado.getUnidad();
        Unidad unidadEnemiga = casilleroEnemigo.getUnidad();

        if(unidadAliada.getSimbolo() == "CT"){
            this.tablero.obtenerUnidadesContiguas(filaEnemigo, columnaEnemigo);
        }

        unidadAliada.atacar(distancia, unidadEnemiga);
    }

    public void pagar(int costo){

        if( costo > puntos){
            throw new PuntosInsuficientesException();
        }
        puntos -= costo;
    }
}
