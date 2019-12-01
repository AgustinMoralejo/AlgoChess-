package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorJuego;
import javafx.scene.layout.HBox;

public class ContenedorBotonesFaseInicial extends HBox {
    public ContenedorBotonesFaseInicial(ControladorJuego controladorJuego) {
        super();
        this.setHeight(20);
        this.getChildren().add(new BotonComprarUnidad(controladorJuego, "soldado"));
        this.getChildren().add(new BotonComprarUnidad(controladorJuego, "jinete"));
        this.getChildren().add(new BotonComprarUnidad(controladorJuego, "curandero"));
        this.getChildren().add(new BotonComprarUnidad(controladorJuego, "catapulta"));
        this.getChildren().add(new BotonCambiarTurno(controladorJuego));
    }
}
