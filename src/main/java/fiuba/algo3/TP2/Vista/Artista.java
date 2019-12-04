package fiuba.algo3.TP2.Vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Artista {

    private Ventana ventana;
    private final String PISO = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/piso.jpg";
    private final String PASTO = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/pasto.jpg";
    private final String TIERRA = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/tierra2.jpg";

    public Artista(Ventana ventana){
        this.ventana = ventana;
    }

    public ImagePattern getImagePattern(Ventana ventana) {

        int fila = ventana.getCasillero().getFila();
        int columna = ventana.getCasillero().getColumna();
        String path = PASTO;

        if(columna > 7 && columna < 12){
            path = PISO;
        }
        Image imagen = new Image ("file:" + path);

        return new ImagePattern(imagen);
    }
}
