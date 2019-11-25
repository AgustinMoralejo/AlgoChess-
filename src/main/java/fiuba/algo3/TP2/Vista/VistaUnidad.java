package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.Observer;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import static fiuba.algo3.TP2.Vista.VistaTablero.ALTO_CASILLERO;

public abstract class VistaUnidad extends StackPane implements Observer {

    private double mouseY;
    private double mouseX;
    private Unidad unidad;
    private double columnaInicial;
    private double filaInicial;

    /*
    public VistaUnidad(boolean esRojo, int fila, int columna) {


        dibujar(esRojo);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });


        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + columnaInicial, e.getSceneY() - mouseY + filaInicial);
        });
    }
    */

    protected abstract void dibujar(boolean esRojo);

    public abstract void moverVista(int filaDestino, int columnaDestino);

    /*
    public void moverVista(int fila, int columna) {
        columnaInicial = columna * ALTO_CASILLERO;
        filaInicial = fila * ALTO_CASILLERO;
        relocate(columnaInicial, filaInicial);
    }

    public void abortMove() {
        relocate(columnaInicial, filaInicial);
    }


    @Override
    public void actualizar() {

    }
    */

}
