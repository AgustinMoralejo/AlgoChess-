package fiuba.algo3.TP2.Vista;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
import fiuba.algo3.TP2.Modelo.Unidad.*;

import java.util.ArrayList;



public class AtributosUnidades extends VBox {
	
	private GridPane contenedor;
	private ArrayList<Label> atributos;
	private static final Image VIDA = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/vida.jpg");
	private static final Image ESPADA = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/espada.jpg");
	private static final Image ARCO = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/arco.jpg");
	private static final Image DINERO = new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/costo.jpg");
	
	
	public AtributosUnidades() {
		
		contenedor = new GridPane();
		atributos = new ArrayList<>();

		
		ColumnConstraints columna = new ColumnConstraints();
        columna.setPercentWidth(20);
        contenedor.getColumnConstraints().add(columna);
        
        ColumnConstraints columna_2 = new ColumnConstraints();
        columna_2.setPercentWidth(20);
        contenedor.getColumnConstraints().add(columna_2);
        
        contenedor.setPrefSize(200, 200);
        for (int i = 0; i < 7; i++) {
        	contenedor.getRowConstraints().add(new RowConstraints(25));
        }
        
        contenedor.setVgap(10);
        contenedor.setStyle("-fx-background-color: burlyWood; -fx-effect: innershadow(gaussian, rgba(0,0,0,0.4), 75, 0.5, 0, 10);");
        contenedor.setSnapToPixel(false);
        
        
        getChildren().add(contenedor);
		
	}
	
	public void setAtributos(Unidad unidad) {
		
		Label nombreUnidad = new Label("UNIDAD");
        contenedor.addRow(0, nombreUnidad);
        
        Label alianza = new Label("ALIANZA");
        contenedor.addRow(1, alianza);
        
        Label vida = new Label("");
        vida.setGraphic(new ImageView(VIDA));
        contenedor.addRow(2, vida);
        
        Label espada = new Label("");
        espada.setGraphic(new ImageView(ESPADA));
        contenedor.addRow(4, espada);
        
        Label arco = new Label("");
        arco.setGraphic(new ImageView(ARCO));
        contenedor.addRow(5, arco);
        
        Label dinero = new Label("");
        dinero.setGraphic(new ImageView(DINERO));
        contenedor.addRow(3, dinero);
        
        Label realizoAccion = new Label("ACCIONÓ");
        contenedor.addRow(6, realizoAccion);
		
		int vi = unidad.getPuntosDeVida();
		int vidaInicial = unidad.getVidaInicial();
		double porcentajeVida = (vi * 100) / vidaInicial;
		double vidaBarra = porcentajeVida / 100;
		ProgressBar barra = new ProgressBar(vidaBarra);
		contenedor.add(barra, 1, 2);
		
		Label tipoUnidad = new Label(unidad.getSimbolo());
		contenedor.add(tipoUnidad, 1, 0);
		atributos.add(tipoUnidad);
		
		Label estadoAlianza;
		if(unidad.esAliado()) {estadoAlianza = new Label("Aliado");}
		else {estadoAlianza = new Label("Enemigo");}
		contenedor.add(estadoAlianza, 1, 1);
		atributos.add(estadoAlianza);
		
		Label costo = new Label(Integer.toString(unidad.getCosto()));
		contenedor.add(costo, 1, 3);
		atributos.add(costo);
		
		Label armaEspada = new Label(Integer.toString(unidad.getAlcanceCorto()));
		contenedor.add(armaEspada, 1, 4);
		atributos.add(armaEspada);
		
		Label armaArco = new Label(Integer.toString(unidad.getAlcanceADistancia()));
		contenedor.add(armaArco, 1, 5);
		atributos.add(armaArco);
		
		Label turno;
		if(unidad.realizoAccion()) {turno = new Label("SI");}
		else {turno = new Label("NO");}
		contenedor.add(turno, 1, 6);
		atributos.add(turno);
	}
	
	
	public void removerAtributos() {
		
		contenedor.getChildren().clear();
	}
}
