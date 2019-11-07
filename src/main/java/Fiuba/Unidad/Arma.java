package Fiuba.Unidad;

public interface Arma {
	
	public abstract int atacar(int distancia, int costoCuerpoACuerpo, int costoADistancia);
	public abstract Arma cambiarArmaSoldado();
	public abstract Arma cambiarArmaOtraUnidad();
	public abstract Arma cambiarArmaNull();
	public abstract Arma cambiarArmaEnemiga();
}
