package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.BotonEntrarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorPantallaPrincipal extends VBox {

    Stage stage;

    public ContenedorPantallaPrincipal(Stage stage, VBox vbox) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/algoChess.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);

        botonEntrar.setEffect(dropShadow);
        botonEntrar.setText("Comenzar");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tw Cen MT Condensed", FontWeight.BOLD, 50));

        etiqueta.setText("A L G O  C H E S S");
        etiqueta.setTextFill(Color.web("#888888"));

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage);
        botonEntrar.setOnAction(botonEntrarHandler);

        this.getChildren().addAll(etiqueta, botonEntrar);
    }

}


