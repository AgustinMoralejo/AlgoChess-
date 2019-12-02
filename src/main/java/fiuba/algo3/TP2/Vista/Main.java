package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.BotonEntrarEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {

    public static
    void main(String[] args) {
        launch(args);
    }
    Boolean sonidoActivado;

    @Override
    public
    void start(Stage theStage) throws Exception {

        sonidoActivado = true;
        theStage.setTitle("AlgoChess");

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

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(theStage);
        botonEntrar.setOnAction(botonEntrarHandler);

/*
        SONIDO

        Media soundtrack = new Media(new File("media/menu/menuSoundTrack.mp3").toURI().toString());
        MediaPlayer musica = new MediaPlayer(soundtrack);
        soundtrackPlayer.setAutoPlay(true);
        soundtrackPlayer.setVolume(0.1);
*/
        SoundButton botonMusica = new SoundButton();
        Button buttonMusica = (botonMusica).getVisual();

        buttonMusica.setOnAction(e -> {
            if (botonMusica.prendido()) {
                botonMusica.apagar();
                //musica.stop();
            }
            else{
                botonMusica.prender();
                //musica.play();
            }
        });



        vbox.getChildren().addAll(etiqueta, botonEntrar, buttonMusica);

        Scene theScene = new Scene(vbox);
        theStage.setScene(theScene);
        theStage.show();

    }



        /*TODO: El juego, los jugadores */

    }

