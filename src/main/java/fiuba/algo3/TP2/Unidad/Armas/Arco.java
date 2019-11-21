package fiuba.algo3.TP2.Unidad.Armas;

import fiuba.algo3.TP2.Excepciones.ObjetivoFueraDeRangoException;

public class Arco implements Arma {
	
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
		return new ArcoComun();
	}
	
	@Override 
	public Arma cambiarArmaEnemiga() {
		return new Espada();
	}
	
	public Arma cambiarArmaNull() {
		return this;
	}
}
