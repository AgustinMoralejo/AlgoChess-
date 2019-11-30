package fiuba.algo3.TP2.Controlador;

public class ControladorMouse {

    private static ControladorMouse mouse = new ControladorMouse();

    private int[] primerClick = new int[2];
    private int[] segundoClick = new int[2];
    boolean esPrimerClick = true;

    private ControladorMouse(){ }

    public static ControladorMouse getInstancia(){
        return mouse;
    }

    public void guardarPrimerClick(int fila, int columna){

        System.out.println("primer click");
        this.primerClick[0] = fila;
        this.primerClick[1] = columna;
        esPrimerClick = false;
    }

    public void guardarSegundoClick(int fila, int columna){

        System.out.println("segundo click");
        this.segundoClick[0] = fila;
        this.segundoClick[1] = columna;
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
