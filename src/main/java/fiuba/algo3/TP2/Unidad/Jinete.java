package fiuba.algo3.TP2.Unidad;

import fiuba.algo3.TP2.AlgoChess.EstadoAliado;
import fiuba.algo3.TP2.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.TP2.Tablero.Casillero;
import fiuba.algo3.TP2.Unidad.Armas.Arco;
import fiuba.algo3.TP2.Unidad.Armas.Arma;

import java.util.ArrayList;
import java.util.List;


public class Jinete extends Unidad{

    public Jinete(){
        vida = 100;
        costo = 3;
        danioCuerpoACuerpo = 5;
        danioADistancia = 15;
        estadoAlianzas = new EstadoAliado();
        simbolo = "J";
    }
    
    @Override
    public Unidad copiar() {
    	return new Jinete();
    }


    @Override
    public void unirABatallon(ArrayList<Casillero> batallon) {

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
    public void moveteA(Casillero casilleroInicial, int orientacion) {
        estadoAlianzas.puedeActuar();
        Casillero casilleroFinal = casilleroInicial.getAdyacente(orientacion);
        casilleroFinal.recibirUnidad(this, casilleroInicial);
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
    	int costoArma = arma.atacar(distancia, danioCuerpoACuerpo, danioADistancia);
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
    public void agregarUnCasilleroAlBatallon(List<Casillero> batallon, Casillero casillero) {}


}