package fiuba.algo3.TP2.Modelo.Unidad;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.TP2.Modelo.AlgoChess.EstadoAliado;
import fiuba.algo3.TP2.Modelo.Excepciones.LasUnidadesSoloSePuedenMoverUnCasilleroPorTurnoException;
import fiuba.algo3.TP2.Modelo.Excepciones.ObjetivoFueraDeRangoException;
import fiuba.algo3.TP2.Modelo.Tablero.Casillero;
import fiuba.algo3.TP2.Modelo.Unidad.Armas.Arma;


public class Soldado extends Unidad{

    EstadoBatallon estadoBatallon;

    public Soldado(){
        vida = 100;
        costo = 1;
        danioCuerpoACuerpo = 10;
        danioADistancia = 0;
        estadoBatallon = new SoldadoSolo();
        estadoAlianzas = new EstadoAliado();
        simbolo = "S";
        atacoEnEsteTurno = false;
    }
    
    @Override
    public Unidad copiar() {
    	return new Soldado();
    }

    @Override
    public void unirABatallon(ArrayList<Casillero> batallon) {

        estadoBatallon = new SoldadoEnBatallon(batallon, 1);

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
    public void moveteA(Casillero casilleroInicial, int orientacion){

        estadoAlianzas.puedeActuar();

        ArrayList<Casillero> batallon = conformarBatallon(casilleroInicial);

        if (batallon.size() == 3) {
            estadoBatallon = new SoldadoEnBatallon(batallon);
        } else {
            estadoBatallon = new SoldadoSolo(casilleroInicial);
        }

        estadoBatallon.moveteA(casilleroInicial, orientacion);

    }

    private ArrayList<Casillero> conformarBatallon(Casillero casilleroInicial) {

        ArrayList<Casillero> batallon = new ArrayList<>();

        batallon.add(casilleroInicial);
        casilleroInicial.agregarCasillerosAlBatallon(batallon,1);

        return batallon;
    }

    @Override
    public int atacar(ArrayList<Casillero> zonasCercanas, int distancia, Casillero unidadDefensa){
        estadoAlianzas.puedeActuar();
        this.dentroRango(distancia);
        Unidad defensa = unidadDefensa.getUnidad();
        int costo = unidadDefensa.calcularCostoAtaque(danioCuerpoACuerpo);
        int costo_total = defensa.calcularCostoUnidad(costo);
        defensa.perderVida(costo_total);
        atacoEnEsteTurno = true;
        return defensa.getPuntosDeVida();
    }

    @Override
    protected void dentroRango(int distancia) {
        if(distancia > DISTANCIA_CERCANA){
            throw new ObjetivoFueraDeRangoException();
        }
    }
    
    @Override
    public
    Arma seleccionarArmasJinete(Arma armaAnterior) {
    	return estadoAlianzas.seleccionarArmaSoldado(armaAnterior);
    }
    
    @Override
    public void agregarUnCasilleroAlBatallon(List<Casillero> batallon, Casillero casillero) {

        estadoAlianzas.agregarCasilleroAlBatallon(batallon, casillero);
    }


    @Override
    public void seMovioEnEsteTurno() {
        if(seMovioEnEsteTurno){
            throw new LasUnidadesSoloSePuedenMoverUnCasilleroPorTurnoException();
        }
    }

    @Override
    public int getDistanciaAtaque() {
        return DISTANCIA_CERCANA;
    }


}