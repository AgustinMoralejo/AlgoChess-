package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Modelo.Unidad.Soldado;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;
import fiuba.algo3.TP2.Vista.VistaTablero;

public class ControladorJuego {

    private AlgoChess juego;
    private Tablero tablero;
    private VistaTablero vistaTablero;
    private boolean estaColocandoUnaUnidad;
    private String nombreUnidadAColocar;

    public void setJuego(AlgoChess juego) {

        this.juego = juego;
        this.tablero = juego.getTablero();
        estaColocandoUnaUnidad = false;
        nombreUnidadAColocar = "";
    }

    public void asignarVistasACasilleros(VistaTablero vistaTablero) {
        //ACA DEBERIA ESTAR LO QUE HACE EL BUTTON HANDLER, PERO NO SE COMO MANEJAR EL VBOX PARA LA ESCENA
        this.vistaTablero = vistaTablero;
    }

    //SOLO PARA PRUEBAS
    public void setInicioParaPruebas() {

        Soldado soldadoAzul = new Soldado();
        Soldado soldadoRojo = new Soldado();

        vistaTablero.agregarVistaUnidad(soldadoAzul, true);

        tablero.colocarUnidad(soldadoAzul,7,7);

        juego.terminarTurnoYVerSiHayGanador();

        vistaTablero.agregarVistaUnidad(soldadoRojo, false);

        tablero.colocarUnidad(soldadoRojo,11,7);

    }

    public Tablero getTablero() {
        return tablero;
    }

    public void realizarAccion(int[] primerClick, int[] segundoClick) {

        Jugador jugadorActual = getJugadorActual();
        jugadorActual.realizarAccion(primerClick, segundoClick);

    }

    private Jugador getJugadorActual() {
        return juego.getJugadorActual();
    }

    public void cambiarAModoOfensivo() {

        Jugador jugadorActual = getJugadorActual();
        jugadorActual.cambiarAModoOfensivo();

    }

    public void cambiarAModoPasivo() {

        Jugador jugadorActual = getJugadorActual();
        jugadorActual.cambiarAModoPasivo();

    }

    public void terminarTurno() {

        juego.terminarTurnoYVerSiHayGanador();

    }

    public void modoColocarUnidad(String nombreUnidadAColocar) {
        this.estaColocandoUnaUnidad = true;
        this.nombreUnidadAColocar = nombreUnidadAColocar;
    }

    public void modoDefault() {
        this.estaColocandoUnaUnidad = false;
    }


    public boolean estaColocandoUnaUnidad() {
        return estaColocandoUnaUnidad;
    }

    public void comprarUnidad(int fila, int columna) {
        Jugador jugadorActual = getJugadorActual();
        Unidad unidad = jugadorActual.comprarUnidad(nombreUnidadAColocar,fila,columna,1);

        //si es 0 significa que es el jugador azul
        vistaTablero.agregarVistaUnidad(unidad, juego.getIndiceJugadorActual() == 0);

        estaColocandoUnaUnidad = false;
        nombreUnidadAColocar = "";
    }

    public VistaTablero getVistaTablero(){
        return this.vistaTablero;
    }
}
