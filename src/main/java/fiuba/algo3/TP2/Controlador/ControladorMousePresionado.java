package fiuba.algo3.TP2.Controlador;

import fiuba.algo3.TP2.Modelo.Excepciones.UnidadSoloSePuedeMoverUnCasilleroException;
import fiuba.algo3.TP2.Modelo.Tablero.Tablero;
import fiuba.algo3.TP2.Vista.VistaTablero;
import fiuba.algo3.TP2.Vista.VistaUnidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import static fiuba.algo3.TP2.Modelo.AlgoChess.Movimiento.OFFSET_COORDENADAS_MOVIMIENTO;
import static fiuba.algo3.TP2.Vista.VistaTablero.ALTO_CASILLERO;


public class ControladorMousePresionado implements EventHandler<MouseEvent> {

    private Tablero tablero;

    private VistaTablero vistaTablero;

    private double mouseX;
    private double mouseY;
    private boolean primerClick=true;
    private int[] posUnidad=new int[2];
    private int[] destino=new int[2];

    public ControladorMousePresionado(Tablero tablero, VistaTablero vistaTablero) {
        this.tablero = tablero;
        this.vistaTablero = vistaTablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        int columna;
        int fila;


        if(primerClick){

            mouseX = mouseEvent.getSceneX();
            mouseY = mouseEvent.getSceneY();

            columna = convertir(mouseX);
            fila = convertir(mouseY);

            System.out.println("filaUnidad: " + fila);
            System.out.println("columnaUnidad: " + columna);

            posUnidad[0] = fila;
            posUnidad[1] = columna;

            this.primerClick = false;


        }
        else{

            mouseX = mouseEvent.getSceneX();
            mouseY = mouseEvent.getSceneY();

            columna = convertir(mouseX);
            fila = convertir(mouseY);

            System.out.println("filaDestino: " + fila);
            System.out.println("columnaDestino: " + columna);

            destino[0] = fila;
            destino[1] = columna;

            int or = -2;

            try{
                or = tablero.darOrientacion(posUnidad, destino);
            }catch (UnidadSoloSePuedeMoverUnCasilleroException e){
                System.out.println("¡¡¡ La unidad se puede mover solo un casillero a la vez !!!");
            }

            tablero.moverUnidad(posUnidad[0], posUnidad[1], or);

            this.primerClick = true;


        }

        /*Con un click selecciono a la unidad (fila, columna) y con otro lo muevo (orientacion), como separo cada handle?*/

    }

    private int convertir(double posicionImagen){
        return (int)(posicionImagen + ALTO_CASILLERO / 20)
                / ALTO_CASILLERO;
    }

}
