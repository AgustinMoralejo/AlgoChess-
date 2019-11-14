import Fiuba.AlgoChess.*;
import Fiuba.Excepciones.NoSePuedeAtacarAUnaUnidadAliadaException;
import Fiuba.Excepciones.ObjetivoFueraDeRangoException;
import Fiuba.Unidad.Catapulta;
import Fiuba.Unidad.Curandero;
import Fiuba.Unidad.Jinete;
import Fiuba.Unidad.Soldado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SoldadoTest {

    @Test
    public void testCrearSoldadoDeInfanteriaTiene100DeVidaYCuesta1Puntos() {

        Soldado soldado = new Soldado();

        Assertions.assertEquals(100, soldado.getPuntosDeVida());
        Assertions.assertEquals(1, soldado.getCosto());
    }

    @Test
    public void testSoldadoRecibe50PuntosDeDanio() {

        Soldado soldado = new Soldado();

        soldado.perderVida(50);
        Assertions.assertEquals(50, soldado.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAtacaSoldadoEnRango() {

        Soldado soldado = new Soldado();
        Soldado soldadoAAtacar = new Soldado();
        soldado.setAlianza("aliado");
        soldadoAAtacar.setAlianza("enemigo");
        soldado.atacar(1, soldadoAAtacar);
        Assertions.assertEquals(90, soldadoAAtacar.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAtacaCatapultaEnRango() {

        Soldado soldado = new Soldado();
        Catapulta catapulta = new Catapulta();
        soldado.setAlianza("aliado");
        catapulta.setAlianza("enemigo");
        soldado.atacar(1, catapulta);
        Assertions.assertEquals(40, catapulta.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAtacaJineteEnRango() {

        Soldado soldado = new Soldado();
        Jinete jinete = new Jinete();
        soldado.setAlianza("aliado");
        jinete.setAlianza("enemigo");
        soldado.atacar(1, jinete);
        Assertions.assertEquals(90, jinete.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAtacaCuranderoEnRango() {

        Soldado soldado = new Soldado();
        Curandero curandero = new Curandero();
        soldado.setAlianza("aliado");
        curandero.setAlianza("enemigo");
        soldado.atacar(1, curandero);
        Assertions.assertEquals(65, curandero.getPuntosDeVida());
    }

    @Test
    public void testSoldadoAtacaSoldadoFueraDeRango() {

        Soldado soldado = new Soldado();
        Soldado soldadoAAtacar = new Soldado();
        soldado.setAlianza("aliado");
        soldadoAAtacar.setAlianza("enemigo");
        Assertions.assertThrows(ObjetivoFueraDeRangoException.class, () -> soldado.atacar(3,soldadoAAtacar));
    }

    @Test
    public void testSoldadoNoPuedeAtacarAOtroSoldadoAliado(){

        Soldado soldado = new Soldado();
        Soldado soldadoAAtacar = new Soldado();
        soldado.setAlianza("aliado");
        soldadoAAtacar.setAlianza("aliado");
        Assertions.assertThrows(NoSePuedeAtacarAUnaUnidadAliadaException.class, () -> soldado.atacar(1,soldadoAAtacar));
    }
}
