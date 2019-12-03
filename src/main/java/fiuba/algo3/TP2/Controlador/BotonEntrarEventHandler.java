package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.AlgoChess.AlgoChess;
import fiuba.algo3.TP2.Vista.BarraDeEstadoJuego;
import fiuba.algo3.TP2.Vista.ContenedorBotonesFaseInicial;
import fiuba.algo3.TP2.Vista.MensajesDelJuego;
import fiuba.algo3.TP2.Vista.VistaTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

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


        controladorJuego.setJuego(juego, musicaDeFondo);

        /**esto lo deberia hacer el motodo asignarVistasACasilleros*/
        VistaTablero vistaTablero = new VistaTablero(controladorJuego);

        HBox contenedorPrincipal = new HBox();

        VBox vbox = new VBox();
        BarraDeEstadoJuego barraEstado = new BarraDeEstadoJuego(juego);
        vbox.getChildren().addAll(barraEstado, vistaTablero);

        MensajesDelJuego mensajesDelJuego = new MensajesDelJuego();
        ContenedorBotonesFaseInicial contenedorBotones = new ContenedorBotonesFaseInicial(controladorJuego, theStage);
        VBox contenedrBotonesYMensajes = new VBox();
        contenedrBotonesYMensajes.getChildren().addAll(contenedorBotones, mensajesDelJuego);

        //ContenedorBotones contenedorBotones = new ContenedorBotones(controladorJuego);
        contenedorPrincipal.getChildren().addAll(vbox,contenedrBotonesYMensajes);//vbox.getChildren().add(contenedorBotones);
        //vbox.getChildren().remove(contenedorBotones);

        //aca el controlador conoce a la vista y a la ventana de mensajes
        controladorJuego.asignarVistasACasilleros(vistaTablero);
        controladorJuego.setMensajes(mensajesDelJuego);
        /***/

        Scene escenaInicial = new Scene(contenedorPrincipal);
        theStage.setScene(escenaInicial);

        //para evitar que se lo lleve el recolector de basura
        controladorJuego.setMusica(musicaDeFondo);

        /*
        theStage.setFullScreenExitHint("");
        theStage.setFullScreen(true);
        */



    }

}
