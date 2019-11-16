package Fiuba.Tablero;

import Fiuba.Excepciones.CasilleroEstaOcupadoException;
import Fiuba.Excepciones.NoSePuedeColocarUnidadEnSectorEnemigoException;
import Fiuba.Unidad.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Casillero{

    private Unidad unidad;
    private boolean estaOcupado;
    private Coordenada coordenada;

    private ArrayList<Casillero> casillerosAdyacentes;


    private String alianza;

    public Casillero(int fila, int columna){
        this.unidad = new UnidadNull();
        this.estaOcupado = false;
        this.coordenada = new Coordenada(fila, columna);
        this.casillerosAdyacentes = new ArrayList<>();
    }

    public boolean casilleroEstaOcupado(){
        return this.estaOcupado;
    }

    public void ocuparConUnidad(Unidad unaUnidad){

        if(casilleroEstaOcupado()){
            throw new CasilleroEstaOcupadoException();
        }

        if(unaUnidad.getAlianza() != this.alianza) {
            throw new NoSePuedeColocarUnidadEnSectorEnemigoException();
        }

        this.unidad = unaUnidad;
        this.estaOcupado = true;
        unidad.setCoordenada(coordenada);
    }

    public void colocarNuevaUnidad(Unidad unaUnidad){
        if(this.casilleroEstaOcupado()){
            throw new CasilleroEstaOcupadoException();
        }
        this.unidad = unaUnidad;
        this.estaOcupado = true;
    }

    public void quitarUnidad(){
        unidad = new UnidadNull();
        this.estaOcupado = false;
    }

    public void iniciarZonaPorAlianza(String alianza){
        this.alianza = alianza;
    }

    public String getAlianza(){
        return alianza;
    }

    public Coordenada getCoordenada(){
        return this.coordenada;
    }

    public int calcularDistancia(Casillero otroCasillero){
        Coordenada coordenadaOtroCasillero = otroCasillero.getCoordenada();
        int distancia = this.coordenada.calcularDistanciaEntreCoordenadas(coordenadaOtroCasillero);
        return distancia;
    }

    public void moverUnidad(Coordenada coordenadaFinal){

    }

    public void agregarUnCasilleroContiguo(Casillero unCasilleroContiguo){

        casillerosAdyacentes.add(unCasilleroContiguo);

    }

    public Unidad getUnidad(){
        return this.unidad;
    }

    public boolean unidadEnCasilleroEsAliada(String alianza) {

        return (this.unidad.getAlianza() == alianza);

    }

    public void agregarCasillerosAlBatallon(List<Casillero> batallon, int i) {

        Casillero casilleroAdyacente;
        Iterator<Casillero> iterador = casillerosAdyacentes.iterator();

        while(iterador.hasNext() && batallon.size() < 3){

            casilleroAdyacente = iterador.next();

            if(!batallon.contains(casilleroAdyacente) && casilleroAdyacente.unidadEnCasilleroEsAliada(this.unidad.getAlianza())  && casilleroAdyacente.getUnidad().getSimbolo() == "S"){
                batallon.add(casilleroAdyacente);
            }

        }

        /*Si todavia no hay 3 soldados busca en los soldados adyacentes a los del "batallon"*/
        if(batallon.size() > i){
            batallon.get(i).agregarCasillerosAlBatallon(batallon, i+1);
        }

    }


}