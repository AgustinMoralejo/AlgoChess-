package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;


public class VistaTablero extends Group {

    public double ancho;
    public double alto;
    private double anchoCasillero = 64;
    private double altoCasillero = 64;

    private GridPane table;
    private VistaCasillero[][] panes;

    private Group casilleroGroup = new Group();

    public VistaTablero(Tablero tablero) {

        ancho = anchoCasillero * tablero.getColumnas();
        alto = altoCasillero * tablero.getFilas();

        Pane root = new Pane();
        root.setPrefSize(ancho, alto);
        root.getChildren().addAll(casilleroGroup);

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

       // this.addView(table);

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
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void updateView(Node view) {
        getChildren().remove(view);
        getChildren().add(view);
    }
    */
}
