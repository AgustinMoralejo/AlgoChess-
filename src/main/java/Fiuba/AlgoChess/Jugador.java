package Fiuba.AlgoChess;

import Fiuba.Excepciones.PuntosInsuficientesException;

import Fiuba.Tablero.*;
import Fiuba.Unidad.Cuartel;
import Fiuba.Unidad.*;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    protected String nombre;
    protected int puntos;

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

    public Jugador(String unNombre, Tablero tableroDelJuego) {

        nombre = unNombre;
        puntos = 20;
        unidades =  new ArrayList<>();
        tablero = tableroDelJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
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

    public void atacar(int filaAliada, int columnaAliado, int filaEnemigo, int columnaEnemigo){
        Casillero zonaAliada = tablero.getCasillero(filaAliada, columnaAliado);
        Casillero zonaEnemiga = tablero.getCasillero(filaEnemigo, columnaEnemigo);
        int distancia = zonaAliada.calcularDistancia(zonaEnemiga);
        Unidad unidadAliada = zonaAliada.getUnidad();
        ArrayList<Casillero> zonasCercanas = tablero.buscarCasilleros(3, filaAliada, columnaAliado);
        int vida = unidadAliada.atacar(zonasCercanas, distancia, zonaEnemiga);
        if (vida <= 0) {
        	zonaEnemiga.quitarUnidad();
        }
        
    }

    public void moverUnidad(int fila, int columna, int orientacion){
        Casillero zonaInicial = tablero.getCasillero(fila, columna);
        zonaInicial.moverUnidad(orientacion);
    }

    public void pagar(int costo){

        if( costo > puntos){
            throw new PuntosInsuficientesException();
        }
        puntos -= costo;
    }
}
