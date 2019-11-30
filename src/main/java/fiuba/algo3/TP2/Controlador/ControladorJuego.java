package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Modelo.Unidad.Catapulta;
import fiuba.algo3.TP2.Modelo.Unidad.Curandero;
import fiuba.algo3.TP2.Modelo.Unidad.Jinete;
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

        vistaTablero.agregarVistaUnidad(soldadoAzul);
        vistaTablero.agregarVistaUnidad(soldadoRojo);

        tablero.colocarUnidad(soldadoAzul,7,7);
        tablero.colocarUnidad(soldadoRojo,2,7);

    }
}
