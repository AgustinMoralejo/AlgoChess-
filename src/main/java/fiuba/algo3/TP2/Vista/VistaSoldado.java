package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.Observer;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import static fiuba.algo3.TP2.Vista.VistaTablero.ALTO_CASILLERO;

public class VistaSoldado extends VistaUnidad {

    private double mouseY;
    private double mouseX;
    private Unidad unidad;
    private double columnaInicial;
    private double filaInicial;


    public VistaSoldado(boolean esRojo, Unidad unidad) {

        this.unidad = unidad;
        dibujar(esRojo);

        unidad.agregarObserver(this);
        actualizar();

    }

    @Override
    protected void dibujar(boolean esRojo) {

        Ellipse fondo = new Ellipse(ALTO_CASILLERO * 0.3125, ALTO_CASILLERO * 0.26);
        fondo.setFill(Color.BLACK);

        fondo.setStroke(Color.BLACK);
        fondo.setStrokeWidth(ALTO_CASILLERO * 0.03);

        fondo.setTranslateX((ALTO_CASILLERO - ALTO_CASILLERO * 0.3125 * 2) / 2);
        fondo.setTranslateY((ALTO_CASILLERO - ALTO_CASILLERO * 0.26 * 2) / 2 + ALTO_CASILLERO * 0.07);

        Ellipse elipse = new Ellipse(ALTO_CASILLERO * 0.3125, ALTO_CASILLERO * 0.26);
        elipse.setFill(esRojo
                ? Color.valueOf("#c40003") : Color.valueOf("#fff9f4"));

        elipse.setStroke(Color.BLACK);
        elipse.setStrokeWidth(ALTO_CASILLERO * 0.03);

        elipse.setTranslateX((ALTO_CASILLERO - ALTO_CASILLERO * 0.3125 * 2) / 2);
        elipse.setTranslateY((ALTO_CASILLERO - ALTO_CASILLERO * 0.26 * 2) / 2);

        getChildren().addAll(fondo, elipse);

    }

    @Override
    public void moverVista(int fila, int columna) {
        columnaInicial = columna * ALTO_CASILLERO;
        filaInicial = fila * ALTO_CASILLERO;
        relocate(columnaInicial, filaInicial);
    }

    public void abortMove() {
        relocate(columnaInicial, filaInicial);
    }


    @Override
    public void actualizar(){
        columnaInicial = unidad.getColumna() * ALTO_CASILLERO;
        filaInicial = unidad.getFila() * ALTO_CASILLERO;
        relocate(columnaInicial, filaInicial);
    }

}
