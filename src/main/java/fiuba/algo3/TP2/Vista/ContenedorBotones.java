package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorJuego;
import javafx.scene.layout.HBox;

public class ContenedorBotones extends HBox {

    public ContenedorBotones(ControladorJuego controladorJuego) {
        super();
        this.setHeight(20);
        this.getChildren().add(new BotonModoOfensivo(controladorJuego));
        this.getChildren().add(new BotonModoPasivo(controladorJuego));
        this.getChildren().add(new BotonModoInspeccion(controladorJuego));
        this.getChildren().add(new BotonCambiarTurno(controladorJuego));


    }

}
