package Fiuba.Unidad;

import Fiuba.Excepciones.ObjetivoFueraDeRangoException;

public class ArcoComun implements Arma {
	
	@Override
	public int atacar(int distancia, int costoCuerpoACuerpo, int costoADistancia) {
		if (distancia < 3 | distancia > 6) {
			throw new ObjetivoFueraDeRangoException();
		}
		return costoADistancia;
	}
	
	
	@Override
	public Arma cambiarArmaSoldado() {
		return new ArcoInamovible();
	}
	
	@Override
	public Arma cambiarArmaOtraUnidad() {
		return this;
	}
	
	@Override 
	public Arma cambiarArmaEnemiga() {
		return new NullInamovible();
	}
	
	public Arma cambiarArmaNull() {
		return this;
	}
}
