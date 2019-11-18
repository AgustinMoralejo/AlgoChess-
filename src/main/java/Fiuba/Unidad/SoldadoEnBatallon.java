package Fiuba.Unidad;

import Fiuba.Excepciones.BatallonNoSePuedeMoverException;
import Fiuba.Excepciones.CasilleroEstaOcupadoException;
import Fiuba.Tablero.Casillero;

import java.util.ArrayList;

public class SoldadoEnBatallon implements EstadoBatallon {


    @Override
    public void moveteA(Casillero zonaInicial, int orientacion, ArrayList<Casillero> batallon) {

        ArrayList<Unidad> bufferBatallon = new ArrayList<>();

        /*Se puede mover el batallon?*/;
        if(batallon.get(0).getAdyacente(orientacion).estaOcupado() &&
        batallon.get(1).getAdyacente(orientacion).estaOcupado() &&
        batallon.get(2).getAdyacente(orientacion).estaOcupado()
        ){
            throw new BatallonNoSePuedeMoverException();

        }

        /**Cargo todas las unidades del batallon en un buffer, quitandolas del tablero*/
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
    public boolean perteneceABatallon() {
        return true;
    }


}
