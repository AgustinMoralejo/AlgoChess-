package fiuba.algo3.TP2.Vista;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VistaCasillero extends Rectangle {

    public VistaCasillero(boolean light, int x, int y) {

        setWidth(64);
        setHeight(64);
        relocate(x * 64, y * 64);

        setFill(light ? javafx.scene.paint.Color.valueOf("#feb")
                : Color.valueOf("#582"));
    }


}
