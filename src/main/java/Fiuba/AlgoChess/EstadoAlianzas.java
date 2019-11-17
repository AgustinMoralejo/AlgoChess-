package Fiuba.AlgoChess;
import Fiuba.Unidad.*;
import Fiuba.Tablero.Casillero;
import java.util.List;
public interface EstadoAlianzas{

    public abstract EstadoAlianzas cambiarEstadoAlianzas();
    public abstract int calcularCostoCasillero(int costo);
    public abstract int calcularCostoUnidad(int costo);
    public abstract int calcularCostoCuracion(int costo);
    public abstract void puedeActuar();
    public abstract void comprarUnidad();
    public abstract Arma seleccionarArmaSoldado(Arma armaAnterior);
    public abstract Arma seleccionarArmaOtraUnidad(Arma armaAnterior);
    public abstract Arma seleccionarArmaNull(Arma armaAnterior);
    public abstract void agregarCasilleroAlBatallon(List<Casillero> batallon, Casillero casillero);
    
    
}