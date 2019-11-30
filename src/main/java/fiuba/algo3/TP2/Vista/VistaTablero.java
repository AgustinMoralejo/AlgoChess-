package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Modelo.Unidad.Soldado;
import fiuba.algo3.TP2.Modelo.Unidad.Unidad;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class VistaTablero extends Group {

    public double ancho;
    public double alto;
    public static final int ANCHO_CASILLERO = 32;
    public static final int ALTO_CASILLERO = 32;
    private Tablero tablero;

    /*
    private GridPane table;
    private Pane[][] panes;
    */

    private Group casilleroGroup = new Group();
    private Group unidadGroup = new Group();

    public VistaTablero(Tablero tablero) {

        this.tablero = tablero;
        ancho = ANCHO_CASILLERO * tablero.getColumnas();
        alto = ALTO_CASILLERO * tablero.getFilas();

        /*
        table = new GridPane();
        panes = new Pane[(int)ancho][(int)alto];
        */
        Pane root = new Pane();
        root.setPrefSize(ancho, alto);
        root.getChildren().addAll(casilleroGroup,unidadGroup);

        /*
        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                //Pane v = new Pane();
                Ventana v = new Ventana(i < 10,tablero.getCasillero(i,j),tablero);
                v.setMinHeight(ALTO_CASILLERO);
                v.setMinWidth(ANCHO_CASILLERO);
                panes[i][j] = v;
                table.add(v , j, i);

                VistaUnidad vistaUnidad;

                vistaUnidad = new VistaUnidad(tablero.getCasillero(i,j));
                table.getChildren().add(vistaUnidad);
            }
        }

         */

        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {

                VistaUnidad vistaUnidad;

                vistaUnidad = new VistaUnidad(tablero.getCasillero(i,j));
                vistaUnidad.setMouseTransparent(true);

                unidadGroup.getChildren().add(vistaUnidad);

                Ventana vistaCasillero =
                        new Ventana((i < 10), tablero.getCasillero(i,j),
                                tablero);

                /*
                VistaCasillero vistaCasillero =
                        new VistaCasillero((i < 10), tablero.getCasillero(i,j),
                                this, vistaUnidad);
                */

                casilleroGroup.getChildren().add(vistaCasillero);
            }
        }
/*
        Background bi = new Background(new BackgroundImage
            (new Image("file:src/main/java/fiuba/algo3/TP2/Vista/Imagenes/fondo.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.ancho, this.alto, false,
                    false, false, false)));
        table.setBackground(bi);
 */
        this.agregarVista(root);

    }

/*
    public void addViewOnMap(Node view, int x, int y) {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                try {
                    panes[i][j].getChildren().remove(view);
                } catch (Exception e) {
                }
            }
        }
        panes[x][y].getChildren().add(0, view);
    }
*/
    public void agregarVista(Node view) {
        this.getChildren().add(view);
    }

    public void agregarVistaUnidad(Unidad unidad){

        VistaUnidad vistaUnidad = new VistaUnidad(unidad);
        vistaUnidad.setMouseTransparent(true);

        unidadGroup.getChildren().add(vistaUnidad);

    }

    public void actualizarVista(Node view) {
        getChildren().remove(view);
        getChildren().add(view);
    }
}
