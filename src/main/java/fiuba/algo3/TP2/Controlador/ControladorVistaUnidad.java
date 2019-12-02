package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.Unidad.Unidad;
import fiuba.algo3.TP2.Vista.VistaUnidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorVistaUnidad implements EventHandler<MouseEvent> {


    private Unidad unidad;

    public ControladorVistaUnidad(Unidad unidad) {

        this.unidad = unidad;

    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        System.out.println("Unidad Seleccionada: " + unidad.getSimbolo());
        System.out.println("Aliada: " + unidad.esAliado());



    }
}
