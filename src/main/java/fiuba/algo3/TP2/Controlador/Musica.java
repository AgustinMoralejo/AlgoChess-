package fiuba.algo3.TP2.Controlador;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Musica implements Runnable {

    private MediaPlayer musicaDeFondo;

    public Musica(MediaPlayer musicaDeFondo){
        this.musicaDeFondo = musicaDeFondo;
        run();
    }

    @Override
    public void run() {

        musicaDeFondo.seek(Duration.ZERO);
        musicaDeFondo.play();
    }
}
