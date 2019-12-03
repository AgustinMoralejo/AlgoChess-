package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorBotonCambiarTurno;
import fiuba.algo3.TP2.Controlador.ControladorJuego;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class BotonCambiarTurno extends Button {

    public BotonCambiarTurno(ControladorJuego controladorJuego){

        super();
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BURLYWOOD);
        this.setEffect(dropShadow);
        this.setText("Terminar turno");
        this.setMinHeight(30);
        this.setOnAction(new ControladorBotonCambiarTurno(controladorJuego));
    }

}
