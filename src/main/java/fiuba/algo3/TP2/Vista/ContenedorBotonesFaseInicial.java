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

        this.etiqueta.setText("HBOX Comprar Unidades");
        this.etiqueta.setTextFill(Color.web("#336600"));

        BotonComprarUnidad botonComprarSoldado = new BotonComprarUnidad(controladorJuego, "soldado");
        BotonComprarUnidad botonComprarJinete = new BotonComprarUnidad(controladorJuego, "jinete");
        BotonComprarUnidad botonComprarCurandero = new BotonComprarUnidad(controladorJuego, "curandero");
        BotonComprarUnidad botonComprarCatapulta = new BotonComprarUnidad(controladorJuego, "catapulta");

        VBox contenedorPrincipal = new VBox(etiqueta, botonComprarSoldado, botonComprarJinete,
                botonComprarCurandero, botonComprarCatapulta);
        //contenedorPrincipal.setSpacing(20); //separacion entre VBOX
        //contenedorPrincipal.setPadding(new Insets(20)); //separacion bordes

        this.getChildren().add(contenedorPrincipal);
        this.getChildren().addAll(new BotonCambiarTurno(controladorJuego), new BotonComenzarJuego(controladorJuego, stage));



    }
}
