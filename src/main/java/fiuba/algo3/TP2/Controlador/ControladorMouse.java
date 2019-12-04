package fiuba.algo3.TP2.Controlador;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

public class ControladorMouse {

    private static ControladorMouse mouse = new ControladorMouse();

    private int[] primerClick = new int[2];
    private int[] segundoClick = new int[2];
    boolean esPrimerClick = true;
    Reproductor reproductor = new Reproductor();

    private ControladorMouse(){ }

    public static ControladorMouse getInstancia(){
        return mouse;
    }

    public void setPrimerClick(int fila, int columna){

        System.out.println("primer click");
        this.primerClick[0] = fila;
        this.primerClick[1] = columna;

        reproductor.reproducirSonido("media/seleccion/selectUnidad.wav");

        esPrimerClick = false;
    }

    public void setSegundoClick(int fila, int columna){

        System.out.println("segundo click");
        this.segundoClick[0] = fila;
        this.segundoClick[1] = columna;

        reproductor.reproducirSonido("media/seleccion/selectUnidad.wav");

        esPrimerClick = true;

    }

    public void resetMouse(){

        esPrimerClick = true;
    }

    public boolean esPrimerClick(){
        return esPrimerClick;
    }

    public int[] getPrimerClick(){
        return primerClick;
    }

    public int[] getSegundoClick(){
        return segundoClick;
    }

}
