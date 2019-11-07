package Fiuba.Unidad;

public class NullUnidad extends Unidad {

    @Override
    public String getSimbolo(){
        String unidadEnTablero = "-";
        return unidadEnTablero ;
    }

    @Override
    public void atacar(int distancia, Unidad unidadObjetivo) {

    }

    @Override
    public Unidad copiar() {
        return new NullUnidad();
    }
}
