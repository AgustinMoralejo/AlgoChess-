package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorBotonComenzarJuego;
import fiuba.algo3.TP2.Controlador.ControladorJuego;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonComenzarJuego extends Button {

    public BotonComenzarJuego(ControladorJuego controladorJuego, Stage stage){

        super();
        this.setText("Comenzar Juego");
        this.setMinHeight(30);
        this.setOnAction(new ControladorBotonComenzarJuego(controladorJuego, stage));

    }
}
