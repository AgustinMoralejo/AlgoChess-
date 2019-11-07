package Fiuba.Unidad;

import Fiuba.Excepciones.*;

public class ArmaNull implements Arma {
	
	@Override
	public int atacar(int distancia, int costoCuerpoACuerpo, int costoADistancia) {
		throw new NoSePuedeAtacarCasilleroVacioException();
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
		return new Espada();
	}
	
	public Arma cambiarArmaNull() {
		return this;
	}
}
