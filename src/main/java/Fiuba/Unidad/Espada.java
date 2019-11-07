package Fiuba.Unidad;

import Fiuba.Excepciones.ObjetivoFueraDeRangoException;

public class Espada implements Arma {
	
	public int atacar(int distancia, int costoCuerpoACuerpo, int costoADistancia) {
		if(distancia > 2) {
			throw new ObjetivoFueraDeRangoException();
		}
		return costoCuerpoACuerpo;
	}
	
	public Arma cambiarArmaSoldado() {
		return new ArcoInamovible();
	}
	
	public Arma cambiarArmaOtraUnidad() {
		return new ArmaNull();
	}
	
	public Arma cambiarArmaEnemiga() {
		return this;
	}
	
	public Arma cambiarArmaNull() {
		return this;
	}
}
