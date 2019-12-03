package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Modelo.Unidad.Soldado;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;
import fiuba.algo3.TP2.Vista.BarraDeEstadoJuego;
import fiuba.algo3.TP2.Vista.MensajesDelJuego;
import fiuba.algo3.TP2.Vista.VistaTablero;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class ControladorJuego {

    private AlgoChess juego;
    private Tablero tablero;
    private VistaTablero vistaTablero;
    private boolean estaColocandoUnaUnidad;
    private String nombreUnidadAColocar;
    private MediaPlayer musicaDeFondo;
    private Reproductor reproductor;
    private MensajesDelJuego mensajesDelJuego;
    boolean modoOfensivo;

    public void setJuego(AlgoChess juego) {

        this.juego = juego;
        this.tablero = juego.getTablero();
        estaColocandoUnaUnidad = false;
        nombreUnidadAColocar = "";
        modoOfensivo = false;
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
        mensajesDelJuego.setMensaje("Jugador N°: " + juego.getIndiceJugadorActual() + " ha realizado accion");

        if(jugadorActual.getUnidadPosicion(primerClick).getSimbolo()=="CT" && modoOfensivo){
            reproductor.reproducirSonido("media/accion/ataqueCatapulta.wav");
        }
        else if(modoOfensivo){
            reproductor.reproducirSonido("media/accion/ataque.wav");
        }
    }

    private Jugador getJugadorActual() {
        return juego.getJugadorActual();
    }

    public void cambiarAModoOfensivo() {

        Jugador jugadorActual = getJugadorActual();
        jugadorActual.cambiarAModoOfensivo();
        musicaDeFondo.stop();
        musicaDeFondo = reproductor.reproducirSonido("media/ambiente/ambienteCombate.wav");
        modoOfensivo = true;
    }

    public void cambiarAModoPasivo() {

        Jugador jugadorActual = getJugadorActual();
        jugadorActual.cambiarAModoPasivo();
        musicaDeFondo.stop();
        musicaDeFondo = reproductor.reproducirSonido("media/ambiente/1.05MachinadelDiablo.wav");
        modoOfensivo = false;

    }

    public void terminarTurno() {

        juego.terminarTurnoYVerSiHayGanador();
        musicaDeFondo.stop();
        musicaDeFondo = reproductor.reproducirSonido("media/ambiente/1.05MachinadelDiablo.wav");
        modoOfensivo = false;

    }

    public void modoColocarUnidad(String nombreUnidadAColocar) {
        this.estaColocandoUnaUnidad = true;
        this.nombreUnidadAColocar = nombreUnidadAColocar;
    }

    public void modoDefault() {
        this.estaColocandoUnaUnidad = false;
        this.nombreUnidadAColocar = "";
        vistaTablero.desResaltarCasilleros();
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
        reproductor.reproducirSonido("media/accion/crearSoldado.wav");

    }

    public void setVistaUnidadesOpaco() {
        vistaTablero.setVistaUnidadesOpaco();
    }

    public void setVistaUnidadesTransparente() {
        vistaTablero.setVistaUnidadesTransparente();
    }

    public VistaTablero getVistaTablero(){
        return this.vistaTablero;
    }

    public void setMusica(MediaPlayer musicaDeFondo) {

        this.musicaDeFondo = musicaDeFondo;
        this.reproductor = new Reproductor();
    }

    public void reproducirSonido(String path) {
        musicaDeFondo = this.reproductor.reproducirSonido(path);
    }

    public void setVentanaDeMensajes(MensajesDelJuego mensajesDelJuego) {
        this.mensajesDelJuego = mensajesDelJuego;
    }

    public void setMensaje(String mensaje) {
        mensajesDelJuego.setMensaje(mensaje);
    }

    public AlgoChess getJuego(){
        return this.juego;
    }
}

