package fiuba.algo3.TP2.Modelo.AlgoChess;

import fiuba.algo3.TP2.Modelo.Excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.TP2.Modelo.Excepciones.NoSePuedeColocarUnidadEnSectorEnemigoException;
import fiuba.algo3.TP2.Modelo.Excepciones.PuntosInsuficientesException;

import fiuba.algo3.TP2.Modelo.Subject;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Modelo.Unidad.Cuartel;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;
import fiuba.algo3.TP2.Modelo.Unidad.UnidadNull;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Subject {

    protected String nombre;
    protected int puntos;

    private boolean modoOfensivo = false;

    protected List<Unidad> unidades;

    /*El cuartal deberia ser una sola instancia para todos los jugadores, aca estoy duplicando por cada jugador? */
    protected Cuartel cuartel = new Cuartel();
    protected Tablero tablero;
    private EstadoAccion estadoAccion;

    public Jugador(String unNombre) {

        nombre = unNombre;
        puntos = 20;
        unidades =  new ArrayList<>();
        this.estadoAccion = new EstadoPasivo();
    }

    public Jugador(String unNombre, Tablero tableroDelJuego) {

        nombre = unNombre;
        puntos = 20;
        unidades =  new ArrayList<>();
        tablero = tableroDelJuego;
        this.estadoAccion = new EstadoPasivo();

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
        this.pagar(unidadComprada.getCosto());
        this.resetMovimientoUnidades();
    }

    public void comprarUnidad(String nombreUnidad, int fila, int columna){
        Unidad unidadComprada = cuartel.getUnidad(nombreUnidad, this);
        tablero.colocarUnidad(unidadComprada, fila, columna);
        unidades.add(unidadComprada);
        this.pagar(unidadComprada.getCosto());
        this.resetMovimientoUnidades();
    }

    //vista
    public Unidad comprarUnidad(String nombreUnidad, int fila, int columna, int overload){

        Unidad unidadComprada = cuartel.getUnidad(nombreUnidad, this);
        tablero.colocarUnidad(unidadComprada, fila, columna);
        unidades.add(unidadComprada);
        this.pagar(unidadComprada.getCosto());
        notificarObservers();
        this.resetMovimientoUnidades();
        return unidadComprada;

    }

    private void sumarPuntos(int valor) {
        puntos += valor;
    }


    public void atacar(int filaAliada, int columnaAliado, int filaEnemigo, int columnaEnemigo){
        Casillero zonaAliada = tablero.getCasillero(filaAliada, columnaAliado);
        Casillero zonaEnemiga = tablero.getCasillero(filaEnemigo, columnaEnemigo);
        int distancia = zonaAliada.calcularDistancia(zonaEnemiga);
        Unidad unidadAliada = zonaAliada.getUnidad();
        unidadAliada.atacoEnEsteTurno();
        ArrayList<Casillero> zonasCercanas = tablero.buscarCasilleros(3, filaAliada, columnaAliado);
        int vida = unidadAliada.atacar(zonasCercanas, distancia, zonaEnemiga);
        tablero.matarUnidades();

    }

    public void moverUnidad(int fila, int columna, int orientacion){
        tablero.moverUnidad(fila, columna, orientacion);
    }

    public void moverUnidad(int[] posUnidad, int[] destino){

        int orientacion = this.darOrientacion(posUnidad, destino);
        tablero.moverUnidad(posUnidad[0], posUnidad[1], orientacion);

    }

    public void puedePagar(int costo) {
        if( costo > puntos){
            throw new PuntosInsuficientesException();
        }
    }

    public void pagar(int costo){
        puntos -= costo;
    }

    public int unidadesRestantesVivas(){
        int unidadesConVida = 0;
        for(int i = 0; i<unidades.size(); i++){
            if(unidades.get(i).getPuntosDeVida()>0){
                unidadesConVida++;
            }
        }
        return unidadesConVida;
    }

    public boolean perdio(){
        return ((unidadesRestantesVivas()<=0));
    }

    //para los handlers
    public void cambiarAModoPasivo() {
        estadoAccion = new EstadoPasivo();
    }

    public void cambiarAModoOfensivo() {
        estadoAccion = new EstadoOfensivo();
    }

    private int darOrientacion(int[] posUnidad, int[] destino) {
        return tablero.darOrientacion(posUnidad, destino);
    }

    public void realizarAccion(int[] posUnidad, int[] destino) {
        estadoAccion.realizarAccion(posUnidad, destino, this);
    }

    public void resetMovimientoUnidades() {
        for(Unidad unidad : unidades){
            unidad.seMovioEnEsteTurno(false);
            unidad.atacoEnEsteTurno(false);
        }
    }

    public Unidad getUnidadPosicion(int[] posUnidad){
        return (tablero.getCasillero(posUnidad[0], posUnidad[1]).getUnidad());

    }

}
