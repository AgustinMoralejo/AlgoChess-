package fiuba.algo3.TP2.Modelo.Unidad;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.TP2.Modelo.AlgoChess.EstadoAliado;
import fiuba.algo3.TP2.Modelo.Excepciones.NoHayUnidadEnCasilleroException;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.Armas.Arma;

public class UnidadNull extends Unidad{



    public UnidadNull(){
    	estadoAlianzas = new EstadoAliado();
    }

    public UnidadNull(int fil, int col) {
        estadoAlianzas = new EstadoAliado();
        setPosicion(fil,col);
    }

    @Override
    public String getSimbolo(){
      return "-";
    };

    @Override 
    public int calcularCostoUnidad(int costo) {
    	throw new NoHayUnidadEnCasilleroException();
    }
    
    @Override
    public void perderVida(int costoAtaque){
    }

    @Override
    public void cambiarEstadoAlianzas(){
    	estadoAlianzas = estadoAlianzas.cambiarEstadoAlianzas();
    }
    
    public Unidad copiar() {
    	return new UnidadNull();
    }

    @Override
    public void unirABatallon(ArrayList<Casillero> batallon) {
        throw new NoHayUnidadEnCasilleroException();
    }

    @Override
    public int atacar(ArrayList<Casillero> zonasCercanas, int distancia, Casillero unidadDefensa){
        throw new NoHayUnidadEnCasilleroException();
    }

    @Override
    public void moveteA(Casillero zonaInicial, int orientacion) {
        throw new NoHayUnidadEnCasilleroException();
    }

    @Override
    public void dentroRango(int distancia) {
    }
    
    @Override
    public
    Arma seleccionarArmasJinete(Arma armaAnterior) {
    	return estadoAlianzas.seleccionarArmaNull(armaAnterior);
    }
    
    @Override
    public void agregarUnCasilleroAlBatallon(List<Casillero> batallon, Casillero casillero) {}
    

}