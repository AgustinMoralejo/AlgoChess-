package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorBotonComprarUnidad;
import fiuba.algo3.TP2.Controlador.ControladorJuego;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class BotonComprarUnidad extends Button {

    public BotonComprarUnidad(ControladorJuego controladorJuego, String nombreUnidad) {

        super();
        Image imagenUnidad = new Image ("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/" + nombreUnidad + "Azul.png");
        ImageView unidadV = new ImageView(imagenUnidad);
        unidadV.setFitHeight(32);
        unidadV.setFitWidth(32);
        this.setGraphic(unidadV);
        this.setText("Comprar " + nombreUnidad);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        this.setEffect(dropShadow);
        this.setStyle("-fx-base: darkgray;");

        this.setMinHeight(30);
        this.setMaxWidth(160);

        this.setAlignment(Pos.CENTER);
        this.setOnAction(new ControladorBotonComprarUnidad(controladorJuego, nombreUnidad));


    }
}
