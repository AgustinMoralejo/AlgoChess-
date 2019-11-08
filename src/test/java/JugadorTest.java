import Fiuba.AlgoChess.*;
import Fiuba.Excepciones.PuntosInsuficientesException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public
class JugadorTest {

    @Test
    public void testCrearJugadorEquipoAzulConNombreAgustinY20Puntos(){

        Jugador jugador = new JugadorAzul("agustin");

        Assertions.assertEquals("agustin", jugador.getNombre());
        Assertions.assertEquals(20, jugador.getPuntos());

    }

    @Test
    public void testJugadorAzulCompraUnSoldadoPor1Punto(){

        Jugador jugadorAzul = new JugadorAzul("agustin");

        jugadorAzul.comprarUnidad("soldado");
        Assertions.assertEquals(19, jugadorAzul.getPuntos());

    }

    @Test
    public void testJugadorAzulCompraUnJinetePor3Puntos(){

        Jugador jugadorAzul = new JugadorAzul("agustin");

        jugadorAzul.comprarUnidad("jinete");
        Assertions.assertEquals(17, jugadorAzul.getPuntos());

    }

    @Test
    public void testJugadorAzulCompraUnCuranderoPor2Puntos(){

        Jugador jugadorAzul = new JugadorAzul("agustin");

        jugadorAzul.comprarUnidad("curandero");
        Assertions.assertEquals(18, jugadorAzul.getPuntos());
    }

    @Test
    public void testJugadorAzulCompraUnaCatapultaPor5Puntos(){

        Jugador jugadorAzul = new JugadorAzul("agustin");

        jugadorAzul.comprarUnidad("catapulta");
        Assertions.assertEquals(15, jugadorAzul.getPuntos());
    }

    @Test
    public void testJugadorAzulConMenosDe5PuntosNoCompraUnaCatapultaPorInsuficienciaDePuntos(){

        Jugador jugadorAzul = new JugadorAzul("agustin");

        jugadorAzul.comprarUnidad("catapulta");
        jugadorAzul.comprarUnidad("catapulta");
        jugadorAzul.comprarUnidad("catapulta");
        jugadorAzul.comprarUnidad("jinete");

        Assertions.assertThrows(PuntosInsuficientesException.class, () -> jugadorAzul.comprarUnidad("catapulta"));
        Assertions.assertEquals(2, jugadorAzul.getPuntos());
    }


    @Test
    public void testJugadorPierde(){

        Jugador jugadorAzul = new JugadorAzul("agustin");
        jugadorAzul.pagar(20);

        Assertions.assertTrue(jugadorAzul.perdio());

    }

}
