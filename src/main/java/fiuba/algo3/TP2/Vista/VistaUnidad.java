package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.Observer;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.*;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import static fiuba.algo3.TP2.Vista.VistaTablero.ALTO_CASILLERO;

public class VistaUnidad extends Group implements Observer {

    private Unidad unidad;
    private double columnaInicial;
    private double filaInicial;
    ImageView imagenUnidad;
    private VistaTablero vistaTablero;

    private static final Image CATAPULTAAZUL = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/catapultaAzul.jpg");
    private static final Image CATAPULTAROJA = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/catapulaRoja.jpg");
    private static final Image CURANDEROAZUL = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/curanderoAzul.jpg");
    private static final Image CURANDEROROJO = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/curanderoRojo.jpg");
    private static final Image JINETEAZUL = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/jineteAzul.jpg");
    private static final Image JINETEROJO = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/jineteRojo.jpg");
    private static final Image SOLDADOAZUL = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/SoldadoAzul.jpg");
    private static final Image SOLDADOROJO = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/SoldadoRojo.jpg");


    /*TODO: No deberia haber una vista por unidad ya que la unica diferencia es como se dibuja
     *  asi que vistaUnidad no deberia ser abstracta y deberia ser solo una*/

    //Image image = new Image("file:" + getNombreUnidad(casillero) + ".png",ancho,alto,false,false);

    public VistaUnidad(Casillero casillero) {
        this.unidad = casillero.getUnidad();
        if(casillero.estaOcupado()) {
            this.imagenUnidad = new ImageView();
            this.establecerUnidad(this.getNombreUnidad(casillero));
            imagenUnidad.setFitHeight(32);
            imagenUnidad.setFitWidth(32);
            getChildren().add(imagenUnidad);
            unidad.agregarObserver(this);
            this.actualizar();
        }
    }

    public VistaUnidad(Unidad unidad) {
        this.unidad = unidad;
        this.imagenUnidad = new ImageView();

        this.establecerUnidad(this.getNombreUnidad(null));
        imagenUnidad.setFitHeight(32);
        imagenUnidad.setFitWidth(32);
        getChildren().add(imagenUnidad);
        unidad.agregarObserver(this);
        actualizar();

    }

    private String getNombreUnidad(Casillero casillero) {

        if (unidad.getSimbolo().equals("J") && unidad.esAliado()) {
            return "jinete azul";
        } else if (unidad.getSimbolo().equals("S") && unidad.esAliado()) {
            return "soldado azul";
        } else if (unidad.getSimbolo().equals("CT") && unidad.esAliado()) {
            return "catapulta azul";
        } else if (unidad.getSimbolo().equals("C") && unidad.esAliado()) {
            return "curandero azul";
        }else if (unidad.getSimbolo().equals("J")) {
            return "jinete rojo";
        } else if (unidad.getSimbolo().equals("S")) {
            return "soldado rojo";
        } else if (unidad.getSimbolo().equals("CT")) {
            return "catapulta roja";
        } else if (unidad.getSimbolo().equals("C")) {
            return "curandero rojo";
        } else {
            return "vacio";
        }
    }

    public void establecerUnidad(String nombreUnidad) {
        switch (nombreUnidad) {
            case "jinete azul":
                this.imagenUnidad.setImage(JINETEAZUL);
                break;
            case "jinete rojo":
                this.imagenUnidad.setImage(JINETEROJO);
                break;
            case "soldado azul":
                this.imagenUnidad.setImage(SOLDADOAZUL);
                break;
            case "soldado rojo":
                this.imagenUnidad.setImage(SOLDADOROJO);
                break;
            case "catapulta azul":
                this.imagenUnidad.setImage(CATAPULTAAZUL);
                break;
            case "catapulta roja":
                this.imagenUnidad.setImage(CATAPULTAROJA);
                break;
            case "curandero azul":
                this.imagenUnidad.setImage(CURANDEROAZUL);
                break;
            case "curandero rojo":
                this.imagenUnidad.setImage(CURANDEROROJO);
                break;
            case "vacio":
                //this.dibujar();
                break;
        }
    }

    @Override
    public void actualizar() {
        columnaInicial = unidad.getColumna() * ALTO_CASILLERO;
        filaInicial = unidad.getFila() * ALTO_CASILLERO;
        relocate(columnaInicial, filaInicial);

    }

/*
    @Override
    public void actualizar() {
        this.vistaTablero.addViewOnMap(imagenUnidad, unidad.getColumna(),unidad.getFila());

    }
*/

}
