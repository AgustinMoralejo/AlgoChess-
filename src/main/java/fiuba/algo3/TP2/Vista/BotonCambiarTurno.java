package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorBotonCambiarTurno;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import javafx.scene.control.Button;

public class BotonCambiarTurno extends Button {

    public BotonCambiarTurno(Tablero tablero){

        super();
        this.setText("Pasar de turno");
        this.setMinHeight(30);
        this.setOnAction(new ControladorBotonCambiarTurno(tablero));

    }

}
