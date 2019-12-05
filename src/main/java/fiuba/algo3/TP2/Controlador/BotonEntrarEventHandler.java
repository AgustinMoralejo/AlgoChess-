package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import fiuba.algo3.TP2.Vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;

import java.nio.file.Paths;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    private MediaPlayer musicaDeFondo;
    Stage theStage;

    public BotonEntrarEventHandler(Stage theStage, MediaPlayer musicaMenu) {
        this.theStage = theStage;
        this.musicaDeFondo = musicaMenu;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        AlgoChess juego = new AlgoChess("juan","pedro");

        ControladorJuego controladorJuego = new ControladorJuego();

        musicaDeFondo.stop();

        Media media = new Media(Paths.get("media/ambiente/1.05MachinadelDiablo.wav").toUri().toString());
        musicaDeFondo = new MediaPlayer(media);
        musicaDeFondo.setVolume(0.2);
        musicaDeFondo.play();

        controladorJuego.setJuego(juego);

        VistaTablero vistaTablero = new VistaTablero(controladorJuego);

        HBox hbox = new HBox();

        VBox vbox = new VBox();
        BarraDeMenu menuBar = new BarraDeMenu(theStage);
        BarraDeEstadoJuego barraEstado = new BarraDeEstadoJuego(juego);
        vbox.getChildren().addAll(menuBar, barraEstado, vistaTablero);

        MensajesDelJuego mensajesDelJuego = new MensajesDelJuego();
        AtributosUnidades atributosDelJuego = new AtributosUnidades();
        ContenedorBotonesFaseInicial contenedorBotones = new ContenedorBotonesFaseInicial(controladorJuego);
        VBox contenedorBotonesYMensajes = new VBox();

        contenedorBotonesYMensajes.getChildren().addAll(contenedorBotones, mensajesDelJuego, atributosDelJuego);
        contenedorBotonesYMensajes.setSpacing(30);
        BotonComenzarJuego botonComenzarJuego = new BotonComenzarJuego(controladorJuego, contenedorBotones, contenedorBotonesYMensajes);
        contenedorBotonesYMensajes.getChildren().add(botonComenzarJuego);

        contenedorBotonesYMensajes.setAlignment(Pos.TOP_CENTER);
        hbox.getChildren().addAll(vbox, contenedorBotonesYMensajes);
        ScrollPane barraDesplazamiento = new ScrollPane();
        barraDesplazamiento.setContent(hbox);
        HBox contenedorPrincipal = new HBox();
        contenedorPrincipal.getChildren().addAll(hbox, barraDesplazamiento);
        contenedorPrincipal.setStyle("-fx-base: burlyWood;");

        //aca el controlador conoce a la vista y a la ventana de mensajes
        controladorJuego.asignarVistasACasilleros(vistaTablero);
        controladorJuego.setVentanaDeMensajes(mensajesDelJuego);
        controladorJuego.setAtributosUnidades(atributosDelJuego);

        Scene escenaInicial = new Scene(contenedorPrincipal);
        theStage.setScene(escenaInicial);

        controladorJuego.setMusica(musicaDeFondo);


    }

}
