package fiuba.algo3.TP2.Vista;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Random;

import static fiuba.algo3.TP2.Vista.VistaTablero.ALTO_CASILLERO;
import static fiuba.algo3.TP2.Vista.VistaTablero.ANCHO_CASILLERO;

public class Artista {

    private Ventana ventana;
    private int columna;
    private int fila;
    private final String PISO = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/Terreno/piso.jpg";
    private final String PASTO = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/Terreno/pasto3.png";
    private final String TIERRA = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/Terreno/tierra2.jpg";
    private final String PARED = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/Terreno/pared.jpg";
    private final String PARED_ROJO = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/Terreno/paredRojo.jpg";
    private final String PARED_NATURAL = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/Terreno/agua2.png";
    private final String ARENA = "src/main/java/fiuba/algo3/TP2/Vista/Imagenes/Terreno/arena3.png";

    public Artista(Ventana ventana){
        this.ventana = ventana;
        this.fila = ventana.getCasillero().getFila();
        this.columna = ventana.getCasillero().getColumna();
    }

    public ImagePattern getImagePattern(Ventana ventana) {

        String path = PASTO;

        Random random = new Random();
        int num = random.nextInt(2);

        if(num == 0){
            path = ARENA;
        }

        if(columna > 7 && columna < 12){
            path = PISO;
        }
        if(columna == 0 || columna == 19){
            path = PARED_NATURAL;
        }
        if (fila == 0){
            path = PARED;
        }
        if(fila == 19){
            path = PARED_ROJO;
        }

        Image imagen = new Image ("file:" + path);

        return new ImagePattern(imagen);
    }

    public Rectangle getPlanta() {

        Random random = new Random();
        String path;

        int numPlanta = random.nextInt(15);
        Rectangle reactanguloPlanta = new Rectangle(ANCHO_CASILLERO, ALTO_CASILLERO);

        if(fila != 0 && fila != 19 && columna != 0 && columna != 19 && (columna < 8 || columna > 12) ){
            if(numPlanta > 5){
                numPlanta = 0;
            }
            path = ("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/Terreno/planta" + (numPlanta) + ".png");
        } else{
            path = ("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/Terreno/planta0.png");
        }
        Image imagen = new Image(path);
        reactanguloPlanta.setFill(new ImagePattern(imagen));
        return reactanguloPlanta;

    }
}
