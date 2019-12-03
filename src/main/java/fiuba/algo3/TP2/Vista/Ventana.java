package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorJuego;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static fiuba.algo3.TP2.Vista.VistaTablero.ALTO_CASILLERO;
import static fiuba.algo3.TP2.Vista.VistaTablero.ANCHO_CASILLERO;

public class Ventana extends StackPane implements Observer {

    private Rectangle rec;
    private Casillero casillero;
    private Tablero tablero;
    private boolean resaltado;

    private Text textoPosicion;


    public Ventana(boolean alianza, Casillero casillero,
                   ControladorJuego controladorJuego) {

        resaltado = false;
        this.casillero = casillero;

        this.rec = new Rectangle();

        casillero.agregarObserver(this);

        textoPosicion = new Text("(" + casillero.getFila() + "," + casillero.getColumna() + ")");

        textoPosicion.setFont(Font.font("Liberation Serif", FontWeight.EXTRA_BOLD, (float) ALTO_CASILLERO / 5.0));
        textoPosicion.setFill(Color.BLACK);
        textoPosicion.setVisible(false);

        rec.setStroke(Color.BLACK);
        rec.setStrokeWidth(ANCHO_CASILLERO * 0.05);

        rec.setWidth(ANCHO_CASILLERO);
        rec.setHeight(VistaTablero.ALTO_CASILLERO);
        relocate(casillero.getColumna() * ANCHO_CASILLERO,
                casillero.getFila() * VistaTablero.ALTO_CASILLERO);

        rec.setFill(alianza ? Color.BLUE
                : Color.RED);

        getChildren().add(rec);

        ControladorVistaCasillero controlador = new ControladorVistaCasillero(this, controladorJuego);

        this.setOnMouseClicked(controlador);

//        this.setOnMouseEntered(event -> textoPosicion.setVisible(true));

  //      this.setOnMouseExited(event -> textoPosicion.setVisible(false));


    }


    public void resaltar() {
        rec.setStrokeType(StrokeType.INSIDE);
        rec.setStrokeWidth(ANCHO_CASILLERO * 0.05);
        rec.setStroke(Color.GREEN);
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
