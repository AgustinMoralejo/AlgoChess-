package fiuba.algo3.TP2.Vista;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class VistaUnidad extends StackPane {

    private double mouseX, mouseY;
    private double columnaInicial, filaInicial;


    public double getColumnaInicial() {
        return columnaInicial;
    }

    public double getFilaInicial() {
        return filaInicial;
    }

    public VistaUnidad(boolean esRojo, int fila, int columna) {

        move(fila, columna);

        Ellipse fondo = new Ellipse(VistaTablero.ALTO_CASILLERO * 0.3125, VistaTablero.ALTO_CASILLERO * 0.26);
        fondo.setFill(Color.BLACK);

        fondo.setStroke(Color.BLACK);
        fondo.setStrokeWidth(VistaTablero.ALTO_CASILLERO * 0.03);

        fondo.setTranslateX((VistaTablero.ALTO_CASILLERO - VistaTablero.ALTO_CASILLERO * 0.3125 * 2) / 2);
        fondo.setTranslateY((VistaTablero.ALTO_CASILLERO - VistaTablero.ALTO_CASILLERO * 0.26 * 2) / 2 + VistaTablero.ALTO_CASILLERO * 0.07);

        Ellipse elipse = new Ellipse(VistaTablero.ALTO_CASILLERO * 0.3125, VistaTablero.ALTO_CASILLERO * 0.26);
        elipse.setFill(esRojo
                ? Color.valueOf("#c40003") : Color.valueOf("#fff9f4"));

        elipse.setStroke(Color.BLACK);
        elipse.setStrokeWidth(VistaTablero.ALTO_CASILLERO * 0.03);

        elipse.setTranslateX((VistaTablero.ALTO_CASILLERO - VistaTablero.ALTO_CASILLERO * 0.3125 * 2) / 2);
        elipse.setTranslateY((VistaTablero.ALTO_CASILLERO - VistaTablero.ALTO_CASILLERO * 0.26 * 2) / 2);

        getChildren().addAll(fondo, elipse);

        /**Esto debe ser parte del controlador*/
        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - mouseX + columnaInicial, e.getSceneY() - mouseY + filaInicial);
        });
    }

    public void move(int fila, int columna) {
        columnaInicial = columna * VistaTablero.ALTO_CASILLERO;
        filaInicial = fila * VistaTablero.ALTO_CASILLERO;
        relocate(columnaInicial, filaInicial);
    }

    public void abortMove() {
        relocate(columnaInicial, filaInicial);
    }


}
