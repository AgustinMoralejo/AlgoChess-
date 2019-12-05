package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Modelo.Unidad.Soldado;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;
import fiuba.algo3.TP2.Vista.BarraDeEstadoJuego;
import fiuba.algo3.TP2.Vista.MensajesDelJuego;
import fiuba.algo3.TP2.Vista.SoundButton;
import fiuba.algo3.TP2.Vista.VistaTablero;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;
import java.util.ArrayList;

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
        this.vistaTablero = vistaTablero;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void realizarAccion(int[] primerClick, int[] segundoClick) {

        Jugador jugadorActual = getJugadorActual();
        jugadorActual.realizarAccion(primerClick, segundoClick);

        if(jugadorActual.getUnidadPosicion(primerClick).getSimbolo().equals("CT") && modoOfensivo){
            reproductor.reproducirSonido("media/accion/ataqueCatapulta.wav");
            mensajesDelJuego.setMensaje("Jugador N°: " + juego.getIndiceJugadorActual() + " ha atacado", false);
        }
        else if(modoOfensivo){
            reproductor.reproducirSonido("media/accion/ataque.wav");
            mensajesDelJuego.setMensaje("Jugador N°: " + juego.getIndiceJugadorActual() + " ha atacado", false);

        }
        if(juego.hayGanador()){
            reproductor.pausarSonido(musicaDeFondo);
            reproductor.reproducirSonido("media/ambiente/victory.wav");
        }


    }

    private Jugador getJugadorActual() {
        return juego.getJugadorActual();
    }

    public void cambiarAModoOfensivo() {

        Jugador jugadorActual = getJugadorActual();
        jugadorActual.cambiarAModoOfensivo();
        mensajesDelJuego.setMensaje("¡ Modo Ofensivo !", false);

        reproductor.pausarSonido(musicaDeFondo);
        musicaDeFondo = reproductor.reproducirSonido("media/ambiente/ambienteCombate.wav");
        modoOfensivo = true;
    }

    public void cambiarAModoPasivo() {

        Jugador jugadorActual = getJugadorActual();
        jugadorActual.cambiarAModoPasivo();
        reproductor.pausarSonido(musicaDeFondo);
        musicaDeFondo = reproductor.reproducirSonido("media/ambiente/1.05MachinadelDiablo.wav");
        modoOfensivo = false;
        mensajesDelJuego.setMensaje("Modo Pasivo", false);

    }

    public void terminarTurno() {

        mensajesDelJuego.setMensaje("Turno Jugador " + juego.getIndiceJugadorActual() + " finalizado",false);
        juego.terminarTurnoYVerSiHayGanador();
        Jugador jugadorActual = getJugadorActual();
        jugadorActual.cambiarAModoPasivo();

        if(musicaDeFondo.getMedia().getSource().contains("file:///home/usuario/AlgoChess-/media/ambiente/ambienteCombate.wav")) {
            reproductor.pausarSonido(musicaDeFondo);
            musicaDeFondo = reproductor.reproducirSonido("media/ambiente/1.05MachinadelDiablo.wav");
            modoOfensivo = false;
        }

    }

    public void modoColocarUnidad(String nombreUnidadAColocar) {
        this.estaColocandoUnaUnidad = true;
        this.nombreUnidadAColocar = nombreUnidadAColocar;
        mensajesDelJuego.setMensaje("Comprar: Seleccione donde colocar " + nombreUnidadAColocar, false);
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
        mensajesDelJuego.setMensaje(mensaje, false);
    }


    public void setMensajeError(String mensajeError) {
        mensajesDelJuego.setMensaje(mensajeError, true);
        reproductor.reproducirSonido("media/accion/error.wav");
    }

    public void removerMensajes() {
    	mensajesDelJuego.removerMensajes();
    }

    public AlgoChess getJuego(){
        return this.juego;
    }

    public void resaltarVentanas(int distancia, int fila, int columna, Unidad unidad) {
        ArrayList<Casillero> casillerosAResaltar = tablero.buscarCasilleros(distancia, fila, columna);
        for (Casillero casillero : casillerosAResaltar){
            casillero.setSimboloPintura(unidad.getSimbolo());
            casillero.resaltar();
        }
    }

    public void desResaltarVentanas() {
        tablero.desResaltarCasilleros();
        vistaTablero.desResaltarCasilleros();
    }

}

