package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.BotonEntrarEventHandler;
import fiuba.algo3.TP2.Modelo.AlgoChess.Jugador;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;

import fiuba.algo3.TP2.Modelo.Unidad.Catapulta;
import fiuba.algo3.TP2.Modelo.Unidad.Curandero;
import fiuba.algo3.TP2.Modelo.Unidad.Jinete;
import fiuba.algo3.TP2.Modelo.Unidad.Soldado;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) throws Exception {

        theStage.setTitle("AlgoChess");

        Media media = new Media(Paths.get("media/menu/ageofkingsmenu.wav").toUri().toString());
        MediaPlayer musicaMenu = new MediaPlayer(media);
        musicaMenu.setVolume(0.3);
        musicaMenu.play();

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(25));

        Image imagen = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/algoChess.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vbox.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);

        botonEntrar.setEffect(dropShadow);
        botonEntrar.setText("Comenzar");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tw Cen MT Condensed", FontWeight.BOLD, 50));

        etiqueta.setText("A L G O  C H E S S");
        etiqueta.setTextFill(Color.web("#888888"));

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(theStage, musicaMenu);
        botonEntrar.setOnAction(botonEntrarHandler);

        vbox.getChildren().addAll(etiqueta, botonEntrar);

        Scene theScene = new Scene(vbox);
        theStage.setScene(theScene);
        theStage.show();

    }

    /*TODO: El juego, los jugadores */



}