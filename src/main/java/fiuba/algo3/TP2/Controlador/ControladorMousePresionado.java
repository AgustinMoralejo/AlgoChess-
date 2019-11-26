package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Vista.VistaTablero;
import fiuba.algo3.TP2.Vista.VistaUnidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import static fiuba.algo3.TP2.Vista.VistaTablero.ALTO_CASILLERO;


public class ControladorMousePresionado implements EventHandler<MouseEvent> {

    private Tablero tablero;

    private VistaTablero vistaTablero;

    private double mouseX;
    private double mouseY;

    public ControladorMousePresionado(Tablero tablero, VistaTablero vistaTablero) {
        this.tablero = tablero;
        this.vistaTablero = vistaTablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        double mouseX = mouseEvent.getSceneX();
        double mouseY = mouseEvent.getSceneY();

        int columna = convertir(mouseX);
        int fila = convertir(mouseY);

        System.out.println("fila: " + fila);
        System.out.println("columna: " + columna);

        tablero.moverUnidad(fila, columna, 0 );

        /*Con un click selecciono a la unidad (fila, columna) y con otro lo muevo (orientacion), como separo cada handle?*/

    }

    private int convertir(double posicionImagen){
        return (int)(posicionImagen + ALTO_CASILLERO / 20)
                / ALTO_CASILLERO;
    }

}
