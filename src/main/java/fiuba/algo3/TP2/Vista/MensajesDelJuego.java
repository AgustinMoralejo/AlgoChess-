package fiuba.algo3.TP2.Vista;

import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class MensajesDelJuego extends VBox {

    public TextArea areaTexto;

    private GridPane contenedor;
    private List<String> mensajesAnteriores;

    public MensajesDelJuego() {


        contenedor = new GridPane();
        areaTexto = new TextArea("hola soy un label que deberia ocupar toda la cajaaaaaa aaaaaaaaaaa aaaaaaaaa aaaaaaaaaa aaaaaaa " +
                "aaaaaaaa");
        mensajesAnteriores = new ArrayList<>();

        ColumnConstraints columna = new ColumnConstraints();
        columna.setPercentWidth(100);
        contenedor.getColumnConstraints().add(columna);

        contenedor.setPrefSize(400, 200);

        contenedor.getRowConstraints().add(new RowConstraints(200));

        contenedor.addRow(0, areaTexto);

        contenedor.setVgap(10);
        contenedor.setHgap(10);
        contenedor.setPadding(new Insets(10, 10, 10, 10));

        contenedor.setStyle("-fx-background-color: burlyWood; -fx-effect: innershadow(gaussian, rgba(0,0,0,0.4), 75, 0.5, 0, 10);");
        contenedor.setSnapToPixel(false);

        areaTexto.setStyle("-fx-font-size: 8pt; -fx-font-weight: bold; -fx-opacity: 1.0;");
        areaTexto.setPrefRowCount(1);
        areaTexto.setPrefColumnCount(1);
        areaTexto.setWrapText(true);
        areaTexto.setPrefWidth(400);

        getChildren().add(contenedor);

    }

    public void setMensaje(String mensaje) {
        StringBuilder todosLosMensajes = new StringBuilder();

        for(String mensajeAnterior : mensajesAnteriores){
            todosLosMensajes.append(mensajeAnterior).append("\n");
        }

        areaTexto.setText(todosLosMensajes + mensaje);
        mensajesAnteriores.add(mensaje);
        if (mensajesAnteriores.size() > 10){
            mensajesAnteriores.remove(0);
        }
    }
    
    public void removerMensajes() {
    	mensajesAnteriores.clear();
    }
}
