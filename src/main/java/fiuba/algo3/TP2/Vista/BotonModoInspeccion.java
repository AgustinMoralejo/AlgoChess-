package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorBotonModoInspeccion;
import fiuba.algo3.TP2.Controlador.ControladorJuego;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class BotonModoInspeccion extends Button {

    public BotonModoInspeccion(ControladorJuego controladorJuego) {

        super();
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BURLYWOOD);
        this.setEffect(dropShadow);
        this.setText("Modo inspeccion");
        this.setMinHeight(30);
        this.setOnAction(new ControladorBotonModoInspeccion(controladorJuego));

    }
}
