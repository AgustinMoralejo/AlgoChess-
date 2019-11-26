package fiuba.algo3.TP2.Modelo.Unidad.Armas;

import fiuba.algo3.TP2.Modelo.Excepciones.ObjetivoFueraDeRangoException;

public class ArcoInamovible implements Arma{
	
	@Override
	public int atacar(int distancia, int costoCuerpoACuerpo, int costoADistancia) {
		if (distancia < 3 | distancia > 6) {
			throw new ObjetivoFueraDeRangoException();
		}
		return costoADistancia;
	}
	
	
	@Override
	public Arma cambiarArmaSoldado() {
		return this;
	}
	
	@Override
	public Arma cambiarArmaOtraUnidad() {
		return this;
	}
	
	@Override 
	public Arma cambiarArmaEnemiga() {
		return this;
	}
	
	public Arma cambiarArmaNull() {
		return this;
	}

}