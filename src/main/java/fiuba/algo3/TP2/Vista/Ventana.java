package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorVistaCasillero;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Observer;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import static fiuba.algo3.TP2.Vista.VistaTablero.ANCHO_CASILLERO;

public class Ventana extends StackPane implements Observer {

    private Jugador jugador;
    private Rectangle rec;
    private Casillero casillero;
    private Tablero tablero;
    private VistaTablero vistaTablero;
    private boolean resaltado;


    public Ventana(boolean alianza, Casillero casillero,
                   Tablero tablero) {

        this.tablero = tablero;
        resaltado = false;
        this.casillero = casillero;

        this.rec = new Rectangle();

        casillero.agregarObserver(this);

        rec.setStroke(Color.BLACK);
        rec.setStrokeWidth(ANCHO_CASILLERO * 0.05);

        rec.setWidth(ANCHO_CASILLERO);
        rec.setHeight(VistaTablero.ALTO_CASILLERO);
        relocate(casillero.getColumna() * ANCHO_CASILLERO,
                casillero.getFila() * VistaTablero.ALTO_CASILLERO);

        rec.setFill(alianza ? javafx.scene.paint.Color.valueOf("#feb")
                : Color.valueOf("#582"));

        getChildren().add(rec);

        ControladorVistaCasillero controlador = new ControladorVistaCasillero(this, tablero);

        this.setOnMouseClicked(controlador);


    }


    public void resaltar(Color color) {
        rec.setStrokeType(StrokeType.INSIDE);
        rec.setStrokeWidth(ANCHO_CASILLERO * 0.05);
        rec.setStroke(color);
        if (color == Color.GREEN)
            this.resaltado = true;
    }

    public void desResaltar() {
        rec.setStroke(null);
        resaltado = false;
    }

    @Override
    public void actualizar() {

    }

    public Casillero getCasillero() {
        return this.casillero;
    }
}
