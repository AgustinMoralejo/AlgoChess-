package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorBotonModoInspeccion;
import fiuba.algo3.TP2.Controlador.ControladorJuego;
import javafx.scene.control.Button;

public class BotonModoInspeccion extends Button {

    public BotonModoInspeccion(ControladorJuego controladorJuego) {

        super();
        this.setText("Modo inspeccion");
        this.setMinHeight(30);
        this.setOnAction(new ControladorBotonModoInspeccion(controladorJuego));

    }
}
