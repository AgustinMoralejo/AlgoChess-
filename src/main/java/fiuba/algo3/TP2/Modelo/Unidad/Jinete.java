package fiuba.algo3.TP2.Modelo.Unidad;

import fiuba.algo3.TP2.Modelo.AlgoChess.EstadoAliado;
import fiuba.algo3.TP2.Modelo.Excepciones.LasUnidadesSoloSePuedenMoverUnCasilleroPorTurnoException;
import fiuba.algo3.TP2.Modelo.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.Armas.Arco;
import fiuba.algo3.TP2.Modelo.Unidad.Armas.Arma;

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
        atacoEnEsteTurno = false;
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
    	atacoEnEsteTurno = true;
    	return defensa.getPuntosDeVida();
 
    }

    @Override
    protected void dentroRango(int distancia) {
        if(distancia < DISTANCIA_LEJANA){
            throw new ObjetivoFueraDeRangoException();
        }
    }
    
    @Override 
    public Arma seleccionarArmasJinete(Arma armaAnterior) {
    	return estadoAlianzas.seleccionarArmaOtraUnidad(armaAnterior);
    }
    
    @Override
    public void agregarUnCasilleroAlBatallon(List<Casillero> batallon, Casillero casillero) {}


    @Override
    public void seMovioEnEsteTurno() {
        if(seMovioEnEsteTurno){
            throw new LasUnidadesSoloSePuedenMoverUnCasilleroPorTurnoException();
        }
    }

    //Lucho ver como cambiar la distancia
    @Override
    public int getDistanciaAtaque() {
        return 1;
    }

}