package fiuba.algo3.TP2.Controlador;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class Reproductor {

    private MediaPlayer sonido;

    public void reproducirSonido(String path) {

        Media media = new Media(Paths.get(path).toUri().toString());
        sonido = new MediaPlayer(media);
        sonido.setVolume(0.3);
        sonido.play();

    }
}
