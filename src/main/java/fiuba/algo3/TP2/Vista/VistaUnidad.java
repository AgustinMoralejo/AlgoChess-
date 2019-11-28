package fiuba.algo3.TP2.Vista;

import fiuba.algo3.TP2.Modelo.Observer;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import static fiuba.algo3.TP2.Vista.VistaTablero.ALTO_CASILLERO;

public abstract class VistaUnidad extends StackPane implements Observer {

    private Unidad unidad;
    private double columnaInicial;
    private double filaInicial;


    /*TODO: No deberia haber una vista por unidad ya que la unica diferencia es como se dibuja
    *  asi que vistaUnidad no deberia ser abstracta y deberia ser solo una*/

    //Image image = new Image("file:" + getNombreUnidad(casillero) + ".png",ancho,alto,false,false);





    private String getNombreUnidad( Casillero casillero){

        int fila = casillero.getFila();
        int columna = casillero.getColumna();

        Casillero casilleroJinete = new Casillero(fila, columna);
        casilleroJinete.ocuparUnidad(new Jinete());
        Casillero casilleroSoldado = new Casillero(fila, columna);
        casilleroSoldado.ocuparUnidad(new Soldado());
        Casillero casilleroCatapulta = new Casillero(fila, columna);
        casilleroCatapulta.ocuparUnidad(new Catapulta());
        Casillero casilleroCurandero = new Casillero(fila, columna);
        casilleroCurandero.ocuparUnidad(new Curandero());

        if(casillero.equals(casilleroJinete)){ return "jinete";}
        else if(casillero.equals(casilleroSoldado)){ return "soldado";}
        else if(casillero.equals(casilleroCatapulta)){ return "catapulta";}
        else if(casillero.equals(casilleroCurandero)){ return "curandero";}
        else { return "vacio";}

    }



    protected abstract void dibujar(boolean esRojo);


/*
    public void actualizar() {
        columnaInicial = unidad.getColumna() * ALTO_CASILLERO;
        filaInicial = unidad.getFila() * ALTO_CASILLERO;
        relocate(columnaInicial, filaInicial);

    }
    */

}
