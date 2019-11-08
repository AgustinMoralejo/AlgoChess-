import Fiuba.AlgoChess.*;
import Fiuba.Excepciones.PuntosInsuficientesException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public
class JugadorTests {

    @Test
    public void testCrearJugadorEquipoAzulConNombreAgustinY20Puntos(){

        Jugador jugador = new Jugador("agustin");

        Assertions.assertEquals("agustin", jugador.getNombre());
        Assertions.assertEquals(20, jugador.getPuntos());

    }

}
