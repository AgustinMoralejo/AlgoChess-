package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonCambiarTurno implements EventHandler<ActionEvent> {


    private Tablero tablero;

    public ControladorBotonCambiarTurno(Tablero tablero){
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        tablero.cambiarEstado();
        System.out.println("Paso de turno");

    }
}
