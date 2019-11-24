package fiuba.algo3.TP2.Vista;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static fiuba.algo3.TP2.Vista.VistaTablero.ANCHO_CASILLERO;

public class VistaCasillero extends Rectangle {

    public VistaCasillero(boolean light, int fila, int columna) {

        setStroke(Color.BLACK);
        setStrokeWidth(ANCHO_CASILLERO*0.05);

        setWidth(ANCHO_CASILLERO);
        setHeight(VistaTablero.ALTO_CASILLERO);
        relocate(columna * ANCHO_CASILLERO,
                fila * VistaTablero.ALTO_CASILLERO);

        setFill(light ? javafx.scene.paint.Color.valueOf("#feb")
                : Color.valueOf("#582"));
    }


}
