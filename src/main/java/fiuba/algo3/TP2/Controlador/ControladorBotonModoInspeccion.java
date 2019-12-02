package fiuba.algo3.TP2.Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBotonModoInspeccion implements EventHandler<ActionEvent> {


    private ControladorJuego controladorJuego;

    public ControladorBotonModoInspeccion(ControladorJuego controladorJuego) {
        this.controladorJuego = controladorJuego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        System.out.println("Modo inspeccion");
        controladorJuego.setVistaUnidadesOpaco();

    }

}
