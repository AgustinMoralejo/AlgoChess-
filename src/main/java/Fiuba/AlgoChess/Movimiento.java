package Fiuba.AlgoChess;

public class Movimiento {

    /*En un principio no quiero que sea static, pero por ahora lo dejo asi, probablemente
    termine siendo solo del Jugador o la Unidad*/

    public static final int[][] OFFSET_COORDENADAS_MOVIMIENTO = {
            {-1,0}, /*Norte '0'*/
            {-1,1},/*Noreste '1' */
            {0,1},/*Este '2' */
            {1,1},/*Sureste '3' */
            {1,0},/*Sur '4' */
            {1,-1},/*Suroeste '5' */
            {0,-1},/*Oeste '6' */
            {-1,-1}/*Noroeste '7' */
    };
}
