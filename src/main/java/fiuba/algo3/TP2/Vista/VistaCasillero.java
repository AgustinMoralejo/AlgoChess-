package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.Observer;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;

import static fiuba.algo3.TP2.Vista.VistaTablero.ANCHO_CASILLERO;

public class VistaCasillero extends Rectangle implements Observer {

    private Casillero casillero;
    private VistaUnidad vistaUnidad;
    private VistaTablero vistaTablero;

    public VistaCasillero(boolean alianza, Casillero casillero,
                          VistaTablero vistaTablero, VistaUnidad vistaUnidad ) {

        this.casillero = casillero;
        this.vistaTablero = vistaTablero;
        this.vistaUnidad = vistaUnidad;

        casillero.agregarObserver(this);

        setStroke(Color.BLACK);
        setStrokeWidth(ANCHO_CASILLERO * 0.05);

        setWidth(ANCHO_CASILLERO);
        setHeight(VistaTablero.ALTO_CASILLERO);
        relocate(casillero.getColumna() * ANCHO_CASILLERO,
                casillero.getFila() * VistaTablero.ALTO_CASILLERO);

        setFill(alianza ? javafx.scene.paint.Color.valueOf("#feb")
                       : Color.valueOf("#582"));

    }


    @Override
    public void actualizar() {

    }

}
