package fiuba.algo3.TP2.Vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.util.Random;

public class Artista {

    private Ventana ventana;
    private final String PISO = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/piso.jpg";
    private final String PASTO = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/pasto.jpg";
    private final String TIERRA = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/tierra2.jpg";
    private final String PARED = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/pared.jpg";
    private final String ARENA = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/arena2.jpg";

    public Artista(Ventana ventana){
        this.ventana = ventana;
    }

    public ImagePattern getImagePattern(Ventana ventana) {

        int fila = ventana.getCasillero().getFila();
        int columna = ventana.getCasillero().getColumna();

        String path = PASTO;

        Random random = new Random();
        int num = random.nextInt(2);

        if(num == 0){
            path = TIERRA;
        }

        if(columna > 7 && columna < 12){
            path = PISO;
        }
        else if (columna == 0 || fila == 0 || columna == 19 || fila == 19){
            path = PARED;
        }

        Image imagen = new Image ("file:" + path);

        return new ImagePattern(imagen);
    }
}
