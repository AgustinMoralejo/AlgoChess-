package Fiuba.AlgoChess;
import Fiuba.Unidad.*;

public interface EstadoAlianzas{

    public abstract EstadoAlianzas cambiarEstadoAlianzas();
    public abstract int calcularCostoCasillero(int costo);
    public abstract int calcularCostoUnidad(int costo);
    public abstract int calcularCostoCuracion(int costo);
    public abstract void puedeActuar();
    public abstract Arma seleccionarArmaSoldado(Arma armaAnterior);
    public abstract Arma seleccionarArmaOtraUnidad(Arma armaAnterior);
    public abstract Arma seleccionarArmaNull(Arma armaAnterior);
    
}