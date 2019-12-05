package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorJuego;
import fiuba.algo3.TP2.Controlador.ControladorVistaCasillero;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Observer;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static fiuba.algo3.TP2.Vista.VistaTablero.ALTO_CASILLERO;
import static fiuba.algo3.TP2.Vista.VistaTablero.ANCHO_CASILLERO;

public class Ventana extends StackPane implements Observer {

    private Artista artista;
    private Rectangle rec;
    private Casillero casillero;

    private final double STROKE_DEFAULT = 0.03;
    private final double STROKE_RESALTAR_UNIDAD = 0.07;
    private final double STROKE_RESALTAR_CASILLERO = 0.06;

    private boolean alianza;

    public Ventana(boolean alianza, Casillero casillero,
                   ControladorJuego controladorJuego) {

        this.casillero = casillero;
        this.artista = new Artista(this);
        this.rec = new Rectangle();
        this.alianza = alianza;


        Rectangle rectanguloPlanta = artista.getPlanta();

        casillero.agregarObserver(this);

        ImagePattern imagePattern = this.artista.getImagePattern(this);
        rec.setFill(imagePattern);

        rec.setStroke(alianza ? Color.DARKBLUE : Color.DARKRED);
        rec.setStrokeWidth(ANCHO_CASILLERO * STROKE_DEFAULT);

        rec.setWidth(ANCHO_CASILLERO);
        rec.setHeight(ALTO_CASILLERO);
        relocate(casillero.getColumna() * ANCHO_CASILLERO,
                casillero.getFila() * ALTO_CASILLERO);

        /*
        rec.setFill(alianza ? Color.DARKBLUE
                : Color.DARKRED);
        */

        getChildren().addAll(rec, rectanguloPlanta);

        ControladorVistaCasillero controlador = new ControladorVistaCasillero(this, controladorJuego);

        this.setOnMouseClicked(controlador);


    }


    public void resaltar() {
        rec.setStrokeType(StrokeType.INSIDE);
        rec.setStrokeWidth(ANCHO_CASILLERO * STROKE_RESALTAR_UNIDAD);
        rec.setStroke(Color.DARKGREEN);
    }


    public void resaltar(int overload) {
        rec.setStrokeType(StrokeType.INSIDE);
        rec.setStrokeWidth(ANCHO_CASILLERO * STROKE_RESALTAR_CASILLERO);
        rec.setStroke(casillero.getSimboloPintura().equals("CT") ? Color.RED : Color.DARKORANGE );
    }

    public void desResaltar() {
        rec.setStrokeType(StrokeType.CENTERED);
        rec.setStroke(alianza ? Color.DARKBLUE : Color.DARKRED);
        rec.setStrokeWidth(ANCHO_CASILLERO * STROKE_DEFAULT);
    }

    @Override
    public void actualizar() {
        if(casillero.estaResaltado()){
            resaltar(1);
        }
    }

    public Casillero getCasillero() {
        return this.casillero;
    }
}