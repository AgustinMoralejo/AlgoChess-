package fiuba.algo3.TP2.Modelo.Unidad.Armas;

public interface Arma {
	
	public abstract int atacar(int distancia, int costoCuerpoACuerpo, int costoADistancia);
	public abstract Arma cambiarArmaSoldado();
	public abstract Arma cambiarArmaOtraUnidad();
	public abstract Arma cambiarArmaNull();
	public abstract Arma cambiarArmaEnemiga();
	public abstract int getRangoAtaque(int costoCuerpoACuerpo, int costoADistancia);
	public abstract int getRangoAtaqueInicial(int opcion1, int opcion2);
	public abstract int getRangoAtaqueFinal(int opcion1, int opcion2);
}
