package fiuba.algo3.TP2.Vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class SoundButton {

    Button boton;
    Boolean encendido;

    private static final Image MUSICAON = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/musica.png");
    private static final Image MUSICAOFF = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/musicaMute.png");


    public SoundButton(){
        this.boton = new Button();
        this.encendido = true;

        boton.setGraphic(new ImageView(MUSICAON));
    }

    public Button getVisual(){
        return boton;
    }

    public void apagar(){
        this.encendido = false;
        boton.setGraphic(new ImageView(MUSICAOFF));
    }

    public void prender(){
        boton.setGraphic(new ImageView(MUSICAON));
        this.encendido = true;
    }

    public Boolean prendido(){
        return encendido;
    }
}