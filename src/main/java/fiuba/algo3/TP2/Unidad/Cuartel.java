package fiuba.algo3.TP2.Unidad;

import fiuba.algo3.TP2.AlgoChess.Jugador;

import java.util.HashMap;
import java.util.Map;

public class Cuartel {

    private Map<String, Unidad> unidades;

    public Cuartel(){

        unidades = new HashMap<String, Unidad>();
        unidades.put("soldado", new Soldado());
        unidades.put("jinete", new Jinete());
        unidades.put("curandero", new Curandero());
        unidades.put("catapulta", new Catapulta());

    }

    public Unidad getUnidad(String nombreUnidad, Jugador unJugador) {

    	Unidad unidad = unidades.get(nombreUnidad);
        Unidad copia = unidad.copiar();
        unJugador.pagar(copia.getCosto());
        return copia;
    }

}
