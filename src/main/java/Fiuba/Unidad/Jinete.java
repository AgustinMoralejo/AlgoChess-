package Fiuba.Unidad;

import Fiuba.Excepciones.*;

import Fiuba.AlgoChess.*;
import Fiuba.Tablero.*;
import java.util.ArrayList;
import java.util.List;


public class Jinete extends Unidad{

    public Jinete(){
        vida = 100;
        costo = 3;
        costoCuerpoACuerpo = 5;
        costoADistancia = 15;
        estadoAlianzas = new EstadoAliado();
    }
    
    @Override
    public Unidad copiar() {
    	return new Jinete();
    }

    @Override
    public void perderVida(int costoAtaque){
        
        vida -= costoAtaque;
    }   

    @Override
    public void cambiarEstadoAlianzas(){
        estadoAlianzas = estadoAlianzas.cambiarEstadoAlianzas();
    }

    @Override
    public void moveteA(Casillero zonaInicial, Casillero zonaFinal, int orientacion){
        estadoAlianzas.puedeActuar();
        zonaFinal.recibirUnidad(this, zonaInicial);
    }

    @Override
    public int atacar(ArrayList<Casillero> zonasCercanas, int distancia, Casillero unidadDefensa) {
    	estadoAlianzas.puedeActuar();
    	Arma arma = new Arco();
    	for(int i = 0; i < zonasCercanas.size(); i++) {
    		Casillero casillero = zonasCercanas.get(i);
    		Unidad unidad = casillero.getUnidad();
    		arma = unidad.seleccionarArmasJinete(arma);

    	}
    	int costoArma = arma.atacar(distancia, costoCuerpoACuerpo, costoADistancia);
    	int costoZona = unidadDefensa.calcularCostoAtaque(costoArma);
    	Unidad defensa = unidadDefensa.getUnidad();
    	int costoTotal = defensa.calcularCostoUnidad(costoZona);
    	defensa.perderVida(costoTotal);
    	return defensa.getPuntosDeVida();
 
    }

    @Override
    protected void dentroRango(int distancia) {
        if(distancia < 6){
            throw new ObjetivoFueraDeRangoException();
        }
    }
    
    @Override 
    public Arma seleccionarArmasJinete(Arma armaAnterior) {
    	return estadoAlianzas.seleccionarArmaOtraUnidad(armaAnterior);
    }
    
    @Override
    public void agregarCasillerosAlBatallon(List<Casillero> batallon, Casillero casillero) {}


}