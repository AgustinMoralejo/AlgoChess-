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

    public void atacar(int filaAliada, int columnaAliada, int filaEnemigo, int columnaEnemigo){
        /*
        Casillero zonaAliada = tablero.getCasillero(filaAliada, columnaAliado);
        Casillero zonaEnemiga = tablero.getCasillero(filaEnemigo, columnaEnemigo);
        int distancia = zonaAliada.calcularDistancia(zonaEnemiga);
        Unidad unidadAliada = zonaAliada.getUnidad();
        Casillero [][] tabla = tablero.getTablero();
        CondicionesAtaqueMovimiento condiciones = new CondicionesAtaqueMovimiento(filaAliada, columnaAliado, tabla);
        unidadAliada.atacar(condiciones, distancia, zonaEnemiga);

         */
        this.tablero.unidadAliadaAtacaAUnidadEnemiga(filaAliada,columnaAliada, filaEnemigo, columnaEnemigo);
    }

    public void pagar(int costo){

        if( costo > puntos){
            throw new PuntosInsuficientesException();
        }
        puntos -= costo;
    }
}
