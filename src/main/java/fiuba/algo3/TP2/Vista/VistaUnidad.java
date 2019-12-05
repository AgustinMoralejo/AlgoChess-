package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorVistaUnidad;
import fiuba.algo3.TP2.Modelo.Observer;
import fiuba.algo3.TP2.Modelo.Unidad.*;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static fiuba.algo3.TP2.Vista.VistaTablero.ALTO_CASILLERO;

public class VistaUnidad extends Group implements Observer {

    private VistaTablero vistaTablero;
    private Unidad unidad;
    private double columnaInicial;
    private double filaInicial;
    ImageView imagenUnidad;

    private static final Image CATAPULTAAZUL = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/catapultaAzul.png");
    private static final Image CATAPULTAROJA = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/catapultaRoja.png");
    private static final Image CURANDEROAZUL = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/curanderoAzul.png");
    private static final Image CURANDEROROJO = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/curanderoRojo.png");
    private static final Image JINETEAZUL = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/jineteAzul.png");
    private static final Image JINETEROJO = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/jineteRojo.png");
    private static final Image SOLDADOAZUL = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/soldadoAzul.png");
    private static final Image SOLDADOROJO = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/soldadoRojo.png");




    public VistaUnidad(Unidad unidad, boolean esAzul, VistaTablero vistaTablero) {
        this.unidad = unidad;
        this.imagenUnidad = new ImageView();
        this.vistaTablero = vistaTablero;

        this.establecerUnidad(this.getNombreUnidad(esAzul));
        imagenUnidad.setFitHeight(32);
        imagenUnidad.setFitWidth(32);
        getChildren().add(imagenUnidad);
        unidad.agregarObserver(this);
        actualizar();

        //ControladorVistaUnidad controlador = new ControladorVistaUnidad(unidad);

        //this.setOnMouseClicked(controlador);


    }

    private String getNombreUnidad(boolean esAzul) {

        if (unidad.getSimbolo().equals("J") && esAzul) {
            return "jinete azul";
        } else if (unidad.getSimbolo().equals("S") && esAzul) {
            return "soldado azul";
        } else if (unidad.getSimbolo().equals("CT") && esAzul) {
            return "catapulta azul";
        } else if (unidad.getSimbolo().equals("C") && esAzul) {
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
        if(unidad.getFila() == -1 && unidad.getColumna() == -1){
            vistaTablero.borrarVistaUnidad(this);
        } else {
            columnaInicial = unidad.getColumna() * ALTO_CASILLERO;
            filaInicial = unidad.getFila() * ALTO_CASILLERO;
            relocate(columnaInicial, filaInicial);
        }

    }

}
