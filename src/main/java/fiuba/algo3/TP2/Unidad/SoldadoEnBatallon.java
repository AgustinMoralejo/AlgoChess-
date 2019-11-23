package fiuba.algo3.TP2.Unidad;

import fiuba.algo3.TP2.Excepciones.BatallonNoSePuedeMoverException;
import fiuba.algo3.TP2.Excepciones.CasilleroEstaOcupadoException;
import fiuba.algo3.TP2.Tablero.Casillero;

import java.util.*;

public class SoldadoEnBatallon implements EstadoBatallon {


    ArrayList<Casillero> batallon;

    public SoldadoEnBatallon(ArrayList<Casillero> batallon){
        this.batallon = batallon;
        for(Casillero casilleroBatallon : batallon){
            casilleroBatallon.unirABatallon(batallon);
        }
    }

    public SoldadoEnBatallon(ArrayList<Casillero> batallon, int i) {
        this.batallon = batallon;
    }

    @Override
    public void moveteA(Casillero zonaInicial, int orientacion) {

        ArrayList<Unidad> bufferBatallon = new ArrayList<>();


        if(batallon.get(0).getAdyacente(orientacion).estaOcupado() &&
        batallon.get(1).getAdyacente(orientacion).estaOcupado() &&
        batallon.get(2).getAdyacente(orientacion).estaOcupado()
        ){
            throw new BatallonNoSePuedeMoverException();

        }

        /*
        for(int j=0; j < 3; j++){
            int i=0;
            boolean algunSoldadoSeIntentoMover = false;
            while(!algunSoldadoSeIntentoMover && i < 3){
                Casillero casilleroBatallon = batallon.get(i);
                if (!casilleroBatallon.getAdyacente(orientacion).estaOcupado()) {
                    try {
                        casilleroBatallon.intentarMoverse(orientacion);
                    } catch (CasilleroEstaOcupadoException e ) {
                        System.out.println("Un soldado no se pudo mover");
                    }
                    algunSoldadoSeIntentoMover = true;
                }
                i++;
            }
        }
  */
        for(Casillero casilleroBatallon : batallon) {
            bufferBatallon.add(casilleroBatallon.getUnidad());
            casilleroBatallon.quitarUnidad();
        }

        for(Casillero casilleroBatallon: batallon){
            int i=0;
            Unidad unidadDelBatallon = bufferBatallon.get(i);
            try {
                casilleroBatallon.moverUnidadBatallon(unidadDelBatallon, orientacion);
            } catch (CasilleroEstaOcupadoException e ) {
                System.out.println("Un soldado no se pudo mover");
                casilleroBatallon.ocuparUnidad(unidadDelBatallon);
            }
            i++;
        }
    }


    @Override
    public boolean estaSolo() {
        return false;
    }


}
