package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorJuego;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContenedorBotones extends HBox {

    public ContenedorBotones(ControladorJuego controladorJuego) {
        super();
        this.setHeight(20);
        VBox vbox = new VBox(new BotonModoOfensivo(controladorJuego), new BotonModoPasivo(controladorJuego),
                new BotonCambiarTurno(controladorJuego));
        vbox.setSpacing(10);
        this.getChildren().add(vbox);


    }

}
