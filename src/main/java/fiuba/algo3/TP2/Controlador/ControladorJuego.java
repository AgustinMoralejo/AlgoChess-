package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Modelo.Unidad.Soldado;
import fiuba.algo3.TP2.Vista.VistaTablero;

public class ControladorJuego {

    private AlgoChess juego;
    private Tablero tablero;
    private VistaTablero vistaTablero;

    public void setJuego(AlgoChess juego) {

        this.juego = juego;
        this.tablero = juego.getTablero();

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
}