package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Controlador.ControladorBotonComenzarJuego;
import fiuba.algo3.TP2.Controlador.ControladorJuego;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ContenedorBotonesFaseInicial extends HBox {


    private Label etiqueta;


    public ContenedorBotonesFaseInicial(ControladorJuego controladorJuego, Stage stage) {
        super();
        this.setHeight(20);

        etiqueta = new Label();

        this.etiqueta.setText("VBOX Comprar Unidades");
        this.etiqueta.setTextFill(Color.web("#336600"));

        BotonComprarUnidad botonComprarSoldado = new BotonComprarUnidad(controladorJuego, "soldado");
        BotonComprarUnidad botonComprarJinete = new BotonComprarUnidad(controladorJuego, "jinete");
        BotonComprarUnidad botonComprarCurandero = new BotonComprarUnidad(controladorJuego, "curandero");
        BotonComprarUnidad botonComprarCatapulta = new BotonComprarUnidad(controladorJuego, "catapulta");

        BotonCambiarTurno botonCambiarTurno = new BotonCambiarTurno(controladorJuego);
        BotonModoInspeccion botonModoInspeccion = new BotonModoInspeccion(controladorJuego);

        VBox vBoxIzq = new VBox(etiqueta, botonComprarSoldado, botonComprarJinete,
                botonComprarCurandero, botonComprarCatapulta);
        vBoxIzq.setSpacing(10); //separacion entre VBOX
        //contenedorPrincipal.setPadding(new Insets(20)); //separacion bordes

        VBox vBoxDer = new VBox(new Label("VBOX opciones"), botonCambiarTurno, botonModoInspeccion, new BotonComenzarJuego(controladorJuego, stage));
        vBoxDer.setSpacing(10); //separacion entre VBOX

        this.getChildren().add(vBoxIzq);
        this.getChildren().add(vBoxDer);

    }
}
