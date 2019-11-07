package Fiuba.Unidad;

import Fiuba.Excepciones.*;

import Fiuba.AlgoChess.*;
import Fiuba.Tablero.*;
import java.util.ArrayList;


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
        int perdidaTotal = estadoAlianzas.calcularCostoUnidad(costoAtaque);
        vida -= perdidaTotal;
    }   

    @Override
    public void cambiarEstadoAlianzas(){
        estadoAlianzas = estadoAlianzas.cambiarEstadoAlianzas();
    }

    @Override
    public void moveteA(Casillero zonaInicial, Casillero zonaFinal){
        estadoAlianzas.puedeActuar();
        zonaFinal.recibirUnidad(this, zonaFinal);
    }

    @Override
    public void atacar(CondicionesAtaqueMovimiento condiciones, int distancia, Casillero unidadDefensa) {
    	ArrayList<Casillero> zonasCortaDistancia = condiciones.buscarCasilleros(2);
    	Arma arma = new ArmaNull();
    	for(int i = 0; i < zonasCortaDistancia.size(); i++) {
    		Casillero casillero = zonasCortaDistancia.get(i);
    		Unidad unidad = casillero.getUnidad();
    		arma = unidad.seleccionarArmasJinete(arma);

    	}
    	int costoArma = arma.atacar(distancia, costoCuerpoACuerpo, costoADistancia);
    	int costoZona = unidadDefensa.calcularCostoAtaque(costoArma);
    	Unidad defensa = unidadDefensa.getUnidad();
    	int costoTotal = defensa.calcularCostoUnidad(costoZona);
    	defensa.perderVida(costoTotal);
 
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




}