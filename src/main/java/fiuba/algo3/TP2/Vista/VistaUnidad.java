package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.Observer;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import static fiuba.algo3.TP2.Vista.VistaTablero.ALTO_CASILLERO;

public class VistaUnidad extends StackPane implements Observer {

    private double mouseY;
    private double mouseX;
    private Unidad unidad;
    private double columnaInicial;
    private double filaInicial;


    public VistaUnidad(boolean esRojo, Unidad unidad) {

        this.unidad = unidad;

        dibujar(esRojo);


    }

    public VistaUnidad(boolean esRojo, int fila, int columna) {


        dibujar(esRojo);

        /**Esto debe ser parte del controlador*/
        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });


        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + columnaInicial, e.getSceneY() - mouseY + filaInicial);
        });
    }

    private void dibujar(boolean esRojo) {

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
}
