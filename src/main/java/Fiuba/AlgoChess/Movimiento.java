package Fiuba.AlgoChess;

public class Movimiento {

    /*En un principio no quiero que sea static, pero por ahora lo dejo asi, probablemente
    termine siendo solo del Jugador o la Unidad*/

    public static final int[][] OFFSET_COORDENADAS_MOVIMIENTO = {
            {-1,-1}, /*Noroeste*/
            {-1,0},/*Norte*/
            {-1,1},/*Noreste*/
            {0,-1},/*Oeste*/
            {0,1},/*Este*/
            {1,-1},/*Suroeste*/
            {1,0},/*Sur*/
            {1,1}/*Sureste*/
    };
}
