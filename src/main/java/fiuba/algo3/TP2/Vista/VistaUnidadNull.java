package fiuba.algo3.TP2.Vista;


import fiuba.algo3.TP2.Modelo.Observer;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import static fiuba.algo3.TP2.Vista.VistaTablero.ALTO_CASILLERO;

public class VistaUnidadNull extends VistaUnidad {

    private double mouseY;
    private double mouseX;
    private Unidad unidad;
    private double columnaInicial;
    private double filaInicial;



    public VistaUnidadNull(boolean esRojo, Unidad unidad) {

        this.unidad = unidad;
        dibujar(esRojo);
        actualizar();
    }

    @Override
    protected void dibujar(boolean esRojo) {

        Ellipse elipse = new Ellipse(ALTO_CASILLERO * 0.05, ALTO_CASILLERO * 0.05);
        elipse.setFill(Color.BLACK);

        elipse.setStroke(Color.BLACK);
        elipse.setStrokeWidth(ALTO_CASILLERO * 0.03);

        elipse.setTranslateX((ALTO_CASILLERO - ALTO_CASILLERO * 0.3125 * 2) / 2);
        elipse.setTranslateY((ALTO_CASILLERO - ALTO_CASILLERO * 0.26 * 2) / 2);

        getChildren().addAll(elipse);

    }

    public void moverVista(int fila, int columna) {
        columnaInicial = columna * ALTO_CASILLERO;
        filaInicial = fila * ALTO_CASILLERO;
        relocate(columnaInicial, filaInicial);
    }

    public void abortMove() {

    }


    @Override
    public void actualizar() {
        columnaInicial = unidad.getColumna() * ALTO_CASILLERO;
        filaInicial = unidad.getFila() * ALTO_CASILLERO;
        relocate(columnaInicial, filaInicial);
    }
}

