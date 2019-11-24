package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;


public class VistaTablero extends Group {

    public double ancho;
    public double alto;
    public static final int ANCHO_CASILLERO = 32;
    public static final int ALTO_CASILLERO = 32;

    /*
    private GridPane table;
    private VistaCasillero[][] panes;
    */

    private Group casilleroGroup = new Group();
    private Group unidadGroup = new Group();
    private double mouseX;
    private double mouseY;

    public VistaTablero(Tablero tablero) {

        ancho = ANCHO_CASILLERO * tablero.getColumnas();
        alto = ALTO_CASILLERO * tablero.getFilas();

        Pane root = new Pane();
        root.setPrefSize(ancho, alto);
        root.getChildren().addAll(casilleroGroup, unidadGroup);

        /*Es una version del tablero y de los casilleros pero solo para vista*/
        /*
        table = new GridPane();
        ancho = anchoCasillero * tablero.getColumnas();
        alto = altoCasillero * tablero.getFilas();
        panes = new VistaCasillero[(int) ancho][(int) alto];
        */

        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                VistaCasillero vistaCasillero = new VistaCasillero((i < 10), i, j);
                casilleroGroup.getChildren().add(vistaCasillero);
                if(tablero.estaOcupado(i,j)){
                    VistaUnidad vistaUnidad = new VistaUnidad(true,i,j);
                    unidadGroup.getChildren().add(vistaUnidad);
                }

                if (i < 1) {
                    VistaUnidad vistaUnidad = new VistaUnidad(true,i,j);
                    unidadGroup.getChildren().add(vistaUnidad);
                }

                if (i > 18) {
                    VistaUnidad vistaUnidad = new VistaUnidad(false,i,j);
                    unidadGroup.getChildren().add(vistaUnidad);
                }
                //table.add(v, i, j);
            }
        }

        /*
        Background bi = new Background(new BackgroundImage
            (new Image("fondo.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.ancho, this.alto, false,
                    false, false, false)));
        table.setBackground(bi);
        */

        this.agregarVista(root);

    }

    /**
    public void addViewOnMap(Node view, int x, int y) {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                try {
                    panes[i][j].getChildren().remove(view);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
        panes[x][y].getChildren().add(0, view);
    }*/

    public void agregarVista(Node view) {
        this.getChildren().add(view);
    }

    public void setMouseX(double mouseX) {
        this.mouseX = mouseX;
    }

    public void setMouseY(double mouseY) {
        this.mouseY = mouseY;
    }

/**
    public void updateView(Node view) {
        getChildren().remove(view);
        getChildren().add(view);
    }
    */
}
